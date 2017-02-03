package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.reports.PrintUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andersoney
 */
public class PropriedadesBuscaAnimal extends PropriedadesBusca {

    private final static Logger logger = LoggerFactory.getLogger(PropriedadesBuscaAnimal.class);
    private AnimalTableModel tableModel;
    private List<Animal> listaAnimais;
    private ResultadoBusca resultadoBusca;

    public static final String OPCAO_FICHA_CLINICA = "Imprimir ficha clínica";

    public PropriedadesBuscaAnimal(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    public PropriedadesBuscaAnimal(String tipoOperacao, JFrame jFrame, ResultadoBusca resultadoBusca) {
        super(tipoOperacao, jFrame);
        this.resultadoBusca = resultadoBusca;
        tableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/animal/search?palavrachave=" + getPalavraChave());

            listaAnimais = (List<Animal>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<Animal>>() {
            });
            tableModel = new AnimalTableModel(listaAnimais);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            logger.error("mensagem: " + ex.getMessage(), ex);
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
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        CadastrarAnimalJPanel painelCadastroAnimal = new CadastrarAnimalJPanel(animalSelecionado);
                        HUMVApp.setNovoPainelCentral(painelCadastroAnimal);
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "animal", animalSelecionado.getNome())) {
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
                                logger.error("mensagem: " + ex.getMessage(), ex);
                            }
                        }
                        break;
                    case PropriedadesBusca.OPCAO_SELECIONAR:
                        resultadoBusca.setResultado(animalSelecionado);
                        getjFrame().dispose();
                        break;
                    case PropriedadesBuscaAnimal.OPCAO_FICHA_CLINICA:
                        List listaAnimais = new ArrayList();
                        listaAnimais.add(animalSelecionado);
                        PrintUtils.printLista(PrintUtils.FICHA_CLINICA, listaAnimais);
                        break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.printLista(PrintUtils.TABELA_ANIMAIS, listaAnimais);
        } else if (e.getSource().equals(super.getBotaoCancelar())) {
            if (getjFrame() != null) {
                getjFrame().dispose();
            } else {
                boolean sair = InterfaceGraficaUtils.dialogoSair();
                if (sair) {
                    HUMVApp.setPainelCentralComLogo();
                }
            }
        }
    }
}
