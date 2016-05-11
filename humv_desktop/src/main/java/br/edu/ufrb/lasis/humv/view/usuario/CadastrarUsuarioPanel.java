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
import br.edu.ufrb.lasis.humv.utils.SecurityUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tassiovale
 */
public class CadastrarUsuarioPanel extends javax.swing.JPanel implements ActionListener {
    
    private Usuario usuarioSelecionado = null;

    /**
     * Creates new form CadastrarUsuarioPanel
     */
    public CadastrarUsuarioPanel() {
        initComponents();
        customInitComponents();
    }
    
    /**
     * Creates new form CadastrarUsuarioPanel
     */
    public CadastrarUsuarioPanel(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        buttonOK.addActionListener(this);
        buttonCancelar.addActionListener(this);
        textFieldNome.setFocusable(true);
        
        if(usuarioSelecionado != null){
            labelTitulo.setText("Alteração de usuário");
            textFieldNome.setText(usuarioSelecionado.getNome());
            textFieldEmail.setText(usuarioSelecionado.getEmail());
            textFieldEmail.setEnabled(false);
            textFieldSiape.setText(usuarioSelecionado.getSiape().toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer siape;
        try {
            siape = Integer.parseInt(textFieldSiape.getText());
        } catch (NumberFormatException ex) {
            siape = -1;
        }

        if (e.getSource().equals(buttonOK)) {
            if (textFieldNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo nome não pode ser vazio.", "Nome inválido", JOptionPane.ERROR_MESSAGE);
                textFieldNome.setFocusable(true);
            } else if (textFieldEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo e-mail não pode ser vazio.", "E-mail inválido", JOptionPane.ERROR_MESSAGE);
                textFieldEmail.setFocusable(true);
            } else if (textFieldEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "E-mail inválido. Por favor, digite-o novamente.", "E-mail inválido", JOptionPane.ERROR_MESSAGE);
                textFieldEmail.setFocusable(true);
            } else if (!textFieldSiape.getText().isEmpty() && siape <= 0) {
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
                    usuario.setPerfil((String) comboBoxPerfilUsuario.getSelectedItem());
                    usuario.setAtivo(true);
                    
                    ClientResponse response;
                    if(usuarioSelecionado != null){
                        response = RESTMethods.put("/api/usuario", usuario);
                    }else{
                        response = RESTMethods.post("/api/usuario", usuario);
                    }
                             
                    String resposta = response.getEntity(String.class);
                    if (resposta.equals("OK")) {
                        JOptionPane.showMessageDialog(this, "Registro de usuário efetuado com sucesso", "Registro de usuário", JOptionPane.PLAIN_MESSAGE);
                        HUMVApp.setPainelCentralComLogo();
                    } else {
                        JOptionPane.showMessageDialog(this, resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                        textFieldNome.setFocusable(true);
                    }
                } catch (RESTConnectionException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao tentar conectar-se com o servidor. Por favor, tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao criptografar senha. Tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }

        } else if (e.getSource().equals(buttonCancelar)) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo cancelar esta operação?", "Cancelar cadastro", JOptionPane.OK_CANCEL_OPTION);
            if (resposta == JOptionPane.OK_OPTION) {
                HUMVApp.setPainelCentralComLogo();
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

        labelTitulo.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Cadastro de usuário");

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

        comboBoxPerfilUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { br.edu.ufrb.lasis.humv.utils.HUMVConfig.PERFIL_ADMINISTRADOR, br.edu.ufrb.lasis.humv.utils.HUMVConfig.PERFIL_RECEPCIONISTA, br.edu.ufrb.lasis.humv.utils.HUMVConfig.PERFIL_VETERINARIO, br.edu.ufrb.lasis.humv.utils.HUMVConfig.PERFIL_FARMACEUTICO}));

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonOK.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(34, 34, 34)
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
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNomeActionPerformed

    private void textFieldSiapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSiapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSiapeActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelarActionPerformed


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
