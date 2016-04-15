package br.edu.ufrb.lasis.humv.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hello implements Serializable {

	private static final long serialVersionUID = -106456548632220994L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
