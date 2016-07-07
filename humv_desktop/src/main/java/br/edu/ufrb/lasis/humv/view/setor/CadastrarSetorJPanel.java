package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class CadastrarSetorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CadastrarSetorJPanel
     *
     */
    private String cod;
    private final String servicoSetor = "/api/setor";
    private Setor setorSelecionado;

    public CadastrarSetorJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarSetorJPanel(Setor setorSelecionado) {
        this.setorSelecionado = setorSelecionado;
        initComponents();
        customInitComponents();

    }

    private void customInitComponents() {
        jTextFieldNome.setFocusable(true);
        if (setorSelecionado != null) {
            jLabelTitulo.setText("ALTERAÇÃO DO SETOR");
            jTextFieldNome.setText(setorSelecionado.getNome());
            cod = setorSelecionado.getCodigo().toString();
            jLabelCodigo.setText("Código: " + cod);
        } else {
            jLabelCodigo.setText("Código: a ser criado pelo sistema");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelInformacoesSetor = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE SETOR");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanelInformacoesSetor.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do setor"));

        jLabelNome.setText("Nome: ");

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCodigo.setText("Código: ");

        javax.swing.GroupLayout jPanelInformacoesSetorLayout = new javax.swing.GroupLayout(jPanelInformacoesSetor);
        jPanelInformacoesSetor.setLayout(jPanelInformacoesSetorLayout);
        jPanelInformacoesSetorLayout.setHorizontalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCodigo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacoesSetorLayout.setVerticalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabelCodigo)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 169, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int i = MessagesUtils.dialogoCancelar("o cadastro", "setor");
        if (i == JOptionPane.OK_OPTION) {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (jTextFieldNome.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("nome");
            return;
        }
        String nome = jTextFieldNome.getText();
        Setor setor = new Setor();
        setor.setNome(nome);
        if (setorSelecionado != null) {
            setor.setCodigo(Integer.parseInt(cod));
        }
        try {
            ClientResponse response;
            if (setorSelecionado == null) {
                response = RESTMethods.post(servicoSetor, setor);
            } else {
                response = RESTMethods.put(servicoSetor, setor);
            }
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                if (setorSelecionado == null) {
                    MessagesUtils.erroCadastro("setor");
                } else {
                    MessagesUtils.erroAtualizacao("setor");
                }
                return;
            } else {
                if (setorSelecionado == null) {
                    MessagesUtils.sucessoCadastro("setor");
                } else {
                    MessagesUtils.sucessoAtualizacao("setor");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroSetorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelInformacoesSetor;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
