package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

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

	@Id
	//@GeneratedValue
	private Integer codigo;
	private String nome;
	private double valor;
	private Integer codSetor;
	
	public Procedimento(){}
	
	public Integer getCodSetor() {
		return codSetor;
	}

	public void setCodSetor(Integer codSetor) {
		this.codSetor = codSetor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor(){
		return this.valor;
	}

	public Integer getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
}