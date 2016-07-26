package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.MessageUtils;
import br.edu.ufrb.lasis.humv.utils.PrintUtils;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Andersoney
 */
public class PropriedadesBuscaAnimal extends PropriedadesBusca {

    private AnimalTableModel tableModel;
    private List<Animal> listaAnimais;

    public PropriedadesBuscaAnimal(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/animal/search?palavrachave=" + getCampoPalavraChave().getText());

            listaAnimais = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {
            });
            tableModel = new AnimalTableModel(listaAnimais);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
        }
        HUMVApp.esconderMensagemCarregamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(super.getBotaoBusca())) {
            HUMVApp.exibirMensagemCarregamento();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buscar();
                }
            }).start();
        } else if (e.getSource().equals(super.getBotaoOperacao())) {
            if (super.getIndexLinhaSelecionada() < 0) {
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum animal da tabela para realizar a operação.", "Animal não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                Animal animalSelecionado = tableModel.getUsuarioSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR:
                        //Implementar visualização
                        break;
                    case PropriedadesBusca.OPCAO_ALTERAR:
                        CadastrarAnimalJPanel painelCadastroAnimal = new CadastrarAnimalJPanel(animalSelecionado);
                        HUMVApp.setNovoPainelCentral(painelCadastroAnimal);
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (MessageUtils.dialogoRemoverAlterar("remover", "animal", animalSelecionado.getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/animal", animalSelecionado.getRghumv().toString());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Animal removido com sucesso", "Remoção de usuário", JOptionPane.PLAIN_MESSAGE);
                                    HUMVApp.setPainelCentralComLogo();
                                } else {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (RESTConnectionException ex) {
                                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace();
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.print(PrintUtils.TABELA_ANIMAIS, listaAnimais);
        }
    }
}
