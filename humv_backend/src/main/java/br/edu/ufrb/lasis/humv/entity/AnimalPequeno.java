package br.edu.ufrb.lasis.humv.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**Entidade que modela informações de animais de pequeno porte.
 * A diferença entre um animal de pequeno e grande porte é a presença do campo 'pelagem' nesta entidade.
 * 
 * Ver requisito R003 em {@link https://docs.google.com/document/d/1plQtd_M9Qg4SAR9AH0MDhJac_dL5KciqMtWlCBimTDo}
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 15 de maio de 2016
 * */
@Entity
@Table(name="ANIMAIS_PEQUENOS")
public class AnimalPequeno extends AnimalGrande{
	private static final long serialVersionUID = 643128194360002867L;
	
	private String pelagem;
	public String getPelagem() {
		return pelagem;
	}
	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
}