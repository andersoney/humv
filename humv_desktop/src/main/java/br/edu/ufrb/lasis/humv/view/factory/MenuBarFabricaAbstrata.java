/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.factory;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public abstract class MenuBarFabricaAbstrata implements ActionListener{
    
    private JMenuBar menuBar;
    private JMenu menuAjuda;
    private JMenuItem menuItemSair, menuItemSobre;
    
    public MenuBarFabricaAbstrata(JPanel mainPanel){
        menuBar = new JMenuBar();
        mainPanel.add(menuBar, BorderLayout.PAGE_START);
    }
    
    public abstract void criaMenuBar();
    
    public void criaMenuAjuda(){
        menuAjuda = new JMenu("Ajuda");
        menuItemSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuItemSobre);
        getMenuBar().add(menuAjuda);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenuAjuda() {
        return menuAjuda;
    }

    public void setMenuAjuda(JMenu menuAjuda) {
        this.menuAjuda = menuAjuda;
    }

    public JMenuItem getMenuItemSair() {
        return menuItemSair;
    }

    public void setMenuItemSair(JMenuItem menuItemSair) {
        this.menuItemSair = menuItemSair;
    }

    public JMenuItem getMenuItemSobre() {
        return menuItemSobre;
    }

    public void setMenuItemSobre(JMenuItem menuItemSobre) {
        this.menuItemSobre = menuItemSobre;
    }
    
}
