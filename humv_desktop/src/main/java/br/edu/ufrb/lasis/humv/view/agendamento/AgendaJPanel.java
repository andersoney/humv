package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.HUMVConfigUtils;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author tassiovale
 */
public class AgendaJPanel extends JPanel {

    private List<Atendimento> atendimentos;
    private Usuario medico;
    private AtendimentoButton[] atendimentoButtons;
    private String[] horarios;
    private int qtdeHorarios;
    private int duracaoAtendimento, minutosInicioMatutino, minutosTerminoMatutino, minutosInicioVespertino, minutosTerminoVespertino;
    private Date data;
    private JPanel buscarAgendaMedicoJPanel;

    public AgendaJPanel(BuscarAgendaMedicoJPanel buscarAgendaMedicoJPanel, Usuario medico, Date data) {
        super();
        this.buscarAgendaMedicoJPanel = buscarAgendaMedicoJPanel;
        this.medico = medico;
        this.data = data;
        calculateRows();
        initHorarios();
        construirHorarios();
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

    public void construirHorarios() {
        carregarAtendimentos();

        removeAll();
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < qtdeHorarios; i++) {
            JLabel labelHorario = new JLabel(horarios[i]);
            labelHorario.setFont(new Font(null, Font.PLAIN, 14));

            constraints.gridx = 0;
            constraints.insets.right = 10;
            constraints.insets.left = 10;
            add(labelHorario, constraints);

            Atendimento atendimento = buscarAtendimento(horarios[i]);
            constraints.gridx = 1;
            constraints.insets.left = 0;
            if (atendimento == null || atendimento.getStatus() == Atendimento.STATUS_CANCELADO) {
                AtendimentoButton atendimentoButton = new AtendimentoButton(horarios[i], data, this);
                add(atendimentoButton, constraints);
            } else {
                AtendimentoJPanel atendimentoJPanel = new AtendimentoJPanel(atendimento, this);
                add(atendimentoJPanel, constraints);
            }

            constraints.gridy++;
        }

        revalidate();
        repaint();

    }

    private void carregarAtendimentos() {
        try {
            String dataStr = ValidationsUtils.obterDataString(data);
            String emailMedico = medico.getEmail();
            ClientResponse response = RESTMethods.get("/api/atendimento/searchByDateAndMedicoSemCancelados?data=" + dataStr + "&idEmailMedico=" + emailMedico);
            atendimentos = (List<Atendimento>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Atendimento>>() {
            });
        } catch (RESTConnectionException | IOException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
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
            String horaString = ValidationsUtils.obterHoraString(atendimento.getHorarioMarcado());
            if (horaString.equalsIgnoreCase(horario)) {
                return atendimento;
            }
        }
        return null;
    }

    public Usuario getMedico() {
        return medico;
    }

    public JPanel getBuscarAgendaMedicoJPanel() {
        return buscarAgendaMedicoJPanel;
    }

}
