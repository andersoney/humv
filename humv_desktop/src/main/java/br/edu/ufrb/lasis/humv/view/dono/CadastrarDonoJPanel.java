package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andersoney
 */
public class CadastrarDonoJPanel extends javax.swing.JPanel {

    private final String servicoDono = "/api/dono";
    private BigInteger id;
    private String tipoId;
    private CadastrarDonoJDialog cadastroDonoJDialog = null;
    private Dono donoSelecionado;

    /**
     * Creates new form CadastrarDono
     */
    public CadastrarDonoJPanel() {
        initComponents();
        this.jRadioButtonCidade.setSelected(true);
        this.jRadioButtonCpf.setSelected(true);
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setText("");
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
        buttonGroupLocal.add(jRadioButtonCidade);
        buttonGroupLocal.add(jRadioButtonFazenda);
    }

    public CadastrarDonoJPanel(CadastrarDonoJDialog cadastroDonoJDialog) {
        this();
        this.cadastroDonoJDialog = cadastroDonoJDialog;
    }

    public CadastrarDonoJPanel(Dono donoSelecionado) {
        this.donoSelecionado = donoSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        if (donoSelecionado != null) {
            jLabelTitulo.setText("ATUALIZAÇÃO DE DONO");
            nomeJTF.setText(donoSelecionado.getNome());
            jTextFieldTelefone.setText(donoSelecionado.getTelefone());
            jTextFieldEmail.setText(donoSelecionado.getEmail());
            jTextFieldCep.setText(donoSelecionado.getCep());
            jTextFieldEndereco.setText(donoSelecionado.getEndereco());
            jTextFieldCidadeFazenda.setText(donoSelecionado.getCidade());
            if (donoSelecionado.getTipoId().equalsIgnoreCase("CPF")) {
                jTextFieldCpf.setText(MaskUtils.formatarStringCPF(donoSelecionado.getId()));
                jRadioButtonCpf.setSelected(true);
                jRadioButtonCnpj.setSelected(false);
                jTextFieldCnpj.setEnabled(false);
                this.tipoId = "CPF";
            } else {
                jTextFieldCnpj.setText(MaskUtils.formatarStringCNPJ(donoSelecionado.getId()));
                jRadioButtonCnpj.setSelected(true);
                jRadioButtonCpf.setSelected(false);
                jTextFieldCpf.setEnabled(false);
                this.tipoId = "CNPJ";
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLocal = new javax.swing.ButtonGroup();
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
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

        jLabel2.setText("E-mail:");

        javax.swing.GroupLayout jPanelDadosPessoaisLayout = new javax.swing.GroupLayout(jPanelDadosPessoais);
        jPanelDadosPessoais.setLayout(jPanelDadosPessoaisLayout);
        jPanelDadosPessoaisLayout.setHorizontalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeJTF)
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefoneJL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonCnpj)
                            .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButtonCpf)))))
                .addContainerGap())
        );
        jPanelDadosPessoaisLayout.setVerticalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(nomeJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jRadioButtonCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(telefoneJL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelInformacoesEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de endereço"));

        jLabelEndereco.setText("Endereço:");

        jLabelCep.setText("CEP:");

        jRadioButtonCidade.setText("Cidade");

        jRadioButtonFazenda.setText("Fazenda");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "dono");
        if (sair) {
            if (cadastroDonoJDialog != null) {
                cadastroDonoJDialog.dispose();
            } else {
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        }


    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed

        String nome = this.nomeJTF.getText();
        if (nome.isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome");
            return;
        }

        if (jRadioButtonCpf.isSelected()) {
            if (!ValidationsUtils.isCPF(MaskUtils.removeMascara(this.jTextFieldCpf.getText()))) {
                InterfaceGraficaUtils.validaCampoInvalido("CPF");
                return;
            } else {
                id = new BigInteger(MaskUtils.removeMascara(this.jTextFieldCpf.getText()));
            }
        }

        if (jRadioButtonCnpj.isSelected()) {
            if (!ValidationsUtils.isCNPJ(MaskUtils.removeMascara(this.jTextFieldCnpj.getText()))) {
                InterfaceGraficaUtils.validaCampoInvalido("CNPJ");
                return;
            } else {
                id = new BigInteger(MaskUtils.removeMascara(this.jTextFieldCnpj.getText()));
            }
        }

        String telefone = this.jTextFieldTelefone.getText();
        if (telefone.isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("telefone");
            return;
        }

        String endereco = this.jTextFieldEndereco.getText();
        if (endereco.isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("endereço");
            return;
        }

        String cep = this.jTextFieldCep.getText();
        if (cep.isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("CEP");
            return;
        }

        String local;
        if (this.jRadioButtonCidade.isSelected()) {
            local = "";
        } else {
            local = "Fazenda ";
        }

        if (this.jTextFieldCidadeFazenda.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio(local.toLowerCase());
            return;
        }
        String localT = local + this.jTextFieldCidadeFazenda.getText();

        String estado = this.jComboBoxEstado.getSelectedItem().toString();

        Dono dono = new Dono();
        dono.setCep(cep);
        dono.setCidade(localT);
        dono.setId(id);
        dono.setEndereco(endereco);
        dono.setEstado(estado);
        dono.setNome(nome);
        dono.setTelefone(telefone);
        dono.setEmail(jTextFieldEmail.getText());
        dono.setTipoId(tipoId);

        ClientResponse response;
        try {
            if (donoSelecionado == null) {
                String donoURL = servicoDono;
                if (cadastroDonoJDialog != null) {
                    donoURL += "/retornaCadastrado";
                }
                response = RESTMethods.post(donoURL, dono);
            } else {
                response = RESTMethods.put(servicoDono, dono);
            }
            
            if (cadastroDonoJDialog != null) {
                Dono donoRetornado = response.getEntity(Dono.class);
                InterfaceGraficaUtils.sucessoCadastro("dono");
                cadastroDonoJDialog.fecharDialog(donoRetornado);
            } else {

                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                    return;
                }

                if (donoSelecionado == null) {
                    InterfaceGraficaUtils.sucessoCadastro("dono");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("dono");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
        } catch (ClientHandlerException ex) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro do dono. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jRadioButtonCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCpfActionPerformed
        this.jRadioButtonCnpj.setSelected(false);
        this.jTextFieldCpf.setEnabled(true);
        this.jTextFieldCpf.setFocusable(true);
        this.jTextFieldCnpj.setEnabled(false);
        this.tipoId = "CPF";
    }//GEN-LAST:event_jRadioButtonCpfActionPerformed

    private void jRadioButtonCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCnpjActionPerformed
        this.jRadioButtonCpf.setSelected(false);
        this.jTextFieldCnpj.setEnabled(true);
        this.jTextFieldCnpj.setFocusable(true);
        this.jTextFieldCpf.setEnabled(false);
        this.tipoId = "CNPJ";
    }//GEN-LAST:event_jRadioButtonCnpjActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLocal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JLabel nomeJL;
    private javax.swing.JTextField nomeJTF;
    private javax.swing.JLabel telefoneJL;
    // End of variables declaration//GEN-END:variables
}
