package br.edu.ufrb.lasis.humv.view.atendimentosocial;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Toni
 */
public class PropriedadesBuscaAtendimentoSocial extends PropriedadesBusca {

    private final static Logger logger = LoggerFactory.getLogger(PropriedadesBuscaAtendimentoSocial.class);
    private AtendimentoSocialTableModel tableModel;
    private List<AtendimentoSocial> listaAtendimentoSocial;
    private ResultadoBusca resultadoBusca;

    public PropriedadesBuscaAtendimentoSocial(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new AtendimentoSocialTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    public PropriedadesBuscaAtendimentoSocial(String tipoOperacao, JFrame jFrame, ResultadoBusca resultadoBusca) {
        super(tipoOperacao, jFrame);
        this.resultadoBusca = resultadoBusca;
        tableModel = new AtendimentoSocialTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/atendimentoSocial/search?palavrachave=" + getPalavraChave());

            listaAtendimentoSocial = (List<AtendimentoSocial>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<AtendimentoSocial>>() {
            });
            System.out.println("SIZE: " + listaAtendimentoSocial.size());
            tableModel = new AtendimentoSocialTableModel(listaAtendimentoSocial);
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum atendimento social da tabela para realizar a operação.", "Atendimento social não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                AtendimentoSocial atendimentoSocialSelecionado = tableModel.getAtendimentoSocialSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        CadastrarAtendimentoSocialJPanel painelCadastroAtendimentoSocial = new CadastrarAtendimentoSocialJPanel(atendimentoSocialSelecionado);
                        HUMVApp.setNovoPainelCentral(painelCadastroAtendimentoSocial);
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "atendimento social para", atendimentoSocialSelecionado.getAnimal().getDono().getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/atendimentoSocial", "" + atendimentoSocialSelecionado.getId());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Atendimento social removido com sucesso", "Remoção de atendimento social", JOptionPane.PLAIN_MESSAGE);
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
                        resultadoBusca.setResultado(atendimentoSocialSelecionado);
                        getjFrame().dispose();
                        break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            if (super.getIndexLinhaSelecionada() < 0) {
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum atendimento social da tabela para realizar a operação.", "Atendimento social não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                List listaAtendimentoSocial = new ArrayList();
                listaAtendimentoSocial.add(tableModel.getAtendimentoSocialSelecionado(super.getIndexLinhaSelecionada()));
                PrintUtils.printLista(PrintUtils.ATENDIMENTO_SOCIAL, listaAtendimentoSocial);
            }
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
