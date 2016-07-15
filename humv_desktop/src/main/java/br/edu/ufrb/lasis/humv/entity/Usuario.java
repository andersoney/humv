package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;


public class Usuario {

    private BigInteger siape;
    private String email;
    private String nome;
    private String senha;
    private String perfil;
    private boolean ativo;

    public BigInteger getSiape() {
        return siape;
    }

    public void setSiape(BigInteger siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
