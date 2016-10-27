/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.main;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.view.menufactory.FabricaMenuAdministrador;
import br.edu.ufrb.lasis.humv.view.menufactory.FabricaMenuAssistenteSocial;
import br.edu.ufrb.lasis.humv.view.menufactory.FabricaMenuFarmaceutico;
import br.edu.ufrb.lasis.humv.view.menufactory.FabricaMenuRecepcionista;
import br.edu.ufrb.lasis.humv.view.menufactory.FabricaMenuVeterinario;
import br.edu.ufrb.lasis.humv.view.menufactory.MenuBarFabricaAbstrata;
import java.awt.FlowLayout;

/**
 *
 * @author tassiovale
 */
public class MainSplitPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainSplitPanel
     *
     * @param perfilUsuario
     */
    public MainSplitPanel(Integer perfilUsuario) {
        initComponents();
        customInitComponents(perfilUsuario);
    }

    private void customInitComponents(Integer perfilUsuario) {
        scrollPane.setViewportView(HUMVApp.getMainPanelInstance());
        panelRightButtons.setLayout(new FlowLayout());

        MenuBarFabricaAbstrata fabricaMenu = null;
        if (perfilUsuario.equals(Usuario.PERFIL_ADMINISTRADOR)) {
            fabricaMenu = new FabricaMenuAdministrador(this, panelRightButtons);
        } else if (perfilUsuario.equals(Usuario.PERFIL_ASSISTENTE_SOCIAL)) {
            fabricaMenu = new FabricaMenuAssistenteSocial(this, panelRightButtons);
        } else if (perfilUsuario.equals(Usuario.PERFIL_FARMACEUTICO)) {
            fabricaMenu = new FabricaMenuFarmaceutico(this, panelRightButtons);
        } else if (perfilUsuario.equals(Usuario.PERFIL_RECEPCIONISTA)) {
            fabricaMenu = new FabricaMenuRecepcionista(this, panelRightButtons);
        } else {
            fabricaMenu = new FabricaMenuVeterinario(this, panelRightButtons);
        }
        fabricaMenu.criaMenuBar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanel = new javax.swing.JSplitPane();
        panelRightButtons = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();

        setLayout(new java.awt.BorderLayout());

        splitPanel.setDividerSize(2);

        panelRightButtons.setMaximumSize(new java.awt.Dimension(150, 32767));

        javax.swing.GroupLayout panelRightButtonsLayout = new javax.swing.GroupLayout(panelRightButtons);
        panelRightButtons.setLayout(panelRightButtonsLayout);
        panelRightButtonsLayout.setHorizontalGroup(
            panelRightButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panelRightButtonsLayout.setVerticalGroup(
            panelRightButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        splitPanel.setLeftComponent(panelRightButtons);
        splitPanel.setRightComponent(scrollPane);

        add(splitPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelRightButtons;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSplitPane splitPanel;
    // End of variables declaration//GEN-END:variables
}
