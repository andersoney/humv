/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.menufactory;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class FabricaMenuRecepcionista extends MenuBarFabricaAbstrata {

    public FabricaMenuRecepcionista(JPanel mainPanel) {
        super(mainPanel);
    }

    @Override
    public void criaMenuBar() {
        super.criaMenuAjuda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getMenuItemSair())) {

        } else if (e.getSource().equals(getMenuItemSobre())) {

        }
    }
    
}
