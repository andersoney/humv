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
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tassi
 */
public class PropriedadesBuscaUsuario extends PropriedadesBusca {

    private UsuarioTableModel tableModel;
    private List<Usuario> listaUsuarios;

    public PropriedadesBuscaUsuario(String tipoOperacao) {
        super(tipoOperacao);
    }

    @Override
    public void buscar() {
        try {
            ClientResponse response = RESTMethods.get("/api/usuario/search?palavrachave=" + getCampoPalavraChave().getText());
            listaUsuarios = (List<Usuario>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Usuario>>() {
            });
            tableModel = new UsuarioTableModel(listaUsuarios);
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
                                ex.printStackTrace();
                            }
                        }   break;
                    default:
                        break;
                }
            }
        } else if (e.getSource().equals(super.getBotaoImprimirTabela())) {
            PrintUtils.printLista(PrintUtils.TABELA_USUARIOS, listaUsuarios);
        } else if (e.getSource().equals(super.getBotaoCancelar())) {
            boolean sair = InterfaceGraficaUtils.dialogoSair();
            if (sair) {
                HUMVApp.setPainelCentralComLogo();
            }
        }
    }

}
