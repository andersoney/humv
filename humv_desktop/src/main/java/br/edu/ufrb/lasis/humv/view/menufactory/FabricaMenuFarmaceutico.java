/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.menufactory;

import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class FabricaMenuFarmaceutico extends MenuBarFabricaAbstrata {

    public FabricaMenuFarmaceutico(JPanel mainPanel, JPanel panelButtons) {
        super(mainPanel, panelButtons);
    }

    @Override
    public void criaMenuBar() {
        boolean comRemover = false;
        super.criaMenuMaterial();
        super.criaMenuSetor(comRemover);
        super.criaMenuAjuda();
        
        super.criaBotaoCadastrarMaterial();
    }

}
