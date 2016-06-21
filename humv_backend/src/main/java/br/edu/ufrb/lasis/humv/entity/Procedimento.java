package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Procedimento")
public class Procedimento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1274972987399L;

	@Id
	Integer codigo;
	
	@PrimaryKeyJoinColumn
	String nome;
	
	Float valor;

	public Procedimento(){
		
	}
	
	public Integer getCodigo(){
		return this.codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Float getValor(){
		return this.valor;
	}
	
	public void setCodigo(Integer codigo){
		this.codigo=codigo;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setValor(Float valor){
		this.valor=valor;
	}
	
	
}
