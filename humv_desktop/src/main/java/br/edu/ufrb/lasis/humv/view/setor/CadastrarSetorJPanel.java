package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.edu.ufrb.lasis.humv.HUMVApp;

/**
 *
 * @author Luiz
 */
public class CadastrarSetorJPanel extends javax.swing.JPanel {

    private final static Logger log = LoggerFactory.getLogger(CadastrarSetorJPanel.class
    );
    /**
     * Creates new form CadastrarSetorJPanel
     *
     */
    private String cod;
    private String servicoSetor = "/api/setor";
    private Setor setorSelecionado;
    private CadastrarSetorJDialog cadastroSetorJDialog;

    public CadastrarSetorJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarSetorJPanel(Setor setorSelecionado) {
        this.setorSelecionado = setorSelecionado;
        initComponents();
        customInitComponents();

    }

    public CadastrarSetorJPanel(CadastrarSetorJDialog cadastroSetorJDialog) {
        this.cadastroSetorJDialog = cadastroSetorJDialog;
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

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonConfirmar.setText("Salvar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCodigo)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "setor");
        if (sair) {
            if (cadastroSetorJDialog != null) {
                cadastroSetorJDialog.dispose();
            } else {
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();

            }
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (jTextFieldNome.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome");
            return;
        }
        String nome = jTextFieldNome.getText();
        Setor setor = new Setor();
        setor.setNome(nome);
        if (setorSelecionado != null) {
            setor.setCodigo(new BigInteger(cod));
        }
        try {
            ClientResponse response;
            if (setorSelecionado == null) {
                String setorURL = servicoSetor;
                if (cadastroSetorJDialog != null) {
                    setorURL += "/retornaCadastrado";
                }
                response = RESTMethods.post(setorURL, setor);
            } else {
                response = RESTMethods.put(servicoSetor, setor);
            }
            if (cadastroSetorJDialog != null) {
                Setor setorRetornado = response.getEntity(Setor.class);
                InterfaceGraficaUtils.sucessoCadastro("setor");
                cadastroSetorJDialog.fecharDialog(setorRetornado);
            } else {
                Object resposta = response.getEntity(Object.class);
                if (!(resposta instanceof Setor)) { //resposta.equalsIgnoreCase("ok")
                    if (setorSelecionado == null) {
                        InterfaceGraficaUtils.erroResposta((String) resposta);
                    } else {
                        InterfaceGraficaUtils.erroResposta((String) resposta);
                    }
                } else {
                    if (setorSelecionado == null) {
                        Setor s = (Setor) resposta;
                        InterfaceGraficaUtils.sucessoCadastro("setor", "código", s.getCodigo().intValue());
                    } else {
                        InterfaceGraficaUtils.sucessoAtualizacao("setor");
                    }
                    HUMVApp.exibirMensagemCarregamento();
                    HUMVApp.setPainelCentralComLogo();
                    HUMVApp.esconderMensagemCarregamento();
                }
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            String mensagem = InterfaceGraficaUtils.getMensagemErroConexao();
            log.error("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem, ex);
        } catch (ClientHandlerException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro do setor. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            String mensagem = "Erro no cadastro do setor. Por favor, tente novamente.";
            log.error("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem, ex);
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
