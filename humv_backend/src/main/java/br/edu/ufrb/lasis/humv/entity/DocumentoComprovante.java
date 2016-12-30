package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENTOS")
public class DocumentoComprovante implements Serializable {
	
	private static final long serialVersionUID = -6125748157292589614L;
	
    public static final String BOLSA_FAMILIA = "Bolsa família";
    public static final String COMPROVANTE_ENDERECO = "Comprovante de endereço";
    public static final String RG_MEMBRO_FAMILIA = "RG de membro da família";
    public static final String RG_DONO = "RG do dono";
	
	@Id
	@GeneratedValue
	private BigInteger idDocumento;
	
	@ManyToOne
	private QuestionarioSocioeconomico questionario;
	
	private Date dataEntrega;
	
	private String nomeUsuarioRecebinte;
	private String nomeDocumento;
	private boolean na;
	private boolean vistoAssistenteSocial;

	public BigInteger getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(BigInteger idDocumento) {
		this.idDocumento = idDocumento;
	}

	public QuestionarioSocioeconomico getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioSocioeconomico questionario) {
		this.questionario = questionario;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getNomeUsuarioRecebinte() {
		return nomeUsuarioRecebinte;
	}

	public void setNomeUsuarioRecebinte(String nomeUsuarioRecebinte) {
		this.nomeUsuarioRecebinte = nomeUsuarioRecebinte;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public boolean isNa() {
		return na;
	}

	public void setNa(boolean na) {
		this.na = na;
	}

	public boolean isVistoAssistenteSocial() {
		return vistoAssistenteSocial;
	}

	public void setVistoAssistenteSocial(boolean vistoAssistenteSocial) {
		this.vistoAssistenteSocial = vistoAssistenteSocial;
	}
	
}
