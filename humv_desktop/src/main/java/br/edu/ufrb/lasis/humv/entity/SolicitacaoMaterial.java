package br.edu.ufrb.lasis.humv.entity;

import java.math.BigInteger;


public class SolicitacaoMaterial {

    private BigInteger id;
    private Material material;
    
    private BigInteger rghumvAnimal;
    private String nomeSetor;
    private String modelo = ""; // será preenchido somente se o material for cirurgico;

    private Integer quantidadeSolicitada;
    private Integer quantidadeLiberada;
    
    private String situacaoStatus; // solicitaçao vista, solicitação nao vista.
    
    
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
    
    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the animal
     */
    public BigInteger getRghumvAnimal() {
        return rghumvAnimal;
    }

    /**
     * @param rghumvAnimal the animal to set
     */
    public void setRghumvAnimal(BigInteger rghumvAnimal) {
        this.rghumvAnimal = rghumvAnimal;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    /**
     * @param quantidadeSolicitada the quantidade to set
     */
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
}
