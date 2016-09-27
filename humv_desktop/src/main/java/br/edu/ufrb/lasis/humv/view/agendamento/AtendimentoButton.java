package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Atendimento;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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

    public AtendimentoButton(String horario, Date data, AgendaJPanel agendaJPanel) {
        super();
        this.horario = horario;
        this.data = data;
        this.agendaJPanel = agendaJPanel;
        initComponent();
    }

    public AtendimentoButton(Atendimento atendimento, AgendaJPanel agendaJPanel) {
        super();
        this.atendimento = atendimento;
        this.agendaJPanel = agendaJPanel;
        initComponent();
    }

    private void initComponent() {
        addActionListener(this);
        setFont(new Font("Lucida Grande", 1, 13));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        if (atendimento == null) {
            setBackground(Color.WHITE);
            setIcon(new ImageIcon("imagens/icon_novo.png"));
            setText("Clique para adicionar - atendimento " + horario);
        } else {
            setText("<html>"
                    + atendimento.getAnimal().getNome().toUpperCase()
                    + "<br/>" + "Dono: " + atendimento.getAnimal().getDono().getNome() + "&nbsp;&nbsp;&nbsp;Telefone: " + atendimento.getAnimal().getDono().getTelefone()
                    + "<br/>" + "Procedimento: " + atendimento.getProcedimento().getCodigo().toString() + " - " + atendimento.getProcedimento().getNome()
                    + "</html>");
            if (atendimento.getStatus() == Atendimento.STATUS_AGENDADO) {
                setBackground(new Color(174, 226, 245));
            } else if (atendimento.getStatus() == Atendimento.STATUS_REALIZADO) {
                setBackground(new Color(123, 198, 133));
            }
        }
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
