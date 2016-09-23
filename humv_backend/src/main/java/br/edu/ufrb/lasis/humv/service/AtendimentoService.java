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

import br.edu.ufrb.lasis.humv.entity.Atendimento;
import br.edu.ufrb.lasis.humv.impl.AtendimentoServiceImpl;

@RestController
@RequestMapping(value = "/api/atendimento")
@Secured("ROLE_ADMIN")
public class AtendimentoService {
	
	@Autowired
	private AtendimentoServiceImpl atendimentoServiceImpl;
    
    @RequestMapping
    public List<Atendimento> getAll(){
    	return atendimentoServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Atendimento findById(@PathVariable final BigInteger id){
    	return atendimentoServiceImpl.findById(id);
    }
    
    /**
     * Retorna todos os atendimentos para uma determinada data
     * @param date Formato da data a ser passada: "dd-MM-yyyy"
     * @param id id do médico a buscar os atendimentos
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/searchByDateAndMedicoSemCancelados")
    public List<Atendimento> searchByDateAndMedicoSemCancelados(@RequestParam(value="data") String date, @RequestParam(value="idEmailMedico") String id){
    	return atendimentoServiceImpl.searchByDateAndMedico(date, id, false);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/searchByDateAndMedico")
    public List<Atendimento> searchByDateAndMedicoComCancelados(@RequestParam(value="data") String date, @RequestParam(value="idEmailMedico") String id){
    	return atendimentoServiceImpl.searchByDateAndMedico(date, id, true);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarAtendimento(@RequestBody Atendimento atendimento, @RequestParam(value="username") String username){
    	return atendimentoServiceImpl.cadastrarAtendimento(atendimento, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarUsuario(@RequestBody Atendimento atendimento, @RequestParam(value="username") String  username){
    	return atendimentoServiceImpl.atualizarAtendimento(atendimento, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerUsuario(@PathVariable final BigInteger id, @RequestParam(value="username") String  username){
    	return atendimentoServiceImpl.removerAtendimento(id, username);
    }
    
	public AtendimentoServiceImpl getAtendimentoServiceImpl( ) {
		return atendimentoServiceImpl;
	}

	public void setUsuarioServiceImpl(AtendimentoServiceImpl atendimentoServiceImpl) {
		this.atendimentoServiceImpl = atendimentoServiceImpl;
	}

}
