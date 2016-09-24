package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.view.animal.PropriedadesBuscaAnimal;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.procedimento.PropriedadesBuscaProcedimento;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author tassiovale
 */
public class CadastrarAtendimentoJPanel extends javax.swing.JPanel implements ResultadoBusca, ActionListener {

    private Atendimento atendimento = null;
    private String horario = null;
    private Date data = null;
    private AgendaJPanel agendaJPanel;
    private Animal animalResultadoBusca = null;
    private Procedimento procedimentoResultadoBusca = null;

    public CadastrarAtendimentoJPanel(AgendaJPanel agendaJPanel, String horario, Date data) {
        this.agendaJPanel = agendaJPanel;
        this.horario = horario;
        this.data = data;
        initComponents();
        customInitComponents(horario, data);
    }

    public CadastrarAtendimentoJPanel(AgendaJPanel agendaJPanel, Atendimento atendimento) {
        this.agendaJPanel = agendaJPanel;
        this.atendimento = atendimento;
        initComponents();
        customInitComponents(atendimento);
    }

    public CadastrarAtendimentoJPanel(AgendaJPanel agendaJPanel, Date data) {
        this.agendaJPanel = agendaJPanel;
        this.data = data;
        initComponents();
        customInitComponents(data);
    }

    private void customInitComponents(String horario, Date data) {
        customInitComponents();
        jLabelHorário.setText(horario);
        jLabelData.setText(ValidationsUtils.obterDataString(data));
        jButtonRemover.setEnabled(false);
    }

    private void customInitComponents(Atendimento atendimento) {
        customInitComponents();
        jLabelHorário.setText(ValidationsUtils.obterHoraString(atendimento.getHorarioMarcado()));
        jLabelData.setText(ValidationsUtils.obterDataString(atendimento.getHorarioMarcado()));
    }

    private void customInitComponents(Date data) {
        customInitComponents("Não informado", data);
        jLabelHorário.setText(horario);
        jLabelData.setText(ValidationsUtils.obterDataString(data));
    }

    private void customInitComponents() {
        buttonGroupCobranca.add(jRadioNormal);
        buttonGroupCobranca.add(jRadioAula);
        buttonGroupCobranca.add(jRadioIsencao);
        buttonGroupCobranca.add(jRadioDesconto);
        jRadioNormal.setSelected(true);
        jTextFieldDesconto.setEnabled(false);
        jRadioNormal.addActionListener(this);
        jRadioAula.addActionListener(this);
        jRadioIsencao.addActionListener(this);
        jRadioDesconto.addActionListener(this);

        buttonGroupExtra.add(jRadioButtonSim);
        buttonGroupExtra.add(jRadioButtonNao);
        jRadioButtonNao.setSelected(true);
        jRadioButtonSim.addActionListener(this);
        jRadioButtonNao.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jRadioButtonSim) || e.getSource().equals(jRadioButtonNao)) {
            if (jRadioButtonSim.isSelected()) {
                jLabelHorário.setText("Não informado");
            } else if (horario != null) {
                jLabelHorário.setText(horario);
            } else {
                jLabelHorário.setText(ValidationsUtils.obterHoraString(atendimento.getHorarioMarcado()));
            }
        } else if (e.getSource() instanceof JRadioButton) {
            if (jRadioDesconto.isSelected()) {
                jTextFieldDesconto.setEnabled(true);
            } else {
                jTextFieldDesconto.setEnabled(false);
            }
        }
    }

    @Override
    public void setResultado(Object resultado) {
        if (resultado instanceof Animal) {
            animalResultadoBusca = (Animal) resultado;
            jLabelNomeAnimal.setText(animalResultadoBusca.getNome());
            jLabelRGHUMV.setText(animalResultadoBusca.getRghumv().toString());
            jLabelEspecie.setText(animalResultadoBusca.getEspecie());
            jLabelRaca.setText(animalResultadoBusca.getRaca());

            Dono dono = animalResultadoBusca.getDono();
            jLabelNomeDono.setText(dono.getNome());
            jLabelIdDono.setText(dono.getId().toString());
            jLabelTipoDocDono.setText(dono.getTipoId());
            jLabelTelefone.setText(dono.getTelefone());
            jLabelEmail.setText(dono.getEmail());
        } else if (resultado instanceof Procedimento) {
            procedimentoResultadoBusca = (Procedimento) resultado;
            jLabelProcedimento.setText(procedimentoResultadoBusca.getCodigo() + " - " + procedimentoResultadoBusca.getNome());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCobranca = new javax.swing.ButtonGroup();
        buttonGroupExtra = new javax.swing.ButtonGroup();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNomeAnimal = new javax.swing.JLabel();
        jLabelEspecie = new javax.swing.JLabel();
        jLabelRGHUMV = new javax.swing.JLabel();
        jLabelRaca = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTipoDocDono = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelIdDono = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelHorário = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonBuscarProcedimento = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioNormal = new javax.swing.JRadioButton();
        jRadioAula = new javax.swing.JRadioButton();
        jRadioIsencao = new javax.swing.JRadioButton();
        jRadioDesconto = new javax.swing.JRadioButton();
        jTextFieldDesconto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldValorCobrado = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonBuscarAnimal = new javax.swing.JButton();
        jLabelProcedimento = new javax.swing.JLabel();
        jButtonRemover = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonSim = new javax.swing.JRadioButton();
        jRadioButtonNao = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivo = new javax.swing.JTextArea();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE ATENDIMENTO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nome:");

        jLabel4.setText("Espécie:");

        jLabel3.setText("RGHUMV:");

        jLabel5.setText("Raça:");

        jLabelNomeAnimal.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelEspecie.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelRGHUMV.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelRaca.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNomeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRGHUMV, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabelRGHUMV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dono"));

        jLabel2.setText("Nome:");

        jLabelTipoDocDono.setText("CPF/CNPJ:");

        jLabel7.setText("Telefone:");

        jLabel8.setText("E-mail:");

        jLabelNomeDono.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelIdDono.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelTelefone.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelEmail.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNomeDono, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelTipoDocDono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIdDono, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabelTipoDocDono)
                        .addComponent(jLabelIdDono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel9.setText("Observações:");

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacoes);

        jLabel10.setText("Data:");

        jLabelData.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel11.setText("Horário:");

        jLabelHorário.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel12.setText("Procedimento:");

        jButtonBuscarProcedimento.setText("Pesquisar procedimento");
        jButtonBuscarProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarProcedimentoActionPerformed(evt);
            }
        });

        jLabel13.setText("Cobrança:");

        jRadioNormal.setText("Valor normal");

        jRadioAula.setText("Valor aula");

        jRadioIsencao.setText("Isenção");

        jRadioDesconto.setText("Desconto");

        jLabel14.setText("%");

        jLabel15.setText("Valor cobrado (R$):");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("<< Voltar");

        jButtonBuscarAnimal.setText("Pesquisar animal");
        jButtonBuscarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAnimalActionPerformed(evt);
            }
        });

        jLabelProcedimento.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelProcedimento.setText("Não informado");

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabel6.setText("Atendimento extra:");

        jRadioButtonSim.setText("Sim");

        jRadioButtonNao.setText("Não");
        jRadioButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNaoActionPerformed(evt);
            }
        });

        jLabel16.setText("Motivo:");

        jTextAreaMotivo.setColumns(20);
        jTextAreaMotivo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMotivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonBuscarAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonBuscarProcedimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelHorário, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jButtonVoltar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel6)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jRadioButtonSim)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jRadioButtonNao))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel9)
                                                                .addComponent(jLabel16))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane2)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel13)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                            .addComponent(jRadioNormal)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioAula)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioIsencao)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioDesconto)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel14)))
                                                    .addGap(9, 9, 9))))
                                        .addGap(0, 23, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscarAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarProcedimento)
                    .addComponent(jLabel12)
                    .addComponent(jLabelProcedimento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabelHorário, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioNormal)
                    .addComponent(jRadioAula)
                    .addComponent(jRadioIsencao)
                    .addComponent(jRadioDesconto)
                    .addComponent(jTextFieldDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButtonSim)
                    .addComponent(jRadioButtonNao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSalvar)
                        .addComponent(jButtonRemover)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");
        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProcedimentoActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaProcedimento propriedadesBusca = new PropriedadesBuscaProcedimento(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE PROCEDIMENTO", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonBuscarProcedimentoActionPerformed

    private void jButtonBuscarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAnimalActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaAnimal propriedadesBusca = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE ANIMAL", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonBuscarAnimalActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        boolean cadastrar = false;

        if (atendimento == null) {
            atendimento = new Atendimento();
            cadastrar = true;
        }

        atendimento.setAnimal(animalResultadoBusca);
        atendimento.setProcedimento(procedimentoResultadoBusca);

        try {
            Date horarioMarcado = null;
            if (horario != null) {
                String dataString = ValidationsUtils.obterDataString(data);
                horarioMarcado = ValidationsUtils.obterHoraData(dataString + " " + horario);
            } else if (data != null) {
                String dataString = ValidationsUtils.obterDataString(data);
                horarioMarcado = ValidationsUtils.obterHoraData(dataString + " 00:00");
            }
            atendimento.setHorarioMarcado(horarioMarcado);
        } catch (ParseException ex) {
            InterfaceGraficaUtils.valorInvalido("horário marcado");
        }

        int tipoCobranca = Atendimento.COBRANCA_VALOR_NORMAL;
        if (jRadioAula.isSelected()) {
            tipoCobranca = Atendimento.COBRANCA_VALOR_AULA;
        } else if (jRadioIsencao.isSelected()) {
            tipoCobranca = Atendimento.COBRANCA_ISENTA;
        } else if (jRadioDesconto.isSelected()) {
            tipoCobranca = Atendimento.COBRANCA_DESCONTO;
            int desconto = Integer.parseInt(jTextFieldDesconto.getText());
            atendimento.setPorcentagemDesconto(desconto);
        }
        atendimento.setTipoCobranca(tipoCobranca);

        double valorCobrado = ValidationsUtils.converteStringParaPreco(jTextFieldValorCobrado.getText());
        atendimento.setValorCobrado(valorCobrado);

        atendimento.setMotivo(jTextAreaMotivo.getText());
        atendimento.setObservacoes(jTextAreaObservacoes.getText());

        try {
            ClientResponse response;
            if (cadastrar) {
                response = RESTMethods.post("/api/atendimento", atendimento);
            } else {
                response = RESTMethods.put("/api/atendimento", atendimento);
            }
            
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.erroResposta(resposta);
            } else {
                if (cadastrar) {
                    InterfaceGraficaUtils.sucessoCadastro("agendamento");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("agendamento");
                }
                HUMVApp.setPainelCentralComLogo();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jRadioButtonNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCobranca;
    private javax.swing.ButtonGroup buttonGroupExtra;
    private javax.swing.JButton jButtonBuscarAnimal;
    private javax.swing.JButton jButtonBuscarProcedimento;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEspecie;
    private javax.swing.JLabel jLabelHorário;
    private javax.swing.JLabel jLabelIdDono;
    private javax.swing.JLabel jLabelNomeAnimal;
    private javax.swing.JLabel jLabelNomeDono;
    private javax.swing.JLabel jLabelProcedimento;
    private javax.swing.JLabel jLabelRGHUMV;
    private javax.swing.JLabel jLabelRaca;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTipoDocDono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioAula;
    private javax.swing.JRadioButton jRadioButtonNao;
    private javax.swing.JRadioButton jRadioButtonSim;
    private javax.swing.JRadioButton jRadioDesconto;
    private javax.swing.JRadioButton jRadioIsencao;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaMotivo;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldDesconto;
    private javax.swing.JTextField jTextFieldValorCobrado;
    // End of variables declaration//GEN-END:variables

}
