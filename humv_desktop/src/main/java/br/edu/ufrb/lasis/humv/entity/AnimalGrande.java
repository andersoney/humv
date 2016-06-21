package br.edu.ufrb.lasis.humv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

/**
 * Entidade que modela informaÃ§Ãµes de animais de grande porte. A diferenÃ§a
 * entre um animal de pequeno e grande porte Ã© a ausencia do campo 'pelagem'
 * nesta entidade.
 *
 * Ver requisito R003 em
 * {@link https://docs.google.com/document/d/1plQtd_M9Qg4SAR9AH0MDhJac_dL5KciqMtWlCBimTDo}
 *
 * @author Luiz AntÃ´nio Pereira
 *
 * @version 1.2
 *
 * @since 15 de maio de 2016
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalGrande {

    private String rghumv; // RGHUMV Ã© um nÃºmero de registro prÃ³prio do hospital veterinÃ¡rio.
    private String nome;
    private String especie;
    private String raca;
    private char sexo; // M = macho, F = femÃªa
    private int idade;
    private double peso;
    private String cpfDono; // Relacionamento entre animal e proprietario.
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
}
