package br.edu.ufrb.lasis.humv.view.solicitacaomaterial;
public class EscolherMaterialJDialog extends javax.swing.JDialog {

    public EscolherMaterialJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSelecionar = new javax.swing.JButton();
        jLabelMaterial = new javax.swing.JLabel();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSelecionar.setText("Selecionar material");

        jLabelMaterial.setText("Material:");

        jLabel2.setText("Quantidade:");

        jButtonConfirmar.setText("Confirmar");

        jButtonCancelar.setText("Cancelar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ESCOLHER MATERIAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmar)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSelecionar))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMaterial))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel3)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelecionar)
                    .addComponent(jLabelMaterial))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConfirmar)
                            .addComponent(jButtonCancelar))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EscolherMaterialJDialog dialog = new EscolherMaterialJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMaterial;
    private javax.swing.JSpinner jSpinnerQuantidade;
    // End of variables declaration//GEN-END:variables
}
