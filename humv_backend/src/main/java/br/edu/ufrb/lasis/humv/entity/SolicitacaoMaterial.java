package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SOLICITACOES_MATERIAIS")
public class SolicitacaoMaterial implements Serializable {
	private static final long serialVersionUID = -2862522164162006684L;
	
	@Id
    @GeneratedValue
    private BigInteger id;
    
    @ManyToOne
    @JoinColumn
    private Material material;
    
    private BigInteger rghumv;
    private String setor;
    private int quantidadeSolicitada;
    private int quantidadeLiberada;
    private String modelo; // Para materiais cirurgicos, ver R044
    private String status; // solicitaçao vista, solicitação nao vista.
    
    
    public int getQuantidadeLiberada() {
        return quantidadeLiberada;
    }

    public void setQuantidadeLiberada(int quantidadeLiberada) {
        this.quantidadeLiberada = quantidadeLiberada;
    }
    
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public BigInteger getRghumv() {
        return rghumv;
    }

    /**
     * @param rghumv the animal to set
     */
    public void setRghumv(BigInteger rghumv) {
        this.rghumv = rghumv;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    /**
     * @param quantidadeSolicitada the quantidade to set
     */
    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

}
