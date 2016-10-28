/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tassiovale
 */
public class AtendimentoJPanel implements ActionListener {

    private final static Logger log = LoggerFactory.getLogger(AtendimentoJPanel.class);
    private Atendimento atendimento;
    private AgendaJPanel agendaJPanel;
    private GridBagConstraints constraints;
    private JButton cancelarJButton, realizadoJButton, reativarJButton;

    public AtendimentoJPanel(Atendimento atendimento, AgendaJPanel agendaJPanel, GridBagConstraints constraints) {
        super();
        this.atendimento = atendimento;
        this.agendaJPanel = agendaJPanel;
        this.constraints = constraints;
    }

    public void addJPanelBotoes() {
        AtendimentoButton atendimentoButton = new AtendimentoButton(atendimento, agendaJPanel);
        atendimentoButton.setHorizontalTextPosition(JButton.LEFT);
        constraints.fill = GridBagConstraints.VERTICAL;

        if (atendimento.getStatus() == Atendimento.STATUS_AGENDADO) {
            agendaJPanel.add(atendimentoButton, constraints);
            Color color = new Color(174, 226, 245);
            addBotaoCancelar(color);
            realizadoJButton = new JButton(new ImageIcon("imagens/icon_realizado.png"));
            constraints.gridx++;
            addBotao(realizadoJButton, color, "Marcar atendimento como realizado", constraints);
        } else if (atendimento.getStatus() == Atendimento.STATUS_REALIZADO) {
            agendaJPanel.add(atendimentoButton, constraints);
            Color color = new Color(123, 198, 133);
            addBotaoCancelar(color);
            reativarJButton = new JButton(new ImageIcon("imagens/icon_reativar.png"));
            constraints.gridx++;
            addBotao(reativarJButton, color, "Reativar atendimento", constraints);
        }
    }

    private void addBotaoCancelar(Color color) {
        cancelarJButton = new JButton(new ImageIcon("imagens/icon_cancelar.png"));
        constraints.gridx++;
        addBotao(cancelarJButton, color, "Cancelar atendimento", constraints);
    }

    private void addBotao(JButton button, Color color, String toolTip, GridBagConstraints constraints) {
        button.addActionListener(this);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setBackground(color);
        button.setToolTipText(toolTip);
        agendaJPanel.add(button, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean confirmado = InterfaceGraficaUtils.dialogoMensagem("Confirmar alteração", "Deseja realmente realizar esta alteração?");

        if (confirmado) {
            if (e.getSource().equals(cancelarJButton)) {
                new CancelarAtendimentoJDialog(atendimento, agendaJPanel).setVisible(true);
            } else {
                String msg = "Atualização efetuada com sucesso!";
                if (e.getSource().equals(realizadoJButton)) {
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
                    String mensagem = "Falha na comunicação com a base de dados. Por favor contate o administrador do sistema.";
                    log.error("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem, ex);
                }
            }
        }
    }

}
