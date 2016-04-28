/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.main;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.usuario.CadastrarUsuarioPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tassiovale
 */
public class HUMVMainPanel extends JPanel implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuUsuario, menuAjuda;
    private JMenuItem menuItemCadastroUsuario, menuItemSair, menuItemSobre;

    public HUMVMainPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();

        menuUsuario = new JMenu("Usuário");
        menuItemCadastroUsuario = new JMenuItem("Cadastro");
        menuItemCadastroUsuario.addActionListener(this);
        menuUsuario.add(menuItemCadastroUsuario);
        menuItemSair = new JMenuItem("Sair");
        menuUsuario.add(menuItemSair);
        menuBar.add(menuUsuario);

        menuAjuda = new JMenu("Ajuda");
        menuItemSobre = new JMenuItem("Sobre");
        menuAjuda.add(menuItemSobre);
        menuBar.add(menuAjuda);

        this.add(menuBar, BorderLayout.PAGE_START);

    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuItemCadastroUsuario)) {
            HUMVApp.setNovoPainelCentral(new CadastrarUsuarioPanel());
        } else if (e.getSource().equals(menuItemSair)) {

        } else if (e.getSource().equals(menuItemSobre)) {

        }
    }

}
