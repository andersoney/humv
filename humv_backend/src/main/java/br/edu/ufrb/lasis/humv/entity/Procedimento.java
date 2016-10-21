package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Entidade que modela informações de procedimento.
 *
 *
 * Ver requisitos R011 - R014
 *
 * 
 * @author Andersoney Rodrigues
 * 
 * @version 1.1
 *
 * @since 26 de junho de 2016
 *
 */

@Entity
@Table(name="PROCEDIMENTOS")
public class Procedimento implements Serializable {
	
	private static final long serialVersionUID = 1274972987399L;
	
	public static final Integer TIPO_CONSULTA = 1;
	public static final Integer TIPO_AMBULATORIO_EXAME = 2;
	public static final Integer TIPO_CIRURGIA_REPRODUCAO = 3;
	public static final Integer TIPO_OUTROS = 4;

	@Id
	//@GeneratedValue
	private BigInteger codigo;
	private String nome;
	private double valor;
	private Integer tipo;
	
	@OneToOne
	@JoinColumn(name="id_procedimento")
	private Setor setor;
	
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor(){
		return this.valor;
	}

	public BigInteger getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(BigInteger codigo){
		this.codigo = codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
}