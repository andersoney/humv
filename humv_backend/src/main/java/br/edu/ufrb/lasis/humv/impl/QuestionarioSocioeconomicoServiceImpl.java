package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ufrb.lasis.humv.dao.QuestionarioSocioeconomicoDAO;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;

@Service
public class QuestionarioSocioeconomicoServiceImpl {
	private final static Logger logger = LoggerFactory.getLogger(QuestionarioSocioeconomicoServiceImpl.class);

	@Autowired
	private QuestionarioSocioeconomicoDAO questionarioSocioeconomicoDAO;

	public List<QuestionarioSocioeconomico> getAll(){
		try {
			return questionarioSocioeconomicoDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<QuestionarioSocioeconomico>();
		}
	}

	public QuestionarioSocioeconomico findById(Integer id){
		return questionarioSocioeconomicoDAO.findByKey(id);
	}


	public String cadastrarQuestionarioSocioeconomico(QuestionarioSocioeconomico questionarioSocioeconomico, String usuarioResponsavel){
		try{
			questionarioSocioeconomicoDAO.saveQuestionario(questionarioSocioeconomico);
			logger.info("[cadastrarQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario salvo com sucesso: " + questionarioSocioeconomico.getIdQuestionario() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				return "Erro no registro do questionario socioeconomico.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}
	
	public List<QuestionarioSocioeconomico> search(String palavrachave){
		return questionarioSocioeconomicoDAO.search(palavrachave);
	}
	public String atualizarQuestionarioSocioeconomico(QuestionarioSocioeconomico questionarioSocioeconomico, String usuarioResponsavel){
		if(questionarioSocioeconomicoDAO.findByKey(questionarioSocioeconomico.getIdQuestionario()) == null){
			return "Questionario socioeconomico não encontrado no sistema. Por favor, informe um id diferente.";

		}
		questionarioSocioeconomicoDAO.updateQuestionario(questionarioSocioeconomico);
		logger.info("[atualizarQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario Socioeconomico " + questionarioSocioeconomico.getIdQuestionario() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerQuestionarioSocioeconomico(Integer id, String usuarioResponsavel){
		if(questionarioSocioeconomicoDAO.findByKey(id) == null){
			return "Nenhum animal com esse identificador encontrado no sistema.";

		}
		QuestionarioSocioeconomico questionarioSocioeconomico = questionarioSocioeconomicoDAO.findByKey(id);
		questionarioSocioeconomicoDAO.removeQuestionario(questionarioSocioeconomico);
		logger.info("[removerQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario Socioeconomico " + questionarioSocioeconomico.getIdQuestionario() + " removido com sucesso.");
    	return "OK";
    }

}
