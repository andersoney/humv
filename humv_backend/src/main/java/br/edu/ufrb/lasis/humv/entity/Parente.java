package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARENTES")
public class Parente implements Serializable {
	
	private static final long serialVersionUID = -6125748157292589614L;
	
	@Id
	@GeneratedValue
	private BigInteger idParente;
	
	@ManyToOne
	@JoinColumn
	private QuestionarioSocioeconomico questionario;
		
	private String nome;
	private Integer idade;
	private String parentesco;
	private Double renda;
	private Integer escolaridade; //De acordo com os atributos de QuestionarioSocioeconomico pra escolaridade
	private String ocupacao;

	public BigInteger getIdParente() {
		return idParente;
	}

	public void setIdParente(BigInteger idParente) {
		this.idParente = idParente;
	}

	public QuestionarioSocioeconomico getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioSocioeconomico questionario) {
		this.questionario = questionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	
}
