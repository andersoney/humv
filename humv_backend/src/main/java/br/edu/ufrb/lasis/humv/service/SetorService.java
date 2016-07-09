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

import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.impl.SetorServiceImpl;

/** 
 *  
 *  @author Vinicius Moura
 *  
 *  @version 1.0
 *  
 *  @since 7 de junho de 2016
 * */

@RestController
@RequestMapping(value = "/api/setor")
@Secured("ROLE_ADMIN")
public class SetorService {
	
	@Autowired
	private SetorServiceImpl setorServiceImpl;
    
    @RequestMapping
    public List<Setor> getAll(){
    	return setorServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{codigo}")
    public Setor findByCodigo(@PathVariable Integer codigo){
    	return setorServiceImpl.findByCodigo(codigo);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Setor> search(@RequestParam(value="palavrachave") String palavrachave){
    	return setorServiceImpl.search(palavrachave);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarSetor(@RequestBody Setor setor, @RequestParam(value="username") String  username){
    	return setorServiceImpl.cadastrarSetor(setor, username);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/retornaCadastrado", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Setor cadastrarSetorRetornandoCadatrado(@RequestBody Setor setor, @RequestParam(value="username") String  username){
    	setorServiceImpl.cadastrarSetor(setor, username);
    	return setor;
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarSetor(@RequestBody Setor setor, @RequestParam(value="username") String  username){
    	return setorServiceImpl.atualizarSetor(setor, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{codigo}")
    public String removerSetor(@PathVariable Integer codigo, @RequestParam(value="username") String  username){
    	return setorServiceImpl.removerSetor(codigo, username);
    }

	public SetorServiceImpl getSetorServiceImpl() {
		return setorServiceImpl;
	}

	public void setSetorServiceImpl(SetorServiceImpl setorServiceImpl) {
		this.setorServiceImpl = setorServiceImpl;
	}
}
