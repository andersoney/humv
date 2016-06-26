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
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.impl.DonoServiceImpl;

/** Serviço para cadastro,atualização e remoção de donos de animais.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.1
 *  
 *  @since 15 de maio de 2016
 * */

@RestController
@RequestMapping(value = "/api/dono")
@Secured("ROLE_ADMIN")
public class DonoService {
		
		@Autowired
		private DonoServiceImpl donoServiceImpl;
	    
	    @RequestMapping
	    public List<Dono> getAll(){
	    	return donoServiceImpl.getAll(); 
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public Dono findById(@PathVariable String id){
	    	return donoServiceImpl.findById(id);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	    public String cadastrarDono(@RequestBody Dono dono, @RequestParam(value="username") String  username){
	    	return donoServiceImpl.cadastrarDono(dono, username);
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	    public String atualizarDono(@RequestBody Dono dono, @RequestParam(value="username") String  username){
	    	return donoServiceImpl.atualizarDono(dono, username);
	    }
	    
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public String removerDono(@PathVariable String  id, @RequestParam(value="username") String  username){
	    	return donoServiceImpl.removerDono(id, username);
	    }
	    
		public DonoServiceImpl getDonoServiceImpl( ) {
			return donoServiceImpl;
		}

		public void setDonoServiceImpl(DonoServiceImpl donoServiceImpl) {
			this.donoServiceImpl = donoServiceImpl;

		}
}
