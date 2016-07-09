/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.utils.MessageUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Andersoney
 */
public class CadastrarDonoJPanel extends javax.swing.JPanel {

    private final String servicoDono = "/api/dono";
    private String id;
    private String tipoId;
    private CadastrarDonoJDialog cadastroDonoJDialog = null;

    /**
     * Creates new form CadastrarDono
     */
    public CadastrarDonoJPanel() {
        initComponents();
        this.jRadioButtonFazenda.setSelected(false);
        this.jRadioButtonCidade.setSelected(true);
        this.jRadioButtonCpf.setSelected(true);
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setText("");
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
    }

    public CadastrarDonoJPanel(CadastrarDonoJDialog cadastroDonoJDialog) {
        initComponents();
        this.cadastroDonoJDialog = cadastroDonoJDialog;
        this.jRadioButtonFazenda.setSelected(false);
        this.jRadioButtonCidade.setSelected(true);
        this.jRadioButtonCpf.setSelected(true);
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setText("");
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosDono = new javax.swing.JPanel();
        jPanelDadosPessoais = new javax.swing.JPanel();
        nomeJL = new javax.swing.JLabel();
        nomeJTF = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldCpf = MaskUtils.mascaraCpf();
        telefoneJL = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldTelefone=MaskUtils.mascaraTelefone();
        jRadioButtonCpf = new javax.swing.JRadioButton();
        jRadioButtonCpf.setSelected(true);
        jRadioButtonCnpj = new javax.swing.JRadioButton();
        jTextFieldCnpj = new javax.swing.JTextField();
        jTextFieldCnpj = MaskUtils.mascaraCnpj();
        jPanelInformacoesEndereco = new javax.swing.JPanel();
        jLabelEndereco = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldCep = new javax.swing.JTextField();
        jTextFieldCep = MaskUtils.mascaraCep();
        jLabelCep = new javax.swing.JLabel();
        jRadioButtonCidade = new javax.swing.JRadioButton();
        jRadioButtonCidade.setSelected(true);
        jRadioButtonFazenda = new javax.swing.JRadioButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jTextFieldCidadeFazenda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        jPanelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados pessoais"));
        jPanelDadosPessoais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanelDadosPessoaisKeyPressed(evt);
            }
        });

        nomeJL.setText("Nome:");

        telefoneJL.setText("Telefone:");

        jRadioButtonCpf.setText("CPF");
        jRadioButtonCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCpfActionPerformed(evt);
            }
        });

        jRadioButtonCnpj.setText("CNPJ");
        jRadioButtonCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCnpjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosPessoaisLayout = new javax.swing.GroupLayout(jPanelDadosPessoais);
        jPanelDadosPessoais.setLayout(jPanelDadosPessoaisLayout);
        jPanelDadosPessoaisLayout.setHorizontalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nomeJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jTextFieldTelefone))
                    .addComponent(telefoneJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCnpj)
                    .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jRadioButtonCpf)))
                .addContainerGap())
        );
        jPanelDadosPessoaisLayout.setVerticalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJL)
                    .addComponent(jRadioButtonCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneJL)
                    .addComponent(jRadioButtonCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInformacoesEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de endereço"));

        jLabelEndereco.setText("Endereço:");

        jLabelCep.setText("CEP:");

        jRadioButtonCidade.setText("Cidade");
        jRadioButtonCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCidadeActionPerformed(evt);
            }
        });

        jRadioButtonFazenda.setText("Fazenda");
        jRadioButtonFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFazendaActionPerformed(evt);
            }
        });

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bahia", "Acre", "Amapá", "Amazonas", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "" }));

        jLabel1.setText("Estado:");

        javax.swing.GroupLayout jPanelInformacoesEnderecoLayout = new javax.swing.GroupLayout(jPanelInformacoesEndereco);
        jPanelInformacoesEndereco.setLayout(jPanelInformacoesEnderecoLayout);
        jPanelInformacoesEnderecoLayout.setHorizontalGroup(
            jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEndereco)
                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addGap(206, 206, 206))
                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCep)
                            .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCidadeFazenda)
                            .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonFazenda))
                                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelInformacoesEnderecoLayout.setVerticalGroup(
            jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCep)
                            .addComponent(jRadioButtonCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                        .addComponent(jRadioButtonFazenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCidadeFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE DONO");

        javax.swing.GroupLayout jPanelDadosDonoLayout = new javax.swing.GroupLayout(jPanelDadosDono);
        jPanelDadosDono.setLayout(jPanelDadosDonoLayout);
        jPanelDadosDonoLayout.setHorizontalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelInformacoesEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDadosDonoLayout.setVerticalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(29, 29, 29)
                .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelInformacoesEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDadosDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDadosDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelDadosPessoaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelDadosPessoaisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelDadosPessoaisKeyPressed

    private void jRadioButtonCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCidadeActionPerformed
        this.jRadioButtonFazenda.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCidadeActionPerformed

    private void jRadioButtonFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFazendaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCidade.setSelected(false);
    }//GEN-LAST:event_jRadioButtonFazendaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        int i = MessageUtils.dialogoCancelar("o cadastro", "dono");
        if (i == JOptionPane.OK_OPTION) {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

        String nome = this.nomeJTF.getText();
        if (nome.isEmpty()) {
            MessageUtils.validaCampoVazio("nome");
            return;
        }

        if (jRadioButtonCpf.isSelected()) {
            if (!ValidationsUtils.isCPF(MaskUtils.removeMascara(this.jTextFieldCpf.getText()))) {
                MessageUtils.validaCampoInvalido("CPF");
                return;
            }
            id = MaskUtils.removeMascara(this.jTextFieldCpf.getText());
        }

        if (jRadioButtonCnpj.isSelected()) {
            if (!ValidationsUtils.isCNPJ(MaskUtils.removeMascara(this.jTextFieldCnpj.getText()))) {
                MessageUtils.validaCampoInvalido("CNPJ");
                return;
            }
            id = MaskUtils.removeMascara(this.jTextFieldCnpj.getText());
        }

        String telefone = this.jTextFieldTelefone.getText();
        if (telefone.isEmpty()) {
            MessageUtils.validaCampoVazio("telefone");
            return;
        }

        String endereco = this.jTextFieldEndereco.getText();
        if (endereco.isEmpty()) {
            MessageUtils.validaCampoVazio("endereço");
            return;
        }

        String cep = this.jTextFieldCep.getText();
        if (cep.isEmpty()) {
            MessageUtils.validaCampoVazio("CEP");
            return;
        }

        String local;
        if (this.jRadioButtonCidade.isSelected()) {
            local = "Cidade";
        } else {
            local = "Fazenda";
        }

        if (this.jTextFieldCidadeFazenda.getText().isEmpty()) {
            MessageUtils.validaCampoVazio(local.toLowerCase());
            return;
        }
        String localT = local + ": " + this.jTextFieldCidadeFazenda.getText();

        String estado = this.jComboBoxEstado.getSelectedItem().toString();

        Dono dono = new Dono();
        dono.setCep(cep);
        dono.setCidade(localT);
        dono.setId(id);
        dono.setEndereco(endereco);
        dono.setEstado(estado);
        dono.setNome(nome);
        dono.setTelefone(telefone);
        dono.setTipoId(tipoId);

        ClientResponse response;
        try {
            response = RESTMethods.post(servicoDono, dono);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                MessageUtils.erroResposta(resposta);
                return;
            }
            MessageUtils.sucessoCadastro("dono");
        } catch (RESTConnectionException ex) {
            MessageUtils.erroConexao();
        }

        if (cadastroDonoJDialog != null) {
            cadastroDonoJDialog.fecharDialog(nome, id);
        } else {
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jRadioButtonCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCpfActionPerformed
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setText("");
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
    }//GEN-LAST:event_jRadioButtonCpfActionPerformed

    private void jRadioButtonCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCnpjActionPerformed
        this.jRadioButtonCpf.setSelected(false);
        this.jTextFieldCnpj.setEnabled(true);
        this.jTextFieldCnpj.setFocusable(true);
        this.jTextFieldCpf.setText("");
        this.jTextFieldCpf.setEnabled(false);
        this.tipoId = "CNPJ";
    }//GEN-LAST:event_jRadioButtonCnpjActionPerformed

    private void custonInitComponents() {
        jRadioButtonCpf.setSelected(true);
        this.jTextFieldCnpj.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelDadosDono;
    private javax.swing.JPanel jPanelDadosPessoais;
    private javax.swing.JPanel jPanelInformacoesEndereco;
    private javax.swing.JRadioButton jRadioButtonCidade;
    private javax.swing.JRadioButton jRadioButtonCnpj;
    private javax.swing.JRadioButton jRadioButtonCpf;
    private javax.swing.JRadioButton jRadioButtonFazenda;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidadeFazenda;
    private javax.swing.JTextField jTextFieldCnpj;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JLabel nomeJL;
    private javax.swing.JTextField nomeJTF;
    private javax.swing.JLabel telefoneJL;
    // End of variables declaration//GEN-END:variables
}
