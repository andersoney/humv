/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.Util;
import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Andersoney
 */
public class CadastrarDonoJPanel extends javax.swing.JPanel {

    final String servicoDono = "/api/dono";
    private String id;
    private String tipoId;
    /**
     * Creates new form CadastrarDono
     */
    public CadastrarDonoJPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nomeJL = new javax.swing.JLabel();
        nomeJTF = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldCpf = MaskUtils.mascaraCpf();
        telefoneJL = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldTelefone=MaskUtils.mascaraTelefone();
        jRadioButtonCpf = new javax.swing.JRadioButton();
        jRadioButtonCpf.setSelected(true);
        jRadioButtonCnpj = new javax.swing.JRadioButton();
        jTextFieldCnpj = new javax.swing.JTextField();
        jTextFieldCnpj = MaskUtils.mascaraCnpj();
        jPanel5 = new javax.swing.JPanel();
        enderecoJL2 = new javax.swing.JLabel();
        enderecoJTF2 = new javax.swing.JTextField();
        jTextFieldCep = new javax.swing.JTextField();
        jTextFieldCep = MaskUtils.mascaraCep();
        cepJL2 = new javax.swing.JLabel();
        cidadeJRB2 = new javax.swing.JRadioButton();
        cidadeJRB2.setSelected(true);
        fazendaJRB = new javax.swing.JRadioButton();
        estadoJCB = new javax.swing.JComboBox<>();
        cidadeFazendaJTF = new javax.swing.JTextField();
        cidadeFazendaJL = new javax.swing.JLabel();
        cancelarJB = new javax.swing.JButton();
        confirmarJB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do cliente"));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });

        nomeJL.setText("Nome");

        telefoneJL.setText("Telefone");

        jRadioButtonCpf.setText("CPF");
        jRadioButtonCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCpfActionPerformed(evt);
            }
        });

        jRadioButtonCnpj.setText("CNPJ");
        jRadioButtonCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCnpjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(telefoneJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonCnpj))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJL)
                    .addComponent(jRadioButtonCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneJL)
                    .addComponent(jRadioButtonCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        enderecoJL2.setText("Endereço");

        cepJL2.setText("CEP");

        cidadeJRB2.setText("Cidade");
        cidadeJRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeJRB2ActionPerformed(evt);
            }
        });

        fazendaJRB.setText("Fazenda");
        fazendaJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazendaJRBActionPerformed(evt);
            }
        });

        estadoJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estados", "Acre", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba ", "Paraná ", "Pernambuco", "Piauí ", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", " " }));

        cidadeFazendaJL.setText("Cidade");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cidadeFazendaJTF)
                    .addComponent(enderecoJL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(fazendaJRB)
                                .addGap(18, 18, 18)
                                .addComponent(cidadeJRB2))
                            .addComponent(enderecoJTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cidadeFazendaJL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(estadoJCB, javax.swing.GroupLayout.Alignment.TRAILING, 0, 200, Short.MAX_VALUE)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(cepJL2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enderecoJL2)
                            .addComponent(cepJL2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoJTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeJRB2)
                    .addComponent(fazendaJRB)
                    .addComponent(estadoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(cidadeFazendaJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeFazendaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cancelarJB.setText("Cancelar");
        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        confirmarJB.setText("Confirmar");
        confirmarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarJBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CADASTRAMENTO DE DONO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarJB)
                    .addComponent(cancelarJB))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4KeyPressed

    private void cidadeJRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeJRB2ActionPerformed
        // TODO add your handling code here:
        this.fazendaJRB.setSelected(false);
        this.cidadeFazendaJL.setText("Cidade");
    }//GEN-LAST:event_cidadeJRB2ActionPerformed

    private void fazendaJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazendaJRBActionPerformed
        // TODO add your handling code here:
        this.cidadeJRB2.setSelected(false);
        this.cidadeFazendaJL.setText("Fazenda");
    }//GEN-LAST:event_fazendaJRBActionPerformed

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        // TODO add your handling code here:
        int i = MessagesUtils.dialogoCancelar("o cadastro", "dono");
        if (i == JOptionPane.OK_OPTION) {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_cancelarJBActionPerformed

    private void confirmarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarJBActionPerformed
        // TODO add your handling code here:
        if (!Util.isNotNull(this.nomeJTF.getText())) {
            MessagesUtils.validaCampoVazio("nome");
            return;
        }
        String nome = this.nomeJTF.getText();
        if(jRadioButtonCpf.isSelected()){
            if (!Util.isCPF(this.jTextFieldCpf.getText())) {
                MessagesUtils.validaCampoInvalido("CPF");
                return;
            }
            id = this.jTextFieldCpf.getText();
        }
        if(jRadioButtonCnpj.isSelected()){
            if (!Util.isCNPJ(this.jTextFieldCnpj.getText())) {
                MessagesUtils.validaCampoInvalido("CNPJ");
                return;
            }
            id = this.jTextFieldCnpj.getText();
        }
        if (!Util.isNotNull(this.jTextFieldTelefone.getText())) {
            MessagesUtils.validaCampoVazio("telefone");
            return;
        }
        String telefone = this.jTextFieldTelefone.getText();
        if (!Util.isNotNull(this.enderecoJTF2.getText())) {
            MessagesUtils.validaCampoVazio("endereço");
            return;
        }
        String endereco = this.enderecoJTF2.getText();
        if (!Util.isNotNull(this.jTextFieldCep.getText())) {
            MessagesUtils.validaCampoVazio("CEP");
            return;
        }
        String cep = this.jTextFieldCep.getText();
        String local;
        if (this.cidadeJRB2.isSelected()) {
            local = "Cidade";
        } else {
            local = "Fazenda";
        }
        if (!Util.isNotNull(this.cidadeFazendaJTF.getText())) {
            MessagesUtils.validaCampoVazio(local);
            return;
        }
        String localT = local + ": " + this.cidadeFazendaJTF.getText();
        String estado;
        if (this.estadoJCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Escolha um estado válido.");
            return;
        } else {
            estado = this.estadoJCB.getSelectedItem().toString();
        }

        Dono dono = new Dono();
        dono.setCep(cep);
        dono.setCidade(localT);
        dono.setId(id);
        dono.setEndereco(endereco);
        dono.setEstado(estado);
        dono.setNome(nome);
        dono.setTelefone(telefone);
        dono.setTipoId(tipoId);
        ClientResponse response;
        try {
            response = RESTMethods.post(servicoDono, dono);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                MessagesUtils.erroCadastro("dono");
                return;
            }
            MessagesUtils.sucessoCadastro("dono");
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroDonoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        HUMVApp.exibirMensagemCarregamento();
        HUMVApp.setPainelCentralComLogo();
        HUMVApp.esconderMensagemCarregamento();
    }//GEN-LAST:event_confirmarJBActionPerformed

    private void jRadioButtonCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCpfActionPerformed
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setText("");
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
    }//GEN-LAST:event_jRadioButtonCpfActionPerformed

    private void jRadioButtonCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCnpjActionPerformed
        this.jRadioButtonCpf.setSelected(false);
        this.jTextFieldCnpj.setEnabled(true);
        this.jTextFieldCnpj.setFocusable(true);
        this.jTextFieldCpf.setText("");
        this.jTextFieldCpf.setEnabled(false);
        this.tipoId = "CNPJ";
    }//GEN-LAST:event_jRadioButtonCnpjActionPerformed
    
    private void custonInitComponents(){
        jRadioButtonCpf.setSelected(true);
        this.jTextFieldCnpj.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JLabel cepJL2;
    private javax.swing.JLabel cidadeFazendaJL;
    private javax.swing.JTextField cidadeFazendaJTF;
    private javax.swing.JRadioButton cidadeJRB2;
    private javax.swing.JButton confirmarJB;
    private javax.swing.JLabel enderecoJL2;
    private javax.swing.JTextField enderecoJTF2;
    private javax.swing.JComboBox<String> estadoJCB;
    private javax.swing.JRadioButton fazendaJRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButtonCnpj;
    private javax.swing.JRadioButton jRadioButtonCpf;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCnpj;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JLabel nomeJL;
    private javax.swing.JTextField nomeJTF;
    private javax.swing.JLabel telefoneJL;
    // End of variables declaration//GEN-END:variables
}
