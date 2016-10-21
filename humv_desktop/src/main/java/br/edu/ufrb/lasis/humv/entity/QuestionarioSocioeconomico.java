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
	
	private BigInteger id;
	private Dono dono;
	
	private Integer estadoCivil;
	private Integer idade;
	private Integer nis;
	private String profissao;
	private String ocupacaoAtual;
	private Double rendaFormal;
	private Double rendaInformal;
	private boolean temSaneamento;
	private boolean temEnergia;
	private String condicaoMoradia;
	private Double valorAluguel;
	private String tipoConstrucao;
	
	
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
}
