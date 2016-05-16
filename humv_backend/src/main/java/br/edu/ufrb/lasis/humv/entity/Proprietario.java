package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**Entidade que modela informações e métodos de propriétarios de animais.
 * 
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 15 de maio de 2016
 * */
@Entity
@Table(name="PROPRIETARIOS")
public class Proprietario implements Serializable {
	private static final long serialVersionUID = -6125748157292589614L;
	@Id
	private String cpf;
	private String nome;
	private String endereco;
	private String estado;
	private String cep;
	private String telefone;
	private String cidade; // Obs.: pode ser uma fazenda ou distrito em caso de zona rural.
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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