/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.busca;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tassi
 */
public class BuscaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuscaPanel
     *
     * @param tituloPanel
     * @param propriedadesBusca
     */
    public BuscaJPanel(String tituloPanel, PropriedadesBusca propriedadesBusca) {
        initComponents();
        customInitComponents(tituloPanel, propriedadesBusca);
    }

    private void customInitComponents(String tituloPanel, PropriedadesBusca propriedadesBusca) {
        labelTitulo.setText(tituloPanel);

        tabelaResultado.setModel(
                new DefaultTableModel(new Object[][]{}, new String[]{"Sem resultados"}));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabelaResultado.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        propriedadesBusca.configurarBusca(textFieldPalavraChave, buttonBuscar, buttonImprimirTabela, buttonCancelar, tabelaResultado);
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
        buttonCancelar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("Palavra-chave:");

        buttonBuscar.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        buttonBuscar.setText("Buscar");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        buttonImprimirTabela.setIcon(new javax.swing.ImageIcon("imagens/small_pdf.png"));
        buttonImprimirTabela.setText("Gerar PDF");

        buttonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        buttonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldPalavraChave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOperacao)
                    .addComponent(buttonImprimirTabela)
                    .addComponent(buttonCancelar))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonImprimirTabela;
    private javax.swing.JButton buttonOperacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tabelaResultado;
    private javax.swing.JTextField textFieldPalavraChave;
    // End of variables declaration//GEN-END:variables
}
