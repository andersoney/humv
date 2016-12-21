/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.reports.PrintUtils;
import br.edu.ufrb.lasis.humv.reports.QuestionarioSocioeconomicoReport;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Orion
 */
public class PropriedadesBuscaQuestionarioSocioeconomico extends PropriedadesBusca {

    private final static Logger logger = LoggerFactory.getLogger(PropriedadesBuscaQuestionarioSocioeconomico.class);
    private QuestionarioSocialTableModel tableModel;
    private List<QuestionarioSocioeconomico> listaQuest;

    public PropriedadesBuscaQuestionarioSocioeconomico(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new QuestionarioSocialTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/questionarioSocioeconomico/search?palavrachave=" + getCampoPalavraChave().getText());
            listaQuest = (List<QuestionarioSocioeconomico>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<QuestionarioSocioeconomico>>() {
            });
            tableModel.setQuestionarios(listaQuest);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            InterfaceGraficaUtils.erroConexao();
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum Questionario social da tabela para realizar a operação.", "Questionario social não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                QuestionarioSocioeconomico questionario = tableModel.getQuestionario(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "Questionario social", questionario.getDono().getNome())) {
                            QuestionarioSocioEconomicoJPanel painel = new QuestionarioSocioEconomicoJPanel(questionario);
                            HUMVApp.setNovoPainelCentral(painel);
                        }
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "Questionario social", questionario.getDono().getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/questionarioSocioeconomico", "" + questionario.getId());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Questionario social removido com sucesso", "Remoção de Questionario social", JOptionPane.PLAIN_MESSAGE);
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
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            if (super.getIndexLinhaSelecionada() < 0) {
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum Questionario social da tabela para realizar a operação.", "Questionario social não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                List listaQuestionarios = new ArrayList();

                QuestionarioSocioeconomicoReport report = QuestionarioSocioeconomicoReport.fillReportObject(tableModel.getQuestionario(super.getIndexLinhaSelecionada()));
                listaQuestionarios.add(report);
                PrintUtils.printLista(PrintUtils.QUESTIONARIO_SOCIOECONOMICO, listaQuestionarios);
            }
        } else if (e.getSource().equals(super.getBotaoCancelar())) {
            boolean sair = InterfaceGraficaUtils.dialogoSair();
            if (sair) {
                HUMVApp.setPainelCentralComLogo();
            }
        }
    }

}
