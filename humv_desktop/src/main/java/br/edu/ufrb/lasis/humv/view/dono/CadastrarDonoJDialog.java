/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.view.animal.CadastrarAnimalJPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;

/**
 *
 * @author tassiovale
 */
public class CadastrarDonoJDialog extends JDialog{
    
    private CadastrarAnimalJPanel cadastroAnimalPanel;
    private CadastrarDonoJPanel cadastrarDonoPanel;

    public CadastrarDonoJDialog(CadastrarAnimalJPanel cadastroAnimalPanel) {
        super(HUMVApp.getMainWindow(), true);
        this.cadastroAnimalPanel = cadastroAnimalPanel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de dono");

        cadastrarDonoPanel = new CadastrarDonoJPanel(this);
        setContentPane(cadastrarDonoPanel);

        pack();

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - getWidth()) / 2;
        final int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void fecharDialog(Dono dono) {
        if (dono != null) {
            cadastroAnimalPanel.setDono(dono);
            cadastroAnimalPanel.getjLabelCpfDono().setText(dono.getTipoId() + ": " + MaskUtils.formatarStringCPF(dono.getId()));
            cadastroAnimalPanel.getjLabelNomeDono().setText("Nome: " + dono.getNome());
            dispose();
        }
    }
    
}
