package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Entidade que modela informações de procedimento.
 *
 *
 * Ver requisitos R011 - R014
 *
 * @author Luiz Antônio Pereira
 *
 * @version 3
 *
 * @since 26 de junho de 2016
 *
 */
public class Procedimento implements Serializable {

    private static final long serialVersionUID = 1274972987399L;

    private BigInteger codigo;
    private String nome;
    private Setor setor;
    private double valor;

    public BigInteger getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

}
