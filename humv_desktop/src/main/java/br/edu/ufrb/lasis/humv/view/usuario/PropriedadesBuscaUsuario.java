/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.usuario;

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
public class PropriedadesBuscaUsuario extends PropriedadesBusca{

    public PropriedadesBuscaUsuario(String tipoOperacao) {
        super(tipoOperacao);
    }

    @Override
    public void buscar() {
        try{
        //escrever código que faz a consulta ao banco de dados e constrói o table model apropriado
        ClientResponse response = RESTMethods.get("/api/usuario");
        List<Usuario> lista = (List<Usuario>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Usuario>>(){});
        UsuarioTableModel tableModel = new UsuarioTableModel(lista);
        super.getTabelaResultado().setModel(tableModel);
        super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(super.getBotaoBusca())){
            buscar();
        }else
            if(e.getSource().equals(super.getBotaoOperacao())){
                if(super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_VISUALIZAR)){
                    
                }else
                    if(super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_ALTERAR)){
                        
                    }else
                        if(super.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)){
                            
                        }
            }
    }
    
}
