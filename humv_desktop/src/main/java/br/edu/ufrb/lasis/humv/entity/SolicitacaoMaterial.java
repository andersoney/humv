package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;
import java.util.Date;

public class SolicitacaoMaterial {

    private BigInteger id;
    private Material material;

    private BigInteger rghumvAnimal;
    private String nomeSetor;
    private boolean cirurgico = false;
    private String modelo = ""; // será preenchido somente se o material for cirurgico;

    private Integer quantidadeSolicitada;
    private Integer quantidadeLiberada;
    private Date dataSolicitacao;
    private Date dataLiberacao;

    private String situacaoStatus = "solicitação não vista"; // solicitaçao vista, solicitação autorizada.

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Date dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    public void setQuantidadeSolicitada(Integer quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Integer getQuantidadeLiberada() {
        return quantidadeLiberada;
    }

    public void setQuantidadeLiberada(Integer quantidadeLiberada) {
        this.quantidadeLiberada = quantidadeLiberada;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSituacaoStatus() {
        return situacaoStatus;
    }

    public void setSituacaoStatus(String situacaoStatus) {
        this.situacaoStatus = situacaoStatus;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigInteger getRghumvAnimal() {
        return rghumvAnimal;
    }

    public void setRghumvAnimal(BigInteger rghumvAnimal) {
        this.rghumvAnimal = rghumvAnimal;
    }

    public Integer getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isCirurgico() {
        return cirurgico;
    }

    public void setCirurgico(boolean cirurgico) {
        this.cirurgico = cirurgico;
    }

}
