/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tassiovale
 */
public class BuscarAgendaMedicoJPanel extends javax.swing.JPanel {

    private final static Logger logger = LoggerFactory.getLogger(BuscarAgendaMedicoJPanel.class);
    private List<Usuario> medicos = null;
    private AgendaJPanel agendaJPanel = null;
    
    private static final int CANCELAR_UM_ATENDIMENTO = 1;
    private static final int CANCELAR_VARIOS_ATENDIMENTOS = 2;
    /**
     * Creates new form RealizarAgendamentoJPanel
     */
    public BuscarAgendaMedicoJPanel() {
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        List<Usuario> listMedicos = getMedicos();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Usuario usuario : listMedicos) {
            MedicoComboBox medico = new MedicoComboBox(usuario);
            model.addElement(medico);
        }
        comboBoxMedicos.setModel(model);
        jButtonNovoAtendimentoExtra.setEnabled(false);
        jButtonCancelarAgenda.setEnabled(false);
    }

    private List<Usuario> getMedicos() {
        if (medicos == null) {
            try {
                ClientResponse response = RESTMethods.get("/api/usuario/obterMedicosAtivos");
                medicos = (List<Usuario>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<Usuario>>() {
                });
            } catch (RESTConnectionException | IOException ex) {
                InterfaceGraficaUtils.erroConexao();
                logger.error("mensagem: " + ex.getMessage(), ex);
            }
        }
        return medicos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxMedicos = new javax.swing.JComboBox<>();
        jDateChooserDiaAgenda = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButtonCarregar = new javax.swing.JButton();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButtonNovoAtendimentoExtra = new javax.swing.JButton();
        jButtonCancelarAgenda = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("AGENDAMENTO");

        jLabel1.setText("Médico:");

        jLabel2.setText("Data:");

        jButtonCarregar.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonCarregar.setText("Carregar");
        jButtonCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("imagens/small_voltar.png"));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonNovoAtendimentoExtra.setIcon(new javax.swing.ImageIcon("imagens/small_novo.png"));
        jButtonNovoAtendimentoExtra.setText("Atendimento extra");
        jButtonNovoAtendimentoExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoAtendimentoExtraActionPerformed(evt);
            }
        });

        jButtonCancelarAgenda.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonCancelarAgenda.setText("Cancelar agenda");
        jButtonCancelarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserDiaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovoAtendimentoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(comboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserDiaAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCarregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonNovoAtendimentoExtra)
                    .addComponent(jButtonCancelarAgenda))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarActionPerformed
        if (getMedicos() == null || getMedicos().isEmpty()) {
            InterfaceGraficaUtils.erroResposta("Não existem médicos para consulta. Por favor, realize o cadastro do médico.");
        } else if (jDateChooserDiaAgenda.getDate() == null) {
            InterfaceGraficaUtils.erroResposta("Por favor, informe a data para carregar a agenda do médico " + (MedicoComboBox) comboBoxMedicos.getSelectedItem() + ".");
            jDateChooserDiaAgenda.setFocusable(true);
        } else {
            Usuario medico = ((MedicoComboBox) comboBoxMedicos.getSelectedItem()).getUsuario();
            agendaJPanel = new AgendaJPanel(this, medico, jDateChooserDiaAgenda.getDate());
            jScrollPaneTabela.setViewportView(agendaJPanel);
            jScrollPaneTabela.revalidate();
            jButtonNovoAtendimentoExtra.setEnabled(true);
            jButtonCancelarAgenda.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonCarregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoSair();
        if (sair) {
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonNovoAtendimentoExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoAtendimentoExtraActionPerformed
        if (agendaJPanel != null) {
            HUMVApp.setNovoPainelCentral(new CadastrarAtendimentoJPanel(agendaJPanel, jDateChooserDiaAgenda.getDate(), null));
        }
    }//GEN-LAST:event_jButtonNovoAtendimentoExtraActionPerformed

    private void jButtonCancelarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarAgendaActionPerformed
        Usuario medico = ((MedicoComboBox) comboBoxMedicos.getSelectedItem()).getUsuario();
        Date data = jDateChooserDiaAgenda.getDate();
        new CancelarAtendimentoJDialog(medico, data, agendaJPanel,CANCELAR_VARIOS_ATENDIMENTOS).setVisible(true);
    }//GEN-LAST:event_jButtonCancelarAgendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxMedicos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelarAgenda;
    private javax.swing.JButton jButtonCarregar;
    private javax.swing.JButton jButtonNovoAtendimentoExtra;
    private com.toedter.calendar.JDateChooser jDateChooserDiaAgenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPaneTabela;
    // End of variables declaration//GEN-END:variables
}

class MedicoComboBox {

    private Usuario usuario;

    public MedicoComboBox(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return usuario.getNome();
    }

}
