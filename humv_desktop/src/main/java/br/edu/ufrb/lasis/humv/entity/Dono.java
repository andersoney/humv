package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;


/**Entidade que modela informaÃ§Ãµes e mÃ©todos de propriÃ©tarios de animais.
 * 
 *  @author Luiz AntÃ´nio Pereira
 *  
 *  @version 1
 *  
 *  @since 15 de maio de 2016
 * */
public class Dono implements Serializable {
	private String cpf;
	private String nome;
	private String endereco;
	private String estado;
	private String cep;
	private String telefone;
	
	private String cidade; // Obs.: pode ser uma fazenda ou distrito em caso de zona rural.

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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