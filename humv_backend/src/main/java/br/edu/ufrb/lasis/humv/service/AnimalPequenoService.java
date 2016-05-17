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
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.impl.AnimalPequenoServiceImpl;

/** Serviço para cadastro, atualização e remoção de animais de pequeno porte.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 16 de maio de 2016
 * */

@RestController
@RequestMapping(value = "/api/animalPequeno")
@Secured("ROLE_ADMIN")
public class AnimalPequenoService {
	
	@Autowired
	private AnimalPequenoServiceImpl animalPequenoServiceImpl;
    
    @RequestMapping
    public List<AnimalPequeno> getAll(){
    	return animalPequenoServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{rghumv}")
    public AnimalPequeno findById(@PathVariable String rghumv){
    	return animalPequenoServiceImpl.findById(rghumv);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarAnimalPequeno(@RequestBody AnimalPequeno animalPequeno, @RequestParam(value="username") String  username){
    	return animalPequenoServiceImpl.cadastrarAnimalPequeno(animalPequeno, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarAnimalPequeno(@RequestBody AnimalPequeno animalPequeno, @RequestParam(value="username") String  username){
    	return animalPequenoServiceImpl.atualizarAnimalPequeno(animalPequeno, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{rghumv}")
    public String removerAnimalPequeno(@PathVariable String  rghumv, @RequestParam(value="username") String  username){
    	return animalPequenoServiceImpl.removerAnimalPequeno(rghumv, username);
    }
    
	public AnimalPequenoServiceImpl getAnimalPequenoServiceImpl( ) {
		return animalPequenoServiceImpl;
	}

	public void setAnimalPequenoServiceImpl(AnimalPequenoServiceImpl animalPequenoServiceImpl) {
		this.animalPequenoServiceImpl = animalPequenoServiceImpl;

	}
}
