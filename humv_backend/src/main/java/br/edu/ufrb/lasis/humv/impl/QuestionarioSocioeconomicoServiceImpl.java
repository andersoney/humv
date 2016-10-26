package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ufrb.lasis.humv.dao.DocumentacaoDAO;
import br.edu.ufrb.lasis.humv.dao.ParenteDAO;
import br.edu.ufrb.lasis.humv.dao.QuestionarioSocioeconomicoDAO;
import br.edu.ufrb.lasis.humv.entity.Documentacao;
import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;

@Service
public class QuestionarioSocioeconomicoServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(QuestionarioSocioeconomicoServiceImpl.class);

	@Autowired
	private QuestionarioSocioeconomicoDAO questionarioSocioeconomicoDAO;

	@Autowired
	private DocumentacaoDAO documentacaoDAO;

	@Autowired
	private ParenteDAO parenteDAO;

	public List<QuestionarioSocioeconomico> getAll(){
		try {
			return questionarioSocioeconomicoDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<QuestionarioSocioeconomico>();
		}
	}

	public QuestionarioSocioeconomico findById(BigInteger id){
		return questionarioSocioeconomicoDAO.findByKey(id);
	}

	public List<QuestionarioSocioeconomico> search(String palavrachave){
		return questionarioSocioeconomicoDAO.search(palavrachave);
	}

	public String cadastrarQuestionarioSocioeconomico(QuestionarioSocioeconomico questionarioSocioeconomico, String usuarioResponsavel){
		try{
//			List<Documentacao> documentos = questionarioSocioeconomico.getDocumentosEntregues();
//			questionarioSocioeconomico.setDocumentosEntregues(null);
//			
//			List<Parente> parentes = questionarioSocioeconomico.getParentes();
//			questionarioSocioeconomico.setParentes(null);
			
			questionarioSocioeconomicoDAO.saveQuestionario(questionarioSocioeconomico);
			logger.info("[cadastrarQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario salvo com sucesso: " + questionarioSocioeconomico.getId() + ".");
			
//			for(Documentacao documento : documentos){
//				//documento.setQuestionario(questionarioSocioeconomico);
//				documentacaoDAO.saveDocumentacao(documento);
//				logger.info("[saveDocumentacao - " + usuarioResponsavel + "] Documentação salva com sucesso: " + documento.getIdDocumento() + ".");
//			}
//			for(Parente parente : parentes){
//				//parente.setQuestionario(questionarioSocioeconomico);
//				parenteDAO.saveParente(parente);
//				logger.info("[saveParente - " + usuarioResponsavel + "] Parente salvo com sucesso: " + parente.getIdParente() + ".");
//			}
//			
//			questionarioSocioeconomico.setDocumentosEntregues(documentos);
//			questionarioSocioeconomico.setParentes(parentes);
//			questionarioSocioeconomicoDAO.updateQuestionario(questionarioSocioeconomico);
			
			return "OK";
		}catch(DataIntegrityViolationException ex){
			logger.error("[cadastrarQuestionarioSocioeconomico - " + usuarioResponsavel + "] " + ex.getMessage() + " / root cause: " + ex.getRootCause().getMessage());
			if(ex.getMessage().toLowerCase().contains("constraint")){
				return "Erro no registro do questionario socioeconomico.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarQuestionarioSocioeconomico(QuestionarioSocioeconomico questionarioSocioeconomico, String usuarioResponsavel){
		if(questionarioSocioeconomicoDAO.findByKey(questionarioSocioeconomico.getId()) == null){
			return "Questionario socioeconomico não encontrado no sistema. Por favor, informe um id diferente.";
		}
		questionarioSocioeconomicoDAO.updateQuestionario(questionarioSocioeconomico);
		logger.info("[atualizarQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario Socioeconomico " + questionarioSocioeconomico.getId() + " atualizado com sucesso.");
		return "OK";
	}

	public String removerQuestionarioSocioeconomico(BigInteger id, String usuarioResponsavel){
		if(questionarioSocioeconomicoDAO.findByKey(id) == null){
			return "Nenhum animal com esse identificador encontrado no sistema.";
		}
		QuestionarioSocioeconomico questionarioSocioeconomico = questionarioSocioeconomicoDAO.findByKey(id);
		questionarioSocioeconomicoDAO.removeQuestionario(questionarioSocioeconomico);
		logger.info("[removerQuestionarioSocioeconomico - " + usuarioResponsavel + "] Questionario Socioeconomico " + questionarioSocioeconomico.getId() + " removido com sucesso.");
		return "OK";
	}

}
