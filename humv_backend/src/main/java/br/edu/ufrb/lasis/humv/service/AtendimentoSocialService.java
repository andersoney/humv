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

import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;
import br.edu.ufrb.lasis.humv.impl.AtendimentoSocialServiceImpl;

@RestController
@RequestMapping(value = "/api/atendimentoSocial")
@Secured("ROLE_ADMIN")
public class AtendimentoSocialService {
	
	@Autowired
	private AtendimentoSocialServiceImpl atendimentoSocialServiceImpl;
    
    @RequestMapping
    public List<AtendimentoSocial> getAll(){
    	return atendimentoSocialServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AtendimentoSocial findById(@PathVariable final BigInteger id){
    	return atendimentoSocialServiceImpl.findById(id);
    }
    
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarAtendimentoSocial(@RequestBody AtendimentoSocial atendimentoSocial, @RequestParam(value="username") String username){
    	return atendimentoSocialServiceImpl.cadastrarAtendimentoSocial(atendimentoSocial, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarAtendimentoSocial(@RequestBody AtendimentoSocial atendimentoSocial, @RequestParam(value="username") String username){
    	return atendimentoSocialServiceImpl.atualizarAtendimentoSocial(atendimentoSocial, username);
    }
    
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerAtendimentoSocial(@PathVariable final BigInteger id, @RequestParam(value="username") String  username){
    	return atendimentoSocialServiceImpl.removerAtendimentoSocial(id, username);
    }
    
	public AtendimentoSocialServiceImpl getAtendimentoServiceImpl( ) {
		return atendimentoSocialServiceImpl;
	}

	public void setUsuarioServiceImpl(AtendimentoSocialServiceImpl atendimentoSocialServiceImpl) {
		this.atendimentoSocialServiceImpl = atendimentoSocialServiceImpl;
	}

}
