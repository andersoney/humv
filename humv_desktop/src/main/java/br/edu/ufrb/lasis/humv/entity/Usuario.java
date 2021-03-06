package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;

public class Usuario {

    public static final String ADMINISTRADOR = "Administrador";
    public static final String RECEPCIONISTA = "Recepcionista";
    public static final String VETERINARIO = "Médico";
    public static final String FARMACEUTICO = "Farmacêutico";
    public static final String ASSISTENTE_SOCIAL = "Assistente Social";

    public static final Integer PERFIL_ADMINISTRADOR = 0;
    public static final Integer PERFIL_RECEPCIONISTA = 1;
    public static final Integer PERFIL_VETERINARIO = 2;
    public static final Integer PERFIL_FARMACEUTICO = 3;
    public static final Integer PERFIL_ASSISTENTE_SOCIAL = 4;

    private String email;
    private BigInteger siape;
    private String nome;
    private String senha;
    private Integer perfil;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPerfil() {
        return perfil;
    }

    public void setPerfil(Integer perfil) {
        this.perfil = perfil;
    }

}
