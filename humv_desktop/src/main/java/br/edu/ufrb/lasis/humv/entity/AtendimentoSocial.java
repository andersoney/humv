package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Luiz Toni
 */
public class AtendimentoSocial {

    private BigInteger id;
    private Dono dono;
    private Animal animal;
    private String observacoesDono;
    private String observacoesAnimal;
    private String situacaoAnimal;
    private Date data;

    private String tipoCobrancaConsultas;
    private String tipoCobrancaExames;
    private String tipoCobrancaCirurgias;

    private int percentualDescontoConsultas;
    private int percentualDescontoExames;
    private int percentualDescontoCirurgias;

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getObservacoesDono() {
        return observacoesDono;
    }

    public void setObservacoesDono(String observacoesDono) {
        this.observacoesDono = observacoesDono;
    }

    public String getObservacoesAnimal() {
        return observacoesAnimal;
    }

    public void setObservacoesAnimal(String observacoesAnimal) {
        this.observacoesAnimal = observacoesAnimal;
    }

    public String getTipoCobrancaConsultas() {
        return tipoCobrancaConsultas;
    }

    public void setTipoCobrancaConsultas(String tipoCobrancaConsultas) {
        this.tipoCobrancaConsultas = tipoCobrancaConsultas;
    }

    public String getTipoCobrancaExames() {
        return tipoCobrancaExames;
    }

    public void setTipoCobrancaExames(String tipoCobrancaExames) {
        this.tipoCobrancaExames = tipoCobrancaExames;
    }

    public String getTipoCobrancaCirurgias() {
        return tipoCobrancaCirurgias;
    }

    public void setTipoCobrancaCirurgias(String tipoCobrancaCirurgias) {
        this.tipoCobrancaCirurgias = tipoCobrancaCirurgias;
    }

    public double getPercentualDescontoConsultas() {
        return percentualDescontoConsultas;
    }

    public void setPercentualDescontoConsultas(int percentualDescontoConsultas) {
        this.percentualDescontoConsultas = percentualDescontoConsultas;
    }

    public double getPercentualDescontoExames() {
        return percentualDescontoExames;
    }

    public void setPercentualDescontoExames(int percentualDescontoExames) {
        this.percentualDescontoExames = percentualDescontoExames;
    }

    public double getPercentualDescontoCirurgias() {
        return percentualDescontoCirurgias;
    }

    public void setPercentualDescontoCirurgias(int percentualDescontoCirurgias) {
        this.percentualDescontoCirurgias = percentualDescontoCirurgias;
    }

    public String getSituacaoAnimal() {
        return situacaoAnimal;
    }

    public void setSituacaoAnimal(String situacaoAnimal) {
        this.situacaoAnimal = situacaoAnimal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigInteger getId() {
        return id;
    }
}
