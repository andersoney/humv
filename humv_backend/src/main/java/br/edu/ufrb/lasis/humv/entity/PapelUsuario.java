package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PAPEIS_USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "PAPEL", "USUARIO_ID" }))
public class PapelUsuario implements Serializable {

	private static final long serialVersionUID = -5175042223077958364L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioPapelId;
	
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name = "PAPEL", nullable = false, length = 45)
	private String papel;

	public PapelUsuario() {}

	public PapelUsuario(Usuario usuario, String papel) {
		this.usuario = usuario;
		this.papel = papel;
	}

	public Integer getUsuarioPapelId() {
		return this.usuarioPapelId;
	}

	public void setUsuarioPapelId(Integer usuarioPapelId) {
		this.usuarioPapelId = usuarioPapelId;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPapel() {
		return this.papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

}