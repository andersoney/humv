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
import br.edu.ufrb.lasis.humv.entity.Proprietario;
import br.edu.ufrb.lasis.humv.impl.ProprietarioServiceImpl;

/** Serviço para cadastro,atualização e remoção de proprietários de animais.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 15 de maio de 2016
 * */

@RestController
@RequestMapping(value = "/api/proprietario")
@Secured("ROLE_ADMIN")
public class ProprietarioService {
	
		public class UsuarioService {
		
		@Autowired
		private ProprietarioServiceImpl proprietarioServiceImpl;
	    
	    @RequestMapping
	    public List<Proprietario> getAll(){
	    	return proprietarioServiceImpl.getAll(); 
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, value = "/{cpf}")
	    public Proprietario findById(@PathVariable String cpf){
	    	return proprietarioServiceImpl.findById(cpf);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	    public String cadastrarProprietario(@RequestBody Proprietario proprietario, @RequestParam(value="username") String  username){
	    	return proprietarioServiceImpl.cadastrarProprietario(proprietario, username);
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
	    public String atualizarProprietario(@RequestBody Proprietario proprietario, @RequestParam(value="username") String  username){
	    	return proprietarioServiceImpl.atualizarProprietario(proprietario, username);
	    }
	    
	    @RequestMapping(method = RequestMethod.DELETE, value = "/{cpf}")
	    public String removerProprietario(@PathVariable String  cpf, @RequestParam(value="username") String  username){
	    	return proprietarioServiceImpl.removerProprietario(cpf, username);
	    }
	    
		public ProprietarioServiceImpl getProprietarioServiceImpl( ) {
			return proprietarioServiceImpl;
		}

		public void setProprietarioServiceImpl(ProprietarioServiceImpl proprietarioServiceImpl) {
			this.proprietarioServiceImpl = proprietarioServiceImpl;
		}

	}
}
