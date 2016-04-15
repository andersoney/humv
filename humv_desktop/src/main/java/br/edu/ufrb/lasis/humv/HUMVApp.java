package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.entity.Hello;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.HUMVMainWindow;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author tassiovale
 */
public class HUMVApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {

            RESTMethods.setUsername("temporary");
            RESTMethods.setPassword("temporary");
            ClientResponse response = RESTMethods.get("/hello");
            
            //Opção 1: para recuperar uma lista de objetos
            List<Hello> list = (List<Hello>) RESTMethods.getListFromJSON(response, new TypeReference<List<Hello>>(){});
            for(int i=0; i < list.size(); i++){
                Hello hello = (Hello) list.get(i);
                System.out.println("Text: " + hello.getContent());
            }
            
            //Opção 2: para retornar um objeto único
            //String output = response.getEntity(String.class);
        
        } catch (IOException ex) {
            Logger.getLogger(HUMVApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VetMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VetMainWindow mainWindow = new VetMainWindow();
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setVisible(true);
                mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                mainWindow.setResizable(false);
            }
        /*
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VetMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VetMainWindow mainWindow = new VetMainWindow();
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setVisible(true);
                mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                mainWindow.setResizable(false);
            }
        });*/
    }

}
