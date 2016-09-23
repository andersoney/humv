package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.utils.HUMVConfigUtils;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tassiovale
 */
public class AgendaJPanel extends JPanel {

    private List<Atendimento> atendimentos;
    private AtendimentoButton[] atendimentoButtons;
    private String[] horarios;
    private int qtdeHorarios;
    private int duracaoAtendimento, minutosInicioMatutino, minutosTerminoMatutino, minutosInicioVespertino, minutosTerminoVespertino;
    private Date data;
    private GridBagConstraints constraints;

    public AgendaJPanel(List<Atendimento> atendimentos, Date data) {
        super();
        this.atendimentos = atendimentos;
        this.data = data;
        calculateRows();
        initHorarios();
        initComponents();
    }

    private void calculateRows() {
        minutosInicioMatutino = Integer.parseInt(HUMVConfigUtils.getAtendimentoInicioMatutino()) * 60;
        minutosTerminoMatutino = Integer.parseInt(HUMVConfigUtils.getAtendimentoTerminoMatutino()) * 60;
        minutosInicioVespertino = Integer.parseInt(HUMVConfigUtils.getAtendimentoInicioVespertino()) * 60;
        minutosTerminoVespertino = Integer.parseInt(HUMVConfigUtils.getAtendimentoTerminoVespertino()) * 60;
        duracaoAtendimento = Integer.parseInt(HUMVConfigUtils.getAtendimentoDuracao());

        qtdeHorarios = (minutosTerminoMatutino - minutosInicioMatutino + minutosTerminoVespertino - minutosInicioVespertino) / duracaoAtendimento;
    }

    private void initHorarios() {
        horarios = new String[qtdeHorarios];
        int qtdeAtendimentosMatutino = (minutosTerminoMatutino - minutosInicioMatutino) / duracaoAtendimento;
        int minutosBase;

        for (int index = 0; index < qtdeHorarios; index++) {
            int indexModificado = index;
            if (index < qtdeAtendimentosMatutino) {
                minutosBase = minutosInicioMatutino;
            } else { //vespertino
                minutosBase = minutosInicioVespertino;
                indexModificado = index - qtdeAtendimentosMatutino;
            }

            int minutosResultantes = minutosBase + indexModificado * duracaoAtendimento;
            int hora = minutosResultantes / 60;
            long minuto = Math.round(
                    (((float) minutosResultantes / 60) - hora) * 60
            );

            String horario = new DecimalFormat("00").format(hora) + ":";
            if (minuto == 0) {
                horario += "00";
            } else {
                horario += minuto;
            }
            horarios[index] = horario;
        }
    }

    public void initComponents() {
        removeAll();
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.gridy = 0;

        for (int i = 0; i < qtdeHorarios; i++) {
            JLabel labelHorario = new JLabel(horarios[i]);
            labelHorario.setFont(new Font(null, Font.PLAIN, 14));
            
            constraints.gridx = 0;
            constraints.insets.right = 10;
            constraints.insets.left = 10;
            add(labelHorario, constraints);

            Atendimento atendimento = buscarAtendimento(horarios[i]);
            AtendimentoButton atendimentoButton = null;
            if (atendimento == null) {
                atendimentoButton = new AtendimentoButton(horarios[i], data, this);
            } else {
                atendimentoButton = new AtendimentoButton(atendimento, this);
            }
            constraints.gridx = 1;
            constraints.insets.left = 0;
            add(atendimentoButton, constraints);
            
            constraints.gridy++;
        }
    }

    public void addAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public void removeAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
    }

    private Atendimento buscarAtendimento(String horario) {
        for (Atendimento atendimento : atendimentos) {
            Date horarioMarcado = atendimento.getHorarioMarcado();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            if (sdf.format(horarioMarcado).equalsIgnoreCase(horario)) {
                return atendimento;
            }
        }
        return null;
    }

}
