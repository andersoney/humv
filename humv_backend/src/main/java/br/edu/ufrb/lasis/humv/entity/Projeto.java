package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="PROJETOS")
public class Projeto implements Serializable {

	private static final long serialVersionUID = -1746891834638705105L;

	@Id
	@GeneratedValue 
	private BigInteger id;
	private Date dataCadastro;
	private String nome;
	private String nomeResponsavel;
	private BigInteger siapeResponsavel;
	private String finalidade;
	private Date dataInicio;
	private Date dataFim;
	private String tipo;
	private String publicoAlvo;
	
	@JoinColumn(name="id_setor")
	private Setor setor;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public BigInteger getSiapeResponsavel() {
		return siapeResponsavel;
	}

	public void setSiapeResponsavel(BigInteger siapeResponsavel) {
		this.siapeResponsavel = siapeResponsavel;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
