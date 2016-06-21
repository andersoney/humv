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
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.impl.ProcedimentoServiceImpl;

@RestController
@RequestMapping(value="/api/procedimento")
@Secured("ROLE_ADMIN")
public class ProcedimentoService {
	@Autowired
	private ProcedimentoServiceImpl procedimentoServiceImpl;
	
	@RequestMapping
	public List<Procedimento> getAll(){
		return procedimentoServiceImpl.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{code}")
	public Procedimento findByCode(@PathVariable Integer code){
		return  procedimentoServiceImpl.findByCode(code).get(0);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarSetor(@RequestBody Procedimento procedimento, @RequestParam(value="username") String  username){
    	return procedimentoServiceImpl.cadastrarProcedimento(procedimento, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarSetor(@RequestBody Procedimento procedimento, @RequestParam(value="username") String  username){
    	return procedimentoServiceImpl.atualizarProcedimento(procedimento, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerSetor(@PathVariable Integer code, @RequestParam(value="username") String  username){
    	return procedimentoServiceImpl.removerProcedimento(code, username);
    }

	public ProcedimentoServiceImpl getProcedimentoServiceImpl() {
		return procedimentoServiceImpl;
	}

	public void setProcdimentoServiceImpl(ProcedimentoServiceImpl procedimentoServiceImpl) {
		this.procedimentoServiceImpl=procedimentoServiceImpl;
	}

}
