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

public class PropriedadesBuscaProcedimento extends PropriedadesBusca {

    private ProcedimentoTableModel tableModel;
    private List<Procedimento> listaProcedimentos;

    public PropriedadesBuscaProcedimento(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new ProcedimentoTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/procedimento/search?palavrachave=" + getCampoPalavraChave().getText());

            listaProcedimentos = (List<Procedimento>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Procedimento>>() {
            });
            tableModel = new ProcedimentoTableModel(listaProcedimentos);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            MessageUtils.erroConexao();
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
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        CadastrarProcedimentoJPanel painelAlteracao = new CadastrarProcedimentoJPanel(procedimentoSelecionado);
                        HUMVApp.setNovoPainelCentral(painelAlteracao);
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (MessageUtils.dialogoRemoverAlterar("remover", "procedimento", procedimentoSelecionado.getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/procedimento", "" + procedimentoSelecionado.getCodigo());
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
                        }   break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.print(PrintUtils.TABELA_PROCEDIMENTOS, listaProcedimentos);
        }
    }
}
