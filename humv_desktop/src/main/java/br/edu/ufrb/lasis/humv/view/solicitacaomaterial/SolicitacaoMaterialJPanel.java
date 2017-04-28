package br.edu.ufrb.lasis.humv.view.solicitacaomaterial;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;
import br.edu.ufrb.lasis.humv.entity.Material;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.material.PropriedadesBuscaMaterial;
import com.sun.jersey.api.client.ClientResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SolicitacaoMaterialJPanel extends javax.swing.JPanel implements ResultadoBusca {

    private Material material;
    private String rghumv;
    private String setor;
    private int quantidade;
    private SolicitacaoMaterial solicitacaoMaterial = new SolicitacaoMaterial();
    private final String servicoSolicitacao = "/api/solicitacaoMaterial";
    private SolicitacaoMaterial solicitacaoSelecionada;

    public SolicitacaoMaterialJPanel() {
        initComponents();
        this.solicitacaoMaterial.setSituacaoStatus("não vista");
        this.solicitacaoMaterial.setDataSolicitacao(new Date());
        this.jLabelHora.setText("Hora: " + new Date());
        this.solicitacaoMaterial.setDataLiberacao(null);
    }

    public SolicitacaoMaterialJPanel(SolicitacaoMaterial solicitacaoMaterial) {
        this.solicitacaoMaterial = solicitacaoMaterial;
        initComponents();
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
        jButtonBuscarMaterial = new javax.swing.JButton();
        jLabelMaterial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        jLabelHora = new javax.swing.JLabel();

        jLabel4.setText("Solicitação de Material");

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

        jButtonBuscarMaterial.setText("Escolher material");
        jButtonBuscarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarMaterialActionPerformed(evt);
            }
        });

        jLabelMaterial.setText("Material:");

        jLabel3.setText("Quantidade:");

        jLabelHora.setText("Hora:                                                                                    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldRghumv))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBuscarMaterial)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelHora))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRghumv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarMaterial)
                    .addComponent(jLabelMaterial))
                .addGap(18, 18, 18)
                .addComponent(jLabelHora)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldRghumvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRghumvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRghumvActionPerformed

    @Override
    public void setResultado(Object resultado) {
        this.material = (Material) resultado;
        this.jLabelMaterial.setText("Material: " + material.getDiscriminacao());
    }

    private void jTextFieldSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSetorActionPerformed

    private void jButtonBuscarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarMaterialActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaMaterial propriedadesBusca = new PropriedadesBuscaMaterial(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE MATERIAL", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonBuscarMaterialActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        setor = jTextFieldSetor.getText();
        rghumv = jTextFieldRghumv.getText();
        quantidade = (Integer) jSpinnerQuantidade.getValue();
        if (material == null) {
            JOptionPane.showMessageDialog(this, "Você deve escolher um material para prosseguir com a operação.");
            return;
        } else {
            solicitacaoMaterial.setMaterial(material);
        }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarMaterial;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerQuantidade;
    private javax.swing.JTextField jTextFieldRghumv;
    private javax.swing.JTextField jTextFieldSetor;
    // End of variables declaration//GEN-END:variables

}
