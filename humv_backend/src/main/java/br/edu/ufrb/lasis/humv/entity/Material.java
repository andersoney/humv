package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAIS")
public class Material implements Serializable {

    private static final long serialVersionUID = -6125748157292589614L;

    @Id
    @GeneratedValue
    private BigInteger id;
    private String discriminacao;
    private String unidade;
    private String tipo; // material ou medicamento
    private double valor; // em R$
    private Date validade;
    private BigInteger numeroNotaFiscal;
    private int kit = 0; // 1 - para modelo 1, 2 - para modelo 2, 0 - para nenhum modelo, ver R50
    private int quantidadeEmKit = 0;
    
    public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public BigInteger getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}

	public void setNumeroNotaFiscal(BigInteger numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
