/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.main;

import br.edu.ufrb.lasis.humv.importer.AnimalDonoImporter;
import br.edu.ufrb.lasis.humv.importer.GenericImporter;
import br.edu.ufrb.lasis.humv.importer.SetorProcedimentoImporter;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tassiovale
 */
public class HUMVImporter extends javax.swing.JFrame {

    /**
     * Creates new form HUMVImporter
     */
    public HUMVImporter() {
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        jRadioButtonAnimalDono.setSelected(true);
        buttonGroupTipos.add(jRadioButtonAnimalDono);
        buttonGroupTipos.add(jRadioButtonProcedimento);

        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonAnimalDono = new javax.swing.JRadioButton();
        jRadioButtonProcedimento = new javax.swing.JRadioButton();
        jTextFieldCaminhoArquivo = new javax.swing.JTextField();
        jButtonFileChooser = new javax.swing.JButton();
        jButtonImportar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConsole = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipos de objetos importados:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HUMV importer");

        jRadioButtonAnimalDono.setText("Animal + dono");

        jRadioButtonProcedimento.setText("Setor + procedimento");

        jButtonFileChooser.setText("Escolher arquivo...");
        jButtonFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFileChooserActionPerformed(evt);
            }
        });

        jButtonImportar.setText("Importar");
        jButtonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarActionPerformed(evt);
            }
        });

        jTextAreaConsole.setColumns(20);
        jTextAreaConsole.setRows(5);
        jScrollPane2.setViewportView(jTextAreaConsole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonAnimalDono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonProcedimento))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextFieldCaminhoArquivo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonFileChooser)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonImportar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonAnimalDono)
                    .addComponent(jRadioButtonProcedimento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFileChooser)
                    .addComponent(jButtonImportar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFileChooserActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("Arquivo excel", "xls", "xlsx");
        fileChooser.addChoosableFileFilter(filter);
        int resultado = fileChooser.showDialog(this, "Escolher");
        if (resultado == JFileChooser.APPROVE_OPTION) {
            jTextFieldCaminhoArquivo.setText(fileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jButtonFileChooserActionPerformed

    private void jButtonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarActionPerformed
        String caminhoArquivo = jTextFieldCaminhoArquivo.getText();
        if (caminhoArquivo != null && !caminhoArquivo.isEmpty() && (caminhoArquivo.endsWith(".xls") || caminhoArquivo.endsWith(".xlsx"))) {
            if (jRadioButtonAnimalDono.isSelected()) {
                try {
                    new AnimalDonoImporter(caminhoArquivo, jTextAreaConsole).importar();
                    JOptionPane.showMessageDialog(this, "Importação animal/dono executada com sucesso!", "Animais e donos", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    jTextAreaConsole.append("\nERRO: " + GenericImporter.getStackTraceAsString(ex));
                    JOptionPane.showMessageDialog(this, "Erro durante importação. Confira o console para mais detalhes.", "Erro de importação", JOptionPane.WARNING_MESSAGE);
                }
            } else if (jRadioButtonProcedimento.isSelected()) {
                try {
                    new SetorProcedimentoImporter(caminhoArquivo, jTextAreaConsole).importar();
                    JOptionPane.showMessageDialog(this, "Importação setor/procedimento executada com sucesso!", "Setores e procedimentos", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    jTextAreaConsole.append("\nERRO: " + GenericImporter.getStackTraceAsString(ex));
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro durante importação. Confira o console para mais detalhes.", "Erro de importação", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, informe um arquivo válido", "Arquivo inválido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonImportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HUMVImporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HUMVImporter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipos;
    private javax.swing.JButton jButtonFileChooser;
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonAnimalDono;
    private javax.swing.JRadioButton jRadioButtonProcedimento;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaConsole;
    private javax.swing.JTextField jTextFieldCaminhoArquivo;
    // End of variables declaration//GEN-END:variables
}
