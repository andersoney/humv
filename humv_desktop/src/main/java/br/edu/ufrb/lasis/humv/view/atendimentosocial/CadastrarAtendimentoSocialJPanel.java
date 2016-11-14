package br.edu.ufrb.lasis.humv.view.atendimentosocial;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;
import br.edu.ufrb.lasis.humv.entity.Dono;
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
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Toni
 */
public class CadastrarAtendimentoSocialJPanel extends javax.swing.JPanel implements ResultadoBusca, ActionListener {

    private Animal animalResultadoBusca = null;
    private Dono dono = null;
    private Date data;
    private AtendimentoSocial atendimentoSocial = null;
    private final static Logger logger = LoggerFactory.getLogger(CadastrarAtendimentoSocialJPanel.class);

    private static final String ISENCAO = "Isenção";
    private static final String DESCONTO = "Desconto";
    private static final String VALOR_AULA = "Valor aula";
    private static final String VALOR_NORMAL = "Valor normal";

    public CadastrarAtendimentoSocialJPanel() {
        data = Calendar.getInstance().getTime();
        initComponents();
        customInitComponents(data);
    }

    public CadastrarAtendimentoSocialJPanel(AtendimentoSocial atendimentoSocialSelecionado) {
        this.atendimentoSocial = atendimentoSocialSelecionado;
        data = Calendar.getInstance().getTime();
        initComponents();
        customInitComponents(data);
    }

    public void customInitComponents(Date data) {
        jLabelData.setText(ValidationsUtils.obterDataString(data));
        if (atendimentoSocial != null) {
            jLabelTitulo.setText("ATUALIZAR ATENDIMENTO SOCIAL");

            jLabelNomeAnimal.setText("Nome: " + atendimentoSocial.getAnimal().getNome());
            jLabelRghumv.setText("RGHUMV: " + atendimentoSocial.getAnimal().getRghumv());
            jLabelEspecie.setText("Espécie: " + atendimentoSocial.getAnimal().getEspecie());
            jLabelRaca.setText("Raça: " + atendimentoSocial.getAnimal().getRaca());

            jLabelNomeDono.setText("Nome: " + atendimentoSocial.getDono().getNome());
            jLabelCpf.setText("CPF/CNPJ: " + atendimentoSocial.getDono().getCpfCnpj());
            jLabelTelefone.setText("Telefone: " + atendimentoSocial.getDono().getTelefone());
            jLabelEmail.setText("E-mail: " + atendimentoSocial.getDono().getEmail());

            jTextAreaObservacoesDono.setText(atendimentoSocial.getObservacoesDono());

            if (atendimentoSocial.getSituacaoAnimal().equalsIgnoreCase("animal de rua")) {
                jComboBoxSituacaoAnimal.setSelectedItem(0);
            } else if (atendimentoSocial.getSituacaoAnimal().equalsIgnoreCase("caso de interesse para estudo")) {
                jComboBoxSituacaoAnimal.setSelectedItem(1);
            } else if (atendimentoSocial.getSituacaoAnimal().equalsIgnoreCase("remanejamento de atendimento em aula")) {
                jComboBoxSituacaoAnimal.setSelectedItem(2);
            } else if (atendimentoSocial.getSituacaoAnimal().equalsIgnoreCase("outros casos")) {
                jComboBoxSituacaoAnimal.setSelectedItem(3);
            }

            jTextAreaObservacoesGerais.setText(atendimentoSocial.getObservacoesAnimal());

            if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(VALOR_NORMAL)) {
                jRadioButtonExamesValorNormal.setSelected(true);
                jRadioButtonExamesValorNormalActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(VALOR_AULA)) {
                jRadioButtonExamesValorAula.setSelected(true);
                jRadioButtonExamesValorAulaActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(ISENCAO)) {
                jRadioButtonExamesIsencao.setSelected(true);
                jRadioButtonExamesIsencaoActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(DESCONTO)) {
                jRadioButtonExamesDesconto.setSelected(true);
                jSpinnerDescontoExames.setValue(atendimentoSocial.getPercentualDescontoExames());
                jRadioButtonExamesDescontoActionPerformed(null);
            }

            if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(VALOR_NORMAL)) {
                jRadioButtonConsultasValorNormal.setSelected(true);
                jRadioButtonConsultasValorNormalActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(VALOR_AULA)) {
                jRadioButtonConsultasValorAula.setSelected(true);
                jRadioButtonConsultasValorAulaActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(ISENCAO)) {
                jRadioButtonConsultasIsencao.setSelected(true);
                jRadioButtonConsultasIsencaoActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(DESCONTO)) {
                jRadioButtonConsultasDesconto.setSelected(true);
                jSpinnerDescontoConsultas.setValue(atendimentoSocial.getPercentualDescontoExames());
                jRadioButtonConsultasDescontoActionPerformed(null);
            }

            if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(VALOR_NORMAL)) {
                jRadioButtonCirurgiaValorNormal.setSelected(true);
                jRadioButtonCirurgiaValorNormalActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(VALOR_AULA)) {
                jRadioButtonCirurgiaValorAula.setSelected(true);
                jRadioButtonCirurgiaValorAulaActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(ISENCAO)) {
                jRadioButtonCirurgiaIsencao.setSelected(true);
                jRadioButtonCirurgiaIsencaoActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(DESCONTO)) {
                jRadioButtonCirurgiaDesconto.setSelected(true);
                jSpinnerDescontoCirurgias.setValue(atendimentoSocial.getPercentualDescontoExames());
                jRadioButtonCirurgiaDescontoActionPerformed(null);
            }
        } else {
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaValorNormal);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaValorAula);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaIsencao);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaDesconto);

            buttonGroupCobrancaExames.add(jRadioButtonExamesValorNormal);
            buttonGroupCobrancaExames.add(jRadioButtonExamesValorAula);
            buttonGroupCobrancaExames.add(jRadioButtonExamesIsencao);
            buttonGroupCobrancaExames.add(jRadioButtonExamesDesconto);

            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasValorNormal);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasValorAula);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasIsencao);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasDesconto);

            jRadioButtonCirurgiaValorNormal.setSelected(true);
            jRadioButtonConsultasValorNormal.setSelected(true);
            jRadioButtonExamesValorNormal.setSelected(true);

            jSpinnerDescontoExames.setEnabled(false);
            jSpinnerDescontoCirurgias.setEnabled(false);
            jSpinnerDescontoConsultas.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCobrancaConsultas = new javax.swing.ButtonGroup();
        buttonGroupCobrancaExames = new javax.swing.ButtonGroup();
        buttonGroupCobrancaCirurgias = new javax.swing.ButtonGroup();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonBuscarAnimal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelNomeAnimal = new javax.swing.JLabel();
        jLabelRghumv = new javax.swing.JLabel();
        jLabelRaca = new javax.swing.JLabel();
        jLabelEspecie = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacoesDono = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jComboBoxSituacaoAnimal = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservacoesGerais = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonConsultasValorNormal = new javax.swing.JRadioButton();
        jRadioButtonConsultasValorAula = new javax.swing.JRadioButton();
        jRadioButtonConsultasIsencao = new javax.swing.JRadioButton();
        jRadioButtonConsultasDesconto = new javax.swing.JRadioButton();
        jSpinnerDescontoConsultas = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonCirurgiaValorNormal = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaValorAula = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaIsencao = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaDesconto = new javax.swing.JRadioButton();
        jSpinnerDescontoCirurgias = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonExamesValorNormal = new javax.swing.JRadioButton();
        jRadioButtonExamesValorAula = new javax.swing.JRadioButton();
        jRadioButtonExamesIsencao = new javax.swing.JRadioButton();
        jRadioButtonExamesDesconto = new javax.swing.JRadioButton();
        jSpinnerDescontoExames = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setText("CADASTRAR ATENDIMENTO SOCIAL");

        jButtonBuscarAnimal.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonBuscarAnimal.setText("Buscar animal");
        jButtonBuscarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAnimalActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Animal"));

        jLabelNomeAnimal.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelNomeAnimal.setText("Nome:                                  ");

        jLabelRghumv.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelRghumv.setText("RGHUMV:");

        jLabelRaca.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelRaca.setText("Raça:                          ");

        jLabelEspecie.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelEspecie.setText("Espécie:                    ");

        jTextAreaObservacoesDono.setColumns(20);
        jTextAreaObservacoesDono.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacoesDono);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Observações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(jLabelRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRghumv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeAnimal)
                    .addComponent(jLabelRghumv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRaca)
                    .addComponent(jLabelEspecie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dono"));

        jLabelNomeDono.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelNomeDono.setText("Nome:                                         ");

        jLabelCpf.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelCpf.setText("CPF/CNPJ:                                      ");

        jLabelTelefone.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelTelefone.setText("Telefone:                                    ");

        jLabelEmail.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelEmail.setText("E-mail:                                                            ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeDono)
                    .addComponent(jLabelCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelTelefone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelData.setText("Data:                   ");

        jComboBoxSituacaoAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animal de rua", "Caso de interesse para estudo", "Remanejamento de atendimento em aula", "Outros casos" }));

        jTextAreaObservacoesGerais.setColumns(20);
        jTextAreaObservacoesGerais.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacoesGerais);

        jLabel14.setText("Observações gerais:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de cobrança"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        jRadioButtonConsultasValorNormal.setText("Valor normal");
        jRadioButtonConsultasValorNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasValorNormalActionPerformed(evt);
            }
        });

        jRadioButtonConsultasValorAula.setText("Valor aula");
        jRadioButtonConsultasValorAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasValorAulaActionPerformed(evt);
            }
        });

        jRadioButtonConsultasIsencao.setText("Isenção");
        jRadioButtonConsultasIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasIsencaoActionPerformed(evt);
            }
        });

        jRadioButtonConsultasDesconto.setText("Desconto");
        jRadioButtonConsultasDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasDescontoActionPerformed(evt);
            }
        });

        jSpinnerDescontoConsultas.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel4.setText("%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonConsultasValorNormal)
                    .addComponent(jRadioButtonConsultasValorAula)
                    .addComponent(jRadioButtonConsultasIsencao)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButtonConsultasDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerDescontoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonConsultasValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConsultasValorAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConsultasIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonConsultasDesconto)
                    .addComponent(jSpinnerDescontoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cirurgias/Reprodução"));

        jRadioButtonCirurgiaValorNormal.setText("Valor normal");
        jRadioButtonCirurgiaValorNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaValorNormalActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaValorAula.setText("Valor aula ");
        jRadioButtonCirurgiaValorAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaValorAulaActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaIsencao.setText("Isenção");
        jRadioButtonCirurgiaIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaIsencaoActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaDesconto.setText("Desconto");
        jRadioButtonCirurgiaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaDescontoActionPerformed(evt);
            }
        });

        jSpinnerDescontoCirurgias.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel2.setText("%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCirurgiaValorNormal)
                    .addComponent(jRadioButtonCirurgiaValorAula)
                    .addComponent(jRadioButtonCirurgiaIsencao)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButtonCirurgiaDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerDescontoCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonCirurgiaValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaValorAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCirurgiaDesconto)
                    .addComponent(jSpinnerDescontoCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Proc. Amb + exames"));

        jRadioButtonExamesValorNormal.setText("Valor normal");
        jRadioButtonExamesValorNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesValorNormalActionPerformed(evt);
            }
        });

        jRadioButtonExamesValorAula.setText("Valor aula");
        jRadioButtonExamesValorAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesValorAulaActionPerformed(evt);
            }
        });

        jRadioButtonExamesIsencao.setText("Isenção");
        jRadioButtonExamesIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesIsencaoActionPerformed(evt);
            }
        });

        jRadioButtonExamesDesconto.setText("Desconto");
        jRadioButtonExamesDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesDescontoActionPerformed(evt);
            }
        });

        jSpinnerDescontoExames.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel3.setText("%");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonExamesValorNormal)
                    .addComponent(jRadioButtonExamesValorAula)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jRadioButtonExamesDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerDescontoExames, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jRadioButtonExamesIsencao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonExamesValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesValorAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonExamesDesconto)
                    .addComponent(jSpinnerDescontoExames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel13.setText("Situação do animal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBuscarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxSituacaoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonOk)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addGap(206, 206, 206))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(24, 24, 24)
                .addComponent(jButtonBuscarAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxSituacaoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData))
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAnimalActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaAnimal propriedadesBusca = new PropriedadesBuscaAnimal(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE ANIMAL", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonBuscarAnimalActionPerformed

    private void jRadioButtonExamesDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesDescontoActionPerformed
        jSpinnerDescontoExames.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonExamesDescontoActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        boolean cadastrarNovo;
        if (animalResultadoBusca == null) {
            InterfaceGraficaUtils.erroResposta("Por favor, selecione um animal antes de registrar o atendimento.");
        } else {
            if (atendimentoSocial == null) {
                cadastrarNovo = true;
                atendimentoSocial = new AtendimentoSocial();
            } else {
                cadastrarNovo = false;
            }
            atendimentoSocial.setData(data);
            atendimentoSocial.setDono(dono);
            atendimentoSocial.setAnimal(animalResultadoBusca);

            atendimentoSocial.setObservacoesAnimal(jTextAreaObservacoesGerais.getText());
            atendimentoSocial.setObservacoesDono(jTextAreaObservacoesDono.getText());
            atendimentoSocial.setSituacaoAnimal(jComboBoxSituacaoAnimal.getSelectedItem().toString());
            if (jRadioButtonConsultasValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(VALOR_NORMAL);
            } else if (jRadioButtonConsultasIsencao.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(ISENCAO);
            } else if (jRadioButtonConsultasValorAula.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(VALOR_AULA);
            } else if (jRadioButtonConsultasDesconto.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(DESCONTO);
                Integer descontoConsulta = (Integer) jSpinnerDescontoConsultas.getValue();
                atendimentoSocial.setPercentualDescontoConsultas(descontoConsulta);
            }
            if (jRadioButtonExamesValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(VALOR_NORMAL);
            } else if (jRadioButtonExamesIsencao.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(ISENCAO);
            } else if (jRadioButtonExamesValorAula.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(VALOR_AULA);
            } else if (jRadioButtonExamesDesconto.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(DESCONTO);
                Integer descontoExames = (Integer) jSpinnerDescontoExames.getValue();
                atendimentoSocial.setPercentualDescontoExames(descontoExames);
            }
            if (jRadioButtonCirurgiaValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(VALOR_NORMAL);
            } else if (jRadioButtonCirurgiaIsencao.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(ISENCAO);
            } else if (jRadioButtonCirurgiaValorAula.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(VALOR_AULA);
            } else if (jRadioButtonCirurgiaDesconto.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(DESCONTO);
                Integer descontoCirugia = (Integer) jSpinnerDescontoCirurgias.getValue();
                atendimentoSocial.setPercentualDescontoCirurgias(descontoCirugia);
            }

            try {
                ClientResponse response;
                if (cadastrarNovo) {
                    response = RESTMethods.post("/api/atendimentoSocial", atendimentoSocial);
                } else {
                    response = RESTMethods.put("/api/atendimentoSocial", atendimentoSocial);
                }

                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                } else {
                    if (cadastrarNovo) {
                        InterfaceGraficaUtils.sucessoCadastro("atendimento social");
                    } else {
                        InterfaceGraficaUtils.sucessoAtualizacao("atendimento social");
                    }
                    HUMVApp.exibirMensagemCarregamento();
                    HUMVApp.setPainelCentralComLogo();
                    HUMVApp.esconderMensagemCarregamento();
                }
            } catch (RESTConnectionException ex) {
                InterfaceGraficaUtils.erroConexao();
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "atendimento social");
        if (sair) {
            this.setVisible(false);
            System.gc();
            HUMVApp.exibirMensagemCarregamento();
            HUMVApp.setPainelCentralComLogo();
            HUMVApp.esconderMensagemCarregamento();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonCirurgiaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaDescontoActionPerformed
        jSpinnerDescontoCirurgias.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonCirurgiaDescontoActionPerformed

    private void jRadioButtonCirurgiaIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaIsencaoActionPerformed
        jSpinnerDescontoCirurgias.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaIsencaoActionPerformed

    private void jRadioButtonCirurgiaValorAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaValorAulaActionPerformed
        jSpinnerDescontoCirurgias.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaValorAulaActionPerformed

    private void jRadioButtonCirurgiaValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaValorNormalActionPerformed
        jSpinnerDescontoCirurgias.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaValorNormalActionPerformed

    private void jRadioButtonExamesIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesIsencaoActionPerformed
        jSpinnerDescontoExames.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonExamesIsencaoActionPerformed

    private void jRadioButtonExamesValorAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesValorAulaActionPerformed
        jSpinnerDescontoExames.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonExamesValorAulaActionPerformed

    private void jRadioButtonExamesValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesValorNormalActionPerformed
        jSpinnerDescontoExames.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonExamesValorNormalActionPerformed

    private void jRadioButtonConsultasValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasValorNormalActionPerformed
        jSpinnerDescontoConsultas.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultasValorNormalActionPerformed

    private void jRadioButtonConsultasValorAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasValorAulaActionPerformed
        jSpinnerDescontoConsultas.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultasValorAulaActionPerformed

    private void jRadioButtonConsultasIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasIsencaoActionPerformed
        jSpinnerDescontoConsultas.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultasIsencaoActionPerformed

    private void jRadioButtonConsultasDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasDescontoActionPerformed
        jSpinnerDescontoConsultas.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonConsultasDescontoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCobrancaCirurgias;
    private javax.swing.ButtonGroup buttonGroupCobrancaConsultas;
    private javax.swing.ButtonGroup buttonGroupCobrancaExames;
    private javax.swing.JButton jButtonBuscarAnimal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBoxSituacaoAnimal;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEspecie;
    private javax.swing.JLabel jLabelNomeAnimal;
    private javax.swing.JLabel jLabelNomeDono;
    private javax.swing.JLabel jLabelRaca;
    private javax.swing.JLabel jLabelRghumv;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButtonCirurgiaDesconto;
    private javax.swing.JRadioButton jRadioButtonCirurgiaIsencao;
    private javax.swing.JRadioButton jRadioButtonCirurgiaValorAula;
    private javax.swing.JRadioButton jRadioButtonCirurgiaValorNormal;
    private javax.swing.JRadioButton jRadioButtonConsultasDesconto;
    private javax.swing.JRadioButton jRadioButtonConsultasIsencao;
    private javax.swing.JRadioButton jRadioButtonConsultasValorAula;
    private javax.swing.JRadioButton jRadioButtonConsultasValorNormal;
    private javax.swing.JRadioButton jRadioButtonExamesDesconto;
    private javax.swing.JRadioButton jRadioButtonExamesIsencao;
    private javax.swing.JRadioButton jRadioButtonExamesValorAula;
    private javax.swing.JRadioButton jRadioButtonExamesValorNormal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDescontoCirurgias;
    private javax.swing.JSpinner jSpinnerDescontoConsultas;
    private javax.swing.JSpinner jSpinnerDescontoExames;
    private javax.swing.JTextArea jTextAreaObservacoesDono;
    private javax.swing.JTextArea jTextAreaObservacoesGerais;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setResultado(Object resultado) {
        if (resultado instanceof Animal) {
            animalResultadoBusca = (Animal) resultado;
            jLabelNomeAnimal.setText("Nome: " + animalResultadoBusca.getNome());
            jLabelRghumv.setText("RGHUMV: " + animalResultadoBusca.getRghumv().toString());
            jLabelEspecie.setText("Espécie: " + animalResultadoBusca.getEspecie());
            jLabelRaca.setText("Raça: " + animalResultadoBusca.getRaca());

            dono = animalResultadoBusca.getDono();
            jLabelNomeDono.setText("Nome: " + dono.getNome());
            jLabelCpf.setText("CPF/CNPJ: " + MaskUtils.formatarCPF_CNPJ(dono.getCpfCnpj(), dono.getTipoDocumento()));
            jLabelTelefone.setText("Telefone: " + dono.getTelefone());
            jLabelEmail.setText("E-mail: " + dono.getEmail());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaCirurgias.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonCirurgiaDesconto)) {
                jSpinnerDescontoCirurgias.setEnabled(true);
                atendimentoSocial.setTipoCobrancaCirurgias(DESCONTO);
                int desconto = Integer.parseInt(jSpinnerDescontoCirurgias.getValue().toString());
                atendimentoSocial.setPercentualDescontoCirurgias(desconto);

            } else {
                jSpinnerDescontoCirurgias.setEnabled(false);
                if (e.getSource().equals(jRadioButtonCirurgiaIsencao)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(ISENCAO);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);

                } else if (e.getSource().equals(jRadioButtonCirurgiaValorAula)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setTipoCobrancaCirurgias(VALOR_AULA);
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                } else if (e.getSource().equals(jRadioButtonCirurgiaValorNormal)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(VALOR_NORMAL);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                }
            }
        } else if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaExames.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonExamesDesconto)) {
                jSpinnerDescontoExames.setEnabled(true);
                atendimentoSocial.setTipoCobrancaExames(DESCONTO);
                int desconto = Integer.parseInt(jSpinnerDescontoExames.getValue().toString());
                atendimentoSocial.setPercentualDescontoExames(desconto);
            } else {
                jSpinnerDescontoExames.setEnabled(false);
                if (e.getSource().equals(jRadioButtonExamesIsencao)) {
                    atendimentoSocial.setTipoCobrancaExames(ISENCAO);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoExames(desconto);
                } else if (e.getSource().equals(jRadioButtonExamesValorAula)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                    atendimentoSocial.setTipoCobrancaExames(VALOR_AULA);
                } else if (e.getSource().equals(jRadioButtonExamesValorNormal)) {
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoExames(desconto);
                    atendimentoSocial.setTipoCobrancaExames(VALOR_NORMAL);
                }
            }
        } else if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaConsultas.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonConsultasDesconto)) {
                jSpinnerDescontoConsultas.setEnabled(true);
                atendimentoSocial.setTipoCobrancaConsultas(DESCONTO);
                int desconto = Integer.parseInt(jSpinnerDescontoCirurgias.getValue().toString());
                atendimentoSocial.setPercentualDescontoConsultas(desconto);
            } else {
                jSpinnerDescontoConsultas.setEnabled(false);
                if (e.getSource().equals(jRadioButtonConsultasIsencao)) {
                    atendimentoSocial.setTipoCobrancaConsultas(ISENCAO);
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                } else if (e.getSource().equals(jRadioButtonConsultasValorAula)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                    atendimentoSocial.setTipoCobrancaConsultas(VALOR_AULA);
                } else if (e.getSource().equals(jRadioButtonConsultasValorNormal)) {
                    atendimentoSocial.setTipoCobrancaConsultas(VALOR_NORMAL);
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                }
            }
        }

    }
}
