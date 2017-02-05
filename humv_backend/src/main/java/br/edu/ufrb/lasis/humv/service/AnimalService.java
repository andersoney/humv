package br.edu.ufrb.lasis.humv.service;

import java.math.BigInteger;
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
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.impl.AnimalServiceImpl;

/** Serviço para cadastro, atualização e remoção de animais de pequeno porte.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 16 de maio de 2016
 * */

@RestController
@RequestMapping(value = "/api/animal")
@Secured("ROLE_ADMIN")
public class AnimalService {
	
	@Autowired
	private AnimalServiceImpl animalServiceImpl;
    
    @RequestMapping
    public List<Animal> getAll(){
    	return animalServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{rghumv}")
    public Animal findById(@PathVariable BigInteger rghumv){
    	return animalServiceImpl.findById(rghumv);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/searchByDono/{idDono}")
    public List<Animal> findByIdDono(@PathVariable BigInteger idDono){
    	return animalServiceImpl.findByIdDono(idDono);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Animal> search(@RequestParam(value="palavrachave") String palavrachave){
    	return animalServiceImpl.search(palavrachave);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Object cadastrarAnimal(@RequestBody Animal animal, @RequestParam(value="username") String  username){
    	return animalServiceImpl.cadastrarAnimal(animal, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarAnimal(@RequestBody Animal animal, @RequestParam(value="username") String  username){
    	return animalServiceImpl.atualizarAnimal(animal, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{rghumv}")
    public String removerAnimal(@PathVariable BigInteger rghumv, @RequestParam(value="username") String  username){
    	return animalServiceImpl.removerAnimal(rghumv, username);
    }
    
	public AnimalServiceImpl getAnimalServiceImpl( ) {
		return animalServiceImpl;
	}

	public void setAnimalServiceImpl(AnimalServiceImpl animalServiceImpl) {
		this.animalServiceImpl = animalServiceImpl;

	}
}
