package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.utils.MessagesUtils;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.view.animal.CadastrarAnimalJPanel;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.sun.jersey.api.client.ClientResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andersoney
 */
public class CadastrarDonoJDialog extends javax.swing.JDialog {

    CadastrarAnimalJPanel parent;
    final String servicoDono = "/api/dono";
    private String id;
    private String tipoId;
    /**
     * Creates new form CadastroDono
     *
     * @param parent
     * @param modal
     * @param cA
     */
    public CadastrarDonoJDialog(java.awt.Frame parent, boolean modal, CadastrarAnimalJPanel cA) {
        super(parent, modal);
        this.parent = cA;
        initComponents();
        this.jRadioButtonCidade.setSelected(true);
        this.jLabelCidadeFazenda.setText("Cidade");

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosPessoais = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldCpf = MaskUtils.mascaraCpf();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldTelefone = MaskUtils.mascaraTelefone();
        jRadioButtonCpf = new javax.swing.JRadioButton();
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
        jRadioButtonFazenda = new javax.swing.JRadioButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jTextFieldCidadeFazenda = new javax.swing.JTextField();
        jLabelCidadeFazenda = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados pessoais"));
        jPanelDadosPessoais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanelDadosPessoaisKeyPressed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jLabelTelefone.setText("Telefone:");

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
                    .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNome))
                    .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jTextFieldCpf))
                    .addComponent(jRadioButtonCnpj, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelDadosPessoaisLayout.setVerticalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jRadioButtonCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
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

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Acre", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", " " }));

        jTextFieldCidadeFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCidadeFazendaActionPerformed(evt);
            }
        });

        jLabelCidadeFazenda.setText("Cidade:");

        javax.swing.GroupLayout jPanelInformacoesEnderecoLayout = new javax.swing.GroupLayout(jPanelInformacoesEndereco);
        jPanelInformacoesEndereco.setLayout(jPanelInformacoesEnderecoLayout);
        jPanelInformacoesEnderecoLayout.setHorizontalGroup(
            jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelCidadeFazenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonFazenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldCidadeFazenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCep)
                    .addComponent(jTextFieldCep)
                    .addComponent(jComboBoxEstado, 0, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInformacoesEnderecoLayout.setVerticalGroup(
            jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jLabelCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacoesEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCidade)
                    .addComponent(jRadioButtonFazenda)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jLabelCidadeFazenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCidadeFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setText("CADASTRAMENTO DE DONO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabelTitulo)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInformacoesEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelInformacoesEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        int op = MessagesUtils.dialogoCancelar("o cadastro", "dono");
        if(op == JOptionPane.OK_OPTION){
            this.dispose();
            parent.setIdNull();
        }
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // TODO add your handling code here:
        if (this.jTextFieldNome.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("nome do dono");
            return;
        }
        String nome = this.jTextFieldNome.getText();
        if(jRadioButtonCpf.isSelected()){
            if (!ValidationsUtils.isCPF(MaskUtils.removeMascara(this.jTextFieldCpf.getText()))) {
                MessagesUtils.validaCampoInvalido("CPF");
                return;
            }
            id = MaskUtils.removeMascara(this.jTextFieldCpf.getText());
        }
        if(jRadioButtonCnpj.isSelected()){
            if (!ValidationsUtils.isCNPJ(MaskUtils.removeMascara(this.jTextFieldCnpj.getText()))) {
                MessagesUtils.validaCampoInvalido("CNPJ");
                return;
            }
            id = MaskUtils.removeMascara(this.jTextFieldCnpj.getText());
        }
        if (this.jTextFieldTelefone.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("telefone");
            return;
        }
        String telefone = this.jTextFieldTelefone.getText();
        if (this.jTextFieldEndereco.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("endereço");
            return;
        }
        String endereco = this.jTextFieldEndereco.getText();
        if (this.jTextFieldCep.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio("CEP");
            return;
        }
        String cep = this.jTextFieldCep.getText();
        String local;
        if ((!this.jRadioButtonCidade.isSelected() && !this.jRadioButtonFazenda.isSelected()) || this.jRadioButtonCidade.isSelected() && this.jRadioButtonFazenda.isSelected()) {
            JOptionPane.showMessageDialog(this, "Escolha o local onde a pessoa vive.");
            return;
        } else if (this.jRadioButtonCidade.isSelected()) {
            local = "Cidade";
        } else {
            local = "Fazenda";
        }
        if (this.jTextFieldCidadeFazenda.getText().isEmpty()) {
            MessagesUtils.validaCampoVazio(local.toLowerCase());
            return;
        }
        String localT = local + ": " + this.jTextFieldCidadeFazenda.getText();
        String estado;
        if (this.jComboBoxEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Escolha um estado válido.");
            return;
        } else {
            estado = this.jComboBoxEstado.getSelectedItem().toString();
        }

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
                MessagesUtils.erroCadastro("dono");
                return;
            }else{
                MessagesUtils.sucessoCadastro("dono");
                if(jRadioButtonCnpj.isSelected()){
                    this.parent.setId(MaskUtils.removeMascara(this.jTextFieldCnpj.getText()), this.jTextFieldNome.getText());
                }else{
                    this.parent.setId(MaskUtils.removeMascara(this.jTextFieldCpf.getText()), this.jTextFieldNome.getText());
                }
            }
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastrarDonoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jRadioButtonCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCidadeActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonFazenda.setSelected(false);
        this.jLabelCidadeFazenda.setText("Cidade:");
    }//GEN-LAST:event_jRadioButtonCidadeActionPerformed

    private void jRadioButtonFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFazendaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCidade.setSelected(false);
        this.jLabelCidadeFazenda.setText("Fazenda:");
    }//GEN-LAST:event_jRadioButtonFazendaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowClosed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyPressed

    private void jPanelDadosPessoaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelDadosPessoaisKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanelDadosPessoaisKeyPressed

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = MessagesUtils.dialogoCancelar("o cadastro","dono");
        if (i == JOptionPane.OK_OPTION) {
            this.dispose();
            parent.setIdNull();
        }       
    }//GEN-LAST:event_formWindowClosing

    private void jTextFieldCidadeFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCidadeFazendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCidadeFazendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidadeFazenda;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitulo;
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
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}