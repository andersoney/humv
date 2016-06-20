/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.animal.CadastroAnimal;
import br.edu.ufrb.lasis.humv.utils.Util;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Andersoney
 */
public class CadastrarDonoJPanel extends javax.swing.JPanel {

    final String servicoDono = "/api/dono";

    /**
     * Creates new form CadastrarDono
     */
    public CadastrarDonoJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nomeJL = new javax.swing.JLabel();
        cpfJL = new javax.swing.JLabel();
        nomeJTF = new javax.swing.JTextField();
        cpfJTF = new javax.swing.JTextField();
        telefoneJL = new javax.swing.JLabel();
        telefoneJTF = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        enderecoJL2 = new javax.swing.JLabel();
        enderecoJTF2 = new javax.swing.JTextField();
        cepJTF2 = new javax.swing.JTextField();
        cepJL2 = new javax.swing.JLabel();
        cidadeJRB2 = new javax.swing.JRadioButton();
        fazendaJRB = new javax.swing.JRadioButton();
        estadoJCB = new javax.swing.JComboBox<>();
        cidadeFazendaJTF = new javax.swing.JTextField();
        cidadeFazendaJL = new javax.swing.JLabel();
        cancelarJB = new javax.swing.JButton();
        confirmarJB = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });

        nomeJL.setText("Nome");

        cpfJL.setText("CPF");

        telefoneJL.setText("Telefone");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomeJTF)
                            .addComponent(nomeJL, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfJTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cpfJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telefoneJTF)
                            .addComponent(telefoneJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJL)
                    .addComponent(cpfJL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefoneJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        cidadeFazendaJL.setText("Endereço");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cidadeFazendaJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cidadeFazendaJTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cidadeJRB2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(fazendaJRB))
                    .addComponent(enderecoJL2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enderecoJTF2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cepJL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cepJTF2)
                    .addComponent(estadoJCB, 0, 159, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cepJL2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cepJTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(enderecoJL2)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarJB)
                    .addComponent(cancelarJB))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        int i = JOptionPane.showConfirmDialog(this, "Deseja mesmo Cancelar o cadastro?");
        if (i == JOptionPane.OK_OPTION) {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        } else {

        }
    }//GEN-LAST:event_cancelarJBActionPerformed

    private void confirmarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarJBActionPerformed
        // TODO add your handling code here:
        if (!Util.isNotNull(this.nomeJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite o nome do dono do animal.");
            return;
        }
        String nome = this.nomeJTF.getText();
        if (!Util.isCPF(this.cpfJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite um CPF valido.");
            return;
        }
        String cpf = this.cpfJTF.getText();
        if (!Util.isNotNull(this.telefoneJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite um telefone valido.");
            return;
        }
        String telefone = this.telefoneJTF.getText();
        String email = null;
        if (!this.telefoneJTF.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um Email valido.");
            return;
        }

        if (!Util.isNotNull(this.enderecoJTF2.getText())) {
            JOptionPane.showMessageDialog(this, "Digite um endereço valido.");
            return;
        }
        String endereco = this.enderecoJTF2.getText();
        if (!Util.isNotNull(this.cepJTF2.getText())) {
            JOptionPane.showMessageDialog(this, "Digite o CEP.");
            return;
        }
        String cep = this.cepJTF2.getText();
        String local;
        if ((!this.cidadeJRB2.isSelected() && !this.fazendaJRB.isSelected()) || this.cidadeJRB2.isSelected() && this.fazendaJRB.isSelected()) {
            JOptionPane.showMessageDialog(this, "Escolha o local onde a pessoa vive.");
            return;
        } else if (this.cidadeJRB2.isSelected()) {
            local = "Cidade";
        } else {
            local = "Fazenda";
        }
        if (!Util.isNotNull(this.cidadeFazendaJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite o nome da " + local + " onde vive o dono.");
            return;
        }
        String localT = local + ": " + this.cidadeFazendaJTF.getText();
        String estado;
        if (this.estadoJCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Escolha um estado valido.");
            return;
        } else {
            estado = this.estadoJCB.getSelectedItem().toString();
        }

        Dono dono = new Dono();
        dono.setCep(cep);
        dono.setCidade(localT);
        dono.setCpf(cpf);
        dono.setEndereco(endereco);
        dono.setEstado(estado);
        dono.setNome(nome);
        dono.setTelefone(telefone);
        ClientResponse response;
        try {
            response = RESTMethods.post(servicoDono, dono);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroDonoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        HUMVApp.exibirMensagemCarregamento();
        HUMVApp.setPainelCentralComLogo();
        HUMVApp.esconderMensagemCarregamento();
    }//GEN-LAST:event_confirmarJBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JLabel cepJL2;
    private javax.swing.JTextField cepJTF2;
    private javax.swing.JLabel cidadeFazendaJL;
    private javax.swing.JTextField cidadeFazendaJTF;
    private javax.swing.JRadioButton cidadeJRB2;
    private javax.swing.JButton confirmarJB;
    private javax.swing.JLabel cpfJL;
    private javax.swing.JTextField cpfJTF;
    private javax.swing.JLabel enderecoJL2;
    private javax.swing.JTextField enderecoJTF2;
    private javax.swing.JComboBox<String> estadoJCB;
    private javax.swing.JRadioButton fazendaJRB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel nomeJL;
    private javax.swing.JTextField nomeJTF;
    private javax.swing.JLabel telefoneJL;
    private javax.swing.JTextField telefoneJTF;
    // End of variables declaration//GEN-END:variables
}
