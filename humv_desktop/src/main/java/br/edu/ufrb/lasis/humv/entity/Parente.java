package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class Parente implements Serializable {

    private static final long serialVersionUID = -6125748157292589614L;
    private BigInteger id;

    private String nomeClienteCadastrado;

    private String nome;
    private int idade;
    private String parentesco;
    private double renda;
    private String escolaridade;
    private String ocupacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getNomeClienteCadastrado() {
        return nomeClienteCadastrado;
    }

    public void setNomeClienteCadastrado(String nomeClienteCadastrado) {
        this.nomeClienteCadastrado = nomeClienteCadastrado;
    }

}
