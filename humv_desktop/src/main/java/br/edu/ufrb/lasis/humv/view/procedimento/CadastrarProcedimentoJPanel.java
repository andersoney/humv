package br.edu.ufrb.lasis.humv.view.procedimento;

import br.edu.ufrb.lasis.humv.view.setor.SetorListaJDialog;
import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.setor.CadastrarSetorJDialog;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Luiz
 */
public class CadastrarProcedimentoJPanel extends javax.swing.JPanel {

    private JFrame parent;
    private Setor setor = null;
    private String nomeSetor;
    private final String servicoSetor = "/api/setor";
    private final String servicoProcedimento = "/api/procedimento";
    private Procedimento procedimentoSelecionado;

    /**
     * Creates new form CadastroProcedimento
     */
    public CadastrarProcedimentoJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarProcedimentoJPanel(Procedimento procedimentoSelecionado) {
        this.procedimentoSelecionado = procedimentoSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        jTextFieldNome.setFocusable(true);

        if (procedimentoSelecionado != null) {
            jLabelTitulo.setText("ALTERAÇÃO DO PROCEDIMENTO");
            jTextFieldNome.setText(procedimentoSelecionado.getNome());
            jTextFieldCodigo.setText(procedimentoSelecionado.getCodigo().toString());
            jTextFieldPreco.setText("" + procedimentoSelecionado.getValor());
            setor = procedimentoSelecionado.getSetor();
            jLabelSetorCodigo.setText("Código: " + setor.getCodigo());
            nomeSetor = procedimentoSelecionado.getSetor().getNome();
            jLabelNomeSetor.setText("Nome: " + nomeSetor);

        }
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public JLabel getjLabelNomeSetor() {
        return jLabelNomeSetor;
    }

    public JLabel getjLabelSetorCodigo() {
        return jLabelSetorCodigo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInformacoesSetor = new javax.swing.JPanel();
        jButtonCadastrarSetor = new javax.swing.JButton();
        jButtonPesqusar = new javax.swing.JButton();
        jTextFieldCodSetor = new javax.swing.JTextField();
        jLabelCodSetorBusca = new javax.swing.JLabel();
        jLabelNomeSetor = new javax.swing.JLabel();
        jLabelSetorCodigo = new javax.swing.JLabel();
        jButtonExibirLista = new javax.swing.JButton();
        jPanelInformacoesProcedimento = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        jPanelInformacoesSetor.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do setor"));

        jButtonCadastrarSetor.setText("Novo...");
        jButtonCadastrarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarSetorActionPerformed(evt);
            }
        });

        jButtonPesqusar.setText("Selecionar");
        jButtonPesqusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqusarActionPerformed(evt);
            }
        });

        jLabelCodSetorBusca.setText("Informe o código do setor:");

        jLabelNomeSetor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeSetor.setText("Nome: ");

        jLabelSetorCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSetorCodigo.setText("Código: ");

        jButtonExibirLista.setText("Exibir lista");
        jButtonExibirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExibirListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInformacoesSetorLayout = new javax.swing.GroupLayout(jPanelInformacoesSetor);
        jPanelInformacoesSetor.setLayout(jPanelInformacoesSetorLayout);
        jPanelInformacoesSetorLayout.setHorizontalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addComponent(jTextFieldCodSetor)
                        .addGap(10, 10, 10))
                    .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodSetorBusca)
                            .addComponent(jLabelNomeSetor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSetorCodigo)
                    .addComponent(jButtonPesqusar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExibirLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrarSetor)
                .addGap(5, 5, 5))
        );
        jPanelInformacoesSetorLayout.setVerticalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCodSetorBusca)
                .addGap(7, 7, 7)
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesqusar)
                    .addComponent(jTextFieldCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExibirLista)
                    .addComponent(jButtonCadastrarSetor))
                .addGap(18, 18, 18)
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeSetor)
                    .addComponent(jLabelSetorCodigo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelInformacoesProcedimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do procedimento"));

        jLabelNome.setText("Nome:");

        jLabelCodigo.setText("Código:");

        jLabelPreco.setText("Preço R$ (ex.: 40,00):");

        javax.swing.GroupLayout jPanelInformacoesProcedimentoLayout = new javax.swing.GroupLayout(jPanelInformacoesProcedimento);
        jPanelInformacoesProcedimento.setLayout(jPanelInformacoesProcedimentoLayout);
        jPanelInformacoesProcedimentoLayout.setHorizontalGroup(
            jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCodigo)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPreco))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacoesProcedimentoLayout.setVerticalGroup(
            jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelPreco))
                .addGap(10, 10, 10)
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE PROCEDIMENTO");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInformacoesProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar))
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesqusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqusarActionPerformed
        ClientResponse response;
        if (!jTextFieldCodSetor.getText().isEmpty()) {
            try {
                response = RESTMethods.get(servicoSetor + "/" + this.jTextFieldCodSetor.getText() + "");
                Setor setor = response.getEntity(Setor.class);
                nomeSetor = setor.getNome();
                this.jLabelNomeSetor.setText("Nome: " + nomeSetor);
                this.setor = setor;
                this.jLabelSetorCodigo.setText("Código: " + setor);
                JOptionPane.showMessageDialog(null, "Setor encontrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (RESTConnectionException ex) {
                InterfaceGraficaUtils.erroConexao();
            } catch (ClientHandlerException ex) {
                JOptionPane.showMessageDialog(null, "Setor não encontrado. Por favor, digite um código válido.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            InterfaceGraficaUtils.validaCampoVazio("de busca");
        }
    }//GEN-LAST:event_jButtonPesqusarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (setor == null) {
            InterfaceGraficaUtils.validaCampoVazio("setor");
            return;
        }
        if (this.jTextFieldNome.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome");
            return;
        }
        String nome = this.jTextFieldNome.getText();
        if (this.jTextFieldCodigo.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("código");
            return;
        }
        BigInteger codigo = new BigInteger(jTextFieldCodigo.getText());
        if (jTextFieldPreco.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("preço");
            return;
        }

        double valor = 0;

        try {
            String precoString = this.jTextFieldPreco.getText();
            if (precoString.contains(",")) {
                String[] valores_precos = precoString.split(",");
                if (valores_precos.length > 1) {
                    precoString = valores_precos[0] + "." + valores_precos[1];
                }
            }
            valor = Double.parseDouble(precoString);
        } catch (NumberFormatException ex) {
            InterfaceGraficaUtils.valorInvalido("preço");
            return;
        }

        Procedimento procedimento = new Procedimento();
        procedimento.setValor(valor);
        procedimento.setCodigo(codigo);
        procedimento.setNome(nome);
        procedimento.setSetor(setor);
        try {
            ClientResponse response;
            if (procedimentoSelecionado == null) {
                response = RESTMethods.post(this.servicoProcedimento, procedimento);
            } else if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "procedimento", procedimentoSelecionado.getNome())) {
                response = RESTMethods.put(this.servicoProcedimento, procedimento);
            } else {
                return;
            }
            String resposta = response.getEntity(String.class);
            System.out.println(resposta);
            if (!resposta.equalsIgnoreCase("ok")) {
                if (procedimentoSelecionado == null) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                } else {
                    InterfaceGraficaUtils.erroResposta(resposta);
                }
            } else {
                if (procedimentoSelecionado == null) {
                    InterfaceGraficaUtils.sucessoCadastro("procedimento");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("procedimento");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "procedimento");
        if (sair) {
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCadastrarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarSetorActionPerformed
        new CadastrarSetorJDialog(this).setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarSetorActionPerformed

    private void jButtonExibirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExibirListaActionPerformed
        try {
            ClientResponse response = RESTMethods.get("/api/setor");
            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {
            });
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem setores cadastrados.", "Lista de setores", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new SetorListaJDialog(this, lista).setVisible(true);
            }
        } catch (RESTConnectionException | IOException ex) {
            InterfaceGraficaUtils.erroConexao();
        }
    }//GEN-LAST:event_jButtonExibirListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarSetor;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonExibirLista;
    private javax.swing.JButton jButtonPesqusar;
    private javax.swing.JLabel jLabelCodSetorBusca;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeSetor;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelSetorCodigo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelInformacoesProcedimento;
    private javax.swing.JPanel jPanelInformacoesSetor;
    private javax.swing.JTextField jTextFieldCodSetor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables

}
