/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.MessageUtils;
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
 * @author Luiz
 */
public class PropriedadesBuscaDono extends PropriedadesBusca {

    private final DonoTableModel donoTableModel;
    DonoTableModel tableModel;

    public PropriedadesBuscaDono(String tipoOperacao) {
        super(tipoOperacao);
        donoTableModel = new DonoTableModel();
        super.setTabelaResultado(new JTable(donoTableModel));
    }


    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/dono/search?palavrachave=" + getCampoPalavraChave().getText());

            List<Dono> lista = (List<Dono>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Dono>>() {
            });
            tableModel = new DonoTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            MessageUtils.erroConexao();
        }
        HUMVApp.esconderMensagemCarregamento();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(super.getBotaoBusca())) {
            HUMVApp.exibirMensagemCarregamento();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    buscar();
                }
            }).start();
        } else if (ae.getSource().equals(super.getBotaoOperacao())) {
            if (super.getIndexLinhaSelecionada() < 0) {
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum projeto da tabela para realizar a operação.", "Projeto não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                Dono donoSelecionado = tableModel.getDonoSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR:
                        //Ainda falta implementar
                        break;
                    case PropriedadesBusca.OPCAO_ALTERAR:
                        if (MessageUtils.dialogoRemoverAlterar("alterar", "dono", donoSelecionado.getNome())) {
                            CadastrarDonoJPanel painel = new CadastrarDonoJPanel(donoSelecionado);
                            HUMVApp.setNovoPainelCentral(painel);
                        }   break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (MessageUtils.dialogoRemoverAlterar("remover", "dono", donoSelecionado.getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/dono", "" + donoSelecionado.getId());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Dono removido com sucesso", "Remoção de dono", JOptionPane.PLAIN_MESSAGE);
                                    HUMVApp.setPainelCentralComLogo();
                                } else {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (RESTConnectionException ex) {
                                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
                                ex.printStackTrace();
                            }
                        }   break;
                    default:
                        break;
                }
            }
        }
    }

}
