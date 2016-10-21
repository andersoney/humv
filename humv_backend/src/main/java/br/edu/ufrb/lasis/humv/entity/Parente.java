package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARENTES")
public class Parente implements Serializable {
	
	private static final long serialVersionUID = -6125748157292589614L;
	@Id
	@GeneratedValue
	private BigInteger id;
	
	//private String nomeClienteCadastrado;//TODO verificar se isso é viável
	
	private String nome;
	private Integer idade;
	private String parentesco;
	private Integer renda;
	
	//De acordo com os atributos de QuestionarioSocioeconomico pra escolaridade
	private Integer escolaridade;
	private String ocupacao;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	public Integer getRenda() {
		return renda;
	}

	public void setRenda(Integer renda) {
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
