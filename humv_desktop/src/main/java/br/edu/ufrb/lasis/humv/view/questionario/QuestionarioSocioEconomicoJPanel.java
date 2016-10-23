package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.entity.Documentacao;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe que cria o Painel Questionario SOcial.
 *
 * @author tassiovale
 * @author Orion && Chacal
 */
public class QuestionarioSocioEconomicoJPanel extends javax.swing.JPanel {
    
    AbstractTableModelDocumentacao modelDocumentacao;
    AbstractTableModelParente modelParente;
    Dono dono;
    QuestionarioSocioeconomico quest;

    /**
     * Aqui é configurado o dono repassado pela classe CadastroDonoJPane e de
     * QuestionarioBuscarDono.
     *
     * @param dono
     */
    public void setDono(Dono dono) {
        this.dono = dono;
        configDono(dono);
    }
    
    private void configDono(Dono dono1) {
        this.jLabelNomeDono.setText("Nome : " + dono1.getNome());
        jLabelCpfDono.setText("CPF : " + dono1.getCpfCnpj());
        jLabelTelefone.setText("Telefone: " + dono1.getTelefone());
        jLabelEndereco.setText("Endereço: " + dono1.getEndereco());
    }

    /**
     * Creates new form QuestionarioSocioEconomicoJPanel
     */
    public QuestionarioSocioEconomicoJPanel() {
        initComponents();
        initComponentsCustom();
        HUMVApp.esconderMensagemCarregamento();
    }
    
    private void initComponentsCustom() {
        //this.jTextFieldDocumentoOutro.setEnabled(false);
        this.dteDataEntrega.setDate(Calendar.getInstance().getTime());
        this.jRadioButtonEnergiaSim.setSelected(true);
        this.jRadioButtonSaneamentoSim.setSelected(true);
        this.jRadioButtonEstudanteSim.setSelected(true);
        this.jRadioButtonDocumentosOutro.setSelected(true);
        this.jRadioButtonConsultaNormal.setSelected(true);
        this.jRadioButtonExameNormal.setSelected(true);
        this.jRadioButtonCirurgiaNormal.setSelected(true);
        this.modelDocumentacao = new AbstractTableModelDocumentacao();
        this.jTableDocumentos.setModel(this.modelDocumentacao);
        this.modelParente = new AbstractTableModelParente();
        this.jTableFamiliares.setModel(modelParente);
        this.jFormattedTextFieldCirurgia.setEnabled(false);
        this.jFormattedTextFieldConsulta.setEnabled(false);
        this.jFormattedTextFieldExame.setEnabled(false);
        quest = new QuestionarioSocioeconomico();
    }
    
    public QuestionarioSocioEconomicoJPanel(QuestionarioSocioeconomico questT) {
        this.quest = questT;
        reintroduzirDadosQuestionarioDadosDono();
        
        reintroduzirDocumentacoes();
        
        reintroduzirCobranca();
        
        reintroduzirAnalise();
        
        reintroduzirComposicaoFamiliar();
    }

    private void reintroduzirComposicaoFamiliar() {
        reintroduzirParentes();
        this.jLabelRendaTotal.setText("" + modelParente.getRendaTotal());
        this.jLabelRendaPerCapta.setText("" + modelParente.getRendaPerCapita());
        this.jTextFieldFatoresDeclarados.setText(quest.getRiscosSociais());
        this.jTextAreaBemMaterial.setText(quest.getBensFamiliares());
        this.jTextAreaDividas.setText(quest.getEmprestimos());
        this.jTextAreaMotivos.setText(quest.getImpossibilidadesCusteio());
    }
    
    private void reintroduzirCobranca() {
        switch (quest.getTipoCobrancaCirurgias()) {
            case QuestionarioSocioeconomico.COBRANCA_NORMAL:
                this.jRadioButtonCirurgiaNormal.setSelected(true);
                this.jRadioButtonCirurgiaAula.setSelected(false);
                this.jRadioButtonCirurgiaIsencao.setSelected(false);
                this.jRadioButtonCirurgiaDesconto.setSelected(false);
                this.jFormattedTextFieldCirurgia.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_AULA:
                this.jRadioButtonCirurgiaNormal.setSelected(false);
                this.jRadioButtonCirurgiaAula.setSelected(true);
                this.jRadioButtonCirurgiaIsencao.setSelected(false);
                this.jRadioButtonCirurgiaDesconto.setSelected(false);
                this.jFormattedTextFieldCirurgia.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_INSENCAO:
                this.jRadioButtonCirurgiaNormal.setSelected(false);
                this.jRadioButtonCirurgiaAula.setSelected(false);
                this.jRadioButtonCirurgiaIsencao.setSelected(true);
                this.jRadioButtonCirurgiaDesconto.setSelected(false);
                this.jFormattedTextFieldCirurgia.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_DESCONTO:
                this.jRadioButtonCirurgiaNormal.setSelected(true);
                this.jRadioButtonCirurgiaAula.setSelected(false);
                this.jRadioButtonCirurgiaIsencao.setSelected(false);
                this.jRadioButtonCirurgiaDesconto.setSelected(false);
                this.jFormattedTextFieldCirurgia.setEnabled(true);
                this.jFormattedTextFieldCirurgia.setText("" + quest.getValorDescontoCirurgias());
                break;
            default:
                erroMensage("Erro ao reinserir a forma de cobrança", "Erro em Cobrança");
        }
        
        switch (quest.getTipoCobrancaConsultas()) {
            case QuestionarioSocioeconomico.COBRANCA_NORMAL:
                this.jRadioButtonConsultaNormal.setSelected(true);
                this.jRadioButtonConsultaAula.setSelected(false);
                this.jRadioButtonConsultaIsencao.setSelected(false);
                this.jRadioButtonConsultaDesconto.setSelected(false);
                this.jFormattedTextFieldConsulta.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_AULA:
                this.jRadioButtonConsultaNormal.setSelected(false);
                this.jRadioButtonConsultaAula.setSelected(true);
                this.jRadioButtonConsultaIsencao.setSelected(false);
                this.jRadioButtonConsultaDesconto.setSelected(false);
                this.jFormattedTextFieldConsulta.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_INSENCAO:
                this.jRadioButtonConsultaNormal.setSelected(false);
                this.jRadioButtonConsultaAula.setSelected(false);
                this.jRadioButtonConsultaIsencao.setSelected(true);
                this.jRadioButtonConsultaDesconto.setSelected(false);
                this.jFormattedTextFieldConsulta.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_DESCONTO:
                this.jRadioButtonConsultaNormal.setSelected(false);
                this.jRadioButtonConsultaAula.setSelected(false);
                this.jRadioButtonConsultaIsencao.setSelected(false);
                this.jRadioButtonConsultaDesconto.setSelected(true);
                this.jFormattedTextFieldConsulta.setEnabled(false);
                this.jFormattedTextFieldConsulta.setText("" + quest.getValorDescontoConsultas());
                break;
            default:
                erroMensage("Erro ao reinserir a forma de cobrança", "Erro em Cobrança");
        }
        switch (quest.getTipoCobrancaConsultas()) {
            case QuestionarioSocioeconomico.COBRANCA_NORMAL:
                this.jRadioButtonExameNormal.setSelected(true);
                this.jRadioButtonExameAula.setSelected(false);
                this.jRadioButtonExameIsencao.setSelected(false);
                this.jRadioButtonExameDesconto.setSelected(false);
                this.jFormattedTextFieldExame.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_AULA:
                this.jRadioButtonExameNormal.setSelected(false);
                this.jRadioButtonExameAula.setSelected(true);
                this.jRadioButtonExameIsencao.setSelected(false);
                this.jRadioButtonExameDesconto.setSelected(false);
                this.jFormattedTextFieldExame.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_INSENCAO:
                this.jRadioButtonExameNormal.setSelected(false);
                this.jRadioButtonExameAula.setSelected(false);
                this.jRadioButtonExameIsencao.setSelected(true);
                this.jRadioButtonExameDesconto.setSelected(false);
                this.jFormattedTextFieldExame.setEnabled(false);
                break;
            case QuestionarioSocioeconomico.COBRANCA_DESCONTO:
                this.jRadioButtonExameNormal.setSelected(false);
                this.jRadioButtonExameAula.setSelected(false);
                this.jRadioButtonExameIsencao.setSelected(false);
                this.jRadioButtonExameDesconto.setSelected(true);
                this.jFormattedTextFieldExame.setEnabled(true);
                this.jFormattedTextFieldConsulta.setText("" + quest.getValorDescontoConsultas());
                break;
            default:
                erroMensage("Erro ao reinserir a forma de cobrança", "Erro em Cobrança");
        }
    }
    
    private void reintroduzirAnalise() {
        this.jTextAreaVulnerabilidades.setText(quest.getAnaliseBreveResumo());
        this.jTextAreaEncaminhamentos.setText(quest.getAnaliseObservacoes());
        this.jTextAreaConclusoes.setText(quest.getAnaliseConclusoes());
    }
    
    private void reintroduzirParentes() {
        this.modelParente.setParentes(quest.getParentes());
    }
    
    private void reintroduzirDocumentacoes() {
        this.modelDocumentacao.setDocumentos(quest.getDocumentosEntregues());
    }
    
    private void reintroduzirDadosQuestionarioDadosDono() {
        this.configDono(quest.getDono());
        this.jFormattedTextFieldIdade.setText("" + quest.getIdade());
        this.jComboBoxEstadoCivil.setSelectedIndex(quest.getEstadoCivil());
        this.jTextFieldProfissao.setText(quest.getProfissao());
        this.jComboBoxEscolaridadeDono.setSelectedIndex(quest.getEscolaridade());
        this.jTextFieldOcupacao.setText(quest.getOcupacaoAtual());
        this.jFormattedTextFieldRendaFormal.setText("" + quest.getRendaFormal());
        this.jFormattedTextFieldRendaInformal.setText("" + quest.getRendaInformal());
        this.jFormattedTextFieldAluguel.setText("" + quest.getValorAluguel());
        this.jTextFieldTipoConstrucao.setText(quest.getTipoConstrucao());
        this.jTextFieldCondicaoMoradia.setText(quest.getCondicaoMoradia());
        this.jTextFieldProgramaRenda.setText(quest.getProgramaTransferenciaRenda());
        if (quest.isEstudante()) {
            this.jRadioButtonEstudanteSim.setSelected(true);
            this.jRadioButtonEstudanteNao.setSelected(true);
        } else {
            this.jRadioButtonEstudanteSim.setSelected(false);
            this.jRadioButtonEstudanteNao.setSelected(true);
        }
        if (quest.isTemEnergia()) {
            this.jRadioButtonEnergiaSim.setSelected(true);
            this.jRadioButtonEnergiaNao.setSelected(false);
        } else {
            this.jRadioButtonEnergiaSim.setSelected(false);
            this.jRadioButtonEnergiaNao.setSelected(true);
        }
        if (quest.isTemSaneamento()) {
            this.jRadioButtonSaneamentoSim.setSelected(true);
            this.jRadioButtonSaneamentoNao.setSelected(false);
        } else {
            this.jRadioButtonSaneamentoSim.setSelected(false);
            this.jRadioButtonSaneamentoNao.setSelected(true);
        }
        this.jFormattedTextFieldGastosMensais.setText("" + quest.getGastosMensais());
        this.jTextFieldFonteCusteio.setText(quest.getFontCusteio());
        this.jTextFieldBeneficio.setText(quest.getBolsaOuBeneficio());
        this.jTextAreaObservacoes.setText(quest.getObservacoesDadosDono());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSaneamento = new javax.swing.ButtonGroup();
        buttonGroupEnergia = new javax.swing.ButtonGroup();
        buttonGroupEstudante = new javax.swing.ButtonGroup();
        buttonGroupDocumento = new javax.swing.ButtonGroup();
        buttonGroupConsulta = new javax.swing.ButtonGroup();
        buttonGroupExame = new javax.swing.ButtonGroup();
        buttonGroupCirurgia = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDadosDono = new javax.swing.JPanel();
        jPanelDadosBasicos = new javax.swing.JPanel();
        jButtonPesquisarDono = new javax.swing.JButton();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelCpfDono = new javax.swing.JLabel();
        jButtonCadastrarNovoDono = new javax.swing.JButton();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jPanelAdicionais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldIdade = new javax.swing.JFormattedTextField();
        jComboBoxEstadoCivil = new javax.swing.JComboBox<String>();
        jComboBoxEscolaridadeDono = new javax.swing.JComboBox<String>();
        jTextFieldProfissao = new javax.swing.JTextField();
        jTextFieldOcupacao = new javax.swing.JTextField();
        jPanelMateriais = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButtonSaneamentoSim = new javax.swing.JRadioButton();
        jRadioButtonSaneamentoNao = new javax.swing.JRadioButton();
        jRadioButtonEnergiaSim = new javax.swing.JRadioButton();
        jRadioButtonEnergiaNao = new javax.swing.JRadioButton();
        jFormattedTextFieldRendaFormal = new javax.swing.JFormattedTextField();
        jFormattedTextFieldRendaInformal = new javax.swing.JFormattedTextField();
        jTextFieldTipoConstrucao = new javax.swing.JTextField();
        jTextFieldProgramaRenda = new javax.swing.JTextField();
        jFormattedTextFieldAluguel = new javax.swing.JFormattedTextField();
        jTextFieldCondicaoMoradia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jRadioButtonEstudanteSim = new javax.swing.JRadioButton();
        jRadioButtonEstudanteNao = new javax.swing.JRadioButton();
        jPanelEstudante = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jFormattedTextFieldGastosMensais = new javax.swing.JFormattedTextField();
        jTextFieldFonteCusteio = new javax.swing.JTextField();
        jTextFieldBeneficio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jPanelDocumentos = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldDocumentoOutro = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        dteDataEntrega = new com.toedter.calendar.JDateChooser();
        jButtonDocumentoSalvar = new javax.swing.JButton();
        jButtonDocumentoRemover = new javax.swing.JButton();
        jRadioButtonDocumentosComprovanteEndereco = new javax.swing.JRadioButton();
        jRadioButtonDocumentosRGDono = new javax.swing.JRadioButton();
        jRadioButtonDocumentosMembroFamilia = new javax.swing.JRadioButton();
        jRadioButtonDocumentosBolsaFamilia = new javax.swing.JRadioButton();
        jRadioButtonDocumentosOutro = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDocumentos = new javax.swing.JTable();
        jCheckBoxNA = new javax.swing.JCheckBox();
        jCheckBoxVistoASocial = new javax.swing.JCheckBox();
        jPanelAnalise = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaVulnerabilidades = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaEncaminhamentos = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaConclusoes = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Cobranca = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jRadioButtonConsultaNormal = new javax.swing.JRadioButton();
        jRadioButtonConsultaAula = new javax.swing.JRadioButton();
        jRadioButtonConsultaIsencao = new javax.swing.JRadioButton();
        jRadioButtonConsultaDesconto = new javax.swing.JRadioButton();
        jFormattedTextFieldConsulta = new javax.swing.JFormattedTextField();
        jLabel42 = new javax.swing.JLabel();
        jRadioButtonExameNormal = new javax.swing.JRadioButton();
        jRadioButtonExameAula = new javax.swing.JRadioButton();
        jRadioButtonExameIsencao = new javax.swing.JRadioButton();
        jRadioButtonExameDesconto = new javax.swing.JRadioButton();
        jFormattedTextFieldExame = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        jRadioButtonCirurgiaNormal = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaAula = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaIsencao = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaDesconto = new javax.swing.JRadioButton();
        jFormattedTextFieldCirurgia = new javax.swing.JFormattedTextField();
        jLabel44 = new javax.swing.JLabel();
        jPanelComposicaoFamiliar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFamiliares = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEscolaridadeFamliar = new javax.swing.JComboBox<String>();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jFormattedIdadeFamilia = new javax.swing.JFormattedTextField();
        jTextFieldFamiliaNome = new javax.swing.JTextField();
        jTextFieldParentesco = new javax.swing.JTextField();
        jTextFieldFamiliaOcupacao = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jLabelRendaTotal = new javax.swing.JLabel();
        jLabelRendaPerCapta = new javax.swing.JLabel();
        jLabelFamiliaRendaTotal = new javax.swing.JLabel();
        jLabelFamiliaRendaPerCapita = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldFatoresDeclarados = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaBemMaterial = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDividas = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaMotivos = new javax.swing.JTextArea();
        jTextFieldFamiliaRenda = new javax.swing.JTextField();
        jButtonQuestionarioCancelar = new javax.swing.JButton();
        jButtonQuestionarioSalvar = new javax.swing.JButton();

        jPanelDadosBasicos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados básicos"));

        jButtonPesquisarDono.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonPesquisarDono.setText("Buscar");
        jButtonPesquisarDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarDonoActionPerformed(evt);
            }
        });

        jLabelNomeDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeDono.setText("Nome:");

        jLabelCpfDono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCpfDono.setText("CPF:");

        jButtonCadastrarNovoDono.setIcon(new javax.swing.ImageIcon("imagens/small_cadastrar.png"));
        jButtonCadastrarNovoDono.setText("Novo");
        jButtonCadastrarNovoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarNovoDonoActionPerformed(evt);
            }
        });

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEndereco.setText("Endereço:");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefone.setText("Telefone:");

        javax.swing.GroupLayout jPanelDadosBasicosLayout = new javax.swing.GroupLayout(jPanelDadosBasicos);
        jPanelDadosBasicos.setLayout(jPanelDadosBasicosLayout);
        jPanelDadosBasicosLayout.setHorizontalGroup(
            jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosBasicosLayout.createSequentialGroup()
                .addComponent(jButtonPesquisarDono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrarNovoDono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelDadosBasicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDadosBasicosLayout.createSequentialGroup()
                        .addComponent(jLabelCpfDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDadosBasicosLayout.setVerticalGroup(
            jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosBasicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisarDono)
                    .addComponent(jButtonCadastrarNovoDono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNomeDono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpfDono)
                    .addComponent(jLabelTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEndereco)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelAdicionais.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações adicionais"));

        jLabel1.setText("Idade:");

        jLabel3.setText("Estado civil:");

        jLabel2.setText("Escolaridade:");

        jLabel5.setText("Ocupação:");

        jLabel4.setText("Profissão:");

        jFormattedTextFieldIdade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro", "Casado", "Separado", "Divorciado", "Viúvo" }));

        jComboBoxEscolaridadeDono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fundamental incompleto", "Fundamental completo", "Médio incompleto", "Médio completo", "Superior incompleto", "Superior completo", "Pós-graduação incompleta", "Pós-graduação completa" }));

        javax.swing.GroupLayout jPanelAdicionaisLayout = new javax.swing.GroupLayout(jPanelAdicionais);
        jPanelAdicionais.setLayout(jPanelAdicionaisLayout);
        jPanelAdicionaisLayout.setHorizontalGroup(
            jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdicionaisLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdicionaisLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEscolaridadeDono, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldProfissao)
                    .addComponent(jTextFieldOcupacao, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAdicionaisLayout.setVerticalGroup(
            jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBoxEscolaridadeDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelMateriais.setBorder(javax.swing.BorderFactory.createTitledBorder("Condições materiais"));

        jLabel6.setText("Renda formal (R$):");

        jLabel7.setText("Renda informal (R$):");

        jLabel9.setText("Aluguel/financ. (R$):");

        jLabel8.setText("Condição de moradia:");

        jLabel10.setText("Tipo de construção:");

        jLabel13.setText("Programa transf. renda:");

        jLabel11.setText("Saneamento básico:");

        jLabel12.setText("Energia elétrica:");

        jRadioButtonSaneamentoSim.setText("Sim");
        jRadioButtonSaneamentoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSaneamentoSimActionPerformed(evt);
            }
        });

        jRadioButtonSaneamentoNao.setText("Não");
        jRadioButtonSaneamentoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSaneamentoNaoActionPerformed(evt);
            }
        });

        jRadioButtonEnergiaSim.setText("Sim");
        jRadioButtonEnergiaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEnergiaSimActionPerformed(evt);
            }
        });

        jRadioButtonEnergiaNao.setText("Não");
        jRadioButtonEnergiaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEnergiaNaoActionPerformed(evt);
            }
        });

        jFormattedTextFieldRendaFormal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jFormattedTextFieldRendaInformal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jFormattedTextFieldAluguel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        javax.swing.GroupLayout jPanelMateriaisLayout = new javax.swing.GroupLayout(jPanelMateriais);
        jPanelMateriais.setLayout(jPanelMateriaisLayout);
        jPanelMateriaisLayout.setHorizontalGroup(
            jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonSaneamentoSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonSaneamentoNao))
                    .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldRendaFormal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldRendaInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(9, 9, 9)
                                .addComponent(jFormattedTextFieldAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel12))
                    .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel13)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                        .addComponent(jRadioButtonEnergiaSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonEnergiaNao))
                    .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldCondicaoMoradia)
                        .addComponent(jTextFieldProgramaRenda, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addComponent(jTextFieldTipoConstrucao)))
                .addContainerGap())
        );
        jPanelMateriaisLayout.setVerticalGroup(
            jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMateriaisLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldRendaFormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldTipoConstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldCondicaoMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jFormattedTextFieldRendaInformal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldProgramaRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextFieldAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMateriaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButtonSaneamentoSim)
                    .addComponent(jRadioButtonSaneamentoNao)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButtonEnergiaSim)
                    .addComponent(jRadioButtonEnergiaNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Estudante:");

        jRadioButtonEstudanteSim.setText("Sim");
        jRadioButtonEstudanteSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEstudanteSimActionPerformed(evt);
            }
        });

        jRadioButtonEstudanteNao.setText("Não");
        jRadioButtonEstudanteNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEstudanteNaoActionPerformed(evt);
            }
        });

        jPanelEstudante.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel19.setText("Valor dos gastos mensais (R$):");

        jLabel20.setText("Fonte de custeio:");

        jLabel21.setText("Bolsa ou benefício:");

        jLabel22.setText("Observações:");

        jFormattedTextFieldGastosMensais.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacoes);

        javax.swing.GroupLayout jPanelEstudanteLayout = new javax.swing.GroupLayout(jPanelEstudante);
        jPanelEstudante.setLayout(jPanelEstudanteLayout);
        jPanelEstudanteLayout.setHorizontalGroup(
            jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstudanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstudanteLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstudanteLayout.createSequentialGroup()
                        .addGroup(jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEstudanteLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBeneficio))
                            .addGroup(jPanelEstudanteLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldGastosMensais, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFonteCusteio, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                        .addGap(8, 8, 8))))
        );
        jPanelEstudanteLayout.setVerticalGroup(
            jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstudanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldGastosMensais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldFonteCusteio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEstudanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDadosDonoLayout = new javax.swing.GroupLayout(jPanelDadosDono);
        jPanelDadosDono.setLayout(jPanelDadosDonoLayout);
        jPanelDadosDonoLayout.setHorizontalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAdicionais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosBasicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMateriais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonEstudanteSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonEstudanteNao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelEstudante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelDadosDonoLayout.setVerticalGroup(
            jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosDonoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosBasicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosDonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jRadioButtonEstudanteSim)
                    .addComponent(jRadioButtonEstudanteNao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do dono", jPanelDadosDono);

        jLabel31.setText("Documento:");

        jLabel32.setText("Data de entrega: ");

        jButtonDocumentoSalvar.setText("Salvar");
        jButtonDocumentoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentoSalvarActionPerformed(evt);
            }
        });

        jButtonDocumentoRemover.setText("Remover");
        jButtonDocumentoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentoRemoverActionPerformed(evt);
            }
        });

        jRadioButtonDocumentosComprovanteEndereco.setText("Comprovante de endereço");
        jRadioButtonDocumentosComprovanteEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDocumentosComprovanteEnderecoActionPerformed(evt);
            }
        });

        jRadioButtonDocumentosRGDono.setText("Cópia do documento de identidade do dono");
        jRadioButtonDocumentosRGDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDocumentosRGDonoActionPerformed(evt);
            }
        });

        jRadioButtonDocumentosMembroFamilia.setText("Cópia do documento de identidade de membro da família");
        jRadioButtonDocumentosMembroFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDocumentosMembroFamiliaActionPerformed(evt);
            }
        });

        jRadioButtonDocumentosBolsaFamilia.setText("Cópia do cartão Bolsa Família");
        jRadioButtonDocumentosBolsaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDocumentosBolsaFamiliaActionPerformed(evt);
            }
        });

        jRadioButtonDocumentosOutro.setText("Outro");
        jRadioButtonDocumentosOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDocumentosOutroActionPerformed(evt);
            }
        });

        jTableDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTableDocumentos);

        jCheckBoxNA.setText("NA");
        jCheckBoxNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNAActionPerformed(evt);
            }
        });

        jCheckBoxVistoASocial.setText("Visto Assistente Social");

        javax.swing.GroupLayout jPanelDocumentosLayout = new javax.swing.GroupLayout(jPanelDocumentos);
        jPanelDocumentos.setLayout(jPanelDocumentosLayout);
        jPanelDocumentosLayout.setHorizontalGroup(
            jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDocumentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDocumentoRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDocumentoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonDocumentosRGDono)
                                .addComponent(jRadioButtonDocumentosComprovanteEndereco)
                                .addComponent(jRadioButtonDocumentosMembroFamilia)
                                .addComponent(jRadioButtonDocumentosBolsaFamilia)
                                .addComponent(jRadioButtonDocumentosOutro))
                            .addComponent(jTextFieldDocumentoOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dteDataEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxNA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxVistoASocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanelDocumentosLayout.setVerticalGroup(
            jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonDocumentosComprovanteEndereco))
                            .addComponent(dteDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDocumentosRGDono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDocumentosMembroFamilia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDocumentosLayout.createSequentialGroup()
                        .addComponent(jCheckBoxNA)
                        .addGap(15, 15, 15)))
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDocumentosBolsaFamilia)
                    .addComponent(jCheckBoxVistoASocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDocumentosOutro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDocumentoOutro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDocumentoRemover)
                    .addComponent(jButtonDocumentoSalvar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Documentos", jPanelDocumentos);

        jLabel33.setText("Breve resumo da história de vida e identificação das vulnerabilidades da família:");

        jTextAreaVulnerabilidades.setColumns(20);
        jTextAreaVulnerabilidades.setRows(5);
        jScrollPane7.setViewportView(jTextAreaVulnerabilidades);

        jLabel34.setText("Orientações e encaminhamentos:");

        jTextAreaEncaminhamentos.setColumns(20);
        jTextAreaEncaminhamentos.setRows(5);
        jScrollPane8.setViewportView(jTextAreaEncaminhamentos);

        jLabel35.setText("Conclusões e outras observações:");

        jTextAreaConclusoes.setColumns(20);
        jTextAreaConclusoes.setRows(5);
        jScrollPane9.setViewportView(jTextAreaConclusoes);

        jLabel36.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel36.setText("Considerar: condições socioeconômicas, histórico de perdas ou interrupção de relações, histórico de violações de direitos,");

        jLabel37.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel37.setText("acesso ao sistema degarantias de direitos, outras situações.");

        javax.swing.GroupLayout jPanelAnaliseLayout = new javax.swing.GroupLayout(jPanelAnalise);
        jPanelAnalise.setLayout(jPanelAnaliseLayout);
        jPanelAnaliseLayout.setHorizontalGroup(
            jPanelAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane9)
                    .addGroup(jPanelAnaliseLayout.createSequentialGroup()
                        .addGroup(jPanelAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAnaliseLayout.setVerticalGroup(
            jPanelAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Análise", jPanelAnalise);

        jLabel38.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Tipo de cobrança");

        jLabel39.setText("Consultas:");

        jLabel40.setText("Procedimentos ambulatórios/exames:");

        jLabel41.setText("Cirurgia/reprodução:");

        jRadioButtonConsultaNormal.setText("Valor normal");
        jRadioButtonConsultaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultaNormalActionPerformed(evt);
            }
        });

        jRadioButtonConsultaAula.setText("Valor aula");
        jRadioButtonConsultaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultaAulaActionPerformed(evt);
            }
        });

        jRadioButtonConsultaIsencao.setText("Isenção");
        jRadioButtonConsultaIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultaIsencaoActionPerformed(evt);
            }
        });

        jRadioButtonConsultaDesconto.setText("Desconto");
        jRadioButtonConsultaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConsultaDescontoActionPerformed(evt);
            }
        });

        jFormattedTextFieldConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel42.setText("%");

        jRadioButtonExameNormal.setText("Valor normal");
        jRadioButtonExameNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExameNormalActionPerformed(evt);
            }
        });

        jRadioButtonExameAula.setText("Valor aula");
        jRadioButtonExameAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExameAulaActionPerformed(evt);
            }
        });

        jRadioButtonExameIsencao.setText("Isenção");
        jRadioButtonExameIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExameIsencaoActionPerformed(evt);
            }
        });

        jRadioButtonExameDesconto.setText("Desconto");
        jRadioButtonExameDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExameDescontoActionPerformed(evt);
            }
        });

        jFormattedTextFieldExame.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel43.setText("%");

        jRadioButtonCirurgiaNormal.setText("Valor normal");
        jRadioButtonCirurgiaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaNormalActionPerformed(evt);
            }
        });

        jRadioButtonCirurgiaAula.setText("Valor aula");
        jRadioButtonCirurgiaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCirurgiaAulaActionPerformed(evt);
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

        jFormattedTextFieldCirurgia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel44.setText("%");

        javax.swing.GroupLayout CobrancaLayout = new javax.swing.GroupLayout(Cobranca);
        Cobranca.setLayout(CobrancaLayout);
        CobrancaLayout.setHorizontalGroup(
            CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CobrancaLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addGroup(CobrancaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonConsultaNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaAula)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaIsencao)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42))
                    .addGroup(CobrancaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonExameNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameAula)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameIsencao)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldExame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43))
                    .addGroup(CobrancaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonCirurgiaNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaAula)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaIsencao)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaDesconto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel44)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        CobrancaLayout.setVerticalGroup(
            CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CobrancaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel38)
                .addGap(32, 32, 32)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonConsultaNormal)
                    .addComponent(jRadioButtonConsultaAula)
                    .addComponent(jRadioButtonConsultaIsencao)
                    .addComponent(jRadioButtonConsultaDesconto)
                    .addComponent(jFormattedTextFieldConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonExameNormal)
                    .addComponent(jRadioButtonExameAula)
                    .addComponent(jRadioButtonExameIsencao)
                    .addComponent(jRadioButtonExameDesconto)
                    .addComponent(jFormattedTextFieldExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCirurgiaNormal)
                    .addComponent(jRadioButtonCirurgiaAula)
                    .addComponent(jRadioButtonCirurgiaIsencao)
                    .addComponent(jRadioButtonCirurgiaDesconto)
                    .addComponent(jFormattedTextFieldCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(501, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cobrança", Cobranca);

        jTableFamiliares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableFamiliares);

        jLabel14.setText("Nome:");

        jLabel15.setText("Idade:");

        jLabel16.setText("Parentesco:");

        jComboBoxEscolaridadeFamliar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fundamental incompleto", "Fundamental completo", "Médio incompleto", "Médio completo", "Superior incompleto", "Superior completo", "Pós-graduação incompleta", "Pós-graduação completa" }));

        jLabel17.setText("Escolaridade:");

        jLabel23.setText("Ocupação:");

        jLabel24.setText("Renda (R$):");

        jFormattedIdadeFamilia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabelRendaTotal.setText("Renda total (R$):");

        jLabelRendaPerCapta.setText("Renda per capita (R$):");

        jLabelFamiliaRendaTotal.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabelFamiliaRendaPerCapita.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel27.setText("Fatores de risco social declarados:");

        jLabel28.setText("A família possui algum bem material (casa, carro, etc.)? Qual?");

        jTextAreaBemMaterial.setColumns(20);
        jTextAreaBemMaterial.setRows(5);
        jScrollPane3.setViewportView(jTextAreaBemMaterial);

        jLabel29.setText("A família possui dívidas com banco/empréstimos ou outra situação que comprometa a renda familiar?");

        jTextAreaDividas.setColumns(20);
        jTextAreaDividas.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDividas);

        jLabel30.setText("Quais os principais motivos que impossibilitam custear o tratamento do animal?");

        jTextAreaMotivos.setColumns(20);
        jTextAreaMotivos.setRows(5);
        jScrollPane5.setViewportView(jTextAreaMotivos);

        javax.swing.GroupLayout jPanelComposicaoFamiliarLayout = new javax.swing.GroupLayout(jPanelComposicaoFamiliar);
        jPanelComposicaoFamiliar.setLayout(jPanelComposicaoFamiliarLayout);
        jPanelComposicaoFamiliarLayout.setHorizontalGroup(
            jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFamiliaNome)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFamiliaOcupacao))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEscolaridadeFamliar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedIdadeFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldFamiliaRenda))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addGap(0, 191, Short.MAX_VALUE)
                                .addComponent(jButtonRemover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabelRendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelFamiliaRendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRendaPerCapta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFamiliaRendaPerCapita, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFatoresDeclarados)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanelComposicaoFamiliarLayout.createSequentialGroup()
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComposicaoFamiliarLayout.createSequentialGroup()
                        .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
        );
        jPanelComposicaoFamiliarLayout.setVerticalGroup(
            jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComposicaoFamiliarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldFamiliaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxEscolaridadeFamliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jFormattedIdadeFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldFamiliaRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextFieldFamiliaOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelRendaTotal)
                        .addComponent(jLabelRendaPerCapta)
                        .addComponent(jLabelFamiliaRendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelFamiliaRendaPerCapita, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelComposicaoFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldFatoresDeclarados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Composição familiar", jPanelComposicaoFamiliar);

        jButtonQuestionarioCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonQuestionarioCancelar.setText("Cancelar");
        jButtonQuestionarioCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuestionarioCancelarActionPerformed(evt);
            }
        });

        jButtonQuestionarioSalvar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonQuestionarioSalvar.setText("Salvar");
        jButtonQuestionarioSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuestionarioSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuestionarioCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonQuestionarioSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuestionarioSalvar)
                    .addComponent(jButtonQuestionarioCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarDonoActionPerformed
        HUMVApp.exibirMensagemCarregamento();
        dono = new Dono();
        dono.setNome("HUMV DONO");
        QuestionarioBuscarDono bDono = new QuestionarioBuscarDono(this);
        HUMVApp.setNovoPainelCentral(bDono);
    }//GEN-LAST:event_jButtonPesquisarDonoActionPerformed

    private void jButtonCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoActionPerformed
        //new CadastrarDonoJDialog(this).setVisible(true);
        HUMVApp.exibirMensagemCarregamento();
        CadastrarDonoJPanel donoJP = new CadastrarDonoJPanel(this);
        HUMVApp.setNovoPainelCentral(donoJP);
    }//GEN-LAST:event_jButtonCadastrarNovoDonoActionPerformed

    private void jRadioButtonSaneamentoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSaneamentoNaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonSaneamentoSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSaneamentoNaoActionPerformed

    private void jRadioButtonEnergiaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEnergiaNaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonEnergiaSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonEnergiaNaoActionPerformed

    private void jButtonDocumentoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentoSalvarActionPerformed
        String nomeDocumento = "";
        String nomeUser;
        Date data;
        try {
            if (this.jRadioButtonDocumentosOutro.isSelected()) {
                nomeDocumento = this.jTextFieldDocumentoOutro.getText();
                nomeDocumento = validarString(nomeDocumento, "Nome do Documento");
            } else {
                if (this.jRadioButtonDocumentosBolsaFamilia.isSelected()) {
                    nomeDocumento = Documentacao.BOLSAFAMILIA;
                } else if (jRadioButtonDocumentosComprovanteEndereco.isSelected()) {
                    nomeDocumento = Documentacao.COMPROVANTEENDEREÇO;
                } else if (jRadioButtonDocumentosMembroFamilia.isSelected()) {
                    nomeDocumento = Documentacao.MEMBROFAMILIA;
                } else if (jRadioButtonDocumentosRGDono.isSelected()) {
                    nomeDocumento = Documentacao.RGDONO;
                }
            }
            
            nomeUser = HUMVApp.getNomeUsuario();
            data = this.dteDataEntrega.getDate();
            Documentacao doc = new Documentacao();
            doc.setDataEntrega(data);
            doc.setNomeDocumento(nomeDocumento);
            doc.setNomeRecebinte(nomeUser);
            modelDocumentacao.addDocumento(doc);
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falha de Validação de item no recebimento de Documentos.");
        }
    }//GEN-LAST:event_jButtonDocumentoSalvarActionPerformed

    private void jButtonDocumentoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentoRemoverActionPerformed
        Integer indexRemuver = this.jTableDocumentos.getSelectedRow();
        this.modelDocumentacao.removerDocumento(indexRemuver);
    }//GEN-LAST:event_jButtonDocumentoRemoverActionPerformed

    private void jRadioButtonDocumentosRGDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDocumentosRGDonoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(false);
        this.jRadioButtonDocumentosRGDono.setSelected(true);
        this.jRadioButtonDocumentosMembroFamilia.setSelected(false);
        this.jRadioButtonDocumentosBolsaFamilia.setSelected(false);
        this.jRadioButtonDocumentosOutro.setSelected(false);
        this.jTextFieldDocumentoOutro.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonDocumentosRGDonoActionPerformed

    private void jRadioButtonDocumentosMembroFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDocumentosMembroFamiliaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(false);
        this.jRadioButtonDocumentosRGDono.setSelected(false);
        this.jRadioButtonDocumentosMembroFamilia.setSelected(true);
        this.jRadioButtonDocumentosBolsaFamilia.setSelected(false);
        this.jRadioButtonDocumentosOutro.setSelected(false);
        this.jTextFieldDocumentoOutro.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonDocumentosMembroFamiliaActionPerformed

    private void jCheckBoxNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNAActionPerformed

    private void jRadioButtonConsultaIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultaIsencaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonConsultaNormal.setSelected(false);
        this.jRadioButtonConsultaIsencao.setSelected(true);
        this.jRadioButtonConsultaDesconto.setSelected(false);
        this.jRadioButtonConsultaAula.setSelected(false);
        this.jFormattedTextFieldConsulta.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultaIsencaoActionPerformed

    private void jRadioButtonExameIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExameIsencaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonExameNormal.setSelected(false);
        this.jRadioButtonExameAula.setSelected(false);
        this.jRadioButtonExameDesconto.setSelected(false);
        this.jRadioButtonExameIsencao.setSelected(true);
    }//GEN-LAST:event_jRadioButtonExameIsencaoActionPerformed

    private void jRadioButtonCirurgiaIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaIsencaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCirurgiaNormal.setSelected(false);
        this.jRadioButtonCirurgiaIsencao.setSelected(true);
        this.jRadioButtonCirurgiaDesconto.setSelected(false);
        this.jRadioButtonCirurgiaAula.setSelected(false);
        this.jFormattedTextFieldCirurgia.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaIsencaoActionPerformed

    private void jRadioButtonExameDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExameDescontoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonExameNormal.setSelected(false);
        this.jRadioButtonExameAula.setSelected(false);
        this.jRadioButtonExameDesconto.setSelected(true);
        this.jRadioButtonExameIsencao.setSelected(false);
        this.jFormattedTextFieldExame.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonExameDescontoActionPerformed

    private void jButtonQuestionarioCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioCancelarActionPerformed

    }//GEN-LAST:event_jButtonQuestionarioCancelarActionPerformed

    private void jButtonQuestionarioSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioSalvarActionPerformed
        boolean okDono = validarDadosDoDono();
        
        setArrayDocumentacao();
        
        setAnalisetoQuest();
        
        setValorTipoCirugia();
        setValorTipoConsulta();
        setValorTipoExame();
        
        setArrayParentes();
        setFatoresRiscos();
        
        try {
            RESTMethods.put("/api/questionarioSocioeconomico", quest);
            JOptionPane.showMessageDialog(HUMVApp.getMainWindow(), "Salvo Com Sucesso.");
        } catch (RESTConnectionException ex) {
            erroMensage("Erro ao connectar ao Servidor.\n" + ex.getMessage(), "Falha de Connexão.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonQuestionarioSalvarActionPerformed
    
    private void setAnalisetoQuest() {
        try {
            String breveResumo = this.jTextAreaVulnerabilidades.getText();
            breveResumo = validarString(breveResumo, "Breve resumo em Analise");
            
            String orientacaoIncaminhamento = this.jTextAreaEncaminhamentos.getText();
            orientacaoIncaminhamento = validarString(breveResumo, "Orientação e encaminhamento em Analise");
            
            String conclusao = this.jTextAreaConclusoes.getText();
            conclusao = validarString(conclusao, "Conclusão em Analise");
            
            this.quest.setAnaliseBreveResumo(breveResumo);
            this.quest.setAnaliseObservacoes(orientacaoIncaminhamento);
            this.quest.setAnaliseConclusoes(conclusao);
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falta de item em Analise do Asistente social.");
        }
    }
    
    private void setFatoresRiscos() {
        String fatoresReclarados = this.jTextFieldFatoresDeclarados.getText();
        String bensMateriais = this.jTextAreaBemMaterial.getText();
        String dividasMateriais = this.jTextAreaDividas.getText();
        String motivos = this.jTextAreaMotivos.getText();
        quest.setRiscosSociais(fatoresReclarados);
        quest.setBensFamiliares(bensMateriais);
        quest.setEmprestimos(dividasMateriais);
        quest.setImpossibilidadesCusteio(motivos);
    }
    
    private void setArrayParentes() {
        quest.setParentes((List<Parente>) modelParente.getParentes());
    }
    
    private void setArrayDocumentacao() {
        quest.setDocumentosEntregues((List<Documentacao>) modelDocumentacao.getDocumentos());
    }
    
    private void setValorTipoConsulta() throws HeadlessException {
        Integer consulta;
        if (this.jRadioButtonConsultaAula.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_AULA;
        } else if (this.jRadioButtonConsultaNormal.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonConsultaIsencao.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_INSENCAO;
        } else {
            consulta = QuestionarioSocioeconomico.COBRANCA_DESCONTO;
            String descontoConsultaST = this.jFormattedTextFieldConsulta.getText();
            setValorConsultaDesconto(descontoConsultaST);
        }
    }
    
    private void setValorTipoExame() throws HeadlessException {
        Integer exame;
        if (this.jRadioButtonExameAula.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_AULA;
        } else if (this.jRadioButtonExameNormal.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonExameIsencao.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_INSENCAO;
        } else {
            exame = QuestionarioSocioeconomico.COBRANCA_DESCONTO;
            String descontoExameST = this.jFormattedTextFieldConsulta.getText();
            setValorExameDesconto(descontoExameST);
        }
    }
    
    private void setValorTipoCirugia() throws HeadlessException {
        Integer cirugia;
        if (this.jRadioButtonExameAula.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_AULA;
        } else if (this.jRadioButtonExameNormal.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonExameIsencao.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_INSENCAO;
        } else {
            cirugia = QuestionarioSocioeconomico.COBRANCA_DESCONTO;
            String descontoCirugiaST = this.jFormattedTextFieldConsulta.getText();
            setValorCirugiaDesconto(descontoCirugiaST);
        }
    }
    
    private void setValorCirugiaDesconto(String descontoCirugiaST) throws HeadlessException {
        Double descontoCirugia;
        try {
            descontoCirugia = validarDouble(descontoCirugiaST, "Desconto Consulta");
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falha no valor do desconto da Cirugia.");
        }
    }
    
    private void setValorExameDesconto(String descontoExameST) throws HeadlessException {
        Double descontoExame;
        try {
            descontoExame = validarDouble(descontoExameST, "Desconto Consulta");
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falha no valor do desconto da Exame.");
        }
    }
    
    private void setValorConsultaDesconto(String descontoConsultaST) throws HeadlessException {
        Double descontoConsulta;
        try {
            descontoConsulta = validarDouble(descontoConsultaST, "Desconto Consulta");
            quest.setValorDescontoConsultas(descontoConsulta);
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falha no valor do desconto da Consulta.");
        }
    }
    
    private boolean validarDadosDoDono() {
        String idadeST = this.jFormattedTextFieldIdade.getText();
        Integer idade;
        try {
            idade = validarInteger(idadeST, "Idade");
            Integer estadoCivil;
            estadoCivil = this.jComboBoxEstadoCivil.getSelectedIndex();
            String profissao = this.jTextFieldProfissao.getText();
            profissao = validarString(profissao, "Profissão");
            Integer escolaridade = this.jComboBoxEscolaridadeFamliar.getSelectedIndex();
            String ocupacao = this.jTextFieldOcupacao.getText();
            ocupacao = validarString(ocupacao, "Ocupação");
            String rendaFormalST = this.jFormattedTextFieldRendaFormal.getText();
            Double rendaFormal = validarDouble(rendaFormalST, "Renda Formal");
            String rendaInformalST = this.jFormattedTextFieldRendaInformal.getText();
            Double rendaInformal = validarDouble(rendaFormalST, "Renda Informal");
            String aluguelST = this.jTextFieldOcupacao.getText();
            Double aluguel = validarDouble(aluguelST, "Aluguel");
            boolean saneamento;
            boolean saneamentoS = this.jRadioButtonSaneamentoSim.isSelected();
            boolean saneamentoN = this.jRadioButtonSaneamentoNao.isSelected();
            saneamento = validarRadioButton(saneamentoS, saneamentoN, "Saneamento");
            boolean energiaS = this.jRadioButtonEnergiaSim.isSelected();
            boolean energiaN = this.jRadioButtonEnergiaNao.isSelected();
            boolean energia;
            energia = validarRadioButton(energiaS, energiaN, "Energia");
            String tipoConst = this.jTextFieldTipoConstrucao.getText();
            tipoConst = validarString(tipoConst, "Tipo de Construção");
            String condMoradia = this.jTextFieldCondicaoMoradia.getText();
            condMoradia = validarString(condMoradia, "Condição de Modaria");
            String progTransferRenda = this.jTextFieldProgramaRenda.getText();
            progTransferRenda = validarString(progTransferRenda, "Programa de Transferencia de Renda");
            
            boolean estudante;
            boolean estudanteS = this.jRadioButtonEstudanteSim.isSelected();
            boolean estudanteN = this.jRadioButtonEstudanteNao.isSelected();
            estudante = validarRadioButton(estudanteS, estudanteN, "Estudante");
            
            String gastosMenssaisST = this.jFormattedTextFieldGastosMensais.getText();
            Double gastosMensais = validarDouble(gastosMenssaisST, "Gastos Mensais");
            
            String fonteCusteio = this.jTextFieldFonteCusteio.getText();
            fonteCusteio = validarString(fonteCusteio, "Fonte de Custeio");
            
            String bolsaOuBeneficio = this.jTextFieldBeneficio.getText();
            bolsaOuBeneficio = validarString(bolsaOuBeneficio, "Bolsa ou Beneficio");
            
            String observacao = this.jTextAreaObservacoes.getText();
            validarString(observacao, "Observações");
            quest.setIdade(idade);
            quest.setEstadoCivil(estadoCivil);
            quest.setProfissao(profissao);
            quest.setEscolaridade(escolaridade);
            quest.setOcupacaoAtual(ocupacao);
            quest.setRendaFormal(rendaFormal);
            quest.setRendaInformal(rendaInformal);
            quest.setValorAluguel(aluguel);
            quest.setTemSaneamento(saneamento);
            quest.setTemEnergia(energia);
            quest.setTipoConstrucao(tipoConst);
            quest.setCondicaoMoradia(condMoradia);
            quest.setProgramaTransferenciaRenda(progTransferRenda);
            quest.setEstudante(estudante);
            quest.setGastosMensais(gastosMensais);
            quest.setFontCusteio(fonteCusteio);
            quest.setBolsaOuBeneficio(bolsaOuBeneficio);
            quest.setObservacoesDadosDono(observacao);
            
            return true;
        } catch (Exception e) {
            this.erroMensage(e.getMessage(), "Erro ao Validar dados do dono.");
            return false;
        }
        
    }
    
    private void erroMensage(String mensage, String title) {
        JOptionPane.showMessageDialog(HUMVApp.getMainWindow(), mensage, title, JOptionPane.WARNING_MESSAGE);
    }
    
    private boolean validarRadioButton(boolean radioButtonSim, boolean radioButtonNao, String Campo) throws Exception {
        if (!radioButtonSim && !radioButtonNao) {
            throw new Exception("Escolha Entre as opções " + Campo + ".");
        } else {
            if (radioButtonSim) {
                return radioButtonSim;
            } else {
                
                return radioButtonNao;
            }
        }
    }
    
    private Double validarDouble(String rendaFormalST, String campo) throws Exception {
        Double rendaFormal;
        try {
            rendaFormal = Double.parseDouble(rendaFormalST);
            return rendaFormal;
        } catch (Exception e) {
            throw new Exception("O campo " + campo + " é real.");
        }
    }
    
    private String validarString(String test, String campo) throws Exception {
        String returnMe = test;
        if (returnMe.trim().length() == 0) {
            throw new Exception("Preencha o campo " + campo + ".");
        } else {
            return returnMe;
        }
    }
    
    private Integer validarInteger(String idadeST, String campo) throws Exception {
        try {
            Integer returnMe = Integer.parseInt(idadeST);
            return returnMe;
        } catch (Exception e) {
            throw new Exception("Coloque um inteiro no campo " + campo + ".");
        }
    }
    

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
        try {
            Parente parente = new Parente();
            
            String nome = this.jTextFieldFamiliaNome.getText();
            nome = validarString(nome, "Nome do Familiar");
            parente.setNome(nome);
            
            if (this.jFormattedIdadeFamilia.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("Idade do familiar");
                return;
            }
            int idade = Integer.parseInt(this.jFormattedIdadeFamilia.getText());
            parente.setIdade(idade);
            
            if (this.jTextFieldParentesco.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("Parentesco do familiar");
                return;
            }
            String parentesco = this.jTextFieldParentesco.getText();
            parente.setParentesco(parentesco);
            
            int escolaridade = this.jComboBoxEscolaridadeFamliar.getSelectedIndex();
            parente.setEscolaridade(escolaridade);
            
            if (this.jTextFieldFamiliaOcupacao.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("Ocupação do familiar");
                return;
            }
            String ocupacao = this.jTextFieldFamiliaOcupacao.getText();
            parente.setOcupacao(ocupacao);
            System.out.println("" + this.jTextFieldFamiliaRenda.getText());
            if (this.jTextFieldFamiliaRenda.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("Renda do familiar");
                return;
            }
            Double renda;
            String rendaFamilliarST = jTextFieldFamiliaRenda.getText();
            renda = validarDouble(rendaFamilliarST, "Renda familiar");
            parente.setRenda(renda);
            parente.setNomeClienteCadastrado(dono.getNome());
            modelParente.addParente(parente);
            limparTextfieldsInfoFamiliar();
            atualizaCalculoRenda();
        } catch (Exception ex) {
            this.erroMensage(ex.getMessage(), "Falha ao Salvar Novo Parente.");
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jRadioButtonDocumentosComprovanteEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDocumentosComprovanteEnderecoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(true);
        this.jRadioButtonDocumentosRGDono.setSelected(false);
        this.jRadioButtonDocumentosMembroFamilia.setSelected(false);
        this.jRadioButtonDocumentosBolsaFamilia.setSelected(false);
        this.jRadioButtonDocumentosOutro.setSelected(false);
        this.jTextFieldDocumentoOutro.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonDocumentosComprovanteEnderecoActionPerformed

    private void jRadioButtonDocumentosBolsaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDocumentosBolsaFamiliaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(false);
        this.jRadioButtonDocumentosRGDono.setSelected(false);
        this.jRadioButtonDocumentosMembroFamilia.setSelected(false);
        this.jRadioButtonDocumentosBolsaFamilia.setSelected(true);
        this.jRadioButtonDocumentosOutro.setSelected(false);
        this.jTextFieldDocumentoOutro.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonDocumentosBolsaFamiliaActionPerformed

    private void jRadioButtonDocumentosOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDocumentosOutroActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(false);
        this.jRadioButtonDocumentosRGDono.setSelected(false);
        this.jRadioButtonDocumentosMembroFamilia.setSelected(false);
        this.jRadioButtonDocumentosBolsaFamilia.setSelected(false);
        this.jRadioButtonDocumentosOutro.setSelected(true);
        this.jTextFieldDocumentoOutro.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonDocumentosOutroActionPerformed

    private void jRadioButtonSaneamentoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSaneamentoSimActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonSaneamentoNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSaneamentoSimActionPerformed

    private void jRadioButtonEnergiaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEnergiaSimActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonEnergiaNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonEnergiaSimActionPerformed

    private void jRadioButtonEstudanteSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEstudanteSimActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonEstudanteNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonEstudanteSimActionPerformed

    private void jRadioButtonEstudanteNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEstudanteNaoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonEstudanteSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonEstudanteNaoActionPerformed

    private void jRadioButtonConsultaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultaNormalActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonConsultaNormal.setSelected(true);
        this.jRadioButtonConsultaIsencao.setSelected(false);
        this.jRadioButtonConsultaDesconto.setSelected(false);
        this.jRadioButtonConsultaAula.setSelected(false);
        this.jFormattedTextFieldConsulta.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultaNormalActionPerformed

    private void jRadioButtonConsultaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultaAulaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonConsultaNormal.setSelected(false);
        this.jRadioButtonConsultaIsencao.setSelected(false);
        this.jRadioButtonConsultaDesconto.setSelected(false);
        this.jRadioButtonConsultaAula.setSelected(true);
        this.jFormattedTextFieldConsulta.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonConsultaAulaActionPerformed

    private void jRadioButtonConsultaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConsultaDescontoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonConsultaNormal.setSelected(false);
        this.jRadioButtonConsultaIsencao.setSelected(false);
        this.jRadioButtonConsultaDesconto.setSelected(true);
        this.jRadioButtonConsultaAula.setSelected(false);
        this.jFormattedTextFieldConsulta.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonConsultaDescontoActionPerformed

    private void jRadioButtonExameNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExameNormalActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonExameNormal.setSelected(true);
        this.jRadioButtonExameAula.setSelected(false);
        this.jRadioButtonExameDesconto.setSelected(false);
        this.jRadioButtonExameIsencao.setSelected(false);
        this.jFormattedTextFieldExame.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonExameNormalActionPerformed

    private void jRadioButtonExameAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExameAulaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonExameNormal.setSelected(false);
        this.jRadioButtonExameAula.setSelected(true);
        this.jRadioButtonExameDesconto.setSelected(false);
        this.jRadioButtonExameIsencao.setSelected(false);
        this.jFormattedTextFieldExame.setEnabled(false);
        this.jFormattedTextFieldExame.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonExameAulaActionPerformed

    private void jRadioButtonCirurgiaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaNormalActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCirurgiaNormal.setSelected(true);
        this.jRadioButtonCirurgiaIsencao.setSelected(false);
        this.jRadioButtonCirurgiaDesconto.setSelected(false);
        this.jRadioButtonCirurgiaAula.setSelected(false);
        this.jFormattedTextFieldCirurgia.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaNormalActionPerformed

    private void jRadioButtonCirurgiaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaAulaActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCirurgiaNormal.setSelected(false);
        this.jRadioButtonCirurgiaIsencao.setSelected(false);
        this.jRadioButtonCirurgiaDesconto.setSelected(false);
        this.jRadioButtonCirurgiaAula.setSelected(true);
        this.jFormattedTextFieldCirurgia.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonCirurgiaAulaActionPerformed

    private void jRadioButtonCirurgiaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCirurgiaDescontoActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonCirurgiaNormal.setSelected(false);
        this.jRadioButtonCirurgiaIsencao.setSelected(false);
        this.jRadioButtonCirurgiaDesconto.setSelected(true);
        this.jRadioButtonCirurgiaAula.setSelected(false);
        this.jFormattedTextFieldCirurgia.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonCirurgiaDescontoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cobranca;
    private javax.swing.ButtonGroup buttonGroupCirurgia;
    private javax.swing.ButtonGroup buttonGroupConsulta;
    private javax.swing.ButtonGroup buttonGroupDocumento;
    private javax.swing.ButtonGroup buttonGroupEnergia;
    private javax.swing.ButtonGroup buttonGroupEstudante;
    private javax.swing.ButtonGroup buttonGroupExame;
    private javax.swing.ButtonGroup buttonGroupSaneamento;
    private com.toedter.calendar.JDateChooser dteDataEntrega;
    private javax.swing.JButton jButtonCadastrarNovoDono;
    private javax.swing.JButton jButtonDocumentoRemover;
    private javax.swing.JButton jButtonDocumentoSalvar;
    private javax.swing.JButton jButtonPesquisarDono;
    private javax.swing.JButton jButtonQuestionarioCancelar;
    private javax.swing.JButton jButtonQuestionarioSalvar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxNA;
    private javax.swing.JCheckBox jCheckBoxVistoASocial;
    private javax.swing.JComboBox<String> jComboBoxEscolaridadeDono;
    private javax.swing.JComboBox<String> jComboBoxEscolaridadeFamliar;
    private javax.swing.JComboBox<String> jComboBoxEstadoCivil;
    private javax.swing.JFormattedTextField jFormattedIdadeFamilia;
    private javax.swing.JFormattedTextField jFormattedTextFieldAluguel;
    private javax.swing.JFormattedTextField jFormattedTextFieldCirurgia;
    private javax.swing.JFormattedTextField jFormattedTextFieldConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldExame;
    private javax.swing.JFormattedTextField jFormattedTextFieldGastosMensais;
    private javax.swing.JFormattedTextField jFormattedTextFieldIdade;
    private javax.swing.JFormattedTextField jFormattedTextFieldRendaFormal;
    private javax.swing.JFormattedTextField jFormattedTextFieldRendaInformal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCpfDono;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelFamiliaRendaPerCapita;
    private javax.swing.JLabel jLabelFamiliaRendaTotal;
    private javax.swing.JLabel jLabelNomeDono;
    private javax.swing.JLabel jLabelRendaPerCapta;
    private javax.swing.JLabel jLabelRendaTotal;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanelAdicionais;
    private javax.swing.JPanel jPanelAnalise;
    private javax.swing.JPanel jPanelComposicaoFamiliar;
    private javax.swing.JPanel jPanelDadosBasicos;
    private javax.swing.JPanel jPanelDadosDono;
    private javax.swing.JPanel jPanelDocumentos;
    private javax.swing.JPanel jPanelEstudante;
    private javax.swing.JPanel jPanelMateriais;
    private javax.swing.JRadioButton jRadioButtonCirurgiaAula;
    private javax.swing.JRadioButton jRadioButtonCirurgiaDesconto;
    private javax.swing.JRadioButton jRadioButtonCirurgiaIsencao;
    private javax.swing.JRadioButton jRadioButtonCirurgiaNormal;
    private javax.swing.JRadioButton jRadioButtonConsultaAula;
    private javax.swing.JRadioButton jRadioButtonConsultaDesconto;
    private javax.swing.JRadioButton jRadioButtonConsultaIsencao;
    private javax.swing.JRadioButton jRadioButtonConsultaNormal;
    private javax.swing.JRadioButton jRadioButtonDocumentosBolsaFamilia;
    private javax.swing.JRadioButton jRadioButtonDocumentosComprovanteEndereco;
    private javax.swing.JRadioButton jRadioButtonDocumentosMembroFamilia;
    private javax.swing.JRadioButton jRadioButtonDocumentosOutro;
    private javax.swing.JRadioButton jRadioButtonDocumentosRGDono;
    private javax.swing.JRadioButton jRadioButtonEnergiaNao;
    private javax.swing.JRadioButton jRadioButtonEnergiaSim;
    private javax.swing.JRadioButton jRadioButtonEstudanteNao;
    private javax.swing.JRadioButton jRadioButtonEstudanteSim;
    private javax.swing.JRadioButton jRadioButtonExameAula;
    private javax.swing.JRadioButton jRadioButtonExameDesconto;
    private javax.swing.JRadioButton jRadioButtonExameIsencao;
    private javax.swing.JRadioButton jRadioButtonExameNormal;
    private javax.swing.JRadioButton jRadioButtonSaneamentoNao;
    private javax.swing.JRadioButton jRadioButtonSaneamentoSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDocumentos;
    private javax.swing.JTable jTableFamiliares;
    private javax.swing.JTextArea jTextAreaBemMaterial;
    private javax.swing.JTextArea jTextAreaConclusoes;
    private javax.swing.JTextArea jTextAreaDividas;
    private javax.swing.JTextArea jTextAreaEncaminhamentos;
    private javax.swing.JTextArea jTextAreaMotivos;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextArea jTextAreaVulnerabilidades;
    private javax.swing.JTextField jTextFieldBeneficio;
    private javax.swing.JTextField jTextFieldCondicaoMoradia;
    private javax.swing.JTextField jTextFieldDocumentoOutro;
    private javax.swing.JTextField jTextFieldFamiliaNome;
    private javax.swing.JTextField jTextFieldFamiliaOcupacao;
    private javax.swing.JTextField jTextFieldFamiliaRenda;
    private javax.swing.JTextField jTextFieldFatoresDeclarados;
    private javax.swing.JTextField jTextFieldFonteCusteio;
    private javax.swing.JTextField jTextFieldOcupacao;
    private javax.swing.JTextField jTextFieldParentesco;
    private javax.swing.JTextField jTextFieldProfissao;
    private javax.swing.JTextField jTextFieldProgramaRenda;
    private javax.swing.JTextField jTextFieldTipoConstrucao;
    // End of variables declaration//GEN-END:variables

    private void limparTextfieldsInfoFamiliar() {
        this.jTextFieldFamiliaNome.setText(null);
        this.jFormattedIdadeFamilia.setText(null);
        this.jTextFieldParentesco.setText(null);
        this.jTextFieldFamiliaOcupacao.setText(null);
        this.jTextFieldFamiliaRenda.setText(null); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void atualizaCalculoRenda() {
        jLabelFamiliaRendaTotal.setText("" + modelParente.getRendaTotal());
        jLabelFamiliaRendaPerCapita.setText("" + modelParente.getRendaPerCapita()); //To change body of generated methods, choose Tools | Templates.
    }
}
