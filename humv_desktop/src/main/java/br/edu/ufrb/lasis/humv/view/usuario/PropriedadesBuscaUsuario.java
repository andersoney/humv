/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.usuario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.reports.PrintUtils;
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

/**
 *
 * @author tassi
 */
public class PropriedadesBuscaUsuario extends PropriedadesBusca {

    private final static Logger logger = LoggerFactory.getLogger(PropriedadesBuscaUsuario.class);
    private UsuarioTableModel tableModel;
    private List<Usuario> listaUsuarios;
    private ResultadoBusca resultadoBusca;

    public PropriedadesBuscaUsuario(String tipoOperacao) {
        super(tipoOperacao);
    }
    
    public PropriedadesBuscaUsuario(String tipoOperacao, JFrame jFrame, ResultadoBusca resultadoBusca) {
        super(tipoOperacao, jFrame);
        this.resultadoBusca = resultadoBusca;
        tableModel = new UsuarioTableModel();
        super.setTabelaResultado(new JTable(tableModel));
    }

    @Override
    public void buscar() {
        try {
            ClientResponse response = RESTMethods.get("/api/usuario/search?palavrachave=" + getPalavraChave());
            listaUsuarios = (List<Usuario>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<Usuario>>() {
            });
            tableModel = new UsuarioTableModel(listaUsuarios);
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
                JOptionPane.showMessageDialog(super.getTabelaResultado(), "Por favor, selecione algum usuário da tabela para realizar a operação.", "Usuário não selecionado", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario usuarioSelecionado = tableModel.getUsuarioSelecionado(super.getIndexLinhaSelecionada());
                switch (super.getTipoOperacao()) {
                    case PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR:
                        CadastrarUsuarioJPanel painelCadastrarUsuario = new CadastrarUsuarioJPanel(usuarioSelecionado);
                        HUMVApp.setNovoPainelCentral(painelCadastrarUsuario);
                        break;
                    case PropriedadesBusca.OPCAO_REMOVER:
                        if (InterfaceGraficaUtils.dialogoRemoverAlterar("remover", "usuário", usuarioSelecionado.getNome())) {
                            try {
                                ClientResponse response = RESTMethods.delete("/api/usuario", usuarioSelecionado.getEmail());
                                String resposta = response.getEntity(String.class);
                                if (resposta.equals("OK")) {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), "Usuário removido com sucesso", "Remoção de usuário", JOptionPane.PLAIN_MESSAGE);
                                    HUMVApp.setPainelCentralComLogo();
                                } else {
                                    JOptionPane.showMessageDialog(super.getTabelaResultado(), resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (RESTConnectionException ex) {
                                InterfaceGraficaUtils.erroConexao();
                                logger.error("mensagem: " + ex.getMessage(), ex);
                            }
                        }
                        break;
                    case PropriedadesBusca.OPCAO_SELECIONAR:
                        resultadoBusca.setResultado(usuarioSelecionado);
                        getjFrame().dispose();
                        break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.printLista(PrintUtils.TABELA_USUARIOS, listaUsuarios);
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
