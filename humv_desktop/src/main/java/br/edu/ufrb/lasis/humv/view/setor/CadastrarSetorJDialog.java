/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;

/**
 *
 * @author tassiovale
 */
public class CadastrarSetorJDialog extends JDialog {

    private CadastrarProcedimentoJPanel cadastroProcedimentoPanel;
    private CadastrarSetorJPanel cadastrarSetorPanel;

    public CadastrarSetorJDialog(CadastrarProcedimentoJPanel cadastroProcedimentoPanel) {
        super(HUMVApp.getMainWindow(), true);
        this.cadastroProcedimentoPanel = cadastroProcedimentoPanel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de setor");

        cadastrarSetorPanel = new CadastrarSetorJPanel(this);
        setContentPane(cadastrarSetorPanel);

        pack();

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - getWidth()) / 2;
        final int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void fecharDialog(Integer codigoSetor, String nomeSetor) {
        if (!(codigoSetor == null || nomeSetor == null)) {
            cadastroProcedimentoPanel.getjLabelSetorCodigo().setText("Código: " + codigoSetor);
            cadastroProcedimentoPanel.getjLabelNomeSetor().setText("Nome: " + nomeSetor);
            dispose();
        }
    }
}
