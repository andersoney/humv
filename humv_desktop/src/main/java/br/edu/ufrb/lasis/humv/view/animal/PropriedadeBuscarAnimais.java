/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Andersoney
 */
public class PropriedadeBuscarAnimais extends PropriedadesBusca {

    private final AnimalTableModel animalTableModel;
    private static final Logger LOG = Logger.getLogger(PropriedadeBuscarAnimais.class.getName());
    AnimalTableModel tableModel;

    public PropriedadeBuscarAnimais(String tipoOperacao) {
        super(tipoOperacao);
        animalTableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(animalTableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/animal");

            List<Animal> lista = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {});
            tableModel = new AnimalTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
        }
        HUMVApp.esconderMensagemCarregamento();
    }

    
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
                if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_VISUALIZAR)) {
                    //Ainda falta implementar
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_ALTERAR)) {
                    CadastroAnimal painelCadastroAnimal = new CadastroAnimal(animalSelecionado);
                    HUMVApp.setNovoPainelCentral(painelCadastroAnimal);
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)) {
                    try {
                        ClientResponse response = RESTMethods.delete("/api/animal", animalSelecionado.getRghumv());
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
            }
        }
    }
}
