package br.edu.ufrb.lasis.humv.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.impl.AnimalGrandeServiceImpl;

/** Serviço para cadastro, atualização e remoção de animais de grande porte.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 16 de maio de 2016
 * */

@RestController
@RequestMapping(value = "/api/animalGrande")
@Secured("ROLE_ADMIN")

public class AnimalGrandeService {
	@Autowired
	private AnimalGrandeServiceImpl animalGrandeServiceImpl;
    
    @RequestMapping
    public List<AnimalGrande> getAll(){
    	return animalGrandeServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{rghumv}")
    public AnimalGrande findById(@PathVariable String rghumv){
    	return animalGrandeServiceImpl.findById(rghumv);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarAnimalGrande(@RequestBody AnimalGrande animalGrande, @RequestParam(value="username") String  username){
    	return animalGrandeServiceImpl.cadastrarAnimalGrande(animalGrande, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarAnimalGrande(@RequestBody AnimalGrande animalGrande, @RequestParam(value="username") String  username){
    	return animalGrandeServiceImpl.atualizarAnimalGrande(animalGrande, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{rghumv}")
    public String removerAnimalGrande(@PathVariable String  rghumv, @RequestParam(value="username") String  username){
    	return animalGrandeServiceImpl.removerAnimalGrande(rghumv, username);
    }
    
	public AnimalGrandeServiceImpl getAnimalGrandeServiceImpl( ) {
		return animalGrandeServiceImpl;
	}

	public void setAnimalGrandeServiceImpl(AnimalGrandeServiceImpl animalGrandeServiceImpl) {
		this.animalGrandeServiceImpl = animalGrandeServiceImpl;

	}
}
