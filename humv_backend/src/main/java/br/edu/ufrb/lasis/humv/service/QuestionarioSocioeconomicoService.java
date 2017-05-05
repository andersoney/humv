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
import br.edu.ufrb.lasis.humv.impl.QuestionarioSocioeconomicoServiceImpl;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;


@RestController
@RequestMapping(value = "/api/questionarioSocioeconomico")
@Secured("ROLE_ADMIN")
public class QuestionarioSocioeconomicoService {
	
	@Autowired
	private QuestionarioSocioeconomicoServiceImpl questionarioSocioeconomicoServiceImpl;
    
    @RequestMapping
    public List<QuestionarioSocioeconomico> getAll(){
    	return questionarioSocioeconomicoServiceImpl.getAll(); 
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public QuestionarioSocioeconomico findById(@PathVariable BigInteger id){
    	return questionarioSocioeconomicoServiceImpl.findById(id);
    }
	
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<QuestionarioSocioeconomico> search(@RequestParam(value="palavrachave") String palavrachave){
    	return questionarioSocioeconomicoServiceImpl.search(palavrachave);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarQuestionarioSocioeconomico(@RequestBody QuestionarioSocioeconomico questionarioSocioeconomico, @RequestParam(value="username") String  username){
    	return questionarioSocioeconomicoServiceImpl.cadastrarQuestionarioSocioeconomico(questionarioSocioeconomico, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarQuestionarioSocioeconomico(@RequestBody QuestionarioSocioeconomico questionarioSocioeconomico, @RequestParam(value="username") String  username){
    	return questionarioSocioeconomicoServiceImpl.atualizarQuestionarioSocioeconomico(questionarioSocioeconomico, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String removerQuestionarioSocioeconomico(@PathVariable BigInteger id, @RequestParam(value="username") String  username){
    	return questionarioSocioeconomicoServiceImpl.removerQuestionarioSocioeconomico(id, username);
    }
    
	public QuestionarioSocioeconomicoServiceImpl getQuestionarioSocioeconomicoServiceImpl( ) {
		return questionarioSocioeconomicoServiceImpl;
	}

	public void setQuestionarioSocioeconomicoServiceImpl(QuestionarioSocioeconomicoServiceImpl SolicitacaoMaterialServiceImpl) {
		this.questionarioSocioeconomicoServiceImpl = SolicitacaoMaterialServiceImpl;
	}	
}
