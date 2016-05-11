package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.view.main.HUMVMainWindow;
import br.edu.ufrb.lasis.humv.view.main.LoginDialog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tassiovale
 */
public class HUMVApp {

    private static JPanel mainPanel = null;
    private static HUMVMainWindow mainWindow;

    public static JPanel getMainPanelInstance() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
        }
        return mainPanel;
    }

    public static JProgressBar getBarraProgressoInstance() {
        JProgressBar barraProgresso = new JProgressBar();
        barraProgresso.setIndeterminate(true);
        barraProgresso.setString("Por favor, aguarde...");
        barraProgresso.setStringPainted(true);
        return barraProgresso;
    }

    public static void setPainelCentralComLogo() {
        getMainPanelInstance().removeAll();
        ImageIcon icon = new ImageIcon("images/humv-logo-name.png");
        JLabel labelLogo = new JLabel(icon);
        labelLogo.setBorder(new EmptyBorder(30, 0, 0, 0));
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

    public static void exibirBarraCarregamento() {
        //getMainPanelInstance().add(getBarraProgressoInstance(), BorderLayout.PAGE_END);
        //getMainPanelInstance().repaint();
        //getMainPanelInstance().revalidate();
    }

    public static void esconderBarraCarregamento() {
        //getMainPanelInstance().remove(getBarraProgressoInstance());
        //getMainPanelInstance().repaint();
        //getMainPanelInstance().revalidate();
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(HUMVMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                mainWindow = new HUMVMainWindow();
                mainWindow.setVisible(true);
                mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                mainWindow.setResizable(false);

                new LoginDialog(mainWindow).setVisible(true);
            }
        });
    }

}
