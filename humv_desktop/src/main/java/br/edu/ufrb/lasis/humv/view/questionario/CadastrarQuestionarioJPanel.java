package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.AnimaisQuestionario;
import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luiz Toni
 */
public class CadastrarQuestionarioJPanel extends javax.swing.JPanel {
    private ArrayList<Parente> parentes = new ArrayList<Parente>();
    private ArrayList<AnimaisQuestionario> animais = new ArrayList<AnimaisQuestionario>();
    
    public CadastrarQuestionarioJPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        Date date = new Date();
        tpnlQuestionario = new javax.swing.JTabbedPane();
        pnlInfoPessoais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNis = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        lblEscolaridade = new javax.swing.JLabel();
        txtEscolaridade = new javax.swing.JTextField();
        lblProfissao = new javax.swing.JLabel();
        txtProfissao = new javax.swing.JTextField();
        txtOcupacao = new javax.swing.JTextField();
        lblOcupacao = new javax.swing.JLabel();
        lblRendaFormal = new javax.swing.JLabel();
        txtRendaFormal = new javax.swing.JTextField();
        lblRendaInformal = new javax.swing.JLabel();
        txtRendaInformal = new javax.swing.JTextField();
        txtCondicaoMoradia = new javax.swing.JTextField();
        lblCondicaoMoradia = new javax.swing.JLabel();
        lblValorAluguel = new javax.swing.JLabel();
        txtValorAluguel = new javax.swing.JTextField();
        txtTipoConstrucao = new javax.swing.JTextField();
        lblTipoConstrucao = new javax.swing.JLabel();
        cmbSaneamento = new javax.swing.JComboBox<>();
        lblSaneamento = new javax.swing.JLabel();
        lblEnergia = new javax.swing.JLabel();
        cmbEnergia = new javax.swing.JComboBox<>();
        pnlEstudantes = new javax.swing.JPanel();
        txtCondicoesMoradiaEstudante = new javax.swing.JTextField();
        lblCondicoesMoradiaEstudante = new javax.swing.JLabel();
        lblValorGastos = new javax.swing.JLabel();
        txtValorGastos = new javax.swing.JTextField();
        lblFonteCusteio = new javax.swing.JLabel();
        txtFonteCusteio = new javax.swing.JTextField();
        txtBolsa = new javax.swing.JTextField();
        lblBolsa = new javax.swing.JLabel();
        lblObservacoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        lblProgramaRenda = new javax.swing.JLabel();
        txtProgramaRenda = new javax.swing.JTextField();
        pnlInfoFamiliares = new javax.swing.JPanel();
        lblNomeFamiliar = new javax.swing.JLabel();
        txtNomeFamiliar = new javax.swing.JTextField();
        lblParentesco = new javax.swing.JLabel();
        txtParentesco = new javax.swing.JTextField();
        lblIdadeFamiliar = new javax.swing.JLabel();
        txtIdadeFamiliar = new javax.swing.JTextField();
        lblEscolaridadeFamiliar = new javax.swing.JLabel();
        txtEscolaridadeFamiliar = new javax.swing.JTextField();
        lblOcupacaoFamiliar = new javax.swing.JLabel();
        txtOcupacaoFamiliar = new javax.swing.JTextField();
        lblRendaDoFamilar = new javax.swing.JLabel();
        txtRendaDoFamiliar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFamiliares = new javax.swing.JTable();
        lblRendaTotal = new javax.swing.JLabel();
        lblRendaPerCapta = new javax.swing.JLabel();
        lblFatoresRiscos = new javax.swing.JLabel();
        txtFatoresRiscos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBens = new javax.swing.JTextArea();
        lblBens = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSituacoesRiscoRenda = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMotivosNaoCusteio = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnAddFamiliar = new javax.swing.JButton();
        pnlInfoAnimais = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblNomeAnimal = new javax.swing.JLabel();
        txtNomeAnimal = new javax.swing.JTextField();
        lblEspecie = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblRaca = new javax.swing.JLabel();
        txtRaca = new javax.swing.JTextField();
        lblIdadeAnimal = new javax.swing.JLabel();
        txtIdadeAnimal = new javax.swing.JTextField();
        lblObsAnimal = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtObsAnimal = new javax.swing.JTextArea();
        btnAddAnimal = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAnimais = new javax.swing.JTable();
        btnDelAnimal = new javax.swing.JButton();
        pnlInfoCobranca = new javax.swing.JPanel();
        pnlConsultas = new javax.swing.JPanel();
        rbtnConsultaValNormal = new javax.swing.JRadioButton();
        rbtnConsultaValAula = new javax.swing.JRadioButton();
        rbtnConsultaIsencao = new javax.swing.JRadioButton();
        rbtnConsultaDesconto = new javax.swing.JRadioButton();
        txtConsultaDesconto = new javax.swing.JTextField();
        pnlExames = new javax.swing.JPanel();
        rbtnExameValNormal = new javax.swing.JRadioButton();
        rbtnExameValAula = new javax.swing.JRadioButton();
        rbtnExameIsencao = new javax.swing.JRadioButton();
        rbtnExameDesconto = new javax.swing.JRadioButton();
        txtExameDesconto = new javax.swing.JTextField();
        pnlCirurgias = new javax.swing.JPanel();
        rbtnCirurgiaValNormal = new javax.swing.JRadioButton();
        rbtnCirurgiaValAula = new javax.swing.JRadioButton();
        rbtnCirurgiaIsencao = new javax.swing.JRadioButton();
        rbtnCirurgiaDesconto = new javax.swing.JRadioButton();
        txtCirurgiaDesconto = new javax.swing.JTextField();
        pnlAdicionais = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtOrientacoes = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtHistoricoFamilia = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtConclusoes = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        lblNome.setText("Nome:");

        lblNis.setText("NIS:");

        lblIdade.setText("Idade:");

        lblCpf.setText("CPF:");

        lblEndereco.setText("Endereço:");

        lblTelefone.setText("Telefone:");

        lblEstadoCivil.setText("Estado civil:");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Divorciado", " " }));

        lblEscolaridade.setText("Escolaridade:");

        lblProfissao.setText("Profissão:");

        lblOcupacao.setText("Ocupação:");

        lblRendaFormal.setText("Renda formal R$:");

        lblRendaInformal.setText("Renda informal R$:");

        lblCondicaoMoradia.setText("Condição de moradia:");

        lblValorAluguel.setText("Valor aluguel/finaciamento R$:");

        lblTipoConstrucao.setText("Tipo de construção:");

        cmbSaneamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        lblSaneamento.setText("Saneamento básico?");

        lblEnergia.setText("Energia elétrica?");

        cmbEnergia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        pnlEstudantes.setBorder(javax.swing.BorderFactory.createTitledBorder("Aplicável somente à estudantes: "));

        lblCondicoesMoradiaEstudante.setText("Condições de moradia na cidade:");

        lblValorGastos.setText("Valor dos gastos mensais R$:");

        lblFonteCusteio.setText("Fonte de custeio:");

        lblBolsa.setText("Bolsa/benéficio?");

        lblObservacoes.setText("Observações:");

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPane1.setViewportView(txtObservacoes);

        javax.swing.GroupLayout pnlEstudantesLayout = new javax.swing.GroupLayout(pnlEstudantes);
        pnlEstudantes.setLayout(pnlEstudantesLayout);
        pnlEstudantesLayout.setHorizontalGroup(
            pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEstudantesLayout.createSequentialGroup()
                        .addComponent(lblCondicoesMoradiaEstudante)
                        .addGap(18, 18, 18)
                        .addComponent(txtCondicoesMoradiaEstudante))
                    .addGroup(pnlEstudantesLayout.createSequentialGroup()
                        .addComponent(lblValorGastos)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFonteCusteio)
                        .addGap(18, 18, 18)
                        .addComponent(txtFonteCusteio))
                    .addGroup(pnlEstudantesLayout.createSequentialGroup()
                        .addComponent(lblBolsa)
                        .addGap(18, 18, 18)
                        .addComponent(txtBolsa))
                    .addGroup(pnlEstudantesLayout.createSequentialGroup()
                        .addComponent(lblObservacoes)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        pnlEstudantesLayout.setVerticalGroup(
            pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCondicoesMoradiaEstudante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCondicoesMoradiaEstudante))
                .addGap(18, 18, 18)
                .addGroup(pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorGastos)
                    .addComponent(txtValorGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFonteCusteio)
                    .addComponent(txtFonteCusteio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBolsa)
                    .addComponent(txtBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEstudantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservacoes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblProgramaRenda.setText("Programa de transferência de renda:");

        javax.swing.GroupLayout pnlInfoPessoaisLayout = new javax.swing.GroupLayout(pnlInfoPessoais);
        pnlInfoPessoais.setLayout(pnlInfoPessoaisLayout);
        pnlInfoPessoaisLayout.setHorizontalGroup(
            pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                        .addComponent(lblProgramaRenda)
                        .addGap(18, 18, 18)
                        .addComponent(txtProgramaRenda))
                    .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblCpf)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                    .addComponent(lblNis)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblIdade)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIdade))
                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEndereco)
                                        .addComponent(lblTelefone))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEndereco)
                                        .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                                    .addComponent(lblProfissao)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtProfissao))
                                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                                    .addComponent(lblEstadoCivil)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cmbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                                    .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblRendaFormal)
                                                        .addComponent(lblCondicaoMoradia)
                                                        .addComponent(lblTipoConstrucao)
                                                        .addComponent(lblEnergia))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtCondicaoMoradia)
                                                        .addComponent(txtRendaFormal)
                                                        .addComponent(txtTipoConstrucao)
                                                        .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                                                            .addComponent(cmbEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE)))))))))
                            .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblRendaInformal)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtRendaInformal))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblOcupacao)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtOcupacao))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblEscolaridade)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblValorAluguel)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtValorAluguel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoPessoaisLayout.createSequentialGroup()
                                    .addComponent(lblSaneamento)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbSaneamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlEstudantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoPessoaisLayout.setVerticalGroup(
            pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNis)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscolaridade)
                    .addComponent(txtEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfissao)
                    .addComponent(txtProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcupacao)
                    .addComponent(txtOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRendaFormal)
                    .addComponent(txtRendaFormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRendaInformal)
                    .addComponent(txtRendaInformal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCondicaoMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCondicaoMoradia))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorAluguel)
                    .addComponent(txtValorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoConstrucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoConstrucao))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSaneamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaneamento)
                    .addComponent(lblEnergia)
                    .addComponent(cmbEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlInfoPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProgramaRenda)
                    .addComponent(txtProgramaRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pnlEstudantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpnlQuestionario.addTab("Informações pessoais", pnlInfoPessoais);

        lblNomeFamiliar.setText("Nome:");

        lblParentesco.setText("Parentesco:");

        lblIdadeFamiliar.setText("Idade:");

        lblEscolaridadeFamiliar.setText("Escolaridade:");

        lblOcupacaoFamiliar.setText("Ocupação:");

        lblRendaDoFamilar.setText("Renda R$:");

        tblFamiliares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Parentesco", "Renda R$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFamiliares);

        lblRendaTotal.setText("Renda total R$: ");

        lblRendaPerCapta.setText("Renda per capta R$:");

        lblFatoresRiscos.setText("Fatores de riscos declarados:");

        txtBens.setColumns(20);
        txtBens.setRows(5);
        jScrollPane3.setViewportView(txtBens);

        lblBens.setText("Bens materiais? (Ex.: Carro, casa, terreno)");

        jLabel35.setText("Situações que comprometam a renda familiar?");

        jLabel36.setText("(Ex.: Emprestimos, dividas com banco) ");

        txtSituacoesRiscoRenda.setColumns(20);
        txtSituacoesRiscoRenda.setRows(5);
        jScrollPane4.setViewportView(txtSituacoesRiscoRenda);

        txtMotivosNaoCusteio.setColumns(20);
        txtMotivosNaoCusteio.setRows(5);
        jScrollPane5.setViewportView(txtMotivosNaoCusteio);

        jLabel37.setText("Motivos que impossibilitam o custeio");

        jLabel38.setText("do tratamento dos animais?");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFatoresRiscos)
                            .addComponent(lblBens))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(txtFatoresRiscos)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblRendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(lblRendaPerCapta, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRendaTotal)
                    .addComponent(lblRendaPerCapta))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFatoresRiscos)
                    .addComponent(txtFatoresRiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBens)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)))
                .addGap(31, 31, 31))
        );

        btnAddFamiliar.setText("Adcionar");
        btnAddFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFamiliarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfoFamiliaresLayout = new javax.swing.GroupLayout(pnlInfoFamiliares);
        pnlInfoFamiliares.setLayout(pnlInfoFamiliaresLayout);
        pnlInfoFamiliaresLayout.setHorizontalGroup(
            pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                        .addComponent(lblNomeFamiliar)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeFamiliar))
                    .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                        .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                                .addComponent(lblRendaDoFamilar)
                                .addGap(18, 18, 18)
                                .addComponent(txtRendaDoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176))
                            .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoFamiliaresLayout.createSequentialGroup()
                                    .addComponent(lblEscolaridadeFamiliar)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEscolaridadeFamiliar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoFamiliaresLayout.createSequentialGroup()
                                    .addComponent(lblParentesco)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                                        .addComponent(lblIdadeFamiliar)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdadeFamiliar))
                                    .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                                        .addComponent(lblOcupacaoFamiliar)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOcupacaoFamiliar))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoFamiliaresLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddFamiliar)
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );
        pnlInfoFamiliaresLayout.setVerticalGroup(
            pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoFamiliaresLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFamiliar)
                    .addComponent(txtNomeFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblParentesco)
                    .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIdadeFamiliar)
                        .addComponent(txtIdadeFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEscolaridadeFamiliar)
                    .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEscolaridadeFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblOcupacaoFamiliar)
                        .addComponent(txtOcupacaoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRendaDoFamilar)
                    .addGroup(pnlInfoFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRendaDoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddFamiliar)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpnlQuestionario.addTab("Informações dos familiares", pnlInfoFamiliares);

        lblNomeAnimal.setText("Nome:");

        lblEspecie.setText("Espécie:");

        lblSexo.setText("Sexo:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Fêmea" }));

        lblRaca.setText("Raça:");

        lblIdadeAnimal.setText("Idade:");

        lblObsAnimal.setText("Observações:");

        txtObsAnimal.setColumns(20);
        txtObsAnimal.setRows(5);
        jScrollPane6.setViewportView(txtObsAnimal);

        btnAddAnimal.setText("Adicionar");
        btnAddAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblNomeAnimal)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeAnimal)
                                .addGap(18, 18, 18)
                                .addComponent(lblEspecie))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblRaca)
                                .addGap(18, 18, 18)
                                .addComponent(txtRaca)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblIdadeAnimal)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdadeAnimal))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblObsAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddAnimal)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAnimal)
                    .addComponent(txtNomeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEspecie)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaca)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdadeAnimal)
                    .addComponent(txtIdadeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObsAnimal)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnAddAnimal)
                .addContainerGap())
        );

        tblAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Espécie", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblAnimais);

        btnDelAnimal.setText("Remover");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelAnimal)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelAnimal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInfoAnimaisLayout = new javax.swing.GroupLayout(pnlInfoAnimais);
        pnlInfoAnimais.setLayout(pnlInfoAnimaisLayout);
        pnlInfoAnimaisLayout.setHorizontalGroup(
            pnlInfoAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoAnimaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoAnimaisLayout.setVerticalGroup(
            pnlInfoAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoAnimaisLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        tpnlQuestionario.addTab("Informações de animais", pnlInfoAnimais);

        pnlConsultas.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        rbtnConsultaValNormal.setText("Valor normal");
        rbtnConsultaValNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultaValNormalActionPerformed(evt);
            }
        });

        rbtnConsultaValAula.setText("Valor aula");
        rbtnConsultaValAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultaValAulaActionPerformed(evt);
            }
        });

        rbtnConsultaIsencao.setText("Isenção");
        rbtnConsultaIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultaIsencaoActionPerformed(evt);
            }
        });

        rbtnConsultaDesconto.setText("Desconto %");
        rbtnConsultaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsultaDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultasLayout = new javax.swing.GroupLayout(pnlConsultas);
        pnlConsultas.setLayout(pnlConsultasLayout);
        pnlConsultasLayout.setHorizontalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnConsultaValNormal)
                    .addComponent(rbtnConsultaValAula)
                    .addComponent(rbtnConsultaIsencao)
                    .addGroup(pnlConsultasLayout.createSequentialGroup()
                        .addComponent(rbtnConsultaDesconto)
                        .addGap(18, 18, 18)
                        .addComponent(txtConsultaDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlConsultasLayout.setVerticalGroup(
            pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnConsultaValNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnConsultaValAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnConsultaIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnConsultaDesconto)
                    .addComponent(txtConsultaDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlExames.setBorder(javax.swing.BorderFactory.createTitledBorder("Procedimentos abulatóriais e exames"));

        rbtnExameValNormal.setText("Valor normal");
        rbtnExameValNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnExameValNormalActionPerformed(evt);
            }
        });

        rbtnExameValAula.setText("Valor aula");
        rbtnExameValAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnExameValAulaActionPerformed(evt);
            }
        });

        rbtnExameIsencao.setText("Isenção");
        rbtnExameIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnExameIsencaoActionPerformed(evt);
            }
        });

        rbtnExameDesconto.setText("Desconto %");
        rbtnExameDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnExameDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlExamesLayout = new javax.swing.GroupLayout(pnlExames);
        pnlExames.setLayout(pnlExamesLayout);
        pnlExamesLayout.setHorizontalGroup(
            pnlExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExamesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnExameValNormal)
                    .addComponent(rbtnExameValAula)
                    .addComponent(rbtnExameIsencao)
                    .addGroup(pnlExamesLayout.createSequentialGroup()
                        .addComponent(rbtnExameDesconto)
                        .addGap(18, 18, 18)
                        .addComponent(txtExameDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        pnlExamesLayout.setVerticalGroup(
            pnlExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnExameValNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnExameValAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnExameIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnExameDesconto)
                    .addComponent(txtExameDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCirurgias.setBorder(javax.swing.BorderFactory.createTitledBorder("Cirurgia/reprodução"));

        rbtnCirurgiaValNormal.setText("Valor normal");
        rbtnCirurgiaValNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCirurgiaValNormalActionPerformed(evt);
            }
        });

        rbtnCirurgiaValAula.setText("Valor aula");
        rbtnCirurgiaValAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCirurgiaValAulaActionPerformed(evt);
            }
        });

        rbtnCirurgiaIsencao.setText("Isenção");
        rbtnCirurgiaIsencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCirurgiaIsencaoActionPerformed(evt);
            }
        });

        rbtnCirurgiaDesconto.setText("Desconto %");
        rbtnCirurgiaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCirurgiaDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCirurgiasLayout = new javax.swing.GroupLayout(pnlCirurgias);
        pnlCirurgias.setLayout(pnlCirurgiasLayout);
        pnlCirurgiasLayout.setHorizontalGroup(
            pnlCirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCirurgiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnCirurgiaValNormal)
                    .addComponent(rbtnCirurgiaValAula)
                    .addComponent(rbtnCirurgiaIsencao)
                    .addGroup(pnlCirurgiasLayout.createSequentialGroup()
                        .addComponent(rbtnCirurgiaDesconto)
                        .addGap(18, 18, 18)
                        .addComponent(txtCirurgiaDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        pnlCirurgiasLayout.setVerticalGroup(
            pnlCirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCirurgiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnCirurgiaValNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnCirurgiaValAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnCirurgiaIsencao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCirurgiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCirurgiaDesconto)
                    .addComponent(txtCirurgiaDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInfoCobrancaLayout = new javax.swing.GroupLayout(pnlInfoCobranca);
        pnlInfoCobranca.setLayout(pnlInfoCobrancaLayout);
        pnlInfoCobrancaLayout.setHorizontalGroup(
            pnlInfoCobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoCobrancaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoCobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlExames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCirurgias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInfoCobrancaLayout.setVerticalGroup(
            pnlInfoCobrancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoCobrancaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlExames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCirurgias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        tpnlQuestionario.addTab("Informações de cobrança", pnlInfoCobranca);

        jLabel45.setText("Orientações e encaminhamentos:");

        txtOrientacoes.setColumns(20);
        txtOrientacoes.setRows(5);
        jScrollPane8.setViewportView(txtOrientacoes);

        txtHistoricoFamilia.setColumns(20);
        txtHistoricoFamilia.setRows(5);
        jScrollPane9.setViewportView(txtHistoricoFamilia);

        jLabel46.setText("Breve histórico de vida e vulnerabilidades da família:");

        jLabel47.setText("Conclusões e outras observações: ");

        txtConclusoes.setColumns(20);
        txtConclusoes.setRows(5);
        jScrollPane10.setViewportView(txtConclusoes);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos entregues:"));

        jLabel48.setText("Comprovante de endereço: ");

        jDateChooser1.setDate(date);

        jLabel49.setText("Copia do documento de identidade:");

        jDateChooser2.setDate(date);

        jLabel50.setText("Copia do cartão Bolsa Família:");

        jDateChooser3.setDate(date);

        jLabel51.setText("Copia dos documentos de identidade dos familiares: ");

        jDateChooser4.setDate(date);

        jButton6.setText("Adicionar outro");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAdicionaisLayout = new javax.swing.GroupLayout(pnlAdicionais);
        pnlAdicionais.setLayout(pnlAdicionaisLayout);
        pnlAdicionaisLayout.setHorizontalGroup(
            pnlAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdicionaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane10)
                    .addGroup(pnlAdicionaisLayout.createSequentialGroup()
                        .addGroup(pnlAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAdicionaisLayout.setVerticalGroup(
            pnlAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdicionaisLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tpnlQuestionario.addTab("Adicionais", pnlAdicionais);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setText("Questionário Socioeconômico");

        btnImprimir.setText("Imprimir declaração");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tpnlQuestionario)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnlQuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnImprimir)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void validaInfoPessoais(){
        if (this.txtNome.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome do cliente");
            return;
        }
        String nome = this.txtNome.getText();
        
        if (this.txtNome.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("idade do cliente");
            return;
        }
        int idade = Integer.parseInt(this.txtIdade.getText());
        
        if (this.txtCpf.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("CPF do cliente");
            return;
        }
        BigInteger cpf = BigInteger.valueOf(Integer.parseInt(this.txtCpf.getText()));
        
        if (this.txtNis.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("NIS do cliente");
            return;
        }
        BigInteger nis = BigInteger.valueOf(Integer.parseInt(this.txtNis.getText()));
        
        if (this.txtEndereco.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Endereço do cliente");
            return;
        }
        String endereco = this.txtIdade.getText();
        
        if (this.txtTelefone.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Telefone do cliente");
            return;
        }
        String telefone = this.txtTelefone.getText();
        
        String estadoCivil = cmbEstadoCivil.getName();
        
        if (this.txtEscolaridade.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Escolaridade do cliente");
            return;
        }
        String escolaridade = this.txtEscolaridade.getText();
        
        if (this.txtProfissao.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Profissão do cliente");
            return;
        }
        String profissao = this.txtProfissao.getText();
        
        if (this.txtOcupacao.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Ocupação do cliente");
            return;
        }
        String ocupacao = this.txtOcupacao.getText();
        
        if (this.txtRendaFormal.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Renda formal do cliente");
            return;
        }
        double rendaFormal = Double.parseDouble(this.txtRendaFormal.getText());
        
        if (this.txtRendaInformal.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Renda informal do cliente");
            return;
        }
        double rendaInformal = Double.parseDouble(this.txtRendaInformal.getText());
        
        if (this.txtCondicaoMoradia.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Condição de moradia do cliente");
            return;
        }
        String condicaoMoradia = this.txtCondicaoMoradia.getText();
        
        if (this.txtValorAluguel.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Valor do aluguel ou financiamento do cliente");
            return;
        }
        Double valorAluguel = Double.parseDouble(this.txtValorAluguel.getText());
        
        String saneamento = this.cmbSaneamento.getName();
        
        String energia = this.cmbEnergia.getName();
        
        if (this.txtProgramaRenda.getText().isEmpty()) {
            String programaRenda = "não possui";
        }else{
            String programaRenda = this.txtProgramaRenda.getText();
        }  
        
        if (this.txtCondicoesMoradiaEstudante.getText().isEmpty()) {
            String condicoesMoradiaEstudante = "não se aplica";
        }else{
            String condicoesMoradiaEstudante = this.txtCondicoesMoradiaEstudante.getText();
        }
        
        if(this.txtCondicoesMoradiaEstudante.getText().isEmpty()){
            double valorGastos = 0;
        }else{
            double valorGastos = Double.parseDouble(this.txtValorGastos.getText());
        }
        
        if (this.txtFonteCusteio.getText().isEmpty()) {
            String fonteCusteio = "não se aplica";
        }else{
            String fonteCusteio = this.txtFonteCusteio.getText();
        }
        
        if (this.txtBolsa.getText().isEmpty()) {
            String bolsa = "não se aplica";
        }else{
            String bolsa = this.txtBolsa.getText();
        }
        
        if (this.txtObservacoes.getText().isEmpty()) {
            String observacoes = "não se aplica";
        }else{
            String observacoes = this.txtObservacoes.getText();
        }
    }
    
    private void validaInfoAdicionais(){
        if (this.txtHistoricoFamilia.getText().isEmpty()) {
            String historicoFamilia = "";
        }else{
            String historicoFamilia = this.txtHistoricoFamilia.getText();
        }
        
        if (this.txtOrientacoes.getText().isEmpty()) {
            String orientacoes = "";
        }else{
            String orientacoes = this.txtOrientacoes.getText();
        }
        
        if (this.txtConclusoes.getText().isEmpty()) {
            String conclusoes = "";
        }else{
            String conclusoes = this.txtConclusoes.getText();
        }
    } 
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        validaInfoPessoais();
        validaInfoFamiliares();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAddFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFamiliarActionPerformed
        Parente parente = new Parente();
        
        if (this.txtNomeFamiliar.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Nome do familiar");
            return;
        }
        String nome = this.txtNomeFamiliar.getText();
        parente.setNome(nome);
        
        if (this.txtIdadeFamiliar.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Idade do familiar");
            return;
        }
        int idade = Integer.parseInt(this.txtNomeFamiliar.getText());
        parente.setIdade(idade);
       
        if (this.txtParentesco.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Parentesco do familiar");
            return;
        }
        String parentesco = this.txtParentesco.getText();
        parente.setParentesco(parentesco);
        
        if (this.txtEscolaridadeFamiliar.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Escolaridade do familiar");
            return;
        }
        String escolaridade = this.txtEscolaridade.getText();
        parente.setEscolaridade(escolaridade);
        
        if (this.txtOcupacaoFamiliar.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Ocupação do familiar");
            return;
        }
        String ocupacao = this.txtOcupacao.getText();
        parente.setOcupacao(ocupacao);
        
        if (this.txtRendaDoFamiliar.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Renda do familiar");
            return;
        }
        double renda = Double.parseDouble(this.txtRendaDoFamiliar.getText());
        parente.setRenda(renda);
        
        
        parentes.add(parente);
        limparTextfieldsInfoFamiliar();
        atualizaTabelaFamiliares();
        atualizaCalculoRenda();
               
    }//GEN-LAST:event_btnAddFamiliarActionPerformed

    private void btnAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnimalActionPerformed
        AnimaisQuestionario animal = new AnimaisQuestionario();
        
        if (this.txtNomeAnimal.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Nome do animal");
            return;
        }
        String nomeAnimal = this.txtNomeAnimal.getText();
        animal.setNome(nomeAnimal);
        
        if (this.txtEspecie.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Espécie do animal");
            return;
        }
        String especie = this.txtEspecie.getText();
        animal.setEspecie(especie);
        
        if(this.cmbSexo.getName().equalsIgnoreCase("macho")){
            animal.setSexo('M');
        }else{
            animal.setSexo('F');
        }
        
        if (this.txtRaca.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Raça do animal");
            return;
        }
        String raca = this.txtRaca.getText();
        animal.setRaca(raca);
        
        if (this.txtIdadeAnimal.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Idade do animal");
            return;
        }
        int idadeAnimal = Integer.parseInt(this.txtIdadeAnimal.getText());
        animal.setIdade(idadeAnimal);
        
        if (this.txtObsAnimal.getText().isEmpty()) {
            String obsAnimal="";
            animal.setObs(obsAnimal);
        }else{
            animal.setObs(this.txtObsAnimal.getText());
        }
        
        animais.add(animal);
        atualizaTabelaAnimais();
        limparTextfieldsInfoAnimal();
    }//GEN-LAST:event_btnAddAnimalActionPerformed

    private void rbtnConsultaValNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultaValNormalActionPerformed
        this.rbtnConsultaValAula.setSelected(false);
        this.rbtnConsultaIsencao.setSelected(false);
        this.rbtnConsultaDesconto.setSelected(false);
        txtConsultaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnConsultaValNormalActionPerformed

    private void rbtnConsultaValAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultaValAulaActionPerformed
        this.rbtnConsultaValNormal.setSelected(false);
        this.rbtnConsultaIsencao.setSelected(false);
        this.rbtnConsultaDesconto.setSelected(false);
        txtConsultaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnConsultaValAulaActionPerformed

    private void rbtnConsultaIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultaIsencaoActionPerformed
        this.rbtnConsultaValNormal.setSelected(false);
        this.rbtnConsultaValAula.setSelected(false);
        this.rbtnConsultaDesconto.setSelected(false);
        txtConsultaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnConsultaIsencaoActionPerformed

    private void rbtnConsultaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsultaDescontoActionPerformed
        this.rbtnConsultaValNormal.setSelected(false);
        this.rbtnConsultaValAula.setSelected(false);
        this.rbtnConsultaIsencao.setSelected(false);
        txtConsultaDesconto.setVisible(true);
    }//GEN-LAST:event_rbtnConsultaDescontoActionPerformed

    private void rbtnExameValNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnExameValNormalActionPerformed
        rbtnExameValAula.setSelected(false);
        rbtnExameIsencao.setSelected(false);
        rbtnExameDesconto.setSelected(false);
        txtExameDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnExameValNormalActionPerformed

    private void rbtnCirurgiaValNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCirurgiaValNormalActionPerformed
        rbtnCirurgiaValAula.setSelected(false);
        rbtnCirurgiaIsencao.setSelected(false);
        rbtnCirurgiaDesconto.setSelected(false);
        txtCirurgiaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnCirurgiaValNormalActionPerformed

    private void rbtnExameValAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnExameValAulaActionPerformed
        rbtnExameValNormal.setSelected(false);
        rbtnExameIsencao.setSelected(false);
        rbtnExameDesconto.setSelected(false);
        txtExameDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnExameValAulaActionPerformed

    private void rbtnExameIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnExameIsencaoActionPerformed
        rbtnExameValNormal.setSelected(false);
        rbtnExameValAula.setSelected(false);
        rbtnExameDesconto.setSelected(false);
        txtExameDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnExameIsencaoActionPerformed

    private void rbtnExameDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnExameDescontoActionPerformed
        rbtnExameValNormal.setSelected(false);
        rbtnExameValAula.setSelected(false);
        rbtnExameIsencao.setSelected(false);
        txtExameDesconto.setVisible(true);
    }//GEN-LAST:event_rbtnExameDescontoActionPerformed

    private void rbtnCirurgiaValAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCirurgiaValAulaActionPerformed
        rbtnCirurgiaValNormal.setSelected(false);
        rbtnCirurgiaIsencao.setSelected(false);
        rbtnCirurgiaDesconto.setSelected(false);
        txtCirurgiaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnCirurgiaValAulaActionPerformed

    private void rbtnCirurgiaIsencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCirurgiaIsencaoActionPerformed
        rbtnCirurgiaValNormal.setSelected(false);
        rbtnCirurgiaValAula.setSelected(false);
        rbtnCirurgiaDesconto.setSelected(false);
        txtCirurgiaDesconto.setVisible(false);
    }//GEN-LAST:event_rbtnCirurgiaIsencaoActionPerformed

    private void rbtnCirurgiaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCirurgiaDescontoActionPerformed
        rbtnCirurgiaValNormal.setSelected(false);
        rbtnCirurgiaValAula.setSelected(false);
        rbtnCirurgiaIsencao.setSelected(false);
        txtCirurgiaDesconto.setVisible(true);
    }//GEN-LAST:event_rbtnCirurgiaDescontoActionPerformed
    
    private void atualizaTabelaAnimais(){
        String colunas[] ={"Nome","Espécie","Sexo"}; 
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        animais.forEach((a) -> {
            if(a.getSexo()=='M' || a.getSexo()=='m')
                model.addRow(new String[]{a.getNome(),a.getEspecie(),"macho"});
            else
                model.addRow(new String[]{a.getNome(),a.getEspecie(),"fêmea"});      
        });
        tblAnimais.setModel(model);
    }
    private void limparTextfieldsInfoAnimal(){
        this.txtNomeAnimal.setText(null);
        this.txtIdadeAnimal.setText(null);
        this.txtRaca.setText(null);
        this.txtEspecie.setText(null);
        this.txtObsAnimal.setText(null);  
    }
    
    private void limparTextfieldsInfoFamiliar(){
        this.txtNomeFamiliar.setText(null);
        this.txtIdadeFamiliar.setText(null);
        this.txtParentesco.setText(null);
        this.txtEscolaridadeFamiliar.setText(null);
        this.txtOcupacaoFamiliar.setText(null);
        this.txtRendaDoFamiliar.setText(null);
    }
    private void atualizaTabelaFamiliares(){
        String colunas[] ={"Nome","Parentesco","Renda R$"}; 
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        parentes.forEach((p) -> {
            model.addRow(new String[]{p.getNome(),p.getParentesco(),""+p.getRenda()});
        });
        tblFamiliares.setModel(model);
    }
    
    private void atualizaCalculoRenda(){
        double rendaTotal = 0.0, rendaPerCapta = 0.0;
        int qtdParentes=0;
        for(Parente parente:parentes){
            rendaTotal += parente.getRenda();
            ++qtdParentes;
        }
        rendaPerCapta = rendaTotal/qtdParentes;
        lblRendaTotal.setText("Renda total R$: "+rendaTotal);
        lblRendaPerCapta.setText("Renda per capta R$: "+rendaTotal);
    }
    
    private void validaInfoFamiliares(){
        if (this.txtFatoresRiscos.getText().isEmpty()) {
            String fatoresRiscos = "inexistentes";
        }else{
            String fatoresRiscos = this.txtFatoresRiscos.getText();
        }
        
        if (this.txtBens.getText().isEmpty()) {
            String bens = "inexistentes";
            
        }else{
            String bens = this.txtBens.getText();
        }
        
        if (this.txtSituacoesRiscoRenda.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Situações que comprometam a renda familiar ");
            return;    
        }else{
            String situacoesRiscoRenda = this.txtSituacoesRiscoRenda.getText();
        }
        
        if (this.txtMotivosNaoCusteio.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("Motivos que impossibilitam o custeio do tartamento do animal");
            return;    
        }else{
            String motivosNaoCusteio = this.txtMotivosNaoCusteio.getText();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAnimal;
    private javax.swing.JButton btnAddFamiliar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDelAnimal;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbEnergia;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbSaneamento;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblBens;
    private javax.swing.JLabel lblBolsa;
    private javax.swing.JLabel lblCondicaoMoradia;
    private javax.swing.JLabel lblCondicoesMoradiaEstudante;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEnergia;
    private javax.swing.JLabel lblEscolaridade;
    private javax.swing.JLabel lblEscolaridadeFamiliar;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFatoresRiscos;
    private javax.swing.JLabel lblFonteCusteio;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblIdadeAnimal;
    private javax.swing.JLabel lblIdadeFamiliar;
    private javax.swing.JLabel lblNis;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeAnimal;
    private javax.swing.JLabel lblNomeFamiliar;
    private javax.swing.JLabel lblObsAnimal;
    private javax.swing.JLabel lblObservacoes;
    private javax.swing.JLabel lblOcupacao;
    private javax.swing.JLabel lblOcupacaoFamiliar;
    private javax.swing.JLabel lblParentesco;
    private javax.swing.JLabel lblProfissao;
    private javax.swing.JLabel lblProgramaRenda;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblRendaDoFamilar;
    private javax.swing.JLabel lblRendaFormal;
    private javax.swing.JLabel lblRendaInformal;
    private javax.swing.JLabel lblRendaPerCapta;
    private javax.swing.JLabel lblRendaTotal;
    private javax.swing.JLabel lblSaneamento;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipoConstrucao;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorAluguel;
    private javax.swing.JLabel lblValorGastos;
    private javax.swing.JPanel pnlAdicionais;
    private javax.swing.JPanel pnlCirurgias;
    private javax.swing.JPanel pnlConsultas;
    private javax.swing.JPanel pnlEstudantes;
    private javax.swing.JPanel pnlExames;
    private javax.swing.JPanel pnlInfoAnimais;
    private javax.swing.JPanel pnlInfoCobranca;
    private javax.swing.JPanel pnlInfoFamiliares;
    private javax.swing.JPanel pnlInfoPessoais;
    private javax.swing.JRadioButton rbtnCirurgiaDesconto;
    private javax.swing.JRadioButton rbtnCirurgiaIsencao;
    private javax.swing.JRadioButton rbtnCirurgiaValAula;
    private javax.swing.JRadioButton rbtnCirurgiaValNormal;
    private javax.swing.JRadioButton rbtnConsultaDesconto;
    private javax.swing.JRadioButton rbtnConsultaIsencao;
    private javax.swing.JRadioButton rbtnConsultaValAula;
    private javax.swing.JRadioButton rbtnConsultaValNormal;
    private javax.swing.JRadioButton rbtnExameDesconto;
    private javax.swing.JRadioButton rbtnExameIsencao;
    private javax.swing.JRadioButton rbtnExameValAula;
    private javax.swing.JRadioButton rbtnExameValNormal;
    private javax.swing.JTable tblAnimais;
    private javax.swing.JTable tblFamiliares;
    private javax.swing.JTabbedPane tpnlQuestionario;
    private javax.swing.JTextArea txtBens;
    private javax.swing.JTextField txtBolsa;
    private javax.swing.JTextField txtCirurgiaDesconto;
    private javax.swing.JTextArea txtConclusoes;
    private javax.swing.JTextField txtCondicaoMoradia;
    private javax.swing.JTextField txtCondicoesMoradiaEstudante;
    private javax.swing.JTextField txtConsultaDesconto;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEscolaridade;
    private javax.swing.JTextField txtEscolaridadeFamiliar;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtExameDesconto;
    private javax.swing.JTextField txtFatoresRiscos;
    private javax.swing.JTextField txtFonteCusteio;
    private javax.swing.JTextArea txtHistoricoFamilia;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtIdadeAnimal;
    private javax.swing.JTextField txtIdadeFamiliar;
    private javax.swing.JTextArea txtMotivosNaoCusteio;
    private javax.swing.JTextField txtNis;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeAnimal;
    private javax.swing.JTextField txtNomeFamiliar;
    private javax.swing.JTextArea txtObsAnimal;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtOcupacao;
    private javax.swing.JTextField txtOcupacaoFamiliar;
    private javax.swing.JTextArea txtOrientacoes;
    private javax.swing.JTextField txtParentesco;
    private javax.swing.JTextField txtProfissao;
    private javax.swing.JTextField txtProgramaRenda;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JTextField txtRendaDoFamiliar;
    private javax.swing.JTextField txtRendaFormal;
    private javax.swing.JTextField txtRendaInformal;
    private javax.swing.JTextArea txtSituacoesRiscoRenda;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTipoConstrucao;
    private javax.swing.JTextField txtValorAluguel;
    private javax.swing.JTextField txtValorGastos;
    // End of variables declaration//GEN-END:variables
}
