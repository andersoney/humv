/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.Animais;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.usuario.UsuarioTableModel;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Andersoney
 */
public class PropriedadeBuscarAnimais extends PropriedadesBusca {

    private AnimalTableModel animalTableModel;
    private static final Logger LOG = Logger.getLogger(PropriedadeBuscarAnimais.class.getName());
    AnimalTableModel tableModel;

    public PropriedadeBuscarAnimais(String tipoOperacao) {
        super(tipoOperacao);
        animalTableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(animalTableModel));
    }

    @Override
    public void buscar() {
        try {
            ClientResponse response = RESTMethods.get("/api/animalGrande");

            List<AnimalGrande> lista = (List<AnimalGrande>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<AnimalGrande>>() {
            });
            tableModel = new AnimalTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        HUMVApp.esconderMensagemCarregamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Verificar condições para busca.
        this.buscar();
    }

}
