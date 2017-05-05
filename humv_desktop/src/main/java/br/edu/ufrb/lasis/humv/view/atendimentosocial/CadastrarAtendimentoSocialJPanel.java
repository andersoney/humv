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

    private final static Logger logger = LoggerFactory.getLogger(CadastrarAtendimentoSocialJPanel.class);
    private Animal animalResultadoBusca = null;
    private Dono dono = null;
    private Date data;
    private AtendimentoSocial atendimentoSocial = null;

    private static final String D100 = "Desconto 100%";
    private static final String D75 = "Desconto 75%";
    private static final String D50 = "Desconto 50%";
    private static final String D25 = "Desconto 25%";
    private static final String VALOR_NORMAL = "Valor normal";

    public CadastrarAtendimentoSocialJPanel() {
        data = Calendar.getInstance().getTime();
        initComponents();
        customInitComponents(data);
    }

    public CadastrarAtendimentoSocialJPanel(AtendimentoSocial atendimentoSocialSelecionado) {
        this.atendimentoSocial = atendimentoSocialSelecionado;
        data = Calendar.getInstance().getTime();
        animalResultadoBusca = atendimentoSocialSelecionado.getAnimal();
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

            jLabelNomeDono.setText("Nome: " + atendimentoSocial.getAnimal().getDono().getNome());
            jLabelCpf.setText("CPF/CNPJ: " + atendimentoSocial.getAnimal().getDono().getCpfCnpj());
            jLabelTelefone.setText("Telefone: " + atendimentoSocial.getAnimal().getDono().getTelefone());
            jLabelEmail.setText("E-mail: " + atendimentoSocial.getAnimal().getDono().getEmail());

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
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(D100)) {
                jRadioButtonExamesD100.setSelected(true);
                jRadioButtonExamesD100ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(D75)) {
                jRadioButtonExamesD75.setSelected(true);
                jRadioButtonExamesD75ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(D50)) {
                jRadioButtonExamesD50.setSelected(true);
                jRadioButtonExamesD50ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaExames().equalsIgnoreCase(D25)) {
                jRadioButtonExamesD25.setSelected(true);
                jRadioButtonExamesD25ActionPerformed(null);
            }

            if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(VALOR_NORMAL)) {
                jRadioButtonConsultasValorNormal.setSelected(true);
                jRadioButtonConsultasValorNormalActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(D100)) {
                jRadioButtonConsultasD100.setSelected(true);
                jRadioButtonConsultasD100ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(D75)) {
                jRadioButtonConsultasD75.setSelected(true);
                jRadioButtonConsultasD75ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(D50)) {
                jRadioButtonConsultasD50.setSelected(true);
                jRadioButtonConsultasD50ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaConsultas().equalsIgnoreCase(D25)) {
                jRadioButtonConsultasD25.setSelected(true);
                jRadioButtonConsultasD25ActionPerformed(null);
            }

            if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(VALOR_NORMAL)) {
                jRadioButtonCirurgiaValorNormal.setSelected(true);
                jRadioButtonCirurgiaValorNormalActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(D100)) {
                jRadioButtonCirurgiaD100.setSelected(true);
                jRadioButtonCirurgiaD100ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(D75)) {
                jRadioButtonCirurgiaD75.setSelected(true);
                jRadioButtonCirurgiaD75ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(D50)) {
                jRadioButtonCirurgiaD50.setSelected(true);
                jRadioButtonCirurgiaD50ActionPerformed(null);
            } else if (atendimentoSocial.getTipoCobrancaCirurgias().equalsIgnoreCase(D25)) {
                jRadioButtonCirurgiaD25.setSelected(true);
                jRadioButtonCirurgiaD25ActionPerformed(null);
            }
        } else {
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaValorNormal);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaD100);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaD75);
            buttonGroupCobrancaCirurgias.add(jRadioButtonCirurgiaD50);

            buttonGroupCobrancaExames.add(jRadioButtonExamesValorNormal);
            buttonGroupCobrancaExames.add(jRadioButtonExamesD100);
            buttonGroupCobrancaExames.add(jRadioButtonExamesD75);
            buttonGroupCobrancaExames.add(jRadioButtonExamesD50);

            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasValorNormal);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasD100);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasD75);
            buttonGroupCobrancaConsultas.add(jRadioButtonConsultasD50);

            jRadioButtonCirurgiaValorNormal.setSelected(true);
            jRadioButtonConsultasValorNormal.setSelected(true);
            jRadioButtonExamesValorNormal.setSelected(true);
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
        jRadioButtonConsultasD100 = new javax.swing.JRadioButton();
        jRadioButtonConsultasD75 = new javax.swing.JRadioButton();
        jRadioButtonConsultasD50 = new javax.swing.JRadioButton();
        jRadioButtonConsultasD25 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonCirurgiaValorNormal = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD100 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD75 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD50 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD25 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonExamesValorNormal = new javax.swing.JRadioButton();
        jRadioButtonExamesD100 = new javax.swing.JRadioButton();
        jRadioButtonExamesD75 = new javax.swing.JRadioButton();
        jRadioButtonExamesD50 = new javax.swing.JRadioButton();
        jRadioButtonExamesD25 = new javax.swing.JRadioButton();
        jButtonOk = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        jRadioButtonConsultasD100.setText("D100%");
        jRadioButtonConsultasD100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasD100ActionPerformed(evt);
            }
        });

        jRadioButtonConsultasD75.setText("D75%");
        jRadioButtonConsultasD75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasD75ActionPerformed(evt);
            }
        });

        jRadioButtonConsultasD50.setText("D50%");
        jRadioButtonConsultasD50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasD50ActionPerformed(evt);
            }
        });

        jRadioButtonConsultasD25.setText("D25%");
        jRadioButtonConsultasD25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultasD25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonConsultasD50)
                    .addComponent(jRadioButtonConsultasValorNormal)
                    .addComponent(jRadioButtonConsultasD100)
                    .addComponent(jRadioButtonConsultasD75)
                    .addComponent(jRadioButtonConsultasD25))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonConsultasValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConsultasD100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConsultasD75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonConsultasD50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonConsultasD25)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cirurgias/Reprodução"));

        jRadioButtonCirurgiaValorNormal.setText("Valor normal");
        jRadioButtonCirurgiaValorNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaValorNormalActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaD100.setText("D100%");
        jRadioButtonCirurgiaD100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaD100ActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaD75.setText("D75%");
        jRadioButtonCirurgiaD75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaD75ActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaD50.setText("D50%");
        jRadioButtonCirurgiaD50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaD50ActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaD25.setText("D25%");
        jRadioButtonCirurgiaD25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaD25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCirurgiaValorNormal)
                    .addComponent(jRadioButtonCirurgiaD100)
                    .addComponent(jRadioButtonCirurgiaD75)
                    .addComponent(jRadioButtonCirurgiaD50)
                    .addComponent(jRadioButtonCirurgiaD25))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonCirurgiaValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaD100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaD75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaD50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonCirurgiaD25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Proc. Amb + exames"));

        jRadioButtonExamesValorNormal.setText("Valor normal");
        jRadioButtonExamesValorNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesValorNormalActionPerformed(evt);
            }
        });

        jRadioButtonExamesD100.setText("D100%");
        jRadioButtonExamesD100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesD100ActionPerformed(evt);
            }
        });

        jRadioButtonExamesD75.setText("D75%");
        jRadioButtonExamesD75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesD75ActionPerformed(evt);
            }
        });

        jRadioButtonExamesD50.setText("D50%");
        jRadioButtonExamesD50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesD50ActionPerformed(evt);
            }
        });

        jRadioButtonExamesD25.setText("D25%");
        jRadioButtonExamesD25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExamesD25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonExamesValorNormal)
                    .addComponent(jRadioButtonExamesD100)
                    .addComponent(jRadioButtonExamesD75)
                    .addComponent(jRadioButtonExamesD50)
                    .addComponent(jRadioButtonExamesD25))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonExamesValorNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesD100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesD75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesD50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonExamesD25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButtonOk.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonOk.setText("Salvar");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBuscarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jRadioButtonExamesD50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesD50ActionPerformed
        jRadioButtonExamesD25.setSelected(false);
        jRadioButtonExamesD75.setSelected(false);
        jRadioButtonExamesD100.setSelected(false);
        jRadioButtonExamesValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonExamesD50ActionPerformed

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
            atendimentoSocial.setAnimal(animalResultadoBusca);

            atendimentoSocial.setObservacoesAnimal(jTextAreaObservacoesGerais.getText());
            atendimentoSocial.setObservacoesDono(jTextAreaObservacoesDono.getText());
            atendimentoSocial.setSituacaoAnimal(jComboBoxSituacaoAnimal.getSelectedItem().toString());
            if (jRadioButtonConsultasValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(VALOR_NORMAL);
            } else if (jRadioButtonConsultasD75.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(D100);
            } else if (jRadioButtonConsultasD100.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(D50);
            } else if (jRadioButtonConsultasD50.isSelected()) {
                atendimentoSocial.setTipoCobrancaConsultas(D75);

            }
            if (jRadioButtonExamesValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(VALOR_NORMAL);
            } else if (jRadioButtonExamesD75.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(D100);
            } else if (jRadioButtonExamesD100.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(D50);
            } else if (jRadioButtonExamesD50.isSelected()) {
                atendimentoSocial.setTipoCobrancaExames(D75);
            }
            if (jRadioButtonCirurgiaValorNormal.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(VALOR_NORMAL);
            } else if (jRadioButtonCirurgiaD75.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(D100);
            } else if (jRadioButtonCirurgiaD100.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(D50);
            } else if (jRadioButtonCirurgiaD50.isSelected()) {
                atendimentoSocial.setTipoCobrancaCirurgias(D75);
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
                logger.error("mensagem: " + ex.getMessage(), ex);
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

    private void jRadioButtonCirurgiaD50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaD50ActionPerformed
        jRadioButtonCirurgiaValorNormal.setSelected(false);
        jRadioButtonCirurgiaD100.setSelected(false);
        jRadioButtonCirurgiaD75.setSelected(false);
        jRadioButtonCirurgiaD25.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaD50ActionPerformed

    private void jRadioButtonCirurgiaD75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaD75ActionPerformed
        jRadioButtonCirurgiaD50.setSelected(false);
        jRadioButtonCirurgiaD100.setSelected(false);
        jRadioButtonCirurgiaD25.setSelected(false);
        jRadioButtonCirurgiaValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaD75ActionPerformed

    private void jRadioButtonCirurgiaD100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaD100ActionPerformed
        jRadioButtonCirurgiaD50.setSelected(false);
        jRadioButtonCirurgiaD25.setSelected(false);
        jRadioButtonCirurgiaValorNormal.setSelected(false);
        jRadioButtonCirurgiaD75.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaD100ActionPerformed

    private void jRadioButtonCirurgiaValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaValorNormalActionPerformed
        jRadioButtonCirurgiaD50.setSelected(false);
        jRadioButtonCirurgiaD100.setSelected(false);
        jRadioButtonCirurgiaD75.setSelected(false);
        jRadioButtonCirurgiaD25.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaValorNormalActionPerformed

    private void jRadioButtonExamesD75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesD75ActionPerformed
        jRadioButtonExamesD50.setSelected(false);
        jRadioButtonExamesD25.setSelected(false);
        jRadioButtonExamesD100.setSelected(false);
        jRadioButtonExamesValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonExamesD75ActionPerformed

    private void jRadioButtonExamesD100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesD100ActionPerformed
        jRadioButtonExamesD50.setSelected(false);
        jRadioButtonExamesD25.setSelected(false);
        jRadioButtonExamesValorNormal.setSelected(false);
        jRadioButtonExamesD75.setSelected(false);
    }//GEN-LAST:event_jRadioButtonExamesD100ActionPerformed

    private void jRadioButtonExamesValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesValorNormalActionPerformed
        jRadioButtonExamesD50.setSelected(false);
        jRadioButtonExamesD100.setSelected(false);
        jRadioButtonExamesD75.setSelected(false);
        jRadioButtonExamesD25.setSelected(false);
    }//GEN-LAST:event_jRadioButtonExamesValorNormalActionPerformed

    private void jRadioButtonConsultasValorNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasValorNormalActionPerformed
        jRadioButtonConsultasD75.setSelected(false);
        jRadioButtonConsultasD100.setSelected(false);
        jRadioButtonConsultasD50.setSelected(false);
        jRadioButtonConsultasD25.setSelected(false);
    }//GEN-LAST:event_jRadioButtonConsultasValorNormalActionPerformed

    private void jRadioButtonConsultasD100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasD100ActionPerformed
        jRadioButtonConsultasD75.setSelected(false);
        jRadioButtonConsultasD50.setSelected(false);
        jRadioButtonConsultasD25.setSelected(false);
        jRadioButtonConsultasValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonConsultasD100ActionPerformed

    private void jRadioButtonConsultasD75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasD75ActionPerformed
        jRadioButtonConsultasD50.setSelected(false);
        jRadioButtonConsultasD100.setSelected(false);
        jRadioButtonConsultasD25.setSelected(false);
        jRadioButtonConsultasValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonConsultasD75ActionPerformed

    private void jRadioButtonConsultasD50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasD50ActionPerformed
        jRadioButtonConsultasD75.setSelected(false);
        jRadioButtonConsultasD100.setSelected(false);
        jRadioButtonConsultasD25.setSelected(false);
        jRadioButtonConsultasValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonConsultasD50ActionPerformed

    private void jRadioButtonCirurgiaD25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaD25ActionPerformed
        jRadioButtonCirurgiaD50.setSelected(false);
        jRadioButtonCirurgiaD100.setSelected(false);
        jRadioButtonCirurgiaD75.setSelected(false);
        jRadioButtonCirurgiaValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaD25ActionPerformed

    private void jRadioButtonExamesD25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExamesD25ActionPerformed
        jRadioButtonExamesD50.setSelected(false);
        jRadioButtonExamesD100.setSelected(false);
        jRadioButtonExamesD75.setSelected(false);
        jRadioButtonExamesValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonExamesD25ActionPerformed

    private void jRadioButtonConsultasD25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultasD25ActionPerformed
        jRadioButtonConsultasD75.setSelected(false);
        jRadioButtonConsultasD100.setSelected(false);
        jRadioButtonConsultasD50.setSelected(false);
        jRadioButtonConsultasValorNormal.setSelected(false);
    }//GEN-LAST:event_jRadioButtonConsultasD25ActionPerformed

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
    private javax.swing.JRadioButton jRadioButtonCirurgiaD100;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD25;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD50;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD75;
    private javax.swing.JRadioButton jRadioButtonCirurgiaValorNormal;
    private javax.swing.JRadioButton jRadioButtonConsultasD100;
    private javax.swing.JRadioButton jRadioButtonConsultasD25;
    private javax.swing.JRadioButton jRadioButtonConsultasD50;
    private javax.swing.JRadioButton jRadioButtonConsultasD75;
    private javax.swing.JRadioButton jRadioButtonConsultasValorNormal;
    private javax.swing.JRadioButton jRadioButtonExamesD100;
    private javax.swing.JRadioButton jRadioButtonExamesD25;
    private javax.swing.JRadioButton jRadioButtonExamesD50;
    private javax.swing.JRadioButton jRadioButtonExamesD75;
    private javax.swing.JRadioButton jRadioButtonExamesValorNormal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
            if (e.getSource().equals(jRadioButtonCirurgiaD50)) {
                atendimentoSocial.setTipoCobrancaCirurgias(D75);

            } else {
                if (e.getSource().equals(jRadioButtonCirurgiaD75)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(D100);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);

                } else if (e.getSource().equals(jRadioButtonCirurgiaD100)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setTipoCobrancaCirurgias(D50);
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                } else if (e.getSource().equals(jRadioButtonCirurgiaValorNormal)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(VALOR_NORMAL);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                }
            }
        } else if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaExames.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonExamesD50)) {
                atendimentoSocial.setTipoCobrancaExames(D75);
            } else {
                if (e.getSource().equals(jRadioButtonExamesD75)) {
                    atendimentoSocial.setTipoCobrancaExames(D100);
                    int desconto = 100;
                    atendimentoSocial.setPercentualDescontoExames(desconto);
                } else if (e.getSource().equals(jRadioButtonExamesD100)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                    atendimentoSocial.setTipoCobrancaExames(D50);
                } else if (e.getSource().equals(jRadioButtonExamesValorNormal)) {
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoExames(desconto);
                    atendimentoSocial.setTipoCobrancaExames(VALOR_NORMAL);
                }
            }
        } else if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaConsultas.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonConsultasD50)) {
                atendimentoSocial.setTipoCobrancaConsultas(D75);
            } else {
                if (e.getSource().equals(jRadioButtonConsultasD75)) {
                    atendimentoSocial.setTipoCobrancaConsultas(D100);
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                } else if (e.getSource().equals(jRadioButtonConsultasD100)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                    atendimentoSocial.setTipoCobrancaConsultas(D50);
                } else if (e.getSource().equals(jRadioButtonConsultasValorNormal)) {
                    atendimentoSocial.setTipoCobrancaConsultas(VALOR_NORMAL);
                    int desconto = 0;
                    atendimentoSocial.setPercentualDescontoConsultas(desconto);
                }
            }
        }

    }
}
