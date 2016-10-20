package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Documentacao implements Serializable {

    @Id
    private Long ID;

    private static final long serialVersionUID = -6125748157292589614L;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    @Column
    private String nomeRecebinte;
    @Column
    private String nomeDocumento;

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getNomeRecebinte() {
        return nomeRecebinte;
    }

    public void setNomeRecebinte(String nomeRecebinte) {
        this.nomeRecebinte = nomeRecebinte;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
