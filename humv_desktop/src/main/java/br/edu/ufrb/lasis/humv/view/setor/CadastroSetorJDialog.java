package br.edu.ufrb.lasis.humv.view.setor;
import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.codehaus.jackson.type.TypeReference;


/**
 *
 * @author Luiz
 */
public class CadastroSetorJDialog extends javax.swing.JDialog {

    CadastrarProcedimentoJPanel parent;
    final String servicoSetor = "/api/setor";

    Setor setorSelecionado;
    public CadastroSetorJDialog() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public CadastroSetorJDialog(java.awt.Frame parent, boolean modal, CadastrarProcedimentoJPanel cadastroProcedimento) {
        super(parent, modal);
        this.parent = cadastroProcedimento;
        initComponents();
        customInitComponents();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInformacoesSetor = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setFocusTraversalPolicyProvider(true);
        setFocusable(false);

        jPanelInformacoesSetor.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do setor"));

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCodigo.setText("Código:");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        javax.swing.GroupLayout jPanelInformacoesSetorLayout = new javax.swing.GroupLayout(jPanelInformacoesSetor);
        jPanelInformacoesSetor.setLayout(jPanelInformacoesSetorLayout);
        jPanelInformacoesSetorLayout.setHorizontalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCodigo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacoesSetorLayout.setVerticalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelCodigo)
                .addGap(67, 67, 67))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar))
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int op = MessagesUtils.dialogoCancelar("o cadastro", "setor");
        if (op == JOptionPane.OK_OPTION) {
            this.dispose();
            parent.setCodSetorNull();
        }   
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNome.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("nome");
            return;
        }
        Setor setor = new Setor();
        String nome = jTextFieldNome.getText();
        setor.setNome(nome);
        Integer cod = null;
        try {
            ClientResponse response = RESTMethods.get("/api/setor");
            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {});
            cod = (lista.size()+1);
            jLabelCodigo.setText("Código: "+cod);
            setor.setCodigo(cod);
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao conectar com a base de dados.");
        }
        try {
            ClientResponse response = RESTMethods.post(servicoSetor, setor);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            MessagesUtils.sucessoCadastro("setor");
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroSetorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.parent.setCodSetor(this.jTextFieldNome.getText(), cod);
        this.dispose();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelInformacoesSetor;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

    private void customInitComponents() {
         try {
            ClientResponse response = RESTMethods.get("/api/setor");
            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {});
            int cod = lista.size()+1;
            jLabelCodigo.setText("Código: " + cod);
        }catch (Exception ex) {
                 Logger.getLogger(CadastroSetorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
