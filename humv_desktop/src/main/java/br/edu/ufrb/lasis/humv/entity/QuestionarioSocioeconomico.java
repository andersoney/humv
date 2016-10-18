package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

public class QuestionarioSocioeconomico implements Serializable {

    private static final long serialVersionUID = -4309147069247595796L;

    private int idQuestionario;
    private String nomeDono;
    private String estadoCivil;
    private String endereco;
    private String telefone;
    private int idade;
    private BigInteger nis;
    private BigInteger cpf;
    private String escolaridade;
    private String profissao;
    private String ocupacaoAtual;
    private double rendaFormal;
    private double rendaInformal;
    private boolean temSaneamento;
    private boolean temEnergia;
    private String condicaoMoradia;
    private double valorAluguel;
    private String tipoConstrucao;
    private String programaRenda; // Ex.: Bolsa Familia
    private String situacoesRiscoRenda;
    private String historicoFamiliar;
    
    //_______________________________ Somente para estudantes________________________________
    private String condicoesMoradiaEstudante;
    private double valorGastos;
    private String fonteCusteio;
    private String bolsa; 
    //_______________________________________________________________________________________
    
    private ArrayList<Parente> parentes;
    private ArrayList<AnimaisQuestionario> animais;
    
    private ArrayList<Documentacao> documentosEntregues;
    
    private double rendaPerCapta;
    private double rendaTotal;
    private String impossibilidadesCusteio;
    private String bensFamiliares;
    private String riscosSociais;
    private String emprestimos;
    
    private String orientacoes;
    private String breveResumo;
    private String conclusoes;
    private String observacoes;

    private String tipoCobrancaConsultas; //valor normal, valor aula, desconto ou isenção
    private String tipoCobrancaExames; //valor normal, valor aula, desconto ou isenção
    private String tipoCobrancaCirurgias; //valor normal, valor aula, desconto ou isenção
    private double valorDescontoExames;
    private double valorDescontoCirurgias;
    private double valorDescontoConsultas;
    
    public void setOrientacoes(String orientacoes){
        this.orientacoes = orientacoes;
    }
    
    public void setHistoricoFamiliar(String historicoFamiliar){
        this.historicoFamiliar = historicoFamiliar;
    }
    
    public void setSituacoesRiscoRenda(String situacoesRiscoRenda){
        this.situacoesRiscoRenda = situacoesRiscoRenda;
    }
    
    public void setBolsa(String bolsa){
        this.bolsa = bolsa;
    }
    
    public void setValorGastos(double valorGastos){
        this.valorGastos = valorGastos;
    }
    
    public void setFonteCusteio(String fonteCusteio){
        this.fonteCusteio = fonteCusteio;
    }
    
    public void setCondicoesMoradiaEstudante(String condicoesMoradiaEstudante){
        this.condicoesMoradiaEstudante = condicoesMoradiaEstudante;
    }
    
    public void setProgramaRenda(String programaRenda){
        this.programaRenda = programaRenda;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEscolaridade(String escolaridade){
        this.escolaridade = escolaridade;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void setCpf(BigInteger cpf){
        this.cpf = cpf;
    }
    
    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
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

    public int getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(int idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getTipoCobrancaConsultas() {
        return tipoCobrancaConsultas;
    }

    public void setTipoCobrancaConsultas(String tipoCobrancaConsultas) {
        this.tipoCobrancaConsultas = tipoCobrancaConsultas;
    }

    public String getTipoCobrancaExames() {
        return tipoCobrancaExames;
    }

    public void setTipoCobrancaExames(String tipoCobrancaExames) {
        this.tipoCobrancaExames = tipoCobrancaExames;
    }

    public String getTipoCobrancaCirurgias() {
        return tipoCobrancaCirurgias;
    }

    public void setTipoCobrancaCirurgias(String tipoCobrancaCirurgias) {
        this.tipoCobrancaCirurgias = tipoCobrancaCirurgias;
    }

    public double getValorDescontoExames() {
        return valorDescontoExames;
    }

    public void setValorDescontoExames(double valorDescontoExames) {
        this.valorDescontoExames = valorDescontoExames;
    }

    public double getValorDescontoCirurgias() {
        return valorDescontoCirurgias;
    }

    public void setValorDescontoCirurgias(double valorDescontoCirurgias) {
        this.valorDescontoCirurgias = valorDescontoCirurgias;
    }

    public double getValorDescontoConsultas() {
        return valorDescontoConsultas;
    }

    public void setValorDescontoConsultas(double valorDescontoConsultas) {
        this.valorDescontoConsultas = valorDescontoConsultas;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public BigInteger getNis() {
        return nis;
    }

    public void setNis(BigInteger nis) {
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

    public double getRendaFormal() {
        return rendaFormal;
    }

    public void setRendaFormal(double rendaFormal) {
        this.rendaFormal = rendaFormal;
    }

    public double getRendaInformal() {
        return rendaInformal;
    }

    public void setRendaInformal(double rendaInformal) {
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

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getTipoConstrucao() {
        return tipoConstrucao;
    }

    public void setTipoConstrucao(String tipoConstrucao) {
        this.tipoConstrucao = tipoConstrucao;
    }

    public ArrayList<Parente> getParentes() {
        return parentes;
    }

    public void setParentes(ArrayList<Parente> parentes) {
        this.parentes = parentes;
    }

    public ArrayList<AnimaisQuestionario> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<AnimaisQuestionario> animais) {
        this.animais = animais;
    }

    public double getRendaPerCapta() {
        return rendaPerCapta;
    }

    public void setRendaPerCapta(double rendaPerCapta) {
        this.rendaPerCapta = rendaPerCapta;
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public void setRendaTotal(double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public ArrayList<Documentacao> getDocumentosEntregues() {
        return documentosEntregues;
    }

    public void setDocumentosEntregues(ArrayList<Documentacao> documentosEntregues) {
        this.documentosEntregues = documentosEntregues;
    }
}
