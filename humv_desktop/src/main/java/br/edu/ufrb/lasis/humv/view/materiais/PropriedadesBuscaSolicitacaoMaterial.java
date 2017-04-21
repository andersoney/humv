package br.edu.ufrb.lasis.humv.view.materiais;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;
import br.edu.ufrb.lasis.humv.reports.PrintUtils;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropriedadesBuscaSolicitacaoMaterial  extends PropriedadesBusca {
    private final static Logger logger = LoggerFactory.getLogger(PropriedadesBuscaMaterial.class);
    private SolicitacaoMaterialTableModel tableModel;
    private List<SolicitacaoMaterial> listaSolicitacoesMateriais;
    private ResultadoBusca resultadoBusca = null;

    public PropriedadesBuscaSolicitacaoMaterial(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new SolicitacaoMaterialTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    public PropriedadesBuscaSolicitacaoMaterial(String tipoOperacao, JFrame jFrame, ResultadoBusca resultadoBusca) {
        super(tipoOperacao, jFrame);
        this.resultadoBusca = resultadoBusca;
        tableModel = new SolicitacaoMaterialTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/solicitacaoMaterial/search?");

            listaSolicitacoesMateriais = (List<SolicitacaoMaterial>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<SolicitacaoMaterial>>() {
            });
            tableModel = new SolicitacaoMaterialTableModel(listaSolicitacoesMateriais);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            InterfaceGraficaUtils.erroConexao();
            logger.error("mensagem: " + ex.getMessage(), ex);
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum material da tabela para realizar a operação.", "Material não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                SolicitacaoMaterial solicitacaoMaterialSelecionado = tableModel.getSolicitcaoMaterialSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "solicitação de material", solicitacaoMaterialSelecionado.getMaterial().getDiscriminacao())) {
                            CadastrarSolicitacaoMaterial painel = new CadastrarSolicitacaoMaterial(solicitacaoMaterialSelecionado);
                            HUMVApp.setNovoPainelCentral(painel);
                        }
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "solicitação de material", solicitacaoMaterialSelecionado.getMaterial().getDiscriminacao())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/solicitacaoMaterial", "" + solicitacaoMaterialSelecionado.getId());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Material removido com sucesso", "Remoção de Material", JOptionPane.PLAIN_MESSAGE);
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
                        resultadoBusca.setResultado(solicitacaoMaterialSelecionado);
                        getjFrame().dispose();
                        break;
                    default:
                        break;
                }
            }
        } else if (ae.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.printLista(PrintUtils.TABELA_SETORES, listaSolicitacoesMateriais);
        } else if (ae.getSource().equals(super.getBotaoCancelar())) {
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