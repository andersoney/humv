package br.edu.ufrb.lasis.humv.view.procedimento;

import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.setor.CadastroSetorJDialog;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class CadastroProcedimento extends javax.swing.JPanel implements ActionListener {

    JFrame parent;
    String codSetor;
    String nomeProcedimento;
    String codProcedimento;
    String valorProcedimento;
    String nomeSetor;
    final private String servicoSetor = "/api/setor";
    final private String servicoProcedimento = "/api/procedimento";
    private static final Logger LOG = Logger.getLogger(CadastroProcedimento.class.getName());
    private Procedimento procedimentoSelecionado;

    /**
     * Creates new form CadastroProcedimento
     */
    public CadastroProcedimento() {
        initComponents();
        customInitComponents();
    }

    public CadastroProcedimento(Procedimento procedimentoSelecionado) {
        this.procedimentoSelecionado = procedimentoSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        buttonConfirmar.addActionListener(this);
        buttonCancelar.addActionListener(this);
        textFieldNome.setFocusable(true);

        if (procedimentoSelecionado != null) {
            labelTitulo.setText("Alteração de dados do procedimento");
            textFieldNome.setText(procedimentoSelecionado.getNome());
            textFieldCodigo.setText(procedimentoSelecionado.getCodigo());
            textFieldPreco.setText(""+procedimentoSelecionado.getValor());
            ClientResponse response = null;
            try {
                response = RESTMethods.get(servicoSetor + "/" + procedimentoSelecionado.getCodSetor());
                Setor at = response.getEntity(Setor.class);
                labelNomeSetor.setText("Nome: " + at.getNome());
                jLabelSetorCodigo.setText("Código: "+ at.getCodigo());
            } catch (RESTConnectionException ex) {
                Logger.getLogger(CadastroProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            labelTitulo.setText("Cadastro de dados do procedimento");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonCadastrarSetor = new javax.swing.JButton();
        buttonPesqusar = new javax.swing.JButton();
        textFieldCodSetor = new javax.swing.JTextField();
        labelCodSetor = new javax.swing.JLabel();
        labelNomeSetor = new javax.swing.JLabel();
        jLabelSetorCodigo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textFieldNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        textFieldCodigo = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        buttonConfirmar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        textFieldPreco = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de setor"));

        buttonCadastrarSetor.setText("Cadastrar novo...");
        buttonCadastrarSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCadastrarSetorMouseClicked(evt);
            }
        });

        buttonPesqusar.setText("Pesquisar");
        buttonPesqusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesqusarActionPerformed(evt);
            }
        });

        labelCodSetor.setText("Informe o código do setor");

        labelNomeSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNomeSetor.setText("Nome: ");

        jLabelSetorCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSetorCodigo.setText("Código: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldCodSetor)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodSetor)
                            .addComponent(labelNomeSetor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonPesqusar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCadastrarSetor))
                    .addComponent(jLabelSetorCodigo))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCodSetor)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesqusar)
                    .addComponent(buttonCadastrarSetor)
                    .addComponent(textFieldCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeSetor)
                    .addComponent(jLabelSetorCodigo))
                .addGap(31, 31, 31))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do Procedimento"));

        labelNome.setText("Nome");

        labelCodigo.setText("Código");

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelPreco.setText("Preço R$");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNome)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNome)
                                    .addComponent(labelCodigo)
                                    .addComponent(textFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 144, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPreco))
                                .addGap(157, 157, 157))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonCancelar)
                                .addGap(48, 48, 48)
                                .addComponent(buttonConfirmar)
                                .addGap(138, 138, 138))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(labelPreco))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConfirmar)
                    .addComponent(buttonCancelar)))
        );

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("Titulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCadastrarSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCadastrarSetorMouseClicked
        // TODO add your handling code here:
        CadastroSetorJDialog setor = new CadastroSetorJDialog(parent, true, this);
        setor.setTitle("Cadastro de dono de animais");
        setor.setLocationRelativeTo(null);
        setor.setVisible(true);
    }//GEN-LAST:event_buttonCadastrarSetorMouseClicked
    
    public void setCodSetorNull() {
        this.codSetor=" ";
        this.nomeSetor = null;
        this.labelNomeSetor.setText("Nome: ");
        this.labelCodSetor.setText("Código: ");
    }
    public void setCodSetor(String nome,String cod) {
        this.codSetor=cod;
        if(!cod.equals(" ")){
            this.nomeSetor = nome;
            this.labelNomeSetor.setText("Nome: "+nome);
            this.labelCodSetor.setText("Código: "+cod);
        }
    }
    private void buttonPesqusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesqusarActionPerformed
        // TODO add your handling code here:
        ClientResponse response;
        if (textFieldCodSetor.getText().length() > 0) {
            try {
                response = RESTMethods.get(servicoSetor + "/" + this.textFieldCodSetor.getText() + "");
                Setor at = response.getEntity(Setor.class);
                nomeSetor = at.getNome();
                codSetor = at.getCodigo();
                this.labelNomeSetor.setText("Nome: " + at.getNome());
            } catch (RESTConnectionException ex) {
                Logger.getLogger(CadastroProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite um código válido.");
        }
    }//GEN-LAST:event_buttonPesqusarActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        // TODO add your handling code here:
        if (nomeSetor == null) {
            JOptionPane.showMessageDialog(this, "Escolha um setor na lista ou cadastre um novo.");
            return;
        }
        char sexo;
        float peso;
        int idade;
        boolean pequenoPort;
        if (this.textFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome do procedimento não pode ficar vazio.");
            return;
        }
        String nome = this.textFieldNome.getText();
        if (this.textFieldCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Código não pode ficar vazio.");
            return;
        }
        String codigo = this.textFieldCodigo.getText();
        if (textFieldPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo preço não pode ficar vazio.");
            return;
        }
        double valor = Double.parseDouble(this.textFieldPreco.getText());
        
        Procedimento procedimento = new Procedimento();
        procedimento.setValor(valor);
        procedimento.setCodigo(codigo);
        procedimento.setNome(nome);
        procedimento.setCodSetor(codSetor);
        try {
            ClientResponse response = RESTMethods.post(this.servicoProcedimento, procedimento);
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                JOptionPane.showMessageDialog(this, resposta, "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Sucesso no cadastro");
            }
        } catch (RESTConnectionException ex) {
            Logger.getLogger(CadastroProcedimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.setVisible(false);
        System.gc();
    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrarSetor;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonPesqusar;
    private javax.swing.JLabel jLabelSetorCodigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCodSetor;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomeSetor;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textFieldCodSetor;
    private javax.swing.JTextField textFieldCodigo;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldPreco;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
