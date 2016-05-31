package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.AnimalPequenoDAO;
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;


/** Implementação do serviço para cadastro,atualização e remoção de animais de pequeno porte.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.1
 *  
 *  @since 16 de maio de 2016
 * */


@Service
public class AnimalPequenoServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(AnimalPequenoServiceImpl.class);

	@Autowired
	private AnimalPequenoDAO animalPequenoDAO;

	public List<AnimalPequeno> getAll(){
		try {
			return animalPequenoDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<AnimalPequeno>();
		}
	}

	public AnimalPequeno findById(String rghumv){
		return animalPequenoDAO.findByRghumv(rghumv);
	}

	public String cadastrarAnimalPequeno(AnimalPequeno animalPequeno, String usuarioResponsavel){
		try{
			animalPequenoDAO.saveSmallAnimal(animalPequeno);
			logger.info("[signup - " + usuarioResponsavel + "] Animal Pequeno salvo com sucesso: " + animalPequeno.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[signup] RGHUMV j� cadastrado: " + animalPequeno.getRghumv() + ".");
				return "Animal Pequeno com RGHUMV " + animalPequeno.getRghumv() + " j� cadastrado no sistema. Por favor, informe um RGHUMV diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarAnimalPequeno(AnimalPequeno animalPequeno, String usuarioResponsavel){
		if(animalPequenoDAO.findByRghumv(animalPequeno.getRghumv())==null){
			logger.error("[signup] Nenhum animal pequeno com o RGHUMV " + animalPequeno.getRghumv() + "foi encontrado no sistema.");
			return "Nenhum animal pequeno com o RGHUMV " + animalPequeno.getRghumv() + " encontrado no sistema. Por favor, informe um RGHUMV diferente.";

		}
		animalPequenoDAO.updateSmallAnimal(animalPequeno);
		logger.info("[atualizarAnimalPequeno - " + usuarioResponsavel + "] Animal Pequeno " + animalPequeno.getRghumv() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerAnimalPequeno(String  rghumv, String usuarioResponsavel){
		if(animalPequenoDAO.findByRghumv(rghumv)==null){
			logger.error("[signup] Nenhum animal pequeno com o RGHUMV " + rghumv + "foi encontrado no sistema.");
			return "Nenhum animal pequeno com o RGHUMV " + rghumv + " encontrado no sistema. Por favor, informe um RGHUMV diferente.";

		}
		AnimalPequeno animalPequeno = animalPequenoDAO.findByRghumv(rghumv);
		animalPequenoDAO.removeSmallAnimal(animalPequeno);
		logger.info("[removerAnimalPequeno - " + usuarioResponsavel + "] Animal Pequeno " + animalPequeno.getRghumv() + " removido com sucesso.");
    	return "OK";
    }

	public AnimalPequenoDAO getAnimalPequenoDAO() {
		return animalPequenoDAO;
	}

	public void setAnimalPequenoDAO(AnimalPequenoDAO animalPequenoDAO) {
		this.animalPequenoDAO = animalPequenoDAO;
	}
	
}
