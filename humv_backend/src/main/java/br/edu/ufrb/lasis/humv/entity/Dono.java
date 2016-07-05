package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade que modela informações de dono de animais.
 *
 *
 * Ver requisitos R002 - R006
 *
 * 
 * @author Luiz Antônio Pereira
 * 
 * @version 3
 *
 * @since 26 de junho de 2016
 *
 */
@Entity
@Table(name="DONOS")
public class Dono implements Serializable {
	
	private static final long serialVersionUID = -6125748157292589614L;
	
	@Id
	private String id; // recebe o numero do CPF ou CNPJ do novo dono.
	private String tipoId; // Pode ser CPF ou CNPJ
	private String nome;
	private String endereco;
	private String estado;
	private String cep;
	private String telefone;
	private String cidade; // Obs.: pode ser uma fazenda ou distrito em caso de zona rural.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}