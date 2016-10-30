package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.AnimalDAO;
import br.edu.ufrb.lasis.humv.entity.Animal;

/** Implementação do serviço para cadastro, atualização e remoção de animais.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.1
 *  
 *  @since 16 de maio de 2016
 * */

@Service
public class AnimalServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);

	@Autowired
	private AnimalDAO animalDAO;

	public List<Animal> getAll(){
		try {
			return animalDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Animal>();
		}
	}

	public Animal findById(BigInteger rghumv){
		return animalDAO.findByRghumv(rghumv);
	}
	
	public List<Animal> findByIdDono(BigInteger idDono){
		return animalDAO.findByDono(idDono);
	}

	public List<Animal> search(String palavrachave){
		return animalDAO.search(palavrachave);
	}

	public String cadastrarAnimal(Animal animal, String usuarioResponsavel){
		try{
			animalDAO.saveAnimal(animal);
			logger.info("[cadastrarAnimal - " + usuarioResponsavel + "] Animal salvo com sucesso: " + animal.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				//logger.error("[signup] RGHUMV já cadastrado: " + animal.getRghumv() + ".");
				return "Animal com RGHUMV " + animal.getRghumv() + " já cadastrado no sistema. Por favor, informe um RGHUMV diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarAnimal(Animal animal, String usuarioResponsavel){
		if(animalDAO.findByRghumv(animal.getRghumv()) == null){
			//logger.error("[signup] Nenhum animal com o RGHUMV " + animal.getRghumv() + "foi encontrado no sistema.");
			return "Nenhum animal com o RGHUMV " + animal.getRghumv() + " encontrado no sistema. Por favor, informe um RGHUMV diferente.";

		}
		animalDAO.updateAnimal(animal);
		logger.info("[atualizarAnimal - " + usuarioResponsavel + "] Animal " + animal.getRghumv() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerAnimal(BigInteger rghumv, String usuarioResponsavel){
		if(animalDAO.findByRghumv(rghumv) == null){
			//logger.error("[signup] Nenhum animal com o RGHUMV " + rghumv + "foi encontrado no sistema.");
			return "Nenhum animal com o RGHUMV " + rghumv + " encontrado no sistema. Por favor, informe um RGHUMV diferente.";

		}
		Animal animal = animalDAO.findByRghumv(rghumv);
		animalDAO.removeAnimal(animal);
		logger.info("[removerAnimal - " + usuarioResponsavel + "] Animal " + animal.getRghumv() + " removido com sucesso.");
    	return "OK";
    }

	public AnimalDAO getAnimalDAO() {
		return animalDAO;
	}

	public void setAnimalDAO(AnimalDAO animalDAO) {
		this.animalDAO = animalDAO;
	}
}
