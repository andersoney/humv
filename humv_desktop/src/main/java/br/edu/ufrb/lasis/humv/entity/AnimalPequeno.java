package br.edu.ufrb.lasis.humv.entity;


/**Entidade que modela informaÃ§Ãµes de animais de pequeno porte.
 * A diferenÃ§a entre um animal de pequeno e grande porte Ã© a presenÃ§a do campo 'pelagem' nesta entidade.
 * 
 * Ver requisito R003 em {@link https://docs.google.com/document/d/1plQtd_M9Qg4SAR9AH0MDhJac_dL5KciqMtWlCBimTDo}
 *  
 *  @author Luiz AntÃ´nio Pereira
 *  
 *  @version 1
 *  
 *  @since 15 de maio de 2016
 * */
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