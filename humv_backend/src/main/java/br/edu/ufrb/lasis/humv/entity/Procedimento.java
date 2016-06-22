package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="PROCEDIMENTOS")
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1274972987399L;

	@Id
	@JoinColumn(name="CODIGO")
	String codigo;
	
	String nome;
	double valor;
	String codSetor;
	
	public Procedimento(){}
	
	public String getCodSetor() {
		return codSetor;
	}

	public void setCodSetor(String codSetor) {
		this.codSetor = codSetor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor(){
		return this.valor;
	}

	public String getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
}