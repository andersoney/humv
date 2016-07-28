package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.view.main.CarregandoJDialog;
import br.edu.ufrb.lasis.humv.view.main.HUMVMainWindow;
import br.edu.ufrb.lasis.humv.view.main.LoginJDialog;
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

    private static HUMVMainWindow mainWindow;
    private static JPanel mainPanel = null;
    private static CarregandoJDialog carregandoDialog = null;
    private static String nomeUsuario;
    
    public static HUMVMainWindow getMainWindow(){
        return mainWindow;
    }

    public static JPanel getMainPanelInstance() {
        if (mainPanel == null) {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
        }
        return mainPanel;
    }

    private static CarregandoJDialog getCarregandoDialogInstance() {
        if (carregandoDialog == null) {
            carregandoDialog = new CarregandoJDialog(mainWindow);
            carregandoDialog.pack();
        }
        return carregandoDialog;
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String usuario) {
        HUMVApp.nomeUsuario = usuario;
    }

    public static void setPainelCentralComLogo() {
        getMainPanelInstance().removeAll();
        ImageIcon img = new ImageIcon("imagens/humv-logo-name.png");
        JLabel labelLogo = new JLabel(img);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        getMainPanelInstance().add(labelLogo, BorderLayout.CENTER);
        getMainPanelInstance().repaint();
        getMainPanelInstance().revalidate();
        System.gc();
    }

    public static void setNovoPainelCentral(JPanel panel) {
        getMainPanelInstance().removeAll();
        JPanel outsidePanel = new JPanel(new FlowLayout());
        outsidePanel.add(panel);
        outsidePanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        getMainPanelInstance().add(outsidePanel, BorderLayout.CENTER);
        getMainPanelInstance().repaint();
        getMainPanelInstance().revalidate();
        System.gc();
    }

    public static void exibirMensagemCarregamento() {
        HUMVApp.getCarregandoDialogInstance().setVisible(true);
    }

    public static void esconderMensagemCarregamento() {
        HUMVApp.getCarregandoDialogInstance().dispose();
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
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                 
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(HUMVMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

                mainWindow = new HUMVMainWindow();
                mainWindow.setVisible(true);
                mainWindow.setExtendedState(mainWindow.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                mainWindow.setResizable(false);

                new LoginJDialog(mainWindow).setVisible(true);

                //Instanciar de início o dialog de carregando
                HUMVApp.getCarregandoDialogInstance();
            }
        });
    }

}
