/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.main;

import br.edu.ufrb.lasis.humv.utils.HUMVConfig;
import br.edu.ufrb.lasis.humv.view.factory.FabricaMenuAdministrador;
import br.edu.ufrb.lasis.humv.view.factory.FabricaMenuFarmaceutico;
import br.edu.ufrb.lasis.humv.view.factory.FabricaMenuRecepcionista;
import br.edu.ufrb.lasis.humv.view.factory.FabricaMenuVeterinario;
import br.edu.ufrb.lasis.humv.view.factory.MenuBarFabricaAbstrata;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class HUMVMainPanel extends JPanel {

    public HUMVMainPanel(String perfilUsuario) {
        initialize(perfilUsuario);
    }

    private void initialize(String perfilUsuario) {
        this.setLayout(new BorderLayout());

        MenuBarFabricaAbstrata fabricaMenu = null;

        switch (perfilUsuario) {
            case HUMVConfig.PERFIL_ADMINISTRADOR:
                fabricaMenu = new FabricaMenuAdministrador(this);
                break;
            case HUMVConfig.PERFIL_RECEPCIONISTA:
                fabricaMenu = new FabricaMenuRecepcionista(this);
                break;
            case HUMVConfig.PERFIL_VETERINARIO:
                fabricaMenu = new FabricaMenuVeterinario(this);
                break;
            default:
                fabricaMenu = new FabricaMenuFarmaceutico(this);
                break;
        }
        
        fabricaMenu.criaMenuBar();
    }

}
