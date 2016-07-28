package br.edu.ufrb.lasis.humv.view.menufactory;

import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class FabricaMenuAdministrador extends MenuBarFabricaAbstrata {

    public FabricaMenuAdministrador(JPanel mainPanel, JPanel panelButtons) {
        super(mainPanel, panelButtons);
    }

    @Override
    public void criaMenuBar() {
        boolean comRemover = true;
        super.criaMenuUsuario();
        super.criaMenuDono(comRemover);
        super.criaMenuAnimal(comRemover);
        super.criaMenuSetor(comRemover);
        super.criaMenuProcedimento(comRemover);
        super.criaMenuProjeto(comRemover);
        super.criaMenuAjuda();
        
        super.criaBotaoCadastrarProcedimento();
        super.criaBotaoCadastrarAnimal();
        super.criaBotaoCadastrarUsuario();
    }

}
