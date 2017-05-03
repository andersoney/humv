package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Material implements Serializable {

    private static final long serialVersionUID = -6125748157292589614L;

    private BigInteger id;
    private String discriminacao;
    private String unidade;
    private Integer tipo; // material ou medicamento
    private String modelo; // Aplicavel apenas a materiais cirurgicos 
    private int quantidadeDisponivel; // Quantidade em estoque do material
    private double valor; // em R$
    private Date validade;
    private BigInteger numeroNotaFiscal;

    private int kit = 0; // 1 - para modelo 1, 2 - para modelo 2, 0 - para nenhum modelo, ver R50
    private int quantidadeEmKit = 0;

    public int getQuantidadeEmKit() {
        return quantidadeEmKit;
    }

    public void setQuantidadeEmKit(int quantidadeEmKit) {
        this.quantidadeEmKit = quantidadeEmKit;
    }

    public int getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigInteger getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(BigInteger numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public void setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

}
