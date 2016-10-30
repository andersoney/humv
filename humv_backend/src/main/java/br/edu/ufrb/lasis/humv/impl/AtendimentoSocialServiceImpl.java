package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.AtendimentoSocialDAO;
import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;

@Service
public class AtendimentoSocialServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(AtendimentoServiceImpl.class);

	@Autowired
	private AtendimentoSocialDAO atendimentoSocialDAO;
	
	public List<AtendimentoSocial> getAll(){
		try {
			return atendimentoSocialDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<AtendimentoSocial>();
		}
	}

	public AtendimentoSocial findById(BigInteger id){
		return atendimentoSocialDAO.findById(id);
	}

	public String cadastrarAtendimentoSocial(AtendimentoSocial atendimentoSocial, String usuarioResponsavel){
		try{
			atendimentoSocialDAO.saveAtendimentoSocial(atendimentoSocial);
			logger.info("[cadastrarAtendimentoSocial - " + usuarioResponsavel + "] Atendimento social salvo com sucesso: " + atendimentoSocial.getId() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[cadastrarAtendimentoSocial] Atendimento social ja cadastrado: " + atendimentoSocial.getId() + ".");
				return "Atendimento social ja cadastrado no sistema. Por favor, informe um atendimento social diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarAtendimentoSocial(AtendimentoSocial atendimentoSocial, String usuarioResponsavel){
		atendimentoSocialDAO.updateAtendimentoSocial(atendimentoSocial);
		logger.info("[atualizarAtendimentoSocial - " + usuarioResponsavel + "] Atendimento " + atendimentoSocial.getId() + " atualizado com sucesso.");
		return "OK";
	}

	public String removerAtendimentoSocial(BigInteger id, String usuarioResponsavel){
		AtendimentoSocial atendimentoSocial = atendimentoSocialDAO.findById(id);
		atendimentoSocialDAO.removeAtendimentoSocial(atendimentoSocial);
		logger.info("[removerAtendimentoSocial - " + usuarioResponsavel + "] Atendimento " + atendimentoSocial.getId() + " removido com sucesso.");
		return "OK";
	}

	public AtendimentoSocialDAO getAtendimentoSocialDAO() {
		return atendimentoSocialDAO;
	}

	public void setAtendimentoSocialDAO(AtendimentoSocialDAO atendimentoSocialDAO) {
		this.atendimentoSocialDAO = atendimentoSocialDAO;
	}

}
