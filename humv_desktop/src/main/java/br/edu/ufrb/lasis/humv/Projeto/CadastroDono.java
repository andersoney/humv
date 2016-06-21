package br.edu.ufrb.lasis.humv.Projeto;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andersoney
 */
public class CadastroDono extends javax.swing.JDialog {

    CadastroAnimals parent;
    final String servicoDono = "/api/dono";

    /**
     * Creates new form CadastroDono
     *
     * @param parent
     * @param modal
     * @param cA
     */
    public CadastroDono(java.awt.Frame parent, boolean modal, CadastroAnimals cA) {
        super(parent, modal);
        this.parent = cA;
        initComponents();
        this.cidadeJRB.setSelected(true);
        this.cidadeFazendaJL.setText("Cidade");

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
        nomeJL = new javax.swing.JLabel();
        cpfJL = new javax.swing.JLabel();
        nomeJTF = new javax.swing.JTextField();
        cpfJTF = new javax.swing.JTextField();
        telefoneJL = new javax.swing.JLabel();
        telefoneJTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        enderecoJL = new javax.swing.JLabel();
        enderecoJTF = new javax.swing.JTextField();
        cepJTF = new javax.swing.JTextField();
        cepJL = new javax.swing.JLabel();
        cidadeJRB = new javax.swing.JRadioButton();
        fazendaJRB = new javax.swing.JRadioButton();
        estadoJCB = new javax.swing.JComboBox<String>();
        cidadeFazendaJTF = new javax.swing.JTextField();
        cidadeFazendaJL = new javax.swing.JLabel();
        confirmarJB = new javax.swing.JButton();
        cancelarJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        nomeJL.setText("Nome");

        cpfJL.setText("CPF");

        telefoneJL.setText("Telefone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nomeJTF)
                            .addComponent(nomeJL, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfJTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cpfJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telefoneJTF)
                            .addComponent(telefoneJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJL)
                    .addComponent(cpfJL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefoneJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        enderecoJL.setText("Endereço");

        cepJL.setText("CEP");

        cidadeJRB.setText("Cidade");
        cidadeJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeJRBActionPerformed(evt);
            }
        });

        fazendaJRB.setText("Fazenda");
        fazendaJRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazendaJRBActionPerformed(evt);
            }
        });

        estadoJCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estados", "Acre", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba ", "Paraná ", "Pernambuco", "Piauí ", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", " " }));

        cidadeFazendaJL.setText("Endereço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cidadeFazendaJL, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(cidadeFazendaJTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cidadeJRB, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(fazendaJRB))
                    .addComponent(enderecoJL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enderecoJTF, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cepJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cepJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(estadoJCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cepJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cepJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(enderecoJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeJRB)
                    .addComponent(fazendaJRB)
                    .addComponent(estadoJCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(cidadeFazendaJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeFazendaJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        confirmarJB.setText("Confirmar");
        confirmarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarJBActionPerformed(evt);
            }
        });

        cancelarJB.setText("Cancelar");
        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarJB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarJB)
                    .addComponent(cancelarJB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja mesmo cancelar o cadastro?","",JOptionPane.YES_NO_OPTION);
     
        if (i == JOptionPane.OK_OPTION) {
            this.dispose();
        } else {

        }
        parent.setCPFNull();
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
        
    
       

        if (!Util.isNotNull(this.enderecoJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite um endereço valido.");
            return;
        }
        String endereco = this.enderecoJTF.getText();
        if (!Util.isNotNull(this.cepJTF.getText())) {
            JOptionPane.showMessageDialog(this, "Digite o CEP.");
            return;
        }
        String cep = this.cepJTF.getText();
        String local;
        if ((!this.cidadeJRB.isSelected() && !this.fazendaJRB.isSelected()) || this.cidadeJRB.isSelected() && this.fazendaJRB.isSelected()) {
            JOptionPane.showMessageDialog(this, "Escolha o local onde a pessoa vive.");
            return;
        } else if (this.cidadeJRB.isSelected()) {
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
            Logger.getLogger(CadastroDono.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.parent.setCPF(this.cpfJTF.getText(), this.nomeJTF.getText());
        this.dispose();
    }//GEN-LAST:event_confirmarJBActionPerformed

    private void cidadeJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeJRBActionPerformed
        // TODO add your handling code here:
        this.fazendaJRB.setSelected(false);
        this.cidadeFazendaJL.setText("Cidade");
    }//GEN-LAST:event_cidadeJRBActionPerformed

    private void fazendaJRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazendaJRBActionPerformed
        // TODO add your handling code here:
        this.cidadeJRB.setSelected(false);
        this.cidadeFazendaJL.setText("Fazenda");
    }//GEN-LAST:event_fazendaJRBActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JLabel cepJL;
    private javax.swing.JTextField cepJTF;
    private javax.swing.JLabel cidadeFazendaJL;
    private javax.swing.JTextField cidadeFazendaJTF;
    private javax.swing.JRadioButton cidadeJRB;
    private javax.swing.JButton confirmarJB;
    private javax.swing.JLabel cpfJL;
    private javax.swing.JTextField cpfJTF;
    private javax.swing.JLabel enderecoJL;
    private javax.swing.JTextField enderecoJTF;
    private javax.swing.JComboBox<String> estadoJCB;
    private javax.swing.JRadioButton fazendaJRB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nomeJL;
    private javax.swing.JTextField nomeJTF;
    private javax.swing.JLabel telefoneJL;
    private javax.swing.JTextField telefoneJTF;
    // End of variables declaration//GEN-END:variables
}
