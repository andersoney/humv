package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.entity.DocumentoComprovante;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe que cria o Painel Questionario Social.
 *
 * @author tassiovale
 * @author Orion && Chacal
 */
public class QuestionarioSocioEconomicoJPanel extends javax.swing.JPanel implements ResultadoBusca, ActionListener {

    private final static Logger logger = LoggerFactory.getLogger(QuestionarioSocioEconomicoJPanel.class);
    private DocumentacaoTableModel modelDocumentacao;
    private ParenteTableModel modelParente;
    private Dono dono;
    private QuestionarioSocioeconomico questionario = null;

    /**
     * Creates new form QuestionarioSocioEconomicoJPanel
     */
    public QuestionarioSocioEconomicoJPanel() {
        initComponents();
        customInitComponents();
        habilitarPainelEstudante(false);
        HUMVApp.esconderMensagemCarregamento();
    }

    public QuestionarioSocioEconomicoJPanel(QuestionarioSocioeconomico questT) {
        initComponents();
        customInitComponents();
        HUMVApp.esconderMensagemCarregamento();
        this.questionario = questT;
        this.dono = questionario.getDono();
        reintroduzirDadosQuestionarioDadosDono();
        reintroduzirDocumentacoes();
        reintroduzirCobranca();
        reintroduzirAnalise();
        reintroduzirComposicaoFamiliar();
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

        buttonGroupConsulta.add(jRadioButtonConsultaD100);
        buttonGroupConsulta.add(jRadioButtonConsultaD50);
        buttonGroupConsulta.add(jRadioButtonConsultaD75);
        buttonGroupConsulta.add(jRadioButtonConsultaD25);
        buttonGroupConsulta.add(jRadioButtonConsultaNormal);
        jRadioButtonConsultaD100.addActionListener(this);
        jRadioButtonConsultaD50.addActionListener(this);
        jRadioButtonConsultaD75.addActionListener(this);
        jRadioButtonConsultaD25.addActionListener(this);
        jRadioButtonConsultaNormal.addActionListener(this);

        buttonGroupExame.add(jRadioButtonExameD100);
        buttonGroupExame.add(jRadioButtonExameD50);
        buttonGroupExame.add(jRadioButtonExameD75);
        buttonGroupExame.add(jRadioButtonExameD25);
        buttonGroupExame.add(jRadioButtonExameNormal);
        jRadioButtonExameD100.addActionListener(this);
        jRadioButtonExameD50.addActionListener(this);
        jRadioButtonExameD75.addActionListener(this);
        jRadioButtonExameD25.addActionListener(this);
        jRadioButtonExameNormal.addActionListener(this);

        buttonGroupCirurgia.add(jRadioButtonCirurgiaD100);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaD50);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaD75);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaD25);
        buttonGroupCirurgia.add(jRadioButtonCirurgiaNormal);
        jRadioButtonCirurgiaD100.addActionListener(this);
        jRadioButtonCirurgiaD50.addActionListener(this);
        jRadioButtonCirurgiaD75.addActionListener(this);
        jRadioButtonCirurgiaD25.addActionListener(this);
        
        jRadioButtonCirurgiaNormal.addActionListener(this);
        
        buttonGroupValidade.add(jRadioButtonValidadePatologia);
        buttonGroupValidade.add(jRadioButtonValidade6Meses);

        this.jRadioButtonEstudanteNao.setSelected(true);
        jRadioButtonEstudanteNao.addActionListener(this);
        jRadioButtonEstudanteSim.addActionListener(this);

        this.jRadioButtonEnergiaSim.setSelected(true);
        this.jRadioButtonSaneamentoSim.setSelected(true);
        this.jRadioButtonConsultaNormal.setSelected(true);
        this.jRadioButtonExameNormal.setSelected(true);
        this.jRadioButtonCirurgiaNormal.setSelected(true);
        this.jRadioButtonDocumentosComprovanteEndereco.setSelected(true);
        this.jRadioButtonValidadePatologia.setSelected(true);
        
        this.jRadioButtonAnimalDoadoNao.setSelected(true);
        this.jRadioButtonAtendimentoUrgenciaNao.setSelected(true);
        this.jRadioButtonDeficienciaNao.setSelected(true);
        this.jRadioButtonBeneficioSocialNao.setSelected(true);
        this.jRadioButtonDeficienciaNao.setSelected(true);
        this.jRadioButtonDependeFinanceiramenteNao.setSelected(true);
        this.jRadioButtonDoencaCronicaNao.setSelected(true);
        this.jRadioButtonEnergiaNao.setSelected(true);
        this.jRadioButtonEstudanteNao.setSelected(true);
        this.jRadioButtonNaoCondicoesParticularNao.setSelected(true);
        this.jRadioButtonTrocaDomicilioNao.setSelected(true);
        this.jRadioButtonPossuiDividasNao.setSelected(true);
        this.jRadioButtonPossuiDependenteNao.setSelected(true);
        this.jRadioButtonPrimeiroAtendimentoVeterinarioNao.setSelected(true);
        this.jRadioButtonProtecaoAnimalNao.setSelected(true);
        this.jRadioButtonQuebraDeVinculoNao.setSelected(true);
        this.jRadioButtonTrabalhadorInformalNao.setSelected(true);
        jTextFieldDocumentoOutro.setEnabled(false);
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
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_D100)) {
            this.jRadioButtonCirurgiaD100.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_D75)) {
            this.jRadioButtonCirurgiaD75.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_D50)) {
            this.jRadioButtonCirurgiaD50.setSelected(true);
        } else if (questionario.getTipoCobrancaCirurgias().equals(QuestionarioSocioeconomico.COBRANCA_D25)) {
            this.jRadioButtonCirurgiaD25.setSelected(true);
        } else {
            InterfaceGraficaUtils.erroResposta("Erro ao reinserir a forma de cobrança");
        }

        if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_NORMAL)) {
            this.jRadioButtonConsultaNormal.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_D100)) {
            this.jRadioButtonConsultaD100.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_D75)) {
            this.jRadioButtonConsultaD75.setSelected(true);
        } else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_D50)) {
            this.jRadioButtonConsultaD50.setSelected(true);
        }else if (questionario.getTipoCobrancaConsultas().equals(QuestionarioSocioeconomico.COBRANCA_D25)) {
            this.jRadioButtonConsultaD25.setSelected(true);
        }else {
            InterfaceGraficaUtils.erroResposta("Erro ao reinserir a forma de cobrança");
        }

        if (questionario.getTipoCobrancaExames().equals(QuestionarioSocioeconomico.COBRANCA_NORMAL)) {
            this.jRadioButtonExameNormal.setSelected(true);
        } else if (questionario.getTipoCobrancaExames().equals(QuestionarioSocioeconomico.COBRANCA_D100)) {
            this.jRadioButtonExameD100.setSelected(true);
        } else if (questionario.getTipoCobrancaExames().equals(QuestionarioSocioeconomico.COBRANCA_D75)) {
            this.jRadioButtonExameD75.setSelected(true);
        } else if (questionario.getTipoCobrancaExames().equals(QuestionarioSocioeconomico.COBRANCA_D50)) {
            this.jRadioButtonExameD50.setSelected(true);
        } else if (questionario.getTipoCobrancaExames().equals(QuestionarioSocioeconomico.COBRANCA_D25)) {
            this.jRadioButtonExameD25.setSelected(true);
        }
        else {
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
        setResultado(questionario.getDono());

        this.jFormattedTextFieldIdade.setText("" + questionario.getIdade());
        this.jComboBoxEstadoCivil.setSelectedIndex(questionario.getEstadoCivil()-1);
        this.jTextFieldProfissao.setText(questionario.getProfissao());
        this.jComboBoxEscolaridadeDono.setSelectedIndex(questionario.getEscolaridade()-1);
        this.jTextFieldOcupacao.setText(questionario.getOcupacaoAtual());
        this.jFormattedTextFieldRendaFormal.setText(ValidationsUtils.convertePrecoParaString(questionario.getRendaFormal()));
        this.jFormattedTextFieldRendaInformal.setText(ValidationsUtils.convertePrecoParaString(questionario.getRendaInformal()));
        this.jFormattedTextFieldAluguel.setText(ValidationsUtils.convertePrecoParaString(questionario.getValorAluguel()));
        this.jTextFieldTipoConstrucao.setText(questionario.getTipoConstrucao());
        this.jTextFieldCondicaoMoradia.setText(questionario.getCondicaoMoradia());
        this.jTextFieldProgramaRenda.setText(questionario.getProgramaTransferenciaRenda());
        if (questionario.isEstudante()) {
            this.jRadioButtonEstudanteSim.setSelected(true);
            this.jFormattedTextFieldGastosMensais.setText(ValidationsUtils.convertePrecoParaString(questionario.getGastosMensais()));
            this.jTextFieldFonteCusteio.setText(questionario.getFontCusteio());
            this.jTextFieldBeneficio.setText(questionario.getBolsaOuBeneficio());
            this.jTextAreaObservacoes.setText(questionario.getObservacoesDadosDono());
            habilitarPainelEstudante(true);
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
        
        if(questionario.isValidade6Meses()){
            this.jRadioButtonValidade6Meses.setSelected(true);
        }

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
            inserirAnimais(dono);
        }
    }

    private void inserirAnimais(Dono dono) {
        try {
            ClientResponse response = RESTMethods.get("/api/animal/searchByDono/" + dono.getId().toString());
            List<Animal> animais = (List<Animal>) RESTMethods.getObjectsFromJSON(response, new TypeReference<List<Animal>>() {
            });

            String textoLabel = "Animais: ";
            if (animais.isEmpty()) {
                textoLabel = "Animais: não cadastrados";
            } else {
                if (animais.size() == 1) {
                    textoLabel = "Animal: ";
                }
                for (Animal animal : animais) {
                    textoLabel = textoLabel + animal.getNome() + " (" + animal.getEspecie() + ")   ";
                }
            }
            jLabelAnimais.setText(textoLabel);
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(HUMVApp.getMainWindow(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            logger.error("mensagem: " + ex.getMessage(), ex);
        }
    }

    
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
        buttonGroupValidade = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDadosDono = new javax.swing.JPanel();
        jPanelDadosBasicos = new javax.swing.JPanel();
        jButtonPesquisarDono = new javax.swing.JButton();
        jLabelNomeDono = new javax.swing.JLabel();
        jLabelCpfDono = new javax.swing.JLabel();
        jButtonCadastrarNovoDono = new javax.swing.JButton();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelAnimais = new javax.swing.JLabel();
        jLabelNis = new javax.swing.JLabel();
        jFormattedTextFieldNis = new javax.swing.JFormattedTextField();
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
        dteDataEntrega = new com.toedter.calendar.JDateChooser();
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
        jLabel25 = new javax.swing.JLabel();
        jRadioButtonValidadePatologia = new javax.swing.JRadioButton();
        jRadioButtonValidade6Meses = new javax.swing.JRadioButton();
        Cobranca = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jRadioButtonConsultaNormal = new javax.swing.JRadioButton();
        jRadioButtonConsultaD100 = new javax.swing.JRadioButton();
        jRadioButtonConsultaD75 = new javax.swing.JRadioButton();
        jRadioButtonConsultaD50 = new javax.swing.JRadioButton();
        jRadioButtonExameNormal = new javax.swing.JRadioButton();
        jRadioButtonExameD100 = new javax.swing.JRadioButton();
        jRadioButtonExameD75 = new javax.swing.JRadioButton();
        jRadioButtonExameD50 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaNormal = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD100 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD75 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD50 = new javax.swing.JRadioButton();
        jRadioButtonConsultaD25 = new javax.swing.JRadioButton();
        jRadioButtonExameD25 = new javax.swing.JRadioButton();
        jRadioButtonCirurgiaD25 = new javax.swing.JRadioButton();
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
        jButtonFamiliaRemover = new javax.swing.JButton();
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
        jPanelSituacaoSocial = new javax.swing.JPanel();
        jRadioButtonDependeFinanceiramenteSim = new javax.swing.JRadioButton();
        jRadioButtonDependeFinanceiramenteNao = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jRadioButtonPossuiDependenteSim = new javax.swing.JRadioButton();
        jRadioButtonPossuiDependenteNao = new javax.swing.JRadioButton();
        jRadioButtonDoencaCronicaSim = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        jRadioButtonDoencaCronicaNao = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        jRadioButtonDeficienciaSim = new javax.swing.JRadioButton();
        jRadioButtonDeficienciaNao = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jRadioButtonTrabalhadorInformalSim = new javax.swing.JRadioButton();
        jRadioButtonTrabalhadorInformalNao = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        jRadioButtonQuebraDeVinculoSim = new javax.swing.JRadioButton();
        jRadioButtonQuebraDeVinculoNao = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        jRadioButtonSituacaoIncapacitanteSim = new javax.swing.JRadioButton();
        jRadioButtonSituacaoIncapacitanteNao = new javax.swing.JRadioButton();
        jRadioButtonPossuiDividasSim = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jRadioButtonPossuiDividasNao = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        jRadioButtonBeneficioSocialSim = new javax.swing.JRadioButton();
        jRadioButtonBeneficioSocialNao = new javax.swing.JRadioButton();
        jLabel53 = new javax.swing.JLabel();
        jRadioButtonTrocaDomicilioSim = new javax.swing.JRadioButton();
        jRadioButtonTrocaDomicilioNao = new javax.swing.JRadioButton();
        jLabel54 = new javax.swing.JLabel();
        jRadioButtonProtecaoAnimalSim = new javax.swing.JRadioButton();
        jRadioButtonProtecaoAnimalNao = new javax.swing.JRadioButton();
        jLabel55 = new javax.swing.JLabel();
        jRadioButtonPrimeiroAtendimentoVeterinarioSim = new javax.swing.JRadioButton();
        jRadioButtonPrimeiroAtendimentoVeterinarioNao = new javax.swing.JRadioButton();
        jLabel56 = new javax.swing.JLabel();
        jRadioButtonAnimalDoadoSim = new javax.swing.JRadioButton();
        jRadioButtonAnimalDoadoNao = new javax.swing.JRadioButton();
        jLabel57 = new javax.swing.JLabel();
        jRadioButtonAtendimentoUrgenciaSim = new javax.swing.JRadioButton();
        jRadioButtonAtendimentoUrgenciaNao = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jRadioButtonNaoCondicoesParticularSim = new javax.swing.JRadioButton();
        jRadioButtonNaoCondicoesParticularNao = new javax.swing.JRadioButton();
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

        jLabelAnimais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAnimais.setText("Animais:");

        jLabelNis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNis.setText("NIS:");

        jFormattedTextFieldNis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

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
                    .addComponent(jLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosBasicosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNomeDono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCpfDono, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosBasicosLayout.createSequentialGroup()
                                .addComponent(jLabelNis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldNis)))))
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
                .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeDono)
                    .addComponent(jLabelNis)
                    .addComponent(jFormattedTextFieldNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosBasicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpfDono)
                    .addComponent(jLabelTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAnimais)
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
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do dono", jPanelDadosDono);

        jLabel31.setText("Documento:");

        jLabel32.setText("Data de entrega: ");

        jButtonDocumentoSalvar.setText("Salvar");
        jButtonDocumentoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTabelaDocumentosSalvarActionPerformed(evt);
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
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckBoxNA, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxVistoASocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dteDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanelDocumentosLayout.setVerticalGroup(
            jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                .addGroup(jPanelDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonDocumentosComprovanteEndereco))
                    .addGroup(jPanelDocumentosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dteDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(261, Short.MAX_VALUE))
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

        jLabel25.setText("Validade:");

        jRadioButtonValidadePatologia.setText("Durante o tratamento da patologia apresentada");

        jRadioButtonValidade6Meses.setText("Durante 6 meses");

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
                            .addComponent(jLabel35)
                            .addGroup(jPanelAnaliseLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonValidadePatologia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonValidade6Meses)))
                        .addGap(0, 44, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanelAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jRadioButtonValidadePatologia)
                    .addComponent(jRadioButtonValidade6Meses))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Análise", jPanelAnalise);

        jLabel38.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Tipo de cobrança");

        jLabel39.setText("Consultas:");

        jLabel40.setText("Procedimentos ambulatórios/exames:");

        jLabel41.setText("Cirurgia/reprodução:");

        jRadioButtonConsultaNormal.setText("Valor normal");

        jRadioButtonConsultaD100.setText("D100%");

        jRadioButtonConsultaD75.setText("D75%");

        jRadioButtonConsultaD50.setText("D50%");

        jRadioButtonExameNormal.setText("Valor normal");

        jRadioButtonExameD100.setText("D100%");

        jRadioButtonExameD75.setText("D75%");

        jRadioButtonExameD50.setText("D50%");

        jRadioButtonCirurgiaNormal.setText("Valor normal");

        jRadioButtonCirurgiaD100.setText("D100%");

        jRadioButtonCirurgiaD75.setText("D75%");

        jRadioButtonCirurgiaD50.setText("D50%");

        jRadioButtonConsultaD25.setText("D25%");

        jRadioButtonExameD25.setText("D25%");

        jRadioButtonCirurgiaD25.setText("D25%");

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
                        .addComponent(jRadioButtonConsultaD100)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaD75)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaD50)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonConsultaD25))
                    .addGroup(CobrancaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonExameNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameD100)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameD75)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameD50)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonExameD25))
                    .addGroup(CobrancaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonCirurgiaNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaD100)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaD75)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaD50)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonCirurgiaD25)))
                .addContainerGap(282, Short.MAX_VALUE))
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
                    .addComponent(jRadioButtonConsultaD100)
                    .addComponent(jRadioButtonConsultaD75)
                    .addComponent(jRadioButtonConsultaD50)
                    .addComponent(jRadioButtonConsultaD25))
                .addGap(18, 18, 18)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonExameNormal)
                    .addComponent(jRadioButtonExameD100)
                    .addComponent(jRadioButtonExameD75)
                    .addComponent(jRadioButtonExameD50)
                    .addComponent(jRadioButtonExameD25))
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCirurgiaNormal)
                    .addComponent(jRadioButtonCirurgiaD100)
                    .addComponent(jRadioButtonCirurgiaD75)
                    .addComponent(jRadioButtonCirurgiaD50)
                    .addComponent(jRadioButtonCirurgiaD25))
                .addContainerGap(510, Short.MAX_VALUE))
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
                jButtonTabelaFamiliaSalvarActionPerformed(evt);
            }
        });

        jButtonFamiliaRemover.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonFamiliaRemover.setText("Remover");
        jButtonFamiliaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFamiliaRemoverActionPerformed(evt);
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
                                .addComponent(jButtonFamiliaRemover)
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
                    .addComponent(jButtonFamiliaRemover)
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

        jRadioButtonDependeFinanceiramenteSim.setText("Sim");
        jRadioButtonDependeFinanceiramenteSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDependeFinanceiramenteSimActionPerformed(evt);
            }
        });

        jRadioButtonDependeFinanceiramenteNao.setText("Não");

        jLabel26.setText("Depende financeiramente de alguém?");

        jLabel45.setText("Possui algum dependente financeiro?");

        jRadioButtonPossuiDependenteSim.setText("Sim");

        jRadioButtonPossuiDependenteNao.setText("Não");
        jRadioButtonPossuiDependenteNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPossuiDependenteNaoActionPerformed(evt);
            }
        });

        jRadioButtonDoencaCronicaSim.setText("Sim");
        jRadioButtonDoencaCronicaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDoencaCronicaSimActionPerformed(evt);
            }
        });

        jLabel46.setText("Algum membro da familia com doença crônica ou situação que requer gastos com tratameno?");

        jRadioButtonDoencaCronicaNao.setText("Não");
        jRadioButtonDoencaCronicaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDoencaCronicaNaoActionPerformed(evt);
            }
        });

        jLabel47.setText("Algum membro idoso ou com alguma deficiencia ou dependencia quimica?");

        jRadioButtonDeficienciaSim.setText("Sim");
        jRadioButtonDeficienciaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeficienciaSimActionPerformed(evt);
            }
        });

        jRadioButtonDeficienciaNao.setText("Não");
        jRadioButtonDeficienciaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeficienciaNaoActionPerformed(evt);
            }
        });

        jLabel48.setText("Trabalhador informal e/ou sem renda fixa?");

        jRadioButtonTrabalhadorInformalSim.setText("Sim");
        jRadioButtonTrabalhadorInformalSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTrabalhadorInformalSimActionPerformed(evt);
            }
        });

        jRadioButtonTrabalhadorInformalNao.setText("Não");
        jRadioButtonTrabalhadorInformalNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTrabalhadorInformalNaoActionPerformed(evt);
            }
        });

        jLabel49.setText("Alguma situação de quebra de vinculo (separação, divorcio, morte) ou outros?");

        jRadioButtonQuebraDeVinculoSim.setText("Sim");
        jRadioButtonQuebraDeVinculoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonQuebraDeVinculoSimActionPerformed(evt);
            }
        });

        jRadioButtonQuebraDeVinculoNao.setText("Não");
        jRadioButtonQuebraDeVinculoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonQuebraDeVinculoNaoActionPerformed(evt);
            }
        });

        jLabel50.setText("Alguma situação incapacitante para o trabalho? ");

        jRadioButtonSituacaoIncapacitanteSim.setText("Sim");
        jRadioButtonSituacaoIncapacitanteSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSituacaoIncapacitanteSimActionPerformed(evt);
            }
        });

        jRadioButtonSituacaoIncapacitanteNao.setText("Não");
        jRadioButtonSituacaoIncapacitanteNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSituacaoIncapacitanteNaoActionPerformed(evt);
            }
        });

        jRadioButtonPossuiDividasSim.setText("Sim");
        jRadioButtonPossuiDividasSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPossuiDividasSimActionPerformed(evt);
            }
        });

        jLabel51.setText("Possui dividas no banco/emprestimos que possam comprometer a renda?");

        jRadioButtonPossuiDividasNao.setText("Não");
        jRadioButtonPossuiDividasNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPossuiDividasNaoActionPerformed(evt);
            }
        });

        jLabel52.setText("Possui algum beneficio social? ");

        jRadioButtonBeneficioSocialSim.setText("Sim");
        jRadioButtonBeneficioSocialSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBeneficioSocialSimActionPerformed(evt);
            }
        });

        jRadioButtonBeneficioSocialNao.setText("Não");
        jRadioButtonBeneficioSocialNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBeneficioSocialNaoActionPerformed(evt);
            }
        });

        jLabel53.setText("Alguma situação de troca de domicilio? ");

        jRadioButtonTrocaDomicilioSim.setText("Sim");
        jRadioButtonTrocaDomicilioSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTrocaDomicilioSimActionPerformed(evt);
            }
        });

        jRadioButtonTrocaDomicilioNao.setText("Não");
        jRadioButtonTrocaDomicilioNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTrocaDomicilioNaoActionPerformed(evt);
            }
        });

        jLabel54.setText("Usuário atua na proteção animal?");

        jRadioButtonProtecaoAnimalSim.setText("Sim");
        jRadioButtonProtecaoAnimalSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProtecaoAnimalSimActionPerformed(evt);
            }
        });

        jRadioButtonProtecaoAnimalNao.setText("Não");
        jRadioButtonProtecaoAnimalNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProtecaoAnimalNaoActionPerformed(evt);
            }
        });

        jLabel55.setText("Primeiro atendimento veterinário do animal?");

        jRadioButtonPrimeiroAtendimentoVeterinarioSim.setText("Sim");
        jRadioButtonPrimeiroAtendimentoVeterinarioSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPrimeiroAtendimentoVeterinarioSimActionPerformed(evt);
            }
        });

        jRadioButtonPrimeiroAtendimentoVeterinarioNao.setText("Não");
        jRadioButtonPrimeiroAtendimentoVeterinarioNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPrimeiroAtendimentoVeterinarioNaoActionPerformed(evt);
            }
        });

        jLabel56.setText("Animal doado ou resgatado?");

        jRadioButtonAnimalDoadoSim.setText("Sim");
        jRadioButtonAnimalDoadoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAnimalDoadoSimActionPerformed(evt);
            }
        });

        jRadioButtonAnimalDoadoNao.setText("Não");
        jRadioButtonAnimalDoadoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAnimalDoadoNaoActionPerformed(evt);
            }
        });

        jLabel57.setText("Atendimento do animal foi de urgência? ");

        jRadioButtonAtendimentoUrgenciaSim.setText("Sim");
        jRadioButtonAtendimentoUrgenciaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAtendimentoUrgenciaSimActionPerformed(evt);
            }
        });

        jRadioButtonAtendimentoUrgenciaNao.setText("Não");
        jRadioButtonAtendimentoUrgenciaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAtendimentoUrgenciaNaoActionPerformed(evt);
            }
        });

        jLabel58.setText("Não teria condições de acessar a rede particular?");

        jRadioButtonNaoCondicoesParticularSim.setText("Sim");
        jRadioButtonNaoCondicoesParticularSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNaoCondicoesParticularSimActionPerformed(evt);
            }
        });

        jRadioButtonNaoCondicoesParticularNao.setText("Não");
        jRadioButtonNaoCondicoesParticularNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNaoCondicoesParticularNaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSituacaoSocialLayout = new javax.swing.GroupLayout(jPanelSituacaoSocial);
        jPanelSituacaoSocial.setLayout(jPanelSituacaoSocialLayout);
        jPanelSituacaoSocialLayout.setHorizontalGroup(
            jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(jLabel49)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonNaoCondicoesParticularSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonNaoCondicoesParticularNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonAtendimentoUrgenciaSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonAtendimentoUrgenciaNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonAnimalDoadoSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonAnimalDoadoNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonProtecaoAnimalSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonProtecaoAnimalNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonTrocaDomicilioSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonTrocaDomicilioNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonBeneficioSocialSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonBeneficioSocialNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonPossuiDividasSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonPossuiDividasNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonSituacaoIncapacitanteSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonSituacaoIncapacitanteNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonQuebraDeVinculoSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonQuebraDeVinculoNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonTrabalhadorInformalSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonTrabalhadorInformalNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDeficienciaSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDeficienciaNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDependeFinanceiramenteSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDependeFinanceiramenteNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonPossuiDependenteSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonPossuiDependenteNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDoencaCronicaSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDoencaCronicaNao))
                    .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                        .addComponent(jRadioButtonPrimeiroAtendimentoVeterinarioSim)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonPrimeiroAtendimentoVeterinarioNao)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanelSituacaoSocialLayout.setVerticalGroup(
            jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSituacaoSocialLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDependeFinanceiramenteSim)
                    .addComponent(jRadioButtonDependeFinanceiramenteNao)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jRadioButtonPossuiDependenteSim)
                    .addComponent(jRadioButtonPossuiDependenteNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jRadioButtonDoencaCronicaSim)
                    .addComponent(jRadioButtonDoencaCronicaNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jRadioButtonDeficienciaSim)
                    .addComponent(jRadioButtonDeficienciaNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jRadioButtonTrabalhadorInformalSim)
                    .addComponent(jRadioButtonTrabalhadorInformalNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jRadioButtonQuebraDeVinculoSim)
                    .addComponent(jRadioButtonQuebraDeVinculoNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSituacaoIncapacitanteSim)
                    .addComponent(jLabel50)
                    .addComponent(jRadioButtonSituacaoIncapacitanteNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPossuiDividasSim)
                    .addComponent(jLabel51)
                    .addComponent(jRadioButtonPossuiDividasNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jRadioButtonBeneficioSocialSim)
                    .addComponent(jRadioButtonBeneficioSocialNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jRadioButtonTrocaDomicilioSim)
                    .addComponent(jRadioButtonTrocaDomicilioNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jRadioButtonProtecaoAnimalSim)
                    .addComponent(jRadioButtonProtecaoAnimalNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jRadioButtonPrimeiroAtendimentoVeterinarioSim)
                    .addComponent(jRadioButtonPrimeiroAtendimentoVeterinarioNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jRadioButtonAnimalDoadoSim)
                    .addComponent(jRadioButtonAnimalDoadoNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jRadioButtonAtendimentoUrgenciaSim)
                    .addComponent(jRadioButtonAtendimentoUrgenciaNao))
                .addGap(18, 18, 18)
                .addGroup(jPanelSituacaoSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jRadioButtonNaoCondicoesParticularSim)
                    .addComponent(jRadioButtonNaoCondicoesParticularNao))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Situação social", jPanelSituacaoSocial);

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

    private void jButtonTabelaDocumentosSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTabelaDocumentosSalvarActionPerformed
        String nomeDocumento = "";
        Date data;
        try {
            if (this.jRadioButtonDocumentosOutro.isSelected()) {
                validarCampoVazio(jTextFieldDocumentoOutro, "nome do documento");
                nomeDocumento = jTextFieldDocumentoOutro.getText();
            } else if (this.jRadioButtonDocumentosBolsaFamilia.isSelected()) {
                nomeDocumento = DocumentoComprovante.BOLSA_FAMILIA;
            } else if (jRadioButtonDocumentosComprovanteEndereco.isSelected()) {
                nomeDocumento = DocumentoComprovante.COMPROVANTE_ENDERECO;
            } else if (jRadioButtonDocumentosMembroFamilia.isSelected()) {
                nomeDocumento = DocumentoComprovante.RG_MEMBRO_FAMILIA;
            } else if (jRadioButtonDocumentosRGDono.isSelected()) {
                nomeDocumento = DocumentoComprovante.RG_DONO;
            }

            data = this.dteDataEntrega.getDate();
            DocumentoComprovante doc = new DocumentoComprovante();
            doc.setDataEntrega(data);
            doc.setNomeDocumento(nomeDocumento);
            doc.setNomeUsuarioRecebinte(HUMVApp.getNomeUsuario());
            doc.setNa(jCheckBoxNA.isSelected());
            doc.setVistoAssistenteSocial(jCheckBoxVistoASocial.isSelected());
            //doc.setQuestionario(questionario);
            modelDocumentacao.addDocumento(doc);
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
            String mensagem = InterfaceGraficaUtils.getMensagemValidaCampoVazio(ex.getMessage());
            logger.error("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem, ex);
        }
    }//GEN-LAST:event_jButtonTabelaDocumentosSalvarActionPerformed

    private void jButtonDocumentoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentoRemoverActionPerformed
        Integer indexRemover = this.jTableDocumentos.getSelectedRow();
        this.modelDocumentacao.removerDocumento(indexRemover);
    }//GEN-LAST:event_jButtonDocumentoRemoverActionPerformed

    private void jButtonQuestionarioCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "questionário socioeconômico");
        if (sair) {
            System.gc();
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_jButtonQuestionarioCancelarActionPerformed

    private void jButtonQuestionarioSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuestionarioSalvarActionPerformed

        boolean cadastrar = true;

        if (questionario != null) {
            cadastrar = false;
        } else {
            questionario = new QuestionarioSocioeconomico();
        }

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
            if (cadastrar) {
                RESTMethods.post("/api/questionarioSocioeconomico", questionario);
                InterfaceGraficaUtils.sucessoCadastro("questionário socioeconômico");
            } else {
                RESTMethods.put("/api/questionarioSocioeconomico", questionario);
                InterfaceGraficaUtils.sucessoAtualizacao("questionário socioeconômico");
            }
            HUMVApp.setPainelCentralComLogo();
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            logger.error("mensagem: " + ex.getMessage(), ex);

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
            String mensagem = InterfaceGraficaUtils.getMensagemValidaCampoVazio(ex.getMessage());
            logger.error("mensagem: " + ex.getMessage(), ex);
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
            String mensagem = InterfaceGraficaUtils.getMensagemValidaCampoVazio(ex.getMessage());
            logger.error("mensagem: " + ex.getMessage(), ex);
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
        if (this.jRadioButtonConsultaD100.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_D100;
        } else if (this.jRadioButtonConsultaNormal.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonConsultaD75.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_D75;
        } else if (this.jRadioButtonConsultaD50.isSelected()) {
            consulta = QuestionarioSocioeconomico.COBRANCA_D50;
        }else {
            consulta = QuestionarioSocioeconomico.COBRANCA_D25;
        }
        questionario.setTipoCobrancaConsultas(consulta);
    }

    private void setValorTipoExame() {
        Integer exame;
        if (this.jRadioButtonExameD100.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_D100;
        } else if (this.jRadioButtonExameNormal.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonExameD75.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_D75;
        }else if (this.jRadioButtonExameD50.isSelected()) {
            exame = QuestionarioSocioeconomico.COBRANCA_D50;
        } else {
            exame = QuestionarioSocioeconomico.COBRANCA_D25;
        }
        questionario.setTipoCobrancaExames(exame);
    }

    private void setValorTipoCirugia() {
        Integer cirugia;
        if (this.jRadioButtonCirurgiaD100.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_D100;
        } else if (this.jRadioButtonCirurgiaNormal.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_NORMAL;
        } else if (this.jRadioButtonCirurgiaD75.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_D75;
        } else if (this.jRadioButtonCirurgiaD50.isSelected()) {
            cirugia = QuestionarioSocioeconomico.COBRANCA_D50;
        } else {
            cirugia = QuestionarioSocioeconomico.COBRANCA_D25;
        }
        questionario.setTipoCobrancaCirurgias(cirugia);
    }

    private boolean validarDadosDoDono() {

        try {
            validarCampoVazio(jFormattedTextFieldIdade, "idade");
            validarCampoVazio(jFormattedTextFieldNis, "NIS");
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
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
            String mensagem = InterfaceGraficaUtils.getMensagemValidaCampoVazio(ex.getMessage());
            logger.error("mensagem: " + ex.getMessage(), ex);
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
            questionario.setFontCusteio(jTextFieldFonteCusteio.getText());
            questionario.setBolsaOuBeneficio(jTextFieldBeneficio.getText());
            questionario.setObservacoesDadosDono(jTextAreaObservacoes.getText());
        } else {
            questionario.setGastosMensais(null);
            questionario.setFontCusteio(null);
            questionario.setBolsaOuBeneficio(null);
            questionario.setObservacoesDadosDono(null);
        }

        questionario.setDono(dono);
        questionario.setDataResposta(Calendar.getInstance().getTime());
        questionario.setIdade(Integer.parseInt(jFormattedTextFieldIdade.getText()));
        questionario.setNis(Integer.parseInt(jFormattedTextFieldNis.getText()));
        questionario.setEstadoCivil(jComboBoxEstadoCivil.getSelectedIndex()+1);
        questionario.setProfissao(jTextFieldProfissao.getText());
        questionario.setEscolaridade(jComboBoxEscolaridadeDono.getSelectedIndex()+1);
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
        questionario.setRendaTotal(modelParente.getRendaTotal());
        questionario.setRendaPerCapta(modelParente.getRendaPerCapita());
        questionario.setValidade6Meses(jRadioButtonValidade6Meses.isSelected());

        return true;
    }

    private void jButtonTabelaFamiliaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTabelaFamiliaSalvarActionPerformed

        try {
            Parente parente = new Parente();

            validarCampoVazio(jTextFieldFamiliaNome, "nome do familiar");
            parente.setNome(jTextFieldFamiliaNome.getText());

            if (this.jFormattedIdadeFamilia.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("idade do familiar");
                return;
            }
            int idade = Integer.parseInt(this.jFormattedIdadeFamilia.getText());
            parente.setIdade(idade);

            if (this.jTextFieldParentesco.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("parentesco do familiar");
                return;
            }
            String parentesco = this.jTextFieldParentesco.getText();
            parente.setParentesco(parentesco);

            int escolaridade = this.jComboBoxEscolaridadeFamliar.getSelectedIndex()+1;
            parente.setEscolaridade(escolaridade);

            if (this.jTextFieldFamiliaOcupacao.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("ocupação do familiar");
                return;
            }
            String ocupacao = this.jTextFieldFamiliaOcupacao.getText();
            parente.setOcupacao(ocupacao);
            if (this.jTextFieldFamiliaRenda.getText().isEmpty()) {
                InterfaceGraficaUtils.validaCampoVazio("renda do familiar");
                return;
            }
            Double renda;
            String rendaFamilliarST = jTextFieldFamiliaRenda.getText();
            renda = ValidationsUtils.converteStringParaPreco(rendaFamilliarST);
            parente.setRenda(renda);
            //parente.setQuestionario(questionario);
            modelParente.addParente(parente);
            limparTextfieldsInfoFamiliar();
            atualizaCalculoRenda();
        } catch (Exception ex) {
            InterfaceGraficaUtils.validaCampoVazio(ex.getMessage());
            String mensagem = InterfaceGraficaUtils.getMensagemValidaCampoVazio(ex.getMessage());
            logger.error("mensagem: " + ex.getMessage(), ex);
        }

    }//GEN-LAST:event_jButtonTabelaFamiliaSalvarActionPerformed

    private void jButtonFamiliaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFamiliaRemoverActionPerformed
        Integer indexRemover = this.jTableFamiliares.getSelectedRow();
        this.modelParente.removerParentes(indexRemover);
    }//GEN-LAST:event_jButtonFamiliaRemoverActionPerformed

    private void jRadioButtonDoencaCronicaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDoencaCronicaSimActionPerformed
        questionario.setDoencaCronica(true);
        jRadioButtonDoencaCronicaNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDoencaCronicaSimActionPerformed

    private void jRadioButtonDoencaCronicaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDoencaCronicaNaoActionPerformed
        questionario.setDoencaCronica(false);
        jRadioButtonDoencaCronicaSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDoencaCronicaNaoActionPerformed

    private void jRadioButtonTrabalhadorInformalSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTrabalhadorInformalSimActionPerformed
        questionario.setTrabalhadorInformal(true);
        jRadioButtonTrabalhadorInformalNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonTrabalhadorInformalSimActionPerformed

    private void jRadioButtonDependeFinanceiramenteSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDependeFinanceiramenteSimActionPerformed
        questionario.setDependeFinanceiramente(true);
        jRadioButtonDeficienciaNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDependeFinanceiramenteSimActionPerformed

    private void jRadioButtonPossuiDependenteNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPossuiDependenteNaoActionPerformed
        questionario.setDependeFinanceiramente(false);
        jRadioButtonDeficienciaSim.setSelected(false);

    }//GEN-LAST:event_jRadioButtonPossuiDependenteNaoActionPerformed

    private void jRadioButtonDeficienciaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeficienciaSimActionPerformed
        questionario.setDeficiencia(true);
        jRadioButtonDeficienciaNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDeficienciaSimActionPerformed

    private void jRadioButtonDeficienciaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeficienciaNaoActionPerformed
        questionario.setDeficiencia(false);
        jRadioButtonDeficienciaSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDeficienciaNaoActionPerformed

    private void jRadioButtonTrabalhadorInformalNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTrabalhadorInformalNaoActionPerformed
        questionario.setTrabalhadorInformal(false);
        jRadioButtonTrabalhadorInformalSim.setSelected(false);

    }//GEN-LAST:event_jRadioButtonTrabalhadorInformalNaoActionPerformed

    private void jRadioButtonQuebraDeVinculoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonQuebraDeVinculoSimActionPerformed
        questionario.setQuebraVinculo(true);
        jRadioButtonQuebraDeVinculoNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonQuebraDeVinculoSimActionPerformed

    private void jRadioButtonQuebraDeVinculoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonQuebraDeVinculoNaoActionPerformed
        questionario.setQuebraVinculo(false);
        jRadioButtonQuebraDeVinculoSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonQuebraDeVinculoNaoActionPerformed

    private void jRadioButtonSituacaoIncapacitanteSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSituacaoIncapacitanteSimActionPerformed
        questionario.setSituacaoIncapacitante(true);
        jRadioButtonSituacaoIncapacitanteNao.setSelected(false);

    }//GEN-LAST:event_jRadioButtonSituacaoIncapacitanteSimActionPerformed

    private void jRadioButtonSituacaoIncapacitanteNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSituacaoIncapacitanteNaoActionPerformed
        questionario.setSituacaoIncapacitante(false);
        jRadioButtonSituacaoIncapacitanteSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSituacaoIncapacitanteNaoActionPerformed

    private void jRadioButtonPossuiDividasSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPossuiDividasSimActionPerformed
        questionario.setDividasBanco(true);
        jRadioButtonPossuiDividasNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonPossuiDividasSimActionPerformed

    private void jRadioButtonPossuiDividasNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPossuiDividasNaoActionPerformed
        questionario.setDividasBanco(false);
        jRadioButtonPossuiDividasSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonPossuiDividasNaoActionPerformed

    private void jRadioButtonBeneficioSocialSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBeneficioSocialSimActionPerformed
        questionario.setBeneficioSocial(true);
        jRadioButtonBeneficioSocialNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonBeneficioSocialSimActionPerformed

    private void jRadioButtonBeneficioSocialNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBeneficioSocialNaoActionPerformed
        questionario.setBeneficioSocial(false);
        jRadioButtonBeneficioSocialSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonBeneficioSocialNaoActionPerformed

    private void jRadioButtonTrocaDomicilioSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTrocaDomicilioSimActionPerformed
        questionario.setTrocaDomicilio(true);
        jRadioButtonTrocaDomicilioNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonTrocaDomicilioSimActionPerformed

    private void jRadioButtonTrocaDomicilioNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTrocaDomicilioNaoActionPerformed
        questionario.setTrocaDomicilio(false);
        jRadioButtonTrocaDomicilioSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonTrocaDomicilioNaoActionPerformed

    private void jRadioButtonProtecaoAnimalSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProtecaoAnimalSimActionPerformed
        questionario.setProtecaoAnimal(true);
        jRadioButtonProtecaoAnimalNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonProtecaoAnimalSimActionPerformed

    private void jRadioButtonProtecaoAnimalNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProtecaoAnimalNaoActionPerformed
        questionario.setProtecaoAnimal(false);
        jRadioButtonProtecaoAnimalSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonProtecaoAnimalNaoActionPerformed

    private void jRadioButtonPrimeiroAtendimentoVeterinarioSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPrimeiroAtendimentoVeterinarioSimActionPerformed
        questionario.setPrimeiroAtendimento(true);
        jRadioButtonPrimeiroAtendimentoVeterinarioNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonPrimeiroAtendimentoVeterinarioSimActionPerformed

    private void jRadioButtonPrimeiroAtendimentoVeterinarioNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPrimeiroAtendimentoVeterinarioNaoActionPerformed
        questionario.setPrimeiroAtendimento(false);
        jRadioButtonPrimeiroAtendimentoVeterinarioSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonPrimeiroAtendimentoVeterinarioNaoActionPerformed

    private void jRadioButtonAnimalDoadoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAnimalDoadoSimActionPerformed
        questionario.setAnimalDoado(true);
        jRadioButtonAnimalDoadoNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonAnimalDoadoSimActionPerformed

    private void jRadioButtonAnimalDoadoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAnimalDoadoNaoActionPerformed
        questionario.setAnimalDoado(false);
        jRadioButtonAnimalDoadoSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonAnimalDoadoNaoActionPerformed

    private void jRadioButtonAtendimentoUrgenciaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAtendimentoUrgenciaSimActionPerformed
        questionario.setAtendimentoUrgencia(true);
        jRadioButtonAtendimentoUrgenciaNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonAtendimentoUrgenciaSimActionPerformed

    private void jRadioButtonAtendimentoUrgenciaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAtendimentoUrgenciaNaoActionPerformed
        questionario.setAtendimentoUrgencia(false);
        jRadioButtonAtendimentoUrgenciaSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonAtendimentoUrgenciaNaoActionPerformed

    private void jRadioButtonNaoCondicoesParticularSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNaoCondicoesParticularSimActionPerformed
        questionario.setNaoCondicoesParticular(true);
        jRadioButtonNaoCondicoesParticularNao.setSelected(false);
    }//GEN-LAST:event_jRadioButtonNaoCondicoesParticularSimActionPerformed

    private void jRadioButtonNaoCondicoesParticularNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNaoCondicoesParticularNaoActionPerformed
        questionario.setNaoCondicoesParticular(false);
        jRadioButtonNaoCondicoesParticularSim.setSelected(false);
    }//GEN-LAST:event_jRadioButtonNaoCondicoesParticularNaoActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jRadioButtonEstudanteSim) || e.getSource().equals(jRadioButtonEstudanteNao)) {
            if (jRadioButtonEstudanteSim.isSelected()) {
                habilitarPainelEstudante(true);
            } else {
                habilitarPainelEstudante(false);
            }
        } else if (e.getSource().equals(jRadioButtonConsultaD100) || e.getSource().equals(jRadioButtonConsultaD50)
                || e.getSource().equals(jRadioButtonConsultaD75) || e.getSource().equals(jRadioButtonConsultaNormal)
                || e.getSource().equals(jRadioButtonExameD100) || e.getSource().equals(jRadioButtonExameD50)
                || e.getSource().equals(jRadioButtonExameD75) || e.getSource().equals(jRadioButtonExameNormal)
                || e.getSource().equals(jRadioButtonCirurgiaD100) || e.getSource().equals(jRadioButtonCirurgiaD50)
                || e.getSource().equals(jRadioButtonCirurgiaD75) || e.getSource().equals(jRadioButtonCirurgiaNormal)) {

        

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
    private javax.swing.ButtonGroup buttonGroupValidade;
    private com.toedter.calendar.JDateChooser dteDataEntrega;
    private javax.swing.JButton jButtonCadastrarNovoDono;
    private javax.swing.JButton jButtonDocumentoRemover;
    private javax.swing.JButton jButtonDocumentoSalvar;
    private javax.swing.JButton jButtonFamiliaRemover;
    private javax.swing.JButton jButtonPesquisarDono;
    private javax.swing.JButton jButtonQuestionarioCancelar;
    private javax.swing.JButton jButtonQuestionarioSalvar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxNA;
    private javax.swing.JCheckBox jCheckBoxVistoASocial;
    private javax.swing.JComboBox<String> jComboBoxEscolaridadeDono;
    private javax.swing.JComboBox<String> jComboBoxEscolaridadeFamliar;
    private javax.swing.JComboBox<String> jComboBoxEstadoCivil;
    private javax.swing.JFormattedTextField jFormattedIdadeFamilia;
    private javax.swing.JFormattedTextField jFormattedTextFieldAluguel;
    private javax.swing.JFormattedTextField jFormattedTextFieldGastosMensais;
    private javax.swing.JFormattedTextField jFormattedTextFieldIdade;
    private javax.swing.JFormattedTextField jFormattedTextFieldNis;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAnimais;
    private javax.swing.JLabel jLabelCpfDono;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelFamiliaRendaPerCapita;
    private javax.swing.JLabel jLabelFamiliaRendaTotal;
    private javax.swing.JLabel jLabelNis;
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
    private javax.swing.JPanel jPanelSituacaoSocial;
    private javax.swing.JRadioButton jRadioButtonAnimalDoadoNao;
    private javax.swing.JRadioButton jRadioButtonAnimalDoadoSim;
    private javax.swing.JRadioButton jRadioButtonAtendimentoUrgenciaNao;
    private javax.swing.JRadioButton jRadioButtonAtendimentoUrgenciaSim;
    private javax.swing.JRadioButton jRadioButtonBeneficioSocialNao;
    private javax.swing.JRadioButton jRadioButtonBeneficioSocialSim;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD100;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD25;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD50;
    private javax.swing.JRadioButton jRadioButtonCirurgiaD75;
    private javax.swing.JRadioButton jRadioButtonCirurgiaNormal;
    private javax.swing.JRadioButton jRadioButtonConsultaD100;
    private javax.swing.JRadioButton jRadioButtonConsultaD25;
    private javax.swing.JRadioButton jRadioButtonConsultaD50;
    private javax.swing.JRadioButton jRadioButtonConsultaD75;
    private javax.swing.JRadioButton jRadioButtonConsultaNormal;
    private javax.swing.JRadioButton jRadioButtonDeficienciaNao;
    private javax.swing.JRadioButton jRadioButtonDeficienciaSim;
    private javax.swing.JRadioButton jRadioButtonDependeFinanceiramenteNao;
    private javax.swing.JRadioButton jRadioButtonDependeFinanceiramenteSim;
    private javax.swing.JRadioButton jRadioButtonDocumentosBolsaFamilia;
    private javax.swing.JRadioButton jRadioButtonDocumentosComprovanteEndereco;
    private javax.swing.JRadioButton jRadioButtonDocumentosMembroFamilia;
    private javax.swing.JRadioButton jRadioButtonDocumentosOutro;
    private javax.swing.JRadioButton jRadioButtonDocumentosRGDono;
    private javax.swing.JRadioButton jRadioButtonDoencaCronicaNao;
    private javax.swing.JRadioButton jRadioButtonDoencaCronicaSim;
    private javax.swing.JRadioButton jRadioButtonEnergiaNao;
    private javax.swing.JRadioButton jRadioButtonEnergiaSim;
    private javax.swing.JRadioButton jRadioButtonEstudanteNao;
    private javax.swing.JRadioButton jRadioButtonEstudanteSim;
    private javax.swing.JRadioButton jRadioButtonExameD100;
    private javax.swing.JRadioButton jRadioButtonExameD25;
    private javax.swing.JRadioButton jRadioButtonExameD50;
    private javax.swing.JRadioButton jRadioButtonExameD75;
    private javax.swing.JRadioButton jRadioButtonExameNormal;
    private javax.swing.JRadioButton jRadioButtonNaoCondicoesParticularNao;
    private javax.swing.JRadioButton jRadioButtonNaoCondicoesParticularSim;
    private javax.swing.JRadioButton jRadioButtonPossuiDependenteNao;
    private javax.swing.JRadioButton jRadioButtonPossuiDependenteSim;
    private javax.swing.JRadioButton jRadioButtonPossuiDividasNao;
    private javax.swing.JRadioButton jRadioButtonPossuiDividasSim;
    private javax.swing.JRadioButton jRadioButtonPrimeiroAtendimentoVeterinarioNao;
    private javax.swing.JRadioButton jRadioButtonPrimeiroAtendimentoVeterinarioSim;
    private javax.swing.JRadioButton jRadioButtonProtecaoAnimalNao;
    private javax.swing.JRadioButton jRadioButtonProtecaoAnimalSim;
    private javax.swing.JRadioButton jRadioButtonQuebraDeVinculoNao;
    private javax.swing.JRadioButton jRadioButtonQuebraDeVinculoSim;
    private javax.swing.JRadioButton jRadioButtonSaneamentoNao;
    private javax.swing.JRadioButton jRadioButtonSaneamentoSim;
    private javax.swing.JRadioButton jRadioButtonSituacaoIncapacitanteNao;
    private javax.swing.JRadioButton jRadioButtonSituacaoIncapacitanteSim;
    private javax.swing.JRadioButton jRadioButtonTrabalhadorInformalNao;
    private javax.swing.JRadioButton jRadioButtonTrabalhadorInformalSim;
    private javax.swing.JRadioButton jRadioButtonTrocaDomicilioNao;
    private javax.swing.JRadioButton jRadioButtonTrocaDomicilioSim;
    private javax.swing.JRadioButton jRadioButtonValidade6Meses;
    private javax.swing.JRadioButton jRadioButtonValidadePatologia;
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
