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
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author tassi
 */
public class PropriedadesBuscaUsuario extends PropriedadesBusca {

    private UsuarioTableModel tableModel;

    public PropriedadesBuscaUsuario(String tipoOperacao) {
        super(tipoOperacao);
    }

    @Override
    public void buscar() {
        HUMVApp.exibirBarraCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/usuario");
            List<Usuario> lista = (List<Usuario>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Usuario>>() {
            });
            tableModel = new UsuarioTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        HUMVApp.esconderBarraCarregamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(super.getBotaoBusca())) {
            buscar();
        } else if (e.getSource().equals(super.getBotaoOperacao())) {
            if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_VISUALIZAR)) {

            } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_ALTERAR)) {
                Usuario usuarioSelecionado = tableModel.getUsuarioSelecionado(getIndexLinhaSelecionada());
                CadastrarUsuarioPanel painelCadastrarUsuario = new CadastrarUsuarioPanel(usuarioSelecionado);
                HUMVApp.setNovoPainelCentral(painelCadastrarUsuario);
            } else if (super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)) {

            }
        }
    }

}
