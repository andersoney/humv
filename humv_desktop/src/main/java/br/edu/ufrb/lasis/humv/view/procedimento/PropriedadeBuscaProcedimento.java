/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.procedimento;

/**
 *
 * @author Luiz
 */
import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
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

public class PropriedadeBuscaProcedimento extends PropriedadesBusca{

    
    private final ProcedimentoTableModel procedimentoTableModel;
    private static final Logger LOG = Logger.getLogger(PropriedadeBuscaProcedimento.class.getName());
    ProcedimentoTableModel tableModel;

    public PropriedadeBuscaProcedimento(String tipoOperacao) {
        super(tipoOperacao);
        procedimentoTableModel = new ProcedimentoTableModel();
        super.setTabelaResultado(new JTable(procedimentoTableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/procedimento");

            List<Procedimento> lista = (List<Procedimento>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Procedimento>>() {});
            tableModel = new ProcedimentoTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
        }
        HUMVApp.esconderMensagemCarregamento();
    }

    /**
     *
     * @param e
     */
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum procedimento da tabela para realizar a operação.", "Procedimento não selecionado", JOptionPane.ERROR_MESSAGE);             
            } else {
                Procedimento procedimentoSelecionado = tableModel.getProcedimentoSelecionado(super.getIndexLinhaSelecionada());
                if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_VISUALIZAR)) {
                    //Ainda falta implementar
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_ALTERAR)) {
                    CadastroProcedimento painelAlteracao = new CadastroProcedimento(procedimentoSelecionado);
                    HUMVApp.setNovoPainelCentral(painelAlteracao);
                } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)) {
                    try {
                        ClientResponse response = RESTMethods.delete("/api/procedimento", ""+procedimentoSelecionado.getCodigo());
                        String resposta = response.getEntity(String.class);
                        if (resposta.equals("OK")) {
                            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Procedimento removido com sucesso", "Remoção de procedimento", JOptionPane.PLAIN_MESSAGE);
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
