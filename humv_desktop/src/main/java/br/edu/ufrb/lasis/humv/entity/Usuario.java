package br.edu.ufrb.lasis.humv.entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static final long serialVersionUID = -1487845401492394032L;
    private Integer siape;
    private String email;
    private String nome;
    private String senha;
    private List<PapelUsuario> papelUsuario = new ArrayList<PapelUsuario>();

    public Integer getSiape() {
        return siape;
    }

    public void setSiape(Integer siape) {
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

    public List<PapelUsuario> getPapelUsuario() {
        return papelUsuario;
    }

    public void setPapelUsuario(List<PapelUsuario> usuarioPapel) {
        this.papelUsuario = usuarioPapel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
