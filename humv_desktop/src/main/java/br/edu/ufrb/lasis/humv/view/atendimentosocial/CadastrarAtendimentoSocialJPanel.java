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
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author Luiz Toni
 */
public class CadastrarAtendimentoSocialJPanel extends javax.swing.JPanel implements ResultadoBusca, ActionListener {
    private Animal animalResultadoBusca = null;
    private Dono dono = null;
    private Date data;
    private AtendimentoSocial atendimentoSocial = null;
    
    private static final String ISENCAO = "Isenção";
    private static final String DESCONTO = "Desconto";
    private static final String VALOR_AULA = "Valor aula";
    private static final String VALOR_NORMAL = "Valor normal";
    
    public CadastrarAtendimentoSocialJPanel() {
        initComponents();
        customInitComponents(data);
    }

    public void customInitComponents(Date data){
        jLabelData.setText(ValidationsUtils.obterDataString(data));
        
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
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCobrancaConsultas = new javax.swing.ButtonGroup();
        buttonGroupCobrancaExames = new javax.swing.ButtonGroup();
        buttonGroupCobrancaCirurgias = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscarAnimal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelNomeAnimal = new javax.swing.JLabel();
        jLabelRghumv = new javax.swing.JLabel();
        jLabelRaca = new javax.swing.JLabel();
        jLabelEspecie = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacoesDono = new javax.swing.JTextArea();
        jLabelData = new javax.swing.JLabel();
        jComboBoxSituacaoAnimal = new javax.swing.JComboBox<String>();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CADASTRAR ATENDIMENTO SOCIAL");

        jButtonBuscarAnimal.setText("Buscar animal");
        jButtonBuscarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAnimalActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Animal"));

        jLabelNomeAnimal.setText("Nome:                                  ");

        jLabelRghumv.setText("RGHUMV:");

        jLabelRaca.setText("Raça:                          ");

        jLabelEspecie.setText("Espécie:                    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeAnimal)
                    .addComponent(jLabelRaca))
                .addGap(155, 155, 155)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEspecie)
                    .addComponent(jLabelRghumv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeAnimal)
                    .addComponent(jLabelRghumv))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRaca)
                    .addComponent(jLabelEspecie))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dono"));

        jLabelNomeDono.setText("Nome:                                         ");

        jLabelCpf.setText("CPF/CNPJ:                                      ");

        jLabelTelefone.setText("Telefone:                                    ");

        jLabelEmail.setText("E-mail:                                                            ");

        jLabel12.setText("Observações:");

        jTextAreaObservacoesDono.setColumns(20);
        jTextAreaObservacoesDono.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacoesDono);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNomeDono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCpf)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEmail)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCpf)
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelTelefone))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelData.setText("Data:                   ");

        jComboBoxSituacaoAnimal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Animal de rua", "Caso de interesse para estudo", "Remanejamento de atendimento em aula", "Outros casos" }));

        jTextAreaObservacoesGerais.setColumns(20);
        jTextAreaObservacoesGerais.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservacoesGerais);

        jLabel14.setText("Observações gerais:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de cobrança"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        jRadioButtonConsultasValorNormal.setText("Valor normal");

        jRadioButtonConsultasValorAula.setText("Valor aula");

        jRadioButtonConsultasIsencao.setText("Isenção");

        jRadioButtonConsultasDesconto.setText("Desconto");

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

        jRadioButtonCirurgiaValorAula.setText("Valor aula ");

        jRadioButtonCirurgiaIsencao.setText("Isenção");

        jRadioButtonCirurgiaDesconto.setText("Desconto");

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

        jRadioButtonExamesValorAula.setText("Valor aula");

        jRadioButtonExamesIsencao.setText("Isenção");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
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
                                .addComponent(jLabel1)
                                .addGap(206, 206, 206))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBuscarAnimal)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxSituacaoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData))
                .addGap(18, 18, 18)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonExamesDescontoActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        boolean cadastrar = true;
        if (animalResultadoBusca == null) {
            InterfaceGraficaUtils.erroResposta("Por favor, selecione um animal antes de registrar o atendimento.");
        } 
        else {
            atendimentoSocial.setData(data);
            atendimentoSocial.setDono(dono);
            atendimentoSocial.setAnimal(animalResultadoBusca);
           
            atendimentoSocial.setObservacoesAnimal(jTextAreaObservacoesGerais.getText());
            atendimentoSocial.setObservacoesDono(jTextAreaObservacoesDono.getText());
            atendimentoSocial.setSituacaoAnimal(jComboBoxSituacaoAnimal.getSelectedItem().toString());
            
            try {
                ClientResponse response;
                if (cadastrar) {
                    response = RESTMethods.post("/api/atendimentoSocial", atendimentoSocial);
                } else {
                    //TODO
                    response = RESTMethods.put("/api/atendimentoSocial", atendimentoSocial);
                }

                String resposta = response.getEntity(String.class);
                if (!resposta.equalsIgnoreCase("ok")) {
                    InterfaceGraficaUtils.erroResposta(resposta);
                } else {
                    if (cadastrar) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCobrancaCirurgias;
    private javax.swing.ButtonGroup buttonGroupCobrancaConsultas;
    private javax.swing.ButtonGroup buttonGroupCobrancaExames;
    private javax.swing.JButton jButtonBuscarAnimal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox<String> jComboBoxSituacaoAnimal;
    private javax.swing.JLabel jLabel1;
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
            jLabelNomeAnimal.setText("Nome: "+animalResultadoBusca.getNome());
            jLabelRghumv.setText("RGHUMV: "+animalResultadoBusca.getRghumv().toString());
            jLabelEspecie.setText("Espécie: "+animalResultadoBusca.getEspecie());
            jLabelRaca.setText("Raça: "+animalResultadoBusca.getRaca());

            dono = animalResultadoBusca.getDono();
            jLabelNomeDono.setText("Nome: "+dono.getNome());
            jLabelCpf.setText("CPF/CNPJ: "+MaskUtils.formatarCPF_CNPJ(dono.getCpfCnpj(), dono.getTipoDocumento()));
            jLabelTelefone.setText("Telefone: "+dono.getTelefone());
            jLabelEmail.setText("E-mail: "+dono.getEmail());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton && buttonGroupCobrancaCirurgias.equals(e.getSource())) {
            if (e.getSource().equals(jRadioButtonCirurgiaDesconto)) {
                jSpinnerDescontoCirurgias.setEnabled(true);
                atendimentoSocial.setTipoCobrancaCirurgias(DESCONTO);
                int desconto =Integer.parseInt(jSpinnerDescontoCirurgias.getValue().toString());
                atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                    
            } else {
                jSpinnerDescontoCirurgias.setEnabled(false);
                if (e.getSource().equals(jRadioButtonCirurgiaIsencao)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(ISENCAO);
                    int desconto= 100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                    
                } else if (e.getSource().equals(jRadioButtonCirurgiaValorAula)) {
                    int desconto = Integer.parseInt(HUMVConfigUtils.getPorcentagemDescontoValorAula());
                    atendimentoSocial.setTipoCobrancaCirurgias(VALOR_AULA);
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                } else if (e.getSource().equals(jRadioButtonCirurgiaValorNormal)) {
                    atendimentoSocial.setTipoCobrancaCirurgias(VALOR_NORMAL);
                    int desconto =100;
                    atendimentoSocial.setPercentualDescontoCirurgias(desconto);
                }
            }
        }
        else if(e.getSource() instanceof JRadioButton && buttonGroupCobrancaExames.equals(e.getSource())){
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
                    int desconto =0;
                    atendimentoSocial.setPercentualDescontoExames(desconto);
                    atendimentoSocial.setTipoCobrancaExames(VALOR_NORMAL);
                }
            }
        }
        else if(e.getSource() instanceof JRadioButton && buttonGroupCobrancaConsultas.equals(e.getSource())){
            if (e.getSource().equals(jRadioButtonConsultasDesconto)) {
                jSpinnerDescontoConsultas.setEnabled(true);
                atendimentoSocial.setTipoCobrancaConsultas(DESCONTO);
                int desconto =Integer.parseInt(jSpinnerDescontoCirurgias.getValue().toString());
                atendimentoSocial.setPercentualDescontoConsultas(desconto);
            } else {
                jSpinnerDescontoConsultas.setEnabled(false);
                if (e.getSource().equals(jRadioButtonConsultasIsencao)) {
                    atendimentoSocial.setTipoCobrancaConsultas(ISENCAO);
                    int desconto =0;
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
