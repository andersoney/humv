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
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.impl.SetorServiceImpl;

/** Implementaçãoo do serviço para cadastro,atualização e remoção de setores.
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Setor findById(@PathVariable long id){
    	return setorServiceImpl.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarSetor(@RequestBody Setor setor, @RequestParam(value="username") String  username){
    	return setorServiceImpl.cadastrarSetor(setor, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarSetor(@RequestBody Setor setor, @RequestParam(value="username") String  username){
    	return setorServiceImpl.atualizarsetor(setor, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerSetor(@PathVariable long id, @RequestParam(value="username") String  username){
    	return setorServiceImpl.removerSetor(id, username);
    }

	public SetorServiceImpl getSetorServiceImpl() {
		return setorServiceImpl;
	}

	public void setSetorServiceImpl(SetorServiceImpl setorServiceImpl) {
		this.setorServiceImpl = setorServiceImpl;
	}
    
	
}
