package br.edu.ufrb.lasis.humv.view.materiais;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.util.Date;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CadastarLiberacaoMaterialJPanel extends javax.swing.JPanel {
    private SolicitacaoMaterial solicitacaoMaterial;
    private final static Logger logger = LoggerFactory.getLogger(CadastarLiberacaoMaterialJPanel.class);

    public CadastarLiberacaoMaterialJPanel(SolicitacaoMaterial solicitacaoMaterial) {
        initComponents();
        this.solicitacaoMaterial = solicitacaoMaterial;
        customInit(this.solicitacaoMaterial);
        this.solicitacaoMaterial.setDataLiberacao(new Date());
        
    }

    private void customInit(SolicitacaoMaterial solicitacaoMaterial) {
        jLabelHora.setText("Hora: "+ solicitacaoMaterial.getDataSolicitacao());
        jLabelSetor.setText("Setor solicitante: " + solicitacaoMaterial.getNomeSetor());
        jLabelMaterial.setText("Material solicitado: " + solicitacaoMaterial.getMaterial().getDiscriminacao());
        jLabelRghumvAnimal.setText("RGHUMV do animal: " + solicitacaoMaterial.getRghumvAnimal());
        jLabelQuantidadeSolicitada.setText("Quantidade solicitada: " + solicitacaoMaterial.getQuantidadeSolicitada());
        jLabelQuantidadeEstoque.setText("Quantidade em estoque: " + solicitacaoMaterial.getMaterial().getQuantidadeDisponivel());
        
        if (solicitacaoMaterial.isCirurgico()) {
            jLabelModelo.setText("Modelo: "+solicitacaoMaterial.getModelo());
        } else {
            jLabelModelo.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelSetor = new javax.swing.JLabel();
        jLabelMaterial = new javax.swing.JLabel();
        jLabelRghumvAnimal = new javax.swing.JLabel();
        jLabelQuantidadeSolicitada = new javax.swing.JLabel();
        jLabelQuantidadeEstoque = new javax.swing.JLabel();
        jLabelQuantidadeLiberada = new javax.swing.JLabel();
        SpinnerModel sm = new SpinnerNumberModel(0, 0, this.solicitacaoMaterial.getMaterial().getQuantidadeDisponivel(), 1);
        jSpinnerQuantidadeLiberada = new javax.swing.JSpinner();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelTipo = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();

        jLabel1.setText("Liberação de  Material");

        jLabelSetor.setText("Setor solicitante:");

        jLabelMaterial.setText("Material solicitado:");

        jLabelRghumvAnimal.setText("RGHUMV do animal:");

        jLabelQuantidadeSolicitada.setText("Quantidade solicitada:");

        jLabelQuantidadeEstoque.setText("Quantidade em estoque:");

        jLabelQuantidadeLiberada.setText("Quantidade liberada:");

        jSpinnerQuantidadeLiberada = new javax.swing.JSpinner(sm);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelTipo.setText("Tipo do material:");

        jLabelHora.setText("Hora:");

        jLabelModelo.setText("Modelo:                                     ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelQuantidadeLiberada)
                        .addGap(28, 28, 28)
                        .addComponent(jSpinnerQuantidadeLiberada, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                        .addGap(109, 109, 109))
                    .addComponent(jLabelSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelRghumvAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelQuantidadeSolicitada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelQuantidadeEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelModelo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabelHora)
                .addGap(18, 18, 18)
                .addComponent(jLabelSetor)
                .addGap(18, 18, 18)
                .addComponent(jLabelMaterial)
                .addGap(18, 18, 18)
                .addComponent(jLabelTipo)
                .addGap(18, 18, 18)
                .addComponent(jLabelQuantidadeSolicitada)
                .addGap(18, 18, 18)
                .addComponent(jLabelQuantidadeEstoque)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelQuantidadeLiberada)
                    .addComponent(jSpinnerQuantidadeLiberada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRghumvAnimal)
                .addGap(18, 18, 18)
                .addComponent(jLabelModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        this.solicitacaoMaterial.setQuantidadeLiberada((Integer) jSpinnerQuantidadeLiberada.getValue());
        this.solicitacaoMaterial.setSituacaoStatus("solicitação autorizada");
        try {
            ClientResponse response;
            response = RESTMethods.put("/api/solicitacaoMaterial", solicitacaoMaterial);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                InterfaceGraficaUtils.erroResposta(resposta);
            } else {
                InterfaceGraficaUtils.sucessoCadastro("liberação do material");
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            logger.error("mensagem: " + ex.getMessage(), ex);
        }
        HUMVApp.exibirMensagemCarregamento();
        HUMVApp.setPainelCentralComLogo();
        HUMVApp.esconderMensagemCarregamento();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelQuantidadeEstoque;
    private javax.swing.JLabel jLabelQuantidadeLiberada;
    private javax.swing.JLabel jLabelQuantidadeSolicitada;
    private javax.swing.JLabel jLabelRghumvAnimal;
    private javax.swing.JLabel jLabelSetor;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JSpinner jSpinnerQuantidadeLiberada;
    // End of variables declaration//GEN-END:variables
}
