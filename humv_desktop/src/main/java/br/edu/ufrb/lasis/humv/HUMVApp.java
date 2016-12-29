package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.main.CarregandoJDialog;
import br.edu.ufrb.lasis.humv.view.main.HUMVMainWindow;
import br.edu.ufrb.lasis.humv.view.main.LoginJDialog;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URLEncoder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tassiovale
 */
public class HUMVApp {

    static {
        System.setProperty("logback.configurationFile", "logback.xml");
    }

    private final static Logger logger = LoggerFactory.getLogger(HUMVApp.class);
    private static HUMVMainWindow mainWindow;
    private static JPanel mainPanel = null;
    private static CarregandoJDialog carregandoDialog = null;
    private static String nomeUsuario;
    private static Usuario usuarioLogado = null;

    public static HUMVMainWindow getMainWindow() {
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
            carregandoDialog = new CarregandoJDialog(null);
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

    public static Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            if (nomeUsuario.equalsIgnoreCase("humv")) {
                usuarioLogado = new Usuario();
                usuarioLogado.setAtivo(true);
                usuarioLogado.setEmail("humv");
                usuarioLogado.setNome("humv");
                usuarioLogado.setPerfil(Usuario.PERFIL_ADMINISTRADOR);
            } else {
                try {
                    ClientResponse response = RESTMethods.get("/api/usuario/" + URLEncoder.encode(nomeUsuario, "UTF-8"));
                    usuarioLogado = (Usuario) RESTMethods.getObjectsFromJSON(response, new TypeReference<Usuario>() {
                    });
                } catch (RESTConnectionException | IOException ex) {
                    //JOptionPane.showMessageDialog(getMainWindow(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
                    logger.error("mensagem: " + ex.getMessage(), ex);
                }
            }
        }
        return usuarioLogado;
    }

    public static void invalidarUsuarioLogado() {
        HUMVApp.nomeUsuario = null;
        usuarioLogado = null;
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
                    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
