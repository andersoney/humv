/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.busca;

import br.edu.ufrb.lasis.humv.HUMVApp;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tassi
 */
public class BuscaPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuscaPanel
     *
     * @param tituloPanel
     * @param propriedadesBusca
     */
    public BuscaPanel(String tituloPanel, PropriedadesBusca propriedadesBusca) {
        initComponents();
        customInitComponents(tituloPanel, propriedadesBusca);
    }

    private void customInitComponents(String tituloPanel, PropriedadesBusca propriedadesBusca) {
        labelTitulo.setText(tituloPanel);

        tabelaResultado.setModel(
                new DefaultTableModel(new Object[][]{}, new String[]{"Sem resultados"}));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabelaResultado.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        propriedadesBusca.configurarBusca(textFieldPalavraChave, buttonBuscar, tabelaResultado);
        propriedadesBusca.configurarBotaoOperacaoPosBusca(buttonOperacao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldPalavraChave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonBuscar = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        scrollPaneTabela = new javax.swing.JScrollPane();
        tabelaResultado = new javax.swing.JTable();
        buttonOperacao = new javax.swing.JButton();
        buttonImprimirTabela = new javax.swing.JButton();
        cancelarJB = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        textFieldPalavraChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPalavraChaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Palavra-chave:");

        buttonBuscar.setText("Buscar");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("jLabel2");

        tabelaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneTabela.setViewportView(tabelaResultado);

        buttonOperacao.setText("jButton1");

        buttonImprimirTabela.setText("Imprimir Tabela");
        buttonImprimirTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImprimirTabelaActionPerformed(evt);
            }
        });

        cancelarJB.setText("Cancelar");

        cancelarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPaneTabela)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldPalavraChave, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(cancelarJB)
                        .addGap(18, 18, 18)
                        .addComponent(buttonImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelTitulo)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPalavraChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(buttonBuscar))
                .addGap(26, 26, 26)
                .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOperacao)
                    .addComponent(buttonImprimirTabela)
                    .addComponent(cancelarJB))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldPalavraChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPalavraChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPalavraChaveActionPerformed

    private void buttonImprimirTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImprimirTabelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonImprimirTabelaActionPerformed

    private void cancelarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJBActionPerformed
        // TODO add your handling code here:
        HUMVApp.exibirMensagemCarregamento();
        HUMVApp.setPainelCentralComLogo();
        HUMVApp.esconderMensagemCarregamento();
    }//GEN-LAST:event_cancelarJBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonImprimirTabela;
    private javax.swing.JButton buttonOperacao;
    private javax.swing.JButton cancelarJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tabelaResultado;
    private javax.swing.JTextField textFieldPalavraChave;
    // End of variables declaration//GEN-END:variables
}
