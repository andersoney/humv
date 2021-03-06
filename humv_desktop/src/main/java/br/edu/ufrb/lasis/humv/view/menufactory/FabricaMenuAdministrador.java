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
        boolean soBusca = false, comRemover = true;
        super.criaMenuUsuario();
        super.criaMenuDono(comRemover);
        super.criaMenuAnimal(comRemover);
        super.criaMenuSetor(comRemover);
        super.criaMenuProcedimento(soBusca);
        super.criaMenuProjeto(comRemover);
        super.criaMenuAtendimento();
        super.criaMenuProntuarioEletronico();
        soBusca = true;
        super.criaMenuQuestionarioSocioeconomico(soBusca);
        this.criaMenuAtendimentoSocial(soBusca);
        super.criaMenuMaterial();
        super.criaMenuAjuda();

        super.criaBotaoCadastrarProcedimento();
        super.criaBotaoCadastrarAnimal();
        super.criaBotaoCadastrarUsuario();
        super.criaBotaoVisualizarAgenda();
        super.criaBotaoResponderQuestionario();
        super.criaBotaoCadastrarMaterial();
        //super.criaMenuSolicitacaoMaterial(soBusca);
        //super.criaMenuLiberacaoMaterial(soBusca);
    }

}
