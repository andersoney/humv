/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.materiais;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Material;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.view.atendimentosocial.CadastrarAtendimentoSocialJPanel;
import com.sun.jersey.api.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andersoney
 */
public class CadastrarMaterial extends javax.swing.JPanel {
    
    private final static Logger logger = LoggerFactory.getLogger(CadastrarAtendimentoSocialJPanel.class);
    private boolean novo = true;

    /**
     * Creates new form MateriaisCadastro
     */
    public CadastrarMaterial() {
        initComponents();
    }

    public CadastrarMaterial(Material material) {
        initComponents();
        this.jComboBox1.setSelectedIndex(material.getTipo());
        this.descriminacaoJTF.setText(material.getDiscriminacao());
        this.valorJTF.setText("" + material.getValor());
        this.unidadeJTF.setText(material.getUnidade());
        novo=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descricaoJL = new javax.swing.JLabel();
        descriminacaoJTF = new javax.swing.JTextField();
        unidadeJL = new javax.swing.JLabel();
        unidadeJTF = new javax.swing.JTextField();
        tipoJL = new javax.swing.JLabel();
        valorJTF = new javax.swing.JTextField();
        valorJL = new javax.swing.JLabel();
        salvarJB = new javax.swing.JButton();
        cancelarJB = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        descricaoJL.setText("Descriminação");

        unidadeJL.setText("Unidade");

        tipoJL.setText("Tipo");

        valorJL.setText("Valor");

        salvarJB.setText("Salvar");
        salvarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarJBActionPerformed(evt);
            }
        });

        cancelarJB.setText("Cancelar");
        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicamento", "Material" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelarJB)
                        .addGap(18, 18, 18)
                        .addComponent(salvarJB))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(unidadeJL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unidadeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(descricaoJL)
                            .addGap(18, 18, 18)
                            .addComponent(descriminacaoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(valorJL)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tipoJL)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(valorJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaoJL)
                    .addComponent(descriminacaoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidadeJL)
                    .addComponent(unidadeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoJL)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorJL)
                    .addComponent(valorJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarJB)
                    .addComponent(cancelarJB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        // TODO add your handling code here:
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "Materiais");
        if (sair) {
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_cancelarJBActionPerformed

    private void salvarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarJBActionPerformed
        
        String descricao, unidade, valorST;
        Integer tipo;
        Float valor;
        descricao = this.descriminacaoJTF.getText();
        tipo = this.jComboBox1.getSelectedIndex();
        valorST = this.valorJTF.getText();
        unidade = this.unidadeJTF.getText();
        Material material = new Material();
        if (descricao.trim().isEmpty()) {
            InterfaceGraficaUtils.dialogoMensagem("Descrição nula.", "Campo descrição não pode ser nulo.");
            return;
        }
        if (unidade.trim().isEmpty()) {
            InterfaceGraficaUtils.dialogoMensagem("Unidade nula.", "Campo Unidade não pode ser nulo.");
            return;
        }
        try {
            valor = Float.parseFloat(valorST);
        } catch (Exception e) {
            InterfaceGraficaUtils.dialogoMensagem("Valor não é real", "O valor do medicamento precisa ser em real.");
            return;
        }
        material.setDiscriminacao(descricao);
        material.setTipo(tipo);
        material.setUnidade(unidade);
        material.setValor(valor);
        try {
            ClientResponse response;
            if (novo) {
                response = RESTMethods.post("/api/material", material);
            } else {
                response = RESTMethods.put("/api/material", material);
            }
            
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                InterfaceGraficaUtils.erroResposta(resposta);
            } else {
                if (novo) {
                    InterfaceGraficaUtils.sucessoCadastro("Material");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("Material");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            logger.error("mensagem: " + ex.getMessage(), ex);
        }

    }//GEN-LAST:event_salvarJBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarJB;
    private javax.swing.JLabel descricaoJL;
    private javax.swing.JTextField descriminacaoJTF;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton salvarJB;
    private javax.swing.JLabel tipoJL;
    private javax.swing.JLabel unidadeJL;
    private javax.swing.JTextField unidadeJTF;
    private javax.swing.JLabel valorJL;
    private javax.swing.JTextField valorJTF;
    // End of variables declaration//GEN-END:variables
}
