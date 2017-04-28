package br.edu.ufrb.lasis.humv.view.solicitacaomaterial;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Material;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SolicitacaoKitMaterialCirurgicoJPanel extends javax.swing.JPanel {
    private Material material;
    private String rghumv;
    private String setor;
    private int quantidade;
    private SolicitacaoMaterial solicitacaoMaterial;
    private final String servicoSolicitacao = "/api/solicitacaoKitMaterialCirurgico";
    private SolicitacaoMaterial solicitacaoSelecionada;

    public SolicitacaoKitMaterialCirurgicoJPanel() {
        initComponents();
    }
    
    private void customInitComponents() {
        jTableMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Discriminação", "Quantidade solicitada", "Quantidade liberada"
            }
        ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldRghumv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSetor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonModelo1 = new javax.swing.JRadioButton();
        jRadioButtonModelo2 = new javax.swing.JRadioButton();
        jButtonRemoverItem = new javax.swing.JButton();
        jButtonAdicionarItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMateriais = new javax.swing.JTable();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("SOLICITAÇÃO DE KIT CIRÚRGICO");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");

        jTextFieldRghumv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRghumvActionPerformed(evt);
            }
        });

        jLabel1.setText("RGHUMV:");

        jTextFieldSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSetorActionPerformed(evt);
            }
        });

        jLabel2.setText("Setor:");

        jRadioButtonModelo1.setText("Modelo 1");

        jRadioButtonModelo2.setText("Modelo 2");

        jButtonRemoverItem.setText("Remover item");

        jButtonAdicionarItem.setText("Adicionar Item");
        jButtonAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarItemActionPerformed(evt);
            }
        });

        jTableMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableMateriais);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSetor)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldRghumv, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jRadioButtonModelo1)
                            .addGap(41, 41, 41)
                            .addComponent(jRadioButtonModelo2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButtonRemoverItem)
                                    .addGap(447, 447, 447)
                                    .addComponent(jButtonAdicionarItem))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRghumv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonModelo1)
                    .addComponent(jRadioButtonModelo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoverItem)
                    .addComponent(jButtonAdicionarItem))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonConfirmar))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel4)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        setor = jTextFieldSetor.getText();
        rghumv = jTextFieldRghumv.getText();
        solicitacaoMaterial.setCirurgico(true);
        if (this.jTextFieldSetor.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("identificador de setor");
            return;
        }
        ClientResponse response;
        try {
            if (solicitacaoSelecionada == null) {
                response = RESTMethods.post(this.servicoSolicitacao, solicitacaoMaterial);
            }
            else if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "solicitação", ""+solicitacaoSelecionada.getId())) {
                solicitacaoMaterial.setId(solicitacaoSelecionada.getId());
                response = RESTMethods.put(this.servicoSolicitacao, solicitacaoMaterial);
            } else {
                return;
            }
            
            String resposta = response.getEntity(String.class);
            if (!(resposta.contains("Erro") || resposta.contains("já cadastrado")) && solicitacaoSelecionada == null) { 
                InterfaceGraficaUtils.sucessoCadastro("solicitação do material");
            } else {
                if (solicitacaoSelecionada != null && resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.sucessoAtualizacao("solicitação do material");
                } else {
                    InterfaceGraficaUtils.erroResposta(resposta);
                }
                HUMVApp.setPainelCentralComLogo();
            }
        } catch (RESTConnectionException ex) {
            Logger.getLogger(SolicitacaoMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldRghumvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRghumvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRghumvActionPerformed

    private void jTextFieldSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSetorActionPerformed

    private void jButtonAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionarItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarItem;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonRemoverItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonModelo1;
    private javax.swing.JRadioButton jRadioButtonModelo2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMateriais;
    private javax.swing.JTextField jTextFieldRghumv;
    private javax.swing.JTextField jTextFieldSetor;
    // End of variables declaration//GEN-END:variables
}
