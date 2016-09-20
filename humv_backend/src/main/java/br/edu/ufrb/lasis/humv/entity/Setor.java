package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Entidade que modela informações de setor.
 *
 *
 * Ver requisitos R007 - R010
 *
 * 
 * @author Vinicius Moura
 * 
 * @version 1.0
 *
 * @since 26 de junho de 2016
 *
 */@Entity
@Table(name="SETORES")
public class Setor implements Serializable {

	private static final long serialVersionUID = 3567599639175582162L;
	
	@Id
	@GeneratedValue
	private BigInteger codigo;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigInteger getCodigo(){
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}
	
}