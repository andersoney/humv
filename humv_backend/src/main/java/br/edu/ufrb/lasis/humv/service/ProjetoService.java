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


import br.edu.ufrb.lasis.humv.entity.Projeto;
import br.edu.ufrb.lasis.humv.impl.ProjetoServiceImpl;

@RestController
@RequestMapping(value = "/api/setor")
@Secured("ROLE_ADMIN")
public class ProjetoService {
	
	@Autowired
	private ProjetoServiceImpl projetoServiceImpl;
    
    @RequestMapping
    public List<Projeto> getAll(){
    	return projetoServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Projeto findById(@PathVariable String id){
    	return projetoServiceImpl.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarDono(@RequestBody Projeto projeto, @RequestParam(value="username") String  username){
    	return projetoServiceImpl.cadastrarProjeto(projeto, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarProjeto(@RequestBody Projeto projeto, @RequestParam(value="username") String  username){
    	return projetoServiceImpl.atualizarProjeto(projeto, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerProjeto(@PathVariable String id, @RequestParam(value="username") String  username){
    	return projetoServiceImpl.removerProjeto(id, username);
    }
    
	public ProjetoServiceImpl getProjetoServiceImpl( ) {
		return projetoServiceImpl;
	}

	public void setProjetoServiceImpl(ProjetoServiceImpl projetoServiceImpl) {
		this.projetoServiceImpl = projetoServiceImpl;

	}

}
