/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class AtendimentoJPanel extends JPanel implements ActionListener {

    private Atendimento atendimento;
    private AgendaJPanel agendaJPanel;
    private JButton cancelarJButton, realizadoJButton, reativarJButton;

    public AtendimentoJPanel(Atendimento atendimento, AgendaJPanel agendaJPanel) {
        super();
        this.atendimento = atendimento;
        this.agendaJPanel = agendaJPanel;
        initComponent();
    }

    private void initComponent() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        setLayout(new GridBagLayout());
        
        AtendimentoButton atendimentoButton = new AtendimentoButton(atendimento, agendaJPanel);
        atendimentoButton.setHorizontalTextPosition(JButton.LEFT);
        add(atendimentoButton, constraints);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx++;

        if (atendimento.getStatus() == Atendimento.STATUS_AGENDADO) {
            Color color = new Color(174, 226, 245);
            cancelarJButton = new JButton(new ImageIcon("imagens/icon_cancelar.png"));
            configurarBotao(cancelarJButton, color, "Cancelar atendimento", constraints);
            realizadoJButton = new JButton(new ImageIcon("imagens/icon_realizado.png"));
            configurarBotao(realizadoJButton, color, "Marcar atendimento como realizado", constraints);
        } else if (atendimento.getStatus() == Atendimento.STATUS_REALIZADO) {
            Color color = new Color(123, 198, 133);
            reativarJButton = new JButton(new ImageIcon("imagens/icon_reativar.png"));
            configurarBotao(reativarJButton, color, "Reativar atendimento", constraints);
        }
    }

    private void configurarBotao(JButton button, Color color, String toolTip, GridBagConstraints constraints) {
        button.addActionListener(this);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setBackground(color);
        button.setToolTipText(toolTip);
        add(button, constraints);
        constraints.gridx++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean confirmado = InterfaceGraficaUtils.dialogoMensagem("Confirmar alteração", "Deseja realmente realizar esta alteração?");

        if (confirmado) {
            String msg = "Atualização efetuada com sucesso!";
            if (e.getSource().equals(cancelarJButton)) {
                atendimento.setStatus(Atendimento.STATUS_CANCELADO);
                msg = "Atendimento cancelado com sucesso!";
            } else if (e.getSource().equals(realizadoJButton)) {
                atendimento.setStatus(Atendimento.STATUS_REALIZADO);
            } else if (e.getSource().equals(reativarJButton)) {
                atendimento.setStatus(Atendimento.STATUS_AGENDADO);
            }

            try {
                ClientResponse response = RESTMethods.put("/api/atendimento", atendimento);
                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                } else {
                    InterfaceGraficaUtils.sucessoResposta(msg);
                    agendaJPanel.construirHorarios();
                }
            } catch (RESTConnectionException ex) {
                InterfaceGraficaUtils.erroConexao();
                ex.printStackTrace();
            }
        }
    }

}
