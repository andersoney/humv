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
public class FabricaMenuRecepcionista extends MenuBarFabricaAbstrata {

    public FabricaMenuRecepcionista(JPanel mainPanel, JPanel panelButtons) {
        super(mainPanel, panelButtons);
    }

    @Override
    public void criaMenuBar() {
        boolean soBusca = true, comRemover = false;
        super.criaMenuAtendimento();
        super.criaMenuDono(comRemover);
        super.criaMenuAnimal(comRemover);
        super.criaMenuProntuarioEletronico();
        super.criaMenuProcedimento(comRemover);
        super.criaMenuQuestionarioSocioeconomico(soBusca);
        super.criaMenuAjuda();

        super.criaBotaoVisualizarAgenda();
        super.criaBotaoCadastrarAnimal();
        super.criaBotaoImprimirFichaCLinica();
    }

}
