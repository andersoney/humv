package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.AnimalGrandeDAO;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;


/** Implementação do serviço para cadastro,atualização e remoção de animais de grande porte.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 16 de maio de 2016
 * */


@Service
public class AnimalGrandeServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(AnimalGrandeServiceImpl.class);

	@Autowired
	private AnimalGrandeDAO animalGrandeDAO;

	public List<AnimalGrande> getAll(){
		try {
			return animalGrandeDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<AnimalGrande>();
		}
	}

	public AnimalGrande findById(String rghumv){
		return animalGrandeDAO.findByRghumv(rghumv);
	}

	public String cadastrarAnimalGrande(AnimalGrande animalGrande, String usuarioResponsavel){
		try{
			animalGrandeDAO.saveLargeAnimal(animalGrande);
			logger.info("[signup - " + usuarioResponsavel + "] Animal Grande salvo com sucesso: " + animalGrande.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[signup] RGHUMV j� cadastrado: " + animalGrande.getRghumv() + ".");
				return "Animal Grande com RGHUMV " + animalGrande.getRghumv() + " j� cadastrado no sistema. Por favor, informe um RGHUMV diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarAnimalGrande(AnimalGrande animalGrande, String usuarioResponsavel){
		animalGrandeDAO.updateLargeAnimal(animalGrande);
		logger.info("[atualizarAnimalGrande - " + usuarioResponsavel + "] Animal Grande " + animalGrande.getRghumv() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerAnimalGrande(String  rghumv, String usuarioResponsavel){
		AnimalGrande animalGrande = animalGrandeDAO.findByRghumv(rghumv);
		animalGrandeDAO.removeLargeAnimal(animalGrande);
		logger.info("[removerAnimalGrande - " + usuarioResponsavel + "] Animal Grande " + animalGrande.getRghumv() + " removido com sucesso.");
    	return "OK";
    }

	public AnimalGrandeDAO getAnimalGrandeDAO() {
		return animalGrandeDAO;
	}

	public void setAnimalGrandeDAO(AnimalGrandeDAO animalGrandeDAO) {
		this.animalGrandeDAO = animalGrandeDAO;
	}

}
