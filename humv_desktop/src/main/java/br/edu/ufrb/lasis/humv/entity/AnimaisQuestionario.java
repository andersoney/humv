package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class AnimaisQuestionario implements Serializable {

    private static final long serialVersionUID = -4309147069247595796L;

    private BigInteger rghumv; // RGHUMV é um número de registro próprio do hospital veterinário.
    private String nome;
    private String especie;
    private String raca;
    private char sexo; // M = macho, F = femêa
    private int idade;
    private double peso;
    private String pelagem; // não se aplica para animais de grande porte.
    private String porte; // pequeno ou grande
    private Date dataCadastro; // Data que o animal foi cadastrado no sistema.
    private Dono dono;
    private String obs;

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObs() {
        return obs;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public BigInteger getRghumv() {
        return rghumv;
    }

    public void setRghumv(BigInteger rghumv) {
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

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
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
