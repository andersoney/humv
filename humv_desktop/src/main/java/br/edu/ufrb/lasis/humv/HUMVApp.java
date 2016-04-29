package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.view.main.HUMVMainWindow;
import br.edu.ufrb.lasis.humv.view.main.LoginDialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tassiovale
 */
public class HUMVApp {

    public static JPanel mainPanel = null;

    public static JPanel getMainPanelInstance() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
        }
        return mainPanel;
    }

    public static void setPainelCentralComLogo() {
        getMainPanelInstance().removeAll();
        ImageIcon icon = new ImageIcon("images/humv-logo-name.png");
        JLabel labelLogo = new JLabel(icon);
        labelLogo.setBorder(new EmptyBorder(50, 0, 0, 0));
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        getMainPanelInstance().add(labelLogo, BorderLayout.CENTER);
        getMainPanelInstance().repaint();
        getMainPanelInstance().revalidate();
    }

    public static void setNovoPainelCentral(JPanel panel) {
        getMainPanelInstance().removeAll();
        JPanel outsidePanel = new JPanel(new FlowLayout());
        outsidePanel.add(panel);
        outsidePanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        getMainPanelInstance().add(outsidePanel, BorderLayout.CENTER);
        getMainPanelInstance().repaint();
        getMainPanelInstance().revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*try {
            ClientResponse response = RESTMethods.get("/api/hello");
            
            //Opção 1: para recuperar uma lista de objetos
            List<Hello> list = (List<Hello>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Hello>>(){});
            for(int i=0; i < list.size(); i++){
                Hello hello = (Hello) list.get(i);
                System.out.println("Text: " + hello.getContent());
            }
            
            //Opção 2: para retornar um objeto único
            //String output = response.getEntity(String.class);
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Usuario usuario = new Usuario();
        usuario.setNome("Tassio");
        usuario.setSiape(2126496);
        ClientResponse response;
        try {
            response = RESTMethods.post("/api/usuario", usuario);
            String resposta = response.getEntity(String.class);
        } catch (RESTConnectionException ex) {
            Logger.getLogger(HUMVApp.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HUMVMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        HUMVMainWindow mainWindow = new HUMVMainWindow();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("HUMV UFRB v1.0");
        ImageIcon img = new ImageIcon("images/humv-logo-jframe.ico");
        mainWindow.setIconImage(img.getImage());
        mainWindow.setVisible(true);
        mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mainWindow.setResizable(false);

        new LoginDialog(mainWindow, true).setVisible(true);
    }

}
