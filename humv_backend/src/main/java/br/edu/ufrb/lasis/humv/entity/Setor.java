package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Entidade que modela informações de setores.

 * 
 *
 *  
 *  @author Vinicius Moura
 *  
 *  @version 1.0
 *  
 *  @since 7 de junho de 2016
 * */
@Entity
@Table(name="SETOR")
public class Setor implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3567599639175582162L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getId(){
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}