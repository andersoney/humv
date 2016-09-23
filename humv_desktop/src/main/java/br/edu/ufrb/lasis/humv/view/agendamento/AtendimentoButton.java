package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Atendimento;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author tassiovale
 */
public class AtendimentoButton extends JButton implements ActionListener {

    private Atendimento atendimento = null;
    private String horario = null;
    private Date data = null;
    private AgendaJPanel agendaJPanel;

    public AtendimentoButton(Atendimento atendimento, AgendaJPanel agendaJPanel) {
        super();
        this.atendimento = atendimento;
        this.agendaJPanel = agendaJPanel;
        initComponent();
    }

    public AtendimentoButton(String horario, Date data, AgendaJPanel agendaJPanel) {
        super();
        this.horario = horario;
        this.data = data;
        this.agendaJPanel = agendaJPanel;
        initComponent();
    }

    private void initComponent() {
        addActionListener(this);
        
        if (atendimento == null) {
            setBackground(Color.WHITE);
        } else if (atendimento.getStatus() == Atendimento.STATUS_AGENDADO) {
            setBackground(new Color(117, 189, 238));
        } else if (atendimento.getStatus() == Atendimento.STATUS_REALIZADO) {
            setBackground(new Color(123, 198, 133));
        }
        setPreferredSize(new Dimension(535, 50));
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (atendimento == null) {
            HUMVApp.setNovoPainelCentral(new CadastrarAtendimentoJPanel(agendaJPanel, horario, data));
        } else {
            HUMVApp.setNovoPainelCentral(new CadastrarAtendimentoJPanel(agendaJPanel, atendimento));
        }
    }

}
