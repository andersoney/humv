package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.util.Date;



/**Entidade que modela informações de animais de grande e pequeno porte.
 * A diferença entre um animal de pequeno e grande porte é a ausencia do campo 'pelagem' nesta entidade.
 * 
 * Ver requisito R003 em {@link https://docs.google.com/document/d/1plQtd_M9Qg4SAR9AH0MDhJac_dL5KciqMtWlCBimTDo}
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.2
 *  
 *  @since 15 de maio de 2016
 * */


public class Animal implements Serializable{
	
	private static final long serialVersionUID = -4309147069247595796L;
	
	
	private String rghumv; // RGHUMV é um número de registro próprio do hospital veterinário.
	private String nome;
	private String especie;
	private String raca;
	private char sexo; // M = macho, F = femêa
	private int idade;
	private double peso;
	private String cpfDono; // Relacionamento entre animal e proprietario.
	private String pelagem; // não se aplica para animais de grande porte.
	private String porte; // pequeno ou grande
	
	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	private Date dataCadastro; // Data que o animal foi cadastrado no sistema.

	public String getRghumv() {
		return rghumv;
	}

	public void setRghumv(String rghumv) {
		this.rghumv = rghumv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
    
	public String getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getPelagem() {
		return pelagem;
	}
	
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
}