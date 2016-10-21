package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Documentacao implements Serializable {
	
	private static final long serialVersionUID = -6125748157292589614L;
	
	@Id
	@GeneratedValue
	private BigInteger id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@Column
	private String nomeRecebinte;
	
	@Column
	private String nomeDocumento;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

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