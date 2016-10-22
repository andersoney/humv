package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
//import java.util.ArrayList;
import java.util.List;

public class QuestionarioSocioeconomico implements Serializable {

    private static final long serialVersionUID = -4309147069247595796L;

    public static final Integer ESCOLARIDADE_FUNDAMENTAL_INCOMPLETO = 1;
    public static final Integer ESCOLARIDADE_FUNDAMENTAL_COMPLETO = 2;
    public static final Integer ESCOLARIDADE_MEDIO_INCOMPLETO = 3;
    public static final Integer ESCOLARIDADE_MEDIO_COMPLETO = 4;
    public static final Integer ESCOLARIDADE_SUPERIOR_INCOMPLETO = 5;
    public static final Integer ESCOLARIDADE_SUPERIOR_COMPLETO = 6;
    public static final Integer ESCOLARIDADE_POS_INCOMPLETO = 7;
    public static final Integer ESCOLARIDADE_POS_COMPLETO = 8;

    public static final Integer ESTADO_CIVIL_SOLTEIRO = 1;
    public static final Integer ESTADO_CIVIL_CASADO = 2;
    public static final Integer ESTADO_CIVIL_SEPARADO = 3;
    public static final Integer ESTADO_CIVIL_DIVORCIADO = 4;
    public static final Integer ESTADO_CIVIL_VIUVO = 5;

    public static final Integer COBRANCA_NORMAL = 0;
    public static final Integer COBRANCA_AULA = 1;
    public static final Integer COBRANCA_INSENCAO = 2;
    public static final Integer COBRANCA_DESCONTO = 3;

    private BigInteger id;
    
    
    private Dono dono;

    private Integer estadoCivil;
    private Integer idade;
    private Integer nis;
    private String profissao;
    private Integer escolaridade;
    private String ocupacaoAtual;
    private Double rendaFormal;
    private Double rendaInformal;
    private boolean temSaneamento;
    private boolean temEnergia;
    private String condicaoMoradia;
    private Double valorAluguel;
    private String tipoConstrucao;
    private String programaTransferenciaRenda;
    private boolean estudante;
    private Double gastosMensais;
    private String fontCusteio;
    private String bolsaOuBeneficio;

    private List<Parente> parentes;
    private List<Animal> animais;
    private List<Documentacao> documentosEntregues;
    private double rendaPerCapta;
    private double rendaTotal;
    private String impossibilidadesCusteio;
    private String bensFamiliares;
    private String riscosSociais;
    private String emprestimos;

    private String breveResumo;
    private String conclusoes;
    private String observacoes;

    //Relacionado com atributos da classe Atendimento: valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaConsultas;

    //Relacionado com atributos da classe Atendimento: valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaExames;

    //valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaCirurgias;

    private Double valorDescontoExames;
    private Double valorDescontoCirurgias;

    private Double valorDescontoConsultas;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
        this.nis = nis;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(String ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public Double getRendaFormal() {
        return rendaFormal;
    }

    public void setRendaFormal(Double rendaFormal) {
        this.rendaFormal = rendaFormal;
    }

    public Double getRendaInformal() {
        return rendaInformal;
    }

    public void setRendaInformal(Double rendaInformal) {
        this.rendaInformal = rendaInformal;
    }

    public boolean isTemSaneamento() {
        return temSaneamento;
    }

    public void setTemSaneamento(boolean temSaneamento) {
        this.temSaneamento = temSaneamento;
    }

    public boolean isTemEnergia() {
        return temEnergia;
    }

    public void setTemEnergia(boolean temEnergia) {
        this.temEnergia = temEnergia;
    }

    public String getCondicaoMoradia() {
        return condicaoMoradia;
    }

    public void setCondicaoMoradia(String condicaoMoradia) {
        this.condicaoMoradia = condicaoMoradia;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getTipoConstrucao() {
        return tipoConstrucao;
    }

    public void setTipoConstrucao(String tipoConstrucao) {
        this.tipoConstrucao = tipoConstrucao;
    }

    public List<Parente> getParentes() {
        return parentes;
    }

    public void setParentes(List<Parente> parentes) {
        this.parentes = parentes;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Documentacao> getDocumentosEntregues() {
        return documentosEntregues;
    }

    public void setDocumentosEntregues(List<Documentacao> documentosEntregues) {
        this.documentosEntregues = documentosEntregues;
    }

    public Double getRendaTotal() {
        return rendaTotal;
    }

    public void setRendaTotal(Double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public double getRendaPerCapta() {
        return rendaPerCapta;
    }

    public void setRendaPerCapta(double rendaPerCapta) {
        this.rendaPerCapta = rendaPerCapta;
    }

    public void setRendaTotal(double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public String getImpossibilidadesCusteio() {
        return impossibilidadesCusteio;
    }

    public void setImpossibilidadesCusteio(String impossibilidadesCusteio) {
        this.impossibilidadesCusteio = impossibilidadesCusteio;
    }

    public String getBensFamiliares() {
        return bensFamiliares;
    }

    public void setBensFamiliares(String bensFamiliares) {
        this.bensFamiliares = bensFamiliares;
    }

    public String getRiscosSociais() {
        return riscosSociais;
    }

    public void setRiscosSociais(String riscosSociais) {
        this.riscosSociais = riscosSociais;
    }

    public String getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(String emprestimos) {
        this.emprestimos = emprestimos;
    }

    public String getBreveResumo() {
        return breveResumo;
    }

    public void setBreveResumo(String breveResumo) {
        this.breveResumo = breveResumo;
    }

    public String getConclusoes() {
        return conclusoes;
    }

    public void setConclusoes(String conclusoes) {
        this.conclusoes = conclusoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getTipoCobrancaConsultas() {
        return tipoCobrancaConsultas;
    }

    public void setTipoCobrancaConsultas(Integer tipoCobrancaConsultas) {
        this.tipoCobrancaConsultas = tipoCobrancaConsultas;
    }

    public Integer getTipoCobrancaExames() {
        return tipoCobrancaExames;
    }

    public void setTipoCobrancaExames(Integer tipoCobrancaExames) {
        this.tipoCobrancaExames = tipoCobrancaExames;
    }

    public Integer getTipoCobrancaCirurgias() {
        return tipoCobrancaCirurgias;
    }

    public void setTipoCobrancaCirurgias(Integer tipoCobrancaCirurgias) {
        this.tipoCobrancaCirurgias = tipoCobrancaCirurgias;
    }

    public Double getValorDescontoExames() {
        return valorDescontoExames;
    }

    public void setValorDescontoExames(Double valorDescontoExames) {
        this.valorDescontoExames = valorDescontoExames;
    }

    public Double getValorDescontoCirurgias() {
        return valorDescontoCirurgias;
    }

    public void setValorDescontoCirurgias(Double valorDescontoCirurgias) {
        this.valorDescontoCirurgias = valorDescontoCirurgias;
    }

    public Double getValorDescontoConsultas() {
        return valorDescontoConsultas;
    }

    public void setValorDescontoConsultas(Double valorDescontoConsultas) {
        this.valorDescontoConsultas = valorDescontoConsultas;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProgramaTransferenciaRenda() {
        return programaTransferenciaRenda;
    }

    public void setProgramaTransferenciaRenda(String programaTransferenciaRenda) {
        this.programaTransferenciaRenda = programaTransferenciaRenda;
    }

    public boolean isEstudante() {
        return estudante;
    }

    public void setEstudante(boolean estudante) {
        this.estudante = estudante;
    }

    public Double getGastosMensais() {
        return gastosMensais;
    }

    public void setGastosMensais(Double gastosMensais) {
        this.gastosMensais = gastosMensais;
    }

    public String getFontCusteio() {
        return fontCusteio;
    }

    public void setFontCusteio(String fontCusteio) {
        this.fontCusteio = fontCusteio;
    }

    public String getBolsaOuBeneficio() {
        return bolsaOuBeneficio;
    }

    public void setBolsaOuBeneficio(String bolsaOuBeneficio) {
        this.bolsaOuBeneficio = bolsaOuBeneficio;
    }

}
