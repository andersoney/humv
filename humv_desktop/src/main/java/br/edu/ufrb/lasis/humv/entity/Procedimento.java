package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1274972987399L;
    String codigo;
    String nome;
    String codSetor;
    double valor;

    public Procedimento() {}

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getCodSetor() {
        return this.codSetor;
    }
    public void setCodSetor(String codSetor) {
        this.codSetor = codSetor;
    }
}