package br.edu.ufrb.lasis.humv.view.usuario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.SecurityUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author tassiovale
 */
public class CadastrarUsuarioJPanel extends javax.swing.JPanel {

    private Usuario usuarioSelecionado = null;

    /**
     * Creates new form CadastrarUsuarioPanel
     */
    public CadastrarUsuarioJPanel() {
        initComponents();
        customInitComponents();
    }

    /**
     * Creates new form CadastrarUsuarioPanel
     *
     * @param usuarioSelecionado
     */
    public CadastrarUsuarioJPanel(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        textFieldNome.setFocusable(true);

        if (usuarioSelecionado != null) {
            labelTitulo.setText("Alteração de usuário");
            textFieldNome.setText(usuarioSelecionado.getNome());
            textFieldEmail.setText(usuarioSelecionado.getEmail());
            textFieldEmail.setEnabled(false);
            textFieldSiape.setEnabled(false);
            textFieldSiape.setText(usuarioSelecionado.getSiape().toString());

            if (usuarioSelecionado.getPerfil().compareTo(Usuario.PERFIL_ADMINISTRADOR) == 0) {
                comboBoxPerfilUsuario.setSelectedItem(Usuario.ADMINISTRADOR);
            } else if (usuarioSelecionado.getPerfil().compareTo(Usuario.PERFIL_ASSISTENTE_SOCIAL) == 0) {
                comboBoxPerfilUsuario.setSelectedItem(Usuario.ASSISTENTE_SOCIAL);
            } else if (usuarioSelecionado.getPerfil().compareTo(Usuario.PERFIL_FARMACEUTICO) == 0) {
                comboBoxPerfilUsuario.setSelectedItem(Usuario.FARMACEUTICO);
            } else if (usuarioSelecionado.getPerfil().compareTo(Usuario.PERFIL_RECEPCIONISTA) == 0) {
                comboBoxPerfilUsuario.setSelectedItem(Usuario.RECEPCIONISTA);
            } else {
                comboBoxPerfilUsuario.setSelectedItem(Usuario.VETERINARIO);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldSiape = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        comboBoxPerfilUsuario = new javax.swing.JComboBox<>();
        buttonCancelar = new javax.swing.JButton();
        buttonOK = new javax.swing.JButton();
        passwordFieldSenha = new javax.swing.JPasswordField();
        passwordFieldConfirmSenha = new javax.swing.JPasswordField();

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("CADASTRO DE USUÁRIO");

        jLabel2.setText("Nome:");

        jLabel3.setText("SIAPE:");

        jLabel4.setText("E-mail:");

        jLabel5.setText("Senha:");

        jLabel6.setText("Repita a senha:");

        jLabel7.setText("Perfil do usuário:");

        textFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomeActionPerformed(evt);
            }
        });

        textFieldSiape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSiapeActionPerformed(evt);
            }
        });

        comboBoxPerfilUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { br.edu.ufrb.lasis.humv.entity.Usuario.ADMINISTRADOR, br.edu.ufrb.lasis.humv.entity.Usuario.RECEPCIONISTA, br.edu.ufrb.lasis.humv.entity.Usuario.VETERINARIO, br.edu.ufrb.lasis.humv.entity.Usuario.FARMACEUTICO, br.edu.ufrb.lasis.humv.entity.Usuario.ASSISTENTE_SOCIAL}));

        buttonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonOK.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        buttonOK.setText("Salvar");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNome)
                            .addComponent(textFieldSiape)
                            .addComponent(textFieldEmail)
                            .addComponent(comboBoxPerfilUsuario, 0, 200, Short.MAX_VALUE)
                            .addComponent(passwordFieldSenha)
                            .addComponent(passwordFieldConfirmSenha))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passwordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(passwordFieldConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonCancelar))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNomeActionPerformed

    private void textFieldSiapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSiapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSiapeActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo cancelar esta operação?", "Cancelar cadastro", JOptionPane.OK_CANCEL_OPTION);
        if (resposta == JOptionPane.OK_OPTION) {
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        BigInteger siape;
        /*
        try {
            if(textFieldSiape.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "O campo SIAPE não pode ser vazio.", "SIAPE inválido", JOptionPane.ERROR_MESSAGE);
                textFieldSiape.setFocusable(true);
                return;
            }
            if(Integer.parseInt(textFieldSiape.getText())<=0){
                JOptionPane.showMessageDialog(this, "O campo SIAPE não pode ser negativo.", "SIAPE inválido", JOptionPane.ERROR_MESSAGE);
                textFieldSiape.setFocusable(true);
                return;
            }
            siape = new BigInteger(textFieldSiape.getText());
        } catch (NumberFormatException ex) {
            //siape = new BigInteger("-1");
            JOptionPane.showMessageDialog(this, "O campo SIAPE não parece válido.", "SIAPE inválido", JOptionPane.ERROR_MESSAGE);
            textFieldSiape.setFocusable(true);
            return;
        }
        */
        if(textFieldSiape.getText().isEmpty()){
            siape = new BigInteger("-1");
        }else{
            siape = new BigInteger(textFieldSiape.getText());
        }
        if (textFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo nome não pode ser vazio.", "Nome inválido", JOptionPane.ERROR_MESSAGE);
            textFieldNome.setFocusable(true);
        } else if (textFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo e-mail não pode ser vazio.", "E-mail inválido", JOptionPane.ERROR_MESSAGE);
            textFieldEmail.setFocusable(true);
        } else if (textFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "E-mail inválido. Por favor, digite-o novamente.", "E-mail inválido", JOptionPane.ERROR_MESSAGE);
            textFieldEmail.setFocusable(true);
        } else if (!textFieldSiape.getText().isEmpty() && siape.compareTo(new BigInteger("0")) <= 0) {
            JOptionPane.showMessageDialog(this, "O campo SIAPE deve conter apenas números.", "SIAPE inválido", JOptionPane.ERROR_MESSAGE);
            textFieldSiape.setText("");
            textFieldSiape.setFocusable(true);
        } else if (new String(passwordFieldSenha.getPassword()).length() < 4) {
            JOptionPane.showMessageDialog(this, "A senha deve possuir 4 (quatro) ou mais caracteres.", "Senha inválida", JOptionPane.ERROR_MESSAGE);
            passwordFieldSenha.setFocusable(true);
        } else if (!(new String(passwordFieldSenha.getPassword()).equals(new String(passwordFieldConfirmSenha.getPassword())))) {
            JOptionPane.showMessageDialog(this, "Senhas não conferem. Por favor, digite-as novamente.", "Senha inválida", JOptionPane.ERROR_MESSAGE);
            passwordFieldSenha.setText("");
            passwordFieldConfirmSenha.setText("");
            passwordFieldSenha.setFocusable(true);
        } else {

            try {
                Usuario usuario = new Usuario();
                usuario.setNome(textFieldNome.getText());
                usuario.setSiape(siape);
                usuario.setEmail(textFieldEmail.getText());
                usuario.setSenha(SecurityUtils.criptography(new String(passwordFieldSenha.getPassword())));

                String perfilEscolhido = (String) comboBoxPerfilUsuario.getSelectedItem();
                switch (perfilEscolhido) {
                    case Usuario.ADMINISTRADOR:
                        usuario.setPerfil(Usuario.PERFIL_ADMINISTRADOR);
                        break;
                    case Usuario.ASSISTENTE_SOCIAL:
                        usuario.setPerfil(Usuario.PERFIL_ASSISTENTE_SOCIAL);
                        break;
                    case Usuario.FARMACEUTICO:
                        usuario.setPerfil(Usuario.PERFIL_FARMACEUTICO);
                        break;
                    case Usuario.VETERINARIO:
                        usuario.setPerfil(Usuario.PERFIL_VETERINARIO);
                        break;
                    default:
                        usuario.setPerfil(Usuario.PERFIL_RECEPCIONISTA);
                }

                usuario.setAtivo(true);

                ClientResponse response;
                if (usuarioSelecionado != null) {
                    if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "usuário", usuarioSelecionado.getNome())) {
                        response = RESTMethods.put("/api/usuario", usuario);
                    } else {
                        return;
                    }
                } else {
                    response = RESTMethods.post("/api/usuario", usuario);

                }

                String resposta = response.getEntity(String.class
                );
                if (resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.sucessoCadastro("usuário");
                    HUMVApp.setPainelCentralComLogo();
                } else {
                    InterfaceGraficaUtils.erroResposta(resposta);
                    textFieldNome.setFocusable(true);
                }
            } catch (RESTConnectionException ex) {
                InterfaceGraficaUtils.erroConexao();
                ex.printStackTrace();
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao criptografar senha. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox<String> comboBoxPerfilUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPasswordField passwordFieldConfirmSenha;
    private javax.swing.JPasswordField passwordFieldSenha;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldSiape;
    // End of variables declaration//GEN-END:variables

}
