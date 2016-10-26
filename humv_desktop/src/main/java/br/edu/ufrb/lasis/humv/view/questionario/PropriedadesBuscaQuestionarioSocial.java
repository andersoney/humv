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
import br.edu.ufrb.lasis.humv.utils.PrintUtils;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Orion
 */
public class PropriedadesBuscaQuestionarioSocial extends PropriedadesBusca {
    
    private QuestionarioSocialTableModel tableModel;
    private List<QuestionarioSocioeconomico> listaQuest;
    
    public PropriedadesBuscaQuestionarioSocial(String tipoOperacao) {
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
            ex.printStackTrace();
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum projeto da tabela para realizar a operação.", "Projeto não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                QuestionarioSocioeconomico questionario = tableModel.getQuestionario(super.getIndexLinhaSelecionada());
                LOG.info("Dono: " + questionario.getDono().getNome());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        //if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "projeto", questionario.getDono().getNome())) {
                        QuestionarioSocioEconomicoJPanel painel = new QuestionarioSocioEconomicoJPanel(questionario);
                        HUMVApp.setNovoPainelCentral(painel);
                        //}
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "projeto", questionario.getDono().getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/questionarioSocioeconomico", "" + questionario.getId());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Projeto removido com sucesso", "Remoção de projeto", JOptionPane.PLAIN_MESSAGE);
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
            PrintUtils.print(PrintUtils.TABELA_PROJETOS, listaQuest);
        } else if (e.getSource().equals(super.getBotaoCancelar())) {
            boolean sair = InterfaceGraficaUtils.dialogoSair();
            if (sair) {
                HUMVApp.setPainelCentralComLogo();
            }
        }
    }
    private static final Logger LOG = Logger.getLogger(PropriedadesBuscaQuestionarioSocial.class.getName());
    
}
