package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
public class Setor implements Serializable {
    private static final long serialVersionUID = 3567599639175582162L;

    private String codigo;
    private String nome;

    public Setor(){}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
