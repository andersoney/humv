package br.edu.ufrb.lasis.humv.view.agendamento;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.HUMVConfigUtils;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    private String valorAnterior = "0,00";

    public CadastrarAtendimentoJPanel(AgendaJPanel agendaJPanel, Date data, String horario) {
        this.agendaJPanel = agendaJPanel;
        this.data = data;
        this.horario = horario;
        initComponents();
        customInitComponents(data);
    }

    public CadastrarAtendimentoJPanel(AgendaJPanel agendaJPanel, Atendimento atendimento) {
        this.agendaJPanel = agendaJPanel;
        this.atendimento = atendimento;
        initComponents();
        customInitComponents(atendimento);
    }

    private void customInitComponents(Date data) {
        jLabelData.setText(ValidationsUtils.obterDataString(data));
        customInitComponents();
    }

    private void customInitComponents(Atendimento atendimento) {
        jLabelHorario.setText(ValidationsUtils.obterHoraString(atendimento.getHorarioMarcado()));
        jLabelData.setText(ValidationsUtils.obterDataString(atendimento.getHorarioMarcado()));
        customInitComponents();
    }

    private void customInitComponents() {
        buttonGroupCobranca.add(jRadioNormal);
        buttonGroupCobranca.add(jRadioAula);
        buttonGroupCobranca.add(jRadioIsencao);
        buttonGroupCobranca.add(jRadioDesconto);
        jRadioNormal.setSelected(true);
        jRadioNormal.addActionListener(this);
        jRadioAula.addActionListener(this);
        jRadioIsencao.addActionListener(this);
        jRadioDesconto.addActionListener(this);

        setEnabledComponentesDeValorProcedimento(false);

        if (horario == null) {
            jLabelHorario.setText("EXTRA");
        } else {
            jLabelHorario.setText(horario);
        }

        jCheckBoxRetorno.addActionListener(this);

        jSpinnerDesconto.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!jSpinnerDesconto.getValue().toString().isEmpty() && procedimentoResultadoBusca != null) {
                    int desconto = Integer.parseInt(jSpinnerDesconto.getValue().toString());
                    double multiplicador = 1 - desconto / 100.0;
                    jTextFieldValorCobrado.setText(
                            ValidationsUtils.convertePrecoParaString(
                                    procedimentoResultadoBusca.getValor() * multiplicador
                            )
                    );
                }
            }
        });

        if (atendimento != null) {
            animalResultadoBusca = atendimento.getAnimal();
            jLabelNomeAnimal.setText(animalResultadoBusca.getNome());
            jLabelRGHUMV.setText(animalResultadoBusca.getRghumv().toString());
            jLabelEspecie.setText(animalResultadoBusca.getEspecie());
            jLabelRaca.setText(animalResultadoBusca.getRaca());
            Dono dono = animalResultadoBusca.getDono();
            jLabelNomeDono.setText(dono.getNome());
            jLabelTipoDocDono.setText(dono.getTipoDocumento() + ":");
            jLabelIdDono.setText(MaskUtils.formatarCPF_CNPJ(dono.getCpfCnpj(), dono.getTipoDocumento()));
            jLabelTelefone.setText(dono.getTelefone());
            jLabelEmail.setText(dono.getEmail());

            procedimentoResultadoBusca = atendimento.getProcedimento();
            jLabelProcedimento.setText(
                    procedimentoResultadoBusca.getCodigo().toString() + " - " + procedimentoResultadoBusca.getNome()
            );

            int tipoCobranca = atendimento.getTipoCobranca();
            if (tipoCobranca == Atendimento.COBRANCA_VALOR_NORMAL) {
                jRadioNormal.setSelected(true);
            } else if (tipoCobranca == Atendimento.COBRANCA_VALOR_AULA) {
                jRadioAula.setSelected(true);
            } else if (tipoCobranca == Atendimento.COBRANCA_ISENTA) {
                jRadioIsencao.setSelected(true);
            } else {
                jRadioDesconto.setSelected(true);
                jSpinnerDesconto.setValue(atendimento.getPorcentagemDesconto());
            }

            setEnabledComponentesDeValorProcedimento(true);

            jTextFieldValorCobrado.setText(ValidationsUtils.convertePrecoParaString(atendimento.getValorCobrado()));

            if (atendimento.isRetorno()) {
                setEnabledComponentesDeValorProcedimento(false);
                jTextFieldValorCobrado.setText("0,00");
            }
            
            if (atendimento.isExtra()) {
                jLabelHorario.setText("EXTRA");
            }

            jTextAreaMotivo.setText(atendimento.getMotivo());
            jTextAreaObservacoes.setText(atendimento.getObservacoes());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton && procedimentoResultadoBusca != null) {
            if (e.getSource().equals(jRadioDesconto)) {
                jSpinnerDesconto.setEnabled(true);
            } else {
                jSpinnerDesconto.setEnabled(false);
                if (e.getSource().equals(jRadioIsencao)) {
                    jTextFieldValorCobrado.setText("0,00");
                } else if (e.getSource().equals(jRadioAula)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    jTextFieldValorCobrado.setText(
                            ValidationsUtils.convertePrecoParaString(
                                    procedimentoResultadoBusca.getValor() * (1 - desconto / 100.0)
                            )
                    );
                } else if (e.getSource().equals(jRadioNormal)) {
                    jTextFieldValorCobrado.setText(
                            ValidationsUtils.convertePrecoParaString(procedimentoResultadoBusca.getValor())
                    );
                }
            }
        } else if (e.getSource().equals(jCheckBoxRetorno)) {
            if (jCheckBoxRetorno.isSelected()) {
                setEnabledComponentesDeValorProcedimento(false);
                valorAnterior = jTextFieldValorCobrado.getText();
                jTextFieldValorCobrado.setText("0,00");
            } else {
                setEnabledComponentesDeValorProcedimento(true);
                jTextFieldValorCobrado.setText(valorAnterior);
            }
        }
    }

    private void setEnabledComponentesDeValorProcedimento(boolean habilitar) {
        jRadioAula.setEnabled(habilitar);
        jRadioDesconto.setEnabled(habilitar);
        jRadioIsencao.setEnabled(habilitar);
        jRadioNormal.setEnabled(habilitar);
        if (jRadioDesconto.isSelected() || !habilitar) {
            jSpinnerDesconto.setEnabled(habilitar);
        }
        jTextFieldValorCobrado.setEditable(habilitar);
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
            jLabelIdDono.setText(MaskUtils.formatarCPF_CNPJ(dono.getCpfCnpj(), dono.getTipoDocumento()));
            jLabelTipoDocDono.setText(dono.getTipoDocumento());
            jLabelTelefone.setText(dono.getTelefone());
            jLabelEmail.setText(dono.getEmail());
        } else if (resultado instanceof Procedimento) {
            procedimentoResultadoBusca = (Procedimento) resultado;
            jLabelProcedimento.setText(procedimentoResultadoBusca.getCodigo() + " - " + procedimentoResultadoBusca.getNome());
            jTextFieldValorCobrado.setText(
                    ValidationsUtils.convertePrecoParaString(procedimentoResultadoBusca.getValor())
            );
            setEnabledComponentesDeValorProcedimento(true);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabelHorario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonBuscarProcedimento = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioNormal = new javax.swing.JRadioButton();
        jRadioAula = new javax.swing.JRadioButton();
        jRadioIsencao = new javax.swing.JRadioButton();
        jRadioDesconto = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldValorCobrado = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonBuscarAnimal = new javax.swing.JButton();
        jLabelProcedimento = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivo = new javax.swing.JTextArea();
        jCheckBoxRetorno = new javax.swing.JCheckBox();
        jSpinnerDesconto = new javax.swing.JSpinner();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE ATENDIMENTO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Animal"));

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
                        .addComponent(jLabelEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
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

        jLabelHorario.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel12.setText("Procedimento:");

        jButtonBuscarProcedimento.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonBuscarProcedimento.setText("Buscar procedimento");
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

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar.setIcon(new javax.swing.ImageIcon("imagens/small_voltar.png"));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonBuscarAnimal.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonBuscarAnimal.setText("Buscar animal");
        jButtonBuscarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAnimalActionPerformed(evt);
            }
        });

        jLabelProcedimento.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelProcedimento.setText("Não informado");
        jLabelProcedimento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel16.setText("Motivo:");

        jTextAreaMotivo.setColumns(20);
        jTextAreaMotivo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMotivo);

        jCheckBoxRetorno.setText("Retorno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(234, 234, 234)
                            .addComponent(jCheckBoxRetorno))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(10, 10, 10)
                            .addComponent(jRadioNormal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioAula)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioIsencao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioDesconto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinnerDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14)))
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBuscarProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonBuscarAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 17, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscarProcedimento)
                    .addComponent(jLabel12)
                    .addComponent(jLabelProcedimento))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioNormal)
                    .addComponent(jRadioAula)
                    .addComponent(jRadioIsencao)
                    .addComponent(jRadioDesconto)
                    .addComponent(jLabel14)
                    .addComponent(jSpinnerDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxRetorno))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonSalvar))
                .addContainerGap(29, Short.MAX_VALUE))
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

        if (animalResultadoBusca == null) {
            InterfaceGraficaUtils.erroResposta("Por favor, selecione um animal antes de registrar o atendimento.");
        } else if (procedimentoResultadoBusca == null) {
            InterfaceGraficaUtils.erroResposta("Por favor, selecione um procedimento antes de registrar o atendimento.");
        } else if (jTextFieldValorCobrado.getText().isEmpty()) {
            InterfaceGraficaUtils.erroResposta("Por favor, informe o valor do procedimento.");
        } else {
            atendimento.setMedico(agendaJPanel.getMedico());
            atendimento.setStatus(Atendimento.STATUS_AGENDADO);
            atendimento.setAnimal(animalResultadoBusca);
            atendimento.setProcedimento(procedimentoResultadoBusca);

            try {
                if (horario != null) {
                    String dataString = ValidationsUtils.obterDataString(data);
                    Date horarioMarcado = ValidationsUtils.obterHoraData(dataString + " " + horario);
                    atendimento.setHorarioMarcado(horarioMarcado);
                } else if (data != null) {
                    String dataString = ValidationsUtils.obterDataString(data);
                    Date horarioMarcado = ValidationsUtils.obterHoraData(dataString + " 00:00");
                    atendimento.setHorarioMarcado(horarioMarcado);
                }
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
                int desconto = Integer.parseInt(jSpinnerDesconto.getValue().toString());
                atendimento.setPorcentagemDesconto(desconto);
            }
            atendimento.setTipoCobranca(tipoCobranca);

            double valorCobrado = ValidationsUtils.converteStringParaPreco(jTextFieldValorCobrado.getText());
            atendimento.setValorCobrado(valorCobrado);

            atendimento.setRetorno(jCheckBoxRetorno.isSelected());

            if (jLabelHorario.getText().equalsIgnoreCase("EXTRA")) {
                atendimento.setExtra(true);
            } else {
                atendimento.setExtra(false);
            }

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
                        InterfaceGraficaUtils.sucessoCadastro("atendimento");
                    } else {
                        InterfaceGraficaUtils.sucessoAtualizacao("atendimento");
                    }
                    agendaJPanel.construirHorarios();
                    HUMVApp.setNovoPainelCentral(agendaJPanel.getBuscarAgendaMedicoJPanel());
                }
            } catch (RESTConnectionException ex) {
                InterfaceGraficaUtils.erroConexao();
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        HUMVApp.setNovoPainelCentral(agendaJPanel.getBuscarAgendaMedicoJPanel());
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupCobranca;
    private javax.swing.ButtonGroup buttonGroupExtra;
    private javax.swing.JButton jButtonBuscarAnimal;
    private javax.swing.JButton jButtonBuscarProcedimento;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JCheckBox jCheckBoxRetorno;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEspecie;
    private javax.swing.JLabel jLabelHorario;
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
    private javax.swing.JRadioButton jRadioDesconto;
    private javax.swing.JRadioButton jRadioIsencao;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDesconto;
    private javax.swing.JTextArea jTextAreaMotivo;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldValorCobrado;
    // End of variables declaration//GEN-END:variables

}
