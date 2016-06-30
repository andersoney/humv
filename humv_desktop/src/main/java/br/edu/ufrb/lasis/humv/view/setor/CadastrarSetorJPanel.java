package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CadastrarSetorJPanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form CadastrarSetorJPanel
     *
     */
    final String servicoSetor = "/api/setor";
    Setor setorSelecionado;

    public CadastrarSetorJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarSetorJPanel(Setor setorSelecionado) {
        initComponents();
        customInitComponents();
        this.setorSelecionado = setorSelecionado;
    }
    
    private String geraCodigoSetor() {
        String cod = null;
        try {
            ClientResponse response = RESTMethods.get("/api/setor");
            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {
            });
            int tam = lista.size();
            cod =""+(tam + 1);
           
        } catch (Exception ex) {
            Logger.getLogger(CadastroSetorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cod;
    }

    private void customInitComponents() {
        jButtonConfirmar.addActionListener(this);
        jButtonCancelar.addActionListener(this);
        jTextFieldNome.setFocusable(true);
        if (setorSelecionado != null) {
            jLabelTitulo.setText("ALTERAÇÃO DO SETOR");
            jTextFieldNome.setText(setorSelecionado.getNome());
            jLabelCodigo.setText("Código: " + setorSelecionado.getCodigo());
        }else{
            jLabelCodigo.setText("Código: " + geraCodigoSetor());
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
        jLabelTitulo.setText("CADASTRAMENTO DE SETOR");

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

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabelTitulo)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        int i = MessagesUtils.dialogoCancelar("o cadastro", "setor");
        if (i == JOptionPane.OK_OPTION) {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNome.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("nome");
            return;
        }
        String nome = jTextFieldNome.getText();
        Setor setor = new Setor();
        String cod = geraCodigoSetor();
        setor.setCodigo(cod);
        setor.setNome(nome);
        try {
            ClientResponse response = RESTMethods.post(servicoSetor, setor);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                MessagesUtils.erroCadastro("setor");
                return;
            } else {
                MessagesUtils.sucessoCadastro("setor");
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

    @Override
    public void actionPerformed(ActionEvent ae) {}
}
