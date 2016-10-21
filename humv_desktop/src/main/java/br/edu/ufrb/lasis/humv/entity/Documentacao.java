package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.util.Date;

public class Documentacao implements Serializable {

    private static final long serialVersionUID = -6125748157292589614L;
    private Date dataEntrega;
    private String nomeRecebinte;
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
}
