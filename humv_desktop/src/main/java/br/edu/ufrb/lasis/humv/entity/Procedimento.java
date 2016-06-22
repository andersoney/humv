package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;

public class Procedimento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1274972987399L;
    Integer codigo;
    String nome;
    Float valor;
    
    int codSetor;

    public Procedimento() {

    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    public Integer getCodSetor() {
        return this.codSetor;
    }
    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }
}
