package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
    public static final Integer COBRANCA_D100 = 1;
    public static final Integer COBRANCA_D75 = 2;
    public static final Integer COBRANCA_D50 = 3;
    public static final Integer COBRANCA_D25 = 3;
    private BigInteger id;

    private Dono dono;

    private Date dataResposta;
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
    private String observacoesDadosDono;

    private List<Parente> parentes;

    private List<DocumentoComprovante> documentosEntregues;

    private Double rendaPerCapta;
    private Double rendaTotal;
    private String impossibilidadesCusteio;
    private String bensFamiliares;
    private String riscosSociais;
    private String emprestimos;

    private String analiseBreveResumo;
    private String analiseObservacoes;
    private String analiseConclusoes;

    //Relacionado com atributos da classe Atendimento: valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaConsultas;

    //Relacionado com atributos da classe Atendimento: valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaExames;

    //valor normal, valor aula, desconto ou isenção
    private Integer tipoCobrancaCirurgias;

    private Double valorDescontoExames;
    private Double valorDescontoCirurgias;

    private Double valorDescontoConsultas;
    
    private boolean validade6Meses;

    private boolean dependeFinanceiramente;
    private boolean possuiDependentes;
    private boolean doencaCronica;
    private boolean trabalhadorInformal;
    private boolean quebraVinculo;
    private boolean situacaoIncapacitante;
    private boolean dividasBanco;
    private boolean beneficioSocial;
    private boolean trocaDomicilio;
    private boolean protecaoAnimal;
    private boolean primeiroAtendimento;
    private boolean animalDoado;
    private boolean atendimentoUrgencia;
    private boolean naoCondicoesParticular;
    private boolean deficiencia;

    public boolean isDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }
    
    public boolean isDependeFinanceiramente() {
        return dependeFinanceiramente;
    }

    public void setDependeFinanceiramente(boolean dependeFinanceiramente) {
        this.dependeFinanceiramente = dependeFinanceiramente;
    }

    public boolean isPossuiDependentes() {
        return possuiDependentes;
    }

    public void setPossuiDependentes(boolean possuiDependentes) {
        this.possuiDependentes = possuiDependentes;
    }

    public boolean isDoencaCronica() {
        return doencaCronica;
    }

    public void setDoencaCronica(boolean doencaCronica) {
        this.doencaCronica = doencaCronica;
    }

    public boolean isTrabalhadorInformal() {
        return trabalhadorInformal;
    }

    public void setTrabalhadorInformal(boolean trabalhadorInformal) {
        this.trabalhadorInformal = trabalhadorInformal;
    }

    public boolean isQuebraVinculo() {
        return quebraVinculo;
    }

    public void setQuebraVinculo(boolean quebraVinculo) {
        this.quebraVinculo = quebraVinculo;
    }

    public boolean isSituacaoIncapacitante() {
        return situacaoIncapacitante;
    }

    public void setSituacaoIncapacitante(boolean situacaoIncapacitante) {
        this.situacaoIncapacitante = situacaoIncapacitante;
    }

    public boolean isDividasBanco() {
        return dividasBanco;
    }

    public void setDividasBanco(boolean dividasBanco) {
        this.dividasBanco = dividasBanco;
    }

    public boolean isBeneficioSocial() {
        return beneficioSocial;
    }

    public void setBeneficioSocial(boolean beneficioSocial) {
        this.beneficioSocial = beneficioSocial;
    }

    public boolean isTrocaDomicilio() {
        return trocaDomicilio;
    }

    public void setTrocaDomicilio(boolean trocaDomicilio) {
        this.trocaDomicilio = trocaDomicilio;
    }

    public boolean isProtecaoAnimal() {
        return protecaoAnimal;
    }

    public void setProtecaoAnimal(boolean protecaoAnimal) {
        this.protecaoAnimal = protecaoAnimal;
    }

    public boolean isPrimeiroAtendimento() {
        return primeiroAtendimento;
    }

    public void setPrimeiroAtendimento(boolean primeiroAtendimento) {
        this.primeiroAtendimento = primeiroAtendimento;
    }

    public boolean isAnimalDoado() {
        return animalDoado;
    }

    public void setAnimalDoado(boolean animalDoado) {
        this.animalDoado = animalDoado;
    }

    public boolean isAtendimentoUrgencia() {
        return atendimentoUrgencia;
    }

    public void setAtendimentoUrgencia(boolean atendimentoUrgencia) {
        this.atendimentoUrgencia = atendimentoUrgencia;
    }

    public boolean isNaoCondicoesParticular() {
        return naoCondicoesParticular;
    }

    public void setNaoCondicoesParticular(boolean naoCondicoesParticular) {
        this.naoCondicoesParticular = naoCondicoesParticular;
    }
    
    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
        this.dataResposta = dataResposta;
    }

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

    public List<DocumentoComprovante> getDocumentosEntregues() {
        return documentosEntregues;
    }

    public void setDocumentosEntregues(List<DocumentoComprovante> documentosEntregues) {
        this.documentosEntregues = documentosEntregues;
    }

    public Double getRendaPerCapta() {
        return rendaPerCapta;
    }

    public void setRendaPerCapta(Double rendaPerCapta) {
        this.rendaPerCapta = rendaPerCapta;
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

    public String getAnaliseBreveResumo() {
        return analiseBreveResumo;
    }

    public void setAnaliseBreveResumo(String analiseBreveResumo) {
        this.analiseBreveResumo = analiseBreveResumo;
    }

    public String getAnaliseConclusoes() {
        return analiseConclusoes;
    }

    public void setAnaliseConclusoes(String analiseConclusoes) {
        this.analiseConclusoes = analiseConclusoes;
    }

    public String getObservacoesDadosDono() {
        return observacoesDadosDono;
    }

    public void setObservacoesDadosDono(String observacoesDadosDono) {
        this.observacoesDadosDono = observacoesDadosDono;
    }

    public String getAnaliseObservacoes() {
        return analiseObservacoes;
    }

    public void setAnaliseObservacoes(String analiseObservacoes) {
        this.analiseObservacoes = analiseObservacoes;
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

    public Double getRendaTotal() {
        return rendaTotal;
    }

    public void setRendaTotal(Double rendaTotal) {
        this.rendaTotal = rendaTotal;
    }

    public boolean isValidade6Meses() {
        return validade6Meses;
    }

    public void setValidade6Meses(boolean validade6Meses) {
        this.validade6Meses = validade6Meses;
    }

}
