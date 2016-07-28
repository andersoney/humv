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

/**
 *
 * @author Luiz
 */
public class PropriedadesBuscaSetor extends PropriedadesBusca {

    private SetorTableModel tableModel;
    private List<Setor> listaSetores;

    public PropriedadesBuscaSetor(String tipoOperacao) {
        super(tipoOperacao);
        tableModel = new SetorTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/setor/search?palavrachave=" + getCampoPalavraChave().getText());

            listaSetores = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {
            });
            tableModel = new SetorTableModel(listaSetores);
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum setor da tabela para realizar a operação.", "Setor não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                Setor setorSelecionado = tableModel.getSetorSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        if (MessageUtils.dialogoRemoverAlterar("alterar", "setor", setorSelecionado.getNome())) {
                            CadastrarSetorJPanel painel = new CadastrarSetorJPanel(setorSelecionado);
                            HUMVApp.setNovoPainelCentral(painel);
                        }   break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (MessageUtils.dialogoRemoverAlterar("remover", "setor", setorSelecionado.getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/setor", "" + setorSelecionado.getCodigo());
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
                        }   break;
                    default:
                        break;
                }
            }
        } else if (ae.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.print(PrintUtils.TABELA_SETORES, listaSetores);
        }
    }

}
