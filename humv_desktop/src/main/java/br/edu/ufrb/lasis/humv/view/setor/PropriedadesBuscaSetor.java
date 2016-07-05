/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Luiz
 */
public class PropriedadesBuscaSetor extends PropriedadesBusca {

    private final SetorTabelModel setorTableModel;
    private static final Logger LOG = Logger.getLogger(PropriedadesBuscaSetor.class.getName());
    SetorTabelModel tableModel;

    public PropriedadesBuscaSetor(String tipoOperacao) {
        super(tipoOperacao);
        setorTableModel = new SetorTabelModel();
        super.setTabelaResultado(new JTable(setorTableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/setor");

            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {});
            tableModel = new SetorTabelModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
             Logger.getLogger(PropriedadesBuscaSetor.class.getName()).log(Level.SEVERE, null, ex);
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum setor da tabela para realizar a operação.", "Setor não selecionado", JOptionPane.ERROR_MESSAGE);             
            } else {
                Setor setorSelecionado = tableModel.getSetorSelecionado(super.getIndexLinhaSelecionada());
                if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_VISUALIZAR)) {
                    //Ainda falta implementar
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_ALTERAR)) {
                    CadastrarSetorJPanel painel = new CadastrarSetorJPanel(setorSelecionado);
                    HUMVApp.setNovoPainelCentral(painel);
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)) {
                    try {
                        ClientResponse response = RESTMethods.delete("/api/setor", ""+setorSelecionado.getCodigo());
                        String resposta = response.getEntity(String.class);
                        if (resposta.equals("OK")) {
                            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Setor removido com sucesso", "Remoção de setor", JOptionPane.PLAIN_MESSAGE);
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
    