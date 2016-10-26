package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.entity.Documentacao;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.dono.CadastrarDonoJPanel;
import br.edu.ufrb.lasis.humv.view.dono.PropriedadesBuscaDono;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

/**
 * Classe que cria o Painel Questionario SOcial.
 *
 * @author tassiovale
 * @author Orion && Chacal
 */
public class QuestionarioSocioEconomicoJPanel extends javax.swing.JPanel implements ResultadoBusca, ActionListener {

    private DocumentacaoTableModel modelDocumentacao;
    private ParenteTableModel modelParente;
    private Dono dono;
    private QuestionarioSocioeconomico questionario;

    /**
     * Creates new form QuestionarioSocioEconomicoJPanel
     */
    public QuestionarioSocioEconomicoJPanel() {
        initComponents();
        customInitComponents();
        HUMVApp.esconderMensagemCarregamento();
    }

    private void customInitComponents() {
        this.dteDataEntrega.setDate(Calendar.getInstance().getTime());
        this.modelDocumentacao = new DocumentacaoTableModel();
        this.jTableDocumentos.setModel(this.modelDocumentacao);
        this.modelParente = new ParenteTableModel();
        this.jTableFamiliares.setModel(modelParente);

        buttonGroupEnergia.add(jRadioButtonEnergiaSim);
        buttonGroupEnergia.add(jRadioButtonEnergiaNao);

        buttonGroupSaneamento.add(jRadioButtonSaneamentoSim);
        buttonGroupSaneamento.add(jRadioButtonSaneamentoNao);

        buttonGroupEstudante.add(jRadioButtonEstudanteSim);
        buttonGroupEstudante.add(jRadioButtonEstudanteNao);

        buttonGroupDocumento.add(jRadioButtonDocumentosBolsaFamilia);
        buttonGroupDocumento.add(jRadioButtonDocumentosComprovanteEndereco);
        buttonGroupDocumento.add(jRadioButtonDocumentosMembroFamilia);
        buttonGroupDocumento.add(jRadioButtonDocumentosRGDono);
        buttonGroupDocumento.add(jRadioButtonDocumentosOutro);
        jRadioButtonDocumentosBolsaFamilia.addActionListener(this);
        jRadioButtonDocumentosComprovanteEndereco.addActionListener(this);
        jRadioButtonDocumentosMembroFamilia.addActionListener(this);
        jRadioButtonDocumentosRGDono.addActionListener(this);
        jRadioButtonDocumentosOutro.addActionListener(this);

        buttonGroupConsulta.add(jRadioButtonConsultaAula);
        buttonGroupConsulta.add(jRadioButtonConsultaDesconto);
        buttonGroupConsulta.add(jRadioButtonConsultaIsencao);
        buttonGroupConsulta.add(jRadioButtonConsultaNormal);
        jRadioButtonConsultaAula.addActionListener(this);
        jRadioButtonConsultaDesconto.addActionListener(this);
        jRadioButtonConsultaIsencao.addActionListener(this);
        jRadioButtonConsultaNormal.addActionListener(this);

        buttonGroupExame.add(jRadioButtonExameAula);
        buttonGroupExame.add(jRadioButtonExameDesconto);
        buttonGroupExame.add(jRadioButtonExameIsencao);
        buttonGroupExame.add(jRadioButtonExameNormal);
        jRadioButtonExameAula.addActionListener(this);
        jRadioButtonExameDesconto.addActionListener(this);
        jRadioButtonExameIsencao.addActionListener(this);
        jRadioButtonExameNormal.addActionListener(this);

        buttonGroupCirurgia.add(jRadioButtonCirurgiaAula);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaDesconto);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaIsencao);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaNormal);
        jRadioButtonCirurgiaAula.addActionListener(this);
        jRadioButtonCirurgiaDesconto.addActionListener(this);
        jRadioButtonCirurgiaIsencao.addActionListener(this);
        jRadioButtonCirurgiaNormal.addActionListener(this);

        this.jRadioButtonEstudanteNao.setSelected(true);
        habilitarPainelEstudante(false);
        jRadioButtonEstudanteNao.addActionListener(this);
        jRadioButtonEstudanteSim.addActionListener(this);

        this.jRadioButtonEnergiaSim.setSelected(true);
        this.jRadioButtonSaneamentoSim.setSelected(true);
        this.jRadioButtonConsultaNormal.setSelected(true);
        this.jRadioButtonExameNormal.setSelected(true);
        this.jRadioButtonCirurgiaNormal.setSelected(true);
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(true);

        this.jFormattedTextFieldCirurgia.setEnabled(false);
        this.jFormattedTextFieldConsulta.setEnabled(false);
        this.jFormattedTextFieldExame.setEnabled(false);
        jTextFieldDocumentoOutro.setEnabled(false);

        questionario = new QuestionarioSocioeconomico();
    }

    public QuestionarioSocioEconomicoJPanel(QuestionarioSocioeconomico questT) {
        this.questionario = questT;
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
        this.jTextFieldFatoresDeclarados.setText(questionario.getRiscosSociais());
        this.jTextAreaBemMaterial.setText(questionario.getBensFamiliares());
        this.jTextAreaDividas.setText(questionario.getEmprestimos());
        this.jTextAreaMotivos.setText(questionario.getImpossibilidadesCusteio());
    }

    private void reintroduzirCobranca() {
        if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_NORMAL)) {
            this.jRadioButtonCirurgiaNormal.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_AULA)) {
            this.jRadioButtonCirurgiaAula.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_INSENCAO)) {
            this.jRadioButtonCirurgiaIsencao.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_DESCONTO)) {
            this.jRadioButtonCirurgiaDesconto.setSelected(true);
            this.jFormattedTextFieldCirurgia.setEnabled(true);
            this.jFormattedTextFieldCirurgia.setText("" + questionario.getValorDescontoCirurgias());
        } else {
            InterfaceGraficaUtils.erroResposta("Erro ao reinserir a forma de cobrança");
        }

        if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_NORMAL)) {
            this.jRadioButtonConsultaNormal.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_AULA)) {
            this.jRadioButtonConsultaAula.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_INSENCAO)) {
            this.jRadioButtonConsultaIsencao.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_DESCONTO)) {
            this.jRadioButtonConsultaDesconto.setSelected(true);
            this.jFormattedTextFieldConsulta.setEnabled(false);
            this.jFormattedTextFieldConsulta.setText("" + questionario.getValorDescontoConsultas());
        } else {
            InterfaceGraficaUtils.erroResposta("Erro ao reinserir a forma de cobrança");
        }

        if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_NORMAL)) {
            this.jRadioButtonExameNormal.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_AULA)) {
            this.jRadioButtonExameAula.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_INSENCAO)) {
            this.jRadioButtonExameIsencao.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_DESCONTO)) {
            this.jRadioButtonExameDesconto.setSelected(true);
            this.jFormattedTextFieldExame.setEnabled(true);
            this.jFormattedTextFieldConsulta.setText("" + questionario.getValorDescontoConsultas());
        } else {
            InterfaceGraficaUtils.erroResposta("Erro ao reinserir a forma de cobrança");
        }
    }

    private void reintroduzirAnalise() {
        this.jTextAreaVulnerabilidades.setText(questionario.getAnaliseBreveResumo());
        this.jTextAreaEncaminhamentos.setText(questionario.getAnaliseObservacoes());
        this.jTextAreaConclusoes.setText(questionario.getAnaliseConclusoes());
    }

    private void reintroduzirParentes() {
        this.modelParente.setParentes(questionario.getParentes());
    }

    private void reintroduzirDocumentacoes() {
        this.modelDocumentacao.setDocumentos(questionario.getDocumentosEntregues());
    }

    private void reintroduzirDadosQuestionarioDadosDono() {
        this.jLabelNomeDono.setText("Nome : " + questionario.getDono().getNome());
        jLabelCpfDono.setText("CPF : " + questionario.getDono().getCpfCnpj());
        jLabelTelefone.setText("Telefone: " + questionario.getDono().getTelefone());
        jLabelEndereco.setText("Endereço: " + questionario.getDono().getEndereco());

        this.jFormattedTextFieldIdade.setText("" + questionario.getIdade());
        this.jComboBoxEstadoCivil.setSelectedIndex(questionario.getEstadoCivil());
        this.jTextFieldProfissao.setText(questionario.getProfissao());
        this.jComboBoxEscolaridadeDono.setSelectedIndex(questionario.getEscolaridade());
        this.jTextFieldOcupacao.setText(questionario.getOcupacaoAtual());
        this.jFormattedTextFieldRendaFormal.setText("" + questionario.getRendaFormal());
        this.jFormattedTextFieldRendaInformal.setText("" + questionario.getRendaInformal());
        this.jFormattedTextFieldAluguel.setText("" + questionario.getValorAluguel());
        this.jTextFieldTipoConstrucao.setText(questionario.getTipoConstrucao());
        this.jTextFieldCondicaoMoradia.setText(questionario.getCondicaoMoradia());
        this.jTextFieldProgramaRenda.setText(questionario.getProgramaTransferenciaRenda());
        if (questionario.isEstudante()) {
            this.jRadioButtonEstudanteSim.setSelected(true);
        } else {
            this.jRadioButtonEstudanteNao.setSelected(true);
        }
        if (questionario.isTemEnergia()) {
            this.jRadioButtonEnergiaSim.setSelected(true);
        } else {
            this.jRadioButtonEnergiaNao.setSelected(true);
        }
        if (questionario.isTemSaneamento()) {
            this.jRadioButtonSaneamentoSim.setSelected(true);
        } else {
            this.jRadioButtonSaneamentoNao.setSelected(true);
        }
        this.jFormattedTextFieldGastosMensais.setText("" + questionario.getGastosMensais());
        this.jTextFieldFonteCusteio.setText(questionario.getFontCusteio());
        this.jTextFieldBeneficio.setText(questionario.getBolsaOuBeneficio());
        this.jTextAreaObservacoes.setText(questionario.getObservacoesDadosDono());
    }

    @Override
    public void setResultado(Object resultado) {
        if (resultado instanceof Dono) {
            dono = (Dono) resultado;
            jLabelNomeDono.setText("Nome: " + dono.getNome());
            if (dono.getTipoDocumento().equalsIgnoreCase("cpf")) {
                jLabelCpfDono.setText("CPF: " + MaskUtils.formatarStringCPF(dono.getCpfCnpj()));
            } else {
                jLabelCpfDono.setText("CNPJ: " + MaskUtils.formatarStringCNPJ(dono.getCpfCnpj()));
            }
            jLabelEndereco.setText("Edereço: " + dono.getEndereco());
            jLabelTelefone.setText("Telefone: " + dono.getTelefone());
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
        jComboBoxEstadoCivil = new javax.swing.JComboBox<>();
        jComboBoxEscolaridadeDono = new javax.swing.JComboBox<>();
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
        jTextFieldCondicaoMoradia = new javax.swing.JTextField();
        jFormattedTextFieldAluguel = new javax.swing.JFormattedTextField();
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
        jComboBoxEscolaridadeFamliar = new javax.swing.JComboBox<>();
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

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Separado", "Divorciado", "Viúvo" }));

        jComboBoxEscolaridadeDono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundamental incompleto", "Fundamental completo", "Médio incompleto", "Médio completo", "Superior incompleto", "Superior completo", "Pós-graduação incompleta", "Pós-graduação completa" }));

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

        jRadioButtonSaneamentoNao.setText("Não");

        jRadioButtonEnergiaSim.setText("Sim");

        jRadioButtonEnergiaNao.setText("Não");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
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

        jRadioButtonEstudanteNao.setText("Não");

        jPanelEstudante.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel19.setText("Valor dos gastos mensais (R$):");

        jLabel20.setText("Fonte de custeio:");

        jLabel21.setText("Bolsa ou benefício:");

        jLabel22.setText("Observações:");

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

        jRadioButtonDocumentosRGDono.setText("Cópia do documento de identidade do dono");

        jRadioButtonDocumentosMembroFamilia.setText("Cópia do documento de identidade de membro da família");

        jRadioButtonDocumentosBolsaFamilia.setText("Cópia do cartão Bolsa Família");

        jRadioButtonDocumentosOutro.setText("Outro");

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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

        jRadioButtonConsultaAula.setText("Valor aula");

        jRadioButtonConsultaIsencao.setText("Isenção");

        jRadioButtonConsultaDesconto.setText("Desconto");

        jFormattedTextFieldConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel42.setText("%");

        jRadioButtonExameNormal.setText("Valor normal");

        jRadioButtonExameAula.setText("Valor aula");

        jRadioButtonExameIsencao.setText("Isenção");

        jRadioButtonExameDesconto.setText("Desconto");

        jFormattedTextFieldExame.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel43.setText("%");

        jRadioButtonCirurgiaNormal.setText("Valor normal");

        jRadioButtonCirurgiaAula.setText("Valor aula");

        jRadioButtonCirurgiaIsencao.setText("Isenção");

        jRadioButtonCirurgiaDesconto.setText("Desconto");

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

        jComboBoxEscolaridadeFamliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundamental incompleto", "Fundamental completo", "Médio incompleto", "Médio completo", "Superior incompleto", "Superior completo", "Pós-graduação incompleta", "Pós-graduação completa" }));

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
                        .addGap(0, 106, Short.MAX_VALUE))
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
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaDono propriedadesBusca = new PropriedadesBuscaDono(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE DONO", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonPesquisarDonoActionPerformed

    private void jButtonCadastrarNovoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarNovoDonoActionPerformed
        JFrame jFrame = new JFrame("Cadastro de dono");
        CadastrarDonoJPanel cadastrarDonoJPanel = new CadastrarDonoJPanel(jFrame, this);
        jFrame.setContentPane(cadastrarDonoJPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonCadastrarNovoDonoActionPerformed

    private void jButtonDocumentoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentoSalvarActionPerformed
        String nomeDocumento = "";
        String nomeUser;
        Date data;
        try {
            if (this.jRadioButtonDocumentosOutro.isSelected()) {
                validarCampoVazio(jTextFieldDocumentoOutro, "nome do documento");
                nomeDocumento = jTextFieldDocumentoOutro.getText();
            } else if (this.jRadioButtonDocumentosBolsaFamilia.isSelected()) {
                nomeDocumento = Documentacao.BOLSAFAMILIA;
            } else if (jRadioButtonDocumentosComprovanteEndereco.isSelected()) {
                nomeDocumento = Documentacao.COMPROVANTEENDEREÇO;
            } else if (jRadioButtonDocumentosMembroFamilia.isSelected()) {
                nomeDocumento = Documentacao.MEMBROFAMILIA;
            } else if (jRadioButtonDocumentosRGDono.isSelected()) {
                nomeDocumento = Documentacao.RGDONO;
            }

            nomeUser = HUMVApp.getNomeUsuario();
            data = this.dteDataEntrega.getDate();
            Documentacao doc = new Documentacao();
            doc.setDataEntrega(data);
            doc.setNomeDocumento(nomeDocumento);
            doc.setNomeRecebinte(nomeUser);
            modelDocumentacao.addDocumento(doc);
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonDocumentoSalvarActionPerformed

    private void jButtonDocumentoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentoRemoverActionPerformed
        Integer indexRemuver = this.jTableDocumentos.getSelectedRow();
        this.modelDocumentacao.removerDocumento(indexRemuver);
    }//GEN-LAST:event_jButtonDocumentoRemoverActionPerformed

    private void jButtonQuestionarioCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "questionário socioeconômico");
        if (sair) {
            System.gc();
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_jButtonQuestionarioCancelarActionPerformed

    private void jButtonQuestionarioSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioSalvarActionPerformed
        if (dono == null) {
            InterfaceGraficaUtils.erroCadastro("Escolha ou cadastre um dono de animal para continuar.");
            return;
        }

        boolean okDonoDados, okAnalise, okFatoresRisco;
        okDonoDados = validarDadosDoDono();
        if (!okDonoDados) {
            return;
        }

        setArrayDocumentacao();

        okAnalise = setAnaliseQuestionario();
        if (!okAnalise) {
            return;
        }

        setValorTipoCirugia();
        setValorTipoConsulta();
        setValorTipoExame();

        setArrayParentes();
        okFatoresRisco = setFatoresRiscos();
        if (!okFatoresRisco) {
            return;
        }

        try {
            RESTMethods.post("/api/questionarioSocioeconomico", questionario);
            InterfaceGraficaUtils.sucessoCadastro("questionário socioeconômico");
            HUMVApp.setPainelCentralComLogo();
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonQuestionarioSalvarActionPerformed

    private boolean setAnaliseQuestionario() {
        try {
            validarCampoVazio(jTextAreaVulnerabilidades, "breve resumo em análise");
            validarCampoVazio(jTextAreaEncaminhamentos, "orientação e encaminhamento");
            validarCampoVazio(jTextAreaConclusoes, "conclusão");

            questionario.setAnaliseBreveResumo(jTextAreaVulnerabilidades.getText());
            questionario.setAnaliseObservacoes(jTextAreaEncaminhamentos.getText());
            questionario.setAnaliseConclusoes(jTextAreaConclusoes.getText());
            return true;
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
            return false;
        }
    }

    private boolean setFatoresRiscos() {
        try {
            validarCampoVazio(jTextFieldFatoresDeclarados, "fatores declarados");
            validarCampoVazio(jTextAreaBemMaterial, "bens materiais");
            validarCampoVazio(jTextAreaDividas, "dívidas");
            validarCampoVazio(jTextAreaMotivos, "motivo de impossibilidade de pagamento");

            questionario.setRiscosSociais(jTextFieldFatoresDeclarados.getText());
            questionario.setBensFamiliares(jTextAreaBemMaterial.getText());
            questionario.setEmprestimos(jTextAreaDividas.getText());
            questionario.setImpossibilidadesCusteio(jTextAreaMotivos.getText());
            return true;
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
            return false;
        }
    }

    private void setArrayParentes() {
        questionario.setParentes(modelParente.getParentes());
    }

    private void setArrayDocumentacao() {
        questionario.setDocumentosEntregues(modelDocumentacao.getDocumentos());
    }

    private void setValorTipoConsulta() {
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
            questionario.setValorDescontoConsultas(ValidationsUtils.converteStringParaPreco(descontoConsultaST));
        }
        questionario.setTipoCobrancaConsultas(consulta);
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
            questionario.setValorDescontoExames(ValidationsUtils.converteStringParaPreco(descontoExameST));
        }
        questionario.setTipoCobrancaExames(exame);
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
            questionario.setValorDescontoCirurgias(ValidationsUtils.converteStringParaPreco(descontoCirugiaST));
        }
        questionario.setTipoCobrancaCirurgias(cirugia);
    }

    private boolean validarDadosDoDono() {

        try {
            validarCampoVazio(jFormattedTextFieldIdade, "idade");
            validarCampoVazio(jTextFieldProfissao, "profissão");
            validarCampoVazio(jTextFieldOcupacao, "ocupação");
            validarCampoVazio(jTextFieldTipoConstrucao, "tipo de construção");
            validarCampoVazio(jTextFieldCondicaoMoradia, "condição de moradia");
            validarCampoVazio(jTextFieldProgramaRenda, "programa de transferencia de renda");
            validarCampoVazio(jFormattedTextFieldRendaFormal, "renda formal");
            validarCampoVazio(jFormattedTextFieldRendaInformal, "renda informal");
            validarCampoVazio(jFormattedTextFieldAluguel, "aluguel/financ.");

            if (jRadioButtonEstudanteSim.isSelected()) {
                validarCampoVazio(jFormattedTextFieldGastosMensais, "gastos mensais");
                validarCampoVazio(jTextFieldFonteCusteio, "fonte de custeio");
                validarCampoVazio(jTextFieldBeneficio, "bolsa/benefício");
                validarCampoVazio(jTextAreaObservacoes, "observações");
            }
        } catch (Exception e) {
            InterfaceGraficaUtils.validaCampoVazio(e.getMessage());
            return false;
        }

        String rendaFormalST = this.jFormattedTextFieldRendaFormal.getText();
        Double rendaFormal = ValidationsUtils.converteStringParaPreco(rendaFormalST);

        String rendaInformalST = this.jFormattedTextFieldRendaInformal.getText();
        Double rendaInformal = ValidationsUtils.converteStringParaPreco(rendaInformalST);

        String aluguelST = this.jFormattedTextFieldAluguel.getText();
        Double aluguel = ValidationsUtils.converteStringParaPreco(aluguelST);

        if (jRadioButtonEstudanteSim.isSelected()) {
            String gastosMenssaisST = this.jFormattedTextFieldGastosMensais.getText();
            Double gastosMensais = ValidationsUtils.converteStringParaPreco(gastosMenssaisST);
            questionario.setGastosMensais(gastosMensais);
        }

        questionario.setDono(dono);
        questionario.setDataResposta(Calendar.getInstance().getTime());
        questionario.setIdade(Integer.parseInt(jFormattedTextFieldIdade.getText()));
        questionario.setEstadoCivil(jComboBoxEstadoCivil.getSelectedIndex());
        questionario.setProfissao(jTextFieldProfissao.getText());
        questionario.setEscolaridade(jComboBoxEscolaridadeFamliar.getSelectedIndex());
        questionario.setOcupacaoAtual(jTextFieldOcupacao.getText());
        questionario.setRendaFormal(rendaFormal);
        questionario.setRendaInformal(rendaInformal);
        questionario.setValorAluguel(aluguel);
        questionario.setTemSaneamento(jRadioButtonSaneamentoSim.isSelected());
        questionario.setTemEnergia(jRadioButtonEnergiaSim.isSelected());
        questionario.setTipoConstrucao(jTextFieldTipoConstrucao.getText());
        questionario.setCondicaoMoradia(jTextFieldCondicaoMoradia.getText());
        questionario.setProgramaTransferenciaRenda(jTextFieldProgramaRenda.getText());
        questionario.setEstudante(jRadioButtonEstudanteSim.isSelected());
        questionario.setFontCusteio(jTextFieldFonteCusteio.getText());
        questionario.setBolsaOuBeneficio(jTextFieldBeneficio.getText());
        questionario.setObservacoesDadosDono(jTextAreaObservacoes.getText());

        return true;
    }


    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        try {
            Parente parente = new Parente();

            validarCampoVazio(jTextFieldFamiliaNome, "nome do familiar");
            parente.setNome(jTextFieldFamiliaNome.getText());

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
            renda = ValidationsUtils.converteStringParaPreco(rendaFamilliarST);
            parente.setRenda(renda);
            parente.setNomeClienteCadastrado(dono.getNome());
            modelParente.addParente(parente);
            limparTextfieldsInfoFamiliar();
            atualizaCalculoRenda();
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jRadioButtonEstudanteSim) || e.getSource().equals(jRadioButtonEstudanteNao)) {
            if (jRadioButtonEstudanteSim.isSelected()) {
                habilitarPainelEstudante(true);
            } else {
                habilitarPainelEstudante(false);
            }
        } else if (e.getSource().equals(jRadioButtonConsultaAula) || e.getSource().equals(jRadioButtonConsultaDesconto)
                || e.getSource().equals(jRadioButtonConsultaIsencao) || e.getSource().equals(jRadioButtonConsultaNormal)
                || e.getSource().equals(jRadioButtonExameAula) || e.getSource().equals(jRadioButtonExameDesconto)
                || e.getSource().equals(jRadioButtonExameIsencao) || e.getSource().equals(jRadioButtonExameNormal)
                || e.getSource().equals(jRadioButtonCirurgiaAula) || e.getSource().equals(jRadioButtonCirurgiaDesconto)
                || e.getSource().equals(jRadioButtonCirurgiaIsencao) || e.getSource().equals(jRadioButtonCirurgiaNormal)) {

            jFormattedTextFieldConsulta.setEnabled(jRadioButtonConsultaDesconto.isSelected());
            jFormattedTextFieldExame.setEnabled(jRadioButtonExameDesconto.isSelected());
            jFormattedTextFieldCirurgia.setEnabled(jRadioButtonCirurgiaDesconto.isSelected());

        } else if (e.getSource().equals(jRadioButtonDocumentosBolsaFamilia)
                || e.getSource().equals(jRadioButtonDocumentosComprovanteEndereco)
                || e.getSource().equals(jRadioButtonDocumentosMembroFamilia)
                || e.getSource().equals(jRadioButtonDocumentosRGDono)
                || e.getSource().equals(jRadioButtonDocumentosOutro)) {

            jTextFieldDocumentoOutro.setEnabled(jRadioButtonDocumentosOutro.isSelected());

        }
    }

    private void habilitarPainelEstudante(boolean habilitar) {
        jFormattedTextFieldGastosMensais.setEnabled(habilitar);
        jTextFieldFonteCusteio.setEnabled(habilitar);
        jTextFieldBeneficio.setEnabled(habilitar);
        jTextAreaObservacoes.setEnabled(habilitar);
    }

    private void validarCampoVazio(JTextComponent campoTexto, String nomeCampo) throws Exception {
        if (campoTexto.getText().isEmpty()) {
            campoTexto.setFocusable(true);
            throw new Exception(nomeCampo);
        }
    }

    private void limparTextfieldsInfoFamiliar() {
        this.jTextFieldFamiliaNome.setText(null);
        this.jFormattedIdadeFamilia.setText(null);
        this.jTextFieldParentesco.setText(null);
        this.jTextFieldFamiliaOcupacao.setText(null);
        this.jTextFieldFamiliaRenda.setText(null);
    }

    private void atualizaCalculoRenda() {
        jLabelFamiliaRendaTotal.setText(ValidationsUtils.convertePrecoParaString(modelParente.getRendaTotal()));
        jLabelFamiliaRendaPerCapita.setText(ValidationsUtils.convertePrecoParaString(modelParente.getRendaPerCapita()));
    }

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

}
