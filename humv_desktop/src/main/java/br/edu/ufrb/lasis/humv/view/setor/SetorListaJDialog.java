/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.view.procedimento.CadastrarProcedimentoJPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author tassiovale
 */
public class SetorListaJDialog extends JDialog implements ActionListener {

    private CadastrarProcedimentoJPanel cadastroProcedimentoPanel;
    private List<Setor> setores;
    private ArrayList<JRadioButton> radios;
    private JButton buttonOK;

    public SetorListaJDialog(CadastrarProcedimentoJPanel cadastroProcedimentoPanel, List<Setor> setores) {
        super(HUMVApp.getMainWindow(), true);
        this.cadastroProcedimentoPanel = cadastroProcedimentoPanel;
        this.setores = setores;
        initComponents();
    }

    private void initComponents() {
        setTitle("Setores");

        JPanel painelLinhas = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        ButtonGroup grupoRadios = new ButtonGroup();
        radios = new ArrayList<JRadioButton>();

        for (Setor setor : setores) {
            JPanel panel = new JPanel(new FlowLayout());
            JRadioButton botao = new JRadioButton();
            grupoRadios.add(botao);
            radios.add(botao);
            panel.add(botao);
            panel.add(new JLabel(setor.getCodigo() + " - " + setor.getNome()));
            painelLinhas.add(panel, constraints);
            constraints.gridy++;
        }
        radios.get(0).setSelected(true);
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(painelLinhas, BorderLayout.CENTER);
        buttonOK = new JButton("Selecionar");
        buttonOK.addActionListener(this);
        mainPanel.add(buttonOK, BorderLayout.PAGE_END);
        setContentPane(new JScrollPane(mainPanel));

        setMinimumSize(new Dimension(170, 0));
        pack();

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - getWidth()) / 2;
        final int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).isSelected()) {
                cadastroProcedimentoPanel.setCodigoSetor(setores.get(i).getCodigo());
                cadastroProcedimentoPanel.getjLabelSetorCodigo().setText("Código: " + setores.get(i).getCodigo());
                cadastroProcedimentoPanel.getjLabelNomeSetor().setText("Nome: " + setores.get(i).getNome());
                dispose();
            }
        }
    }

}
