/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.menufactory;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.view.busca.BuscaPanel;
import br.edu.ufrb.lasis.humv.view.usuario.CadastrarUsuarioPanel;
import br.edu.ufrb.lasis.humv.view.usuario.PropriedadesBuscaUsuario;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class FabricaMenuAdministrador extends MenuBarFabricaAbstrata {

    private JMenu menuUsuario;
    private JMenuItem menuItemCadastroUsuario, menuItemBuscaUsuario, menuItemAlteracaoUsuario, menuItemRemocaoUsuario, menuItemSair, menuItemSobre;

    public FabricaMenuAdministrador(JPanel mainPanel) {
        super(mainPanel);
    }

    @Override
    public void criaMenuBar() {
        menuUsuario = new JMenu("Usuário");

        menuItemBuscaUsuario = new JMenuItem("Busca");
        menuItemBuscaUsuario.addActionListener(this);
        menuUsuario.add(menuItemBuscaUsuario);

        menuItemCadastroUsuario = new JMenuItem("Cadastro");
        menuItemCadastroUsuario.addActionListener(this);
        menuUsuario.add(menuItemCadastroUsuario);

        menuItemAlteracaoUsuario = new JMenuItem("Alteração");
        menuItemAlteracaoUsuario.addActionListener(this);
        menuUsuario.add(menuItemAlteracaoUsuario);

        menuItemRemocaoUsuario = new JMenuItem("Remoção");
        menuItemRemocaoUsuario.addActionListener(this);
        menuUsuario.add(menuItemRemocaoUsuario);
        
        menuUsuario.addSeparator();

        menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(this);
        menuUsuario.add(menuItemSair);

        getMenuBar().add(menuUsuario);

        super.criaMenuAjuda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuItemCadastroUsuario)) {
            HUMVApp.setNovoPainelCentral(new CadastrarUsuarioPanel());
        } else if (e.getSource().equals(menuItemBuscaUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_VISUALIZAR)));
        } else if (e.getSource().equals(menuItemAlteracaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para alteração", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_ALTERAR)));
        } else if (e.getSource().equals(menuItemRemocaoUsuario)) {
            HUMVApp.setNovoPainelCentral(new BuscaPanel("Buscar usuário para remoção", new PropriedadesBuscaUsuario(PropriedadesBuscaUsuario.OPCAO_REMOVER)));
        } else if (e.getSource().equals(menuItemSair)) {

        } else if (e.getSource().equals(menuItemSobre)) {

        }
    }

}
