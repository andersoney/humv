package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.ProjetoDAO;
import br.edu.ufrb.lasis.humv.entity.Projeto;

@Service
public class ProjetoServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(ProjetoServiceImpl.class);

	@Autowired
	private ProjetoDAO projetoDAO ;

	public List<Projeto> getAll(){
		try {
			return projetoDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Projeto>();
		}
	}

	public Projeto findById(BigInteger id){
		return projetoDAO.findById(id);
	}

	public List<Projeto> search(String palavrachave){
		return projetoDAO.search(palavrachave);
	}

	public String cadastrarProjeto(Projeto projeto, String usuarioResponsavel){
		try{
			projetoDAO.saveProjeto(projeto);
			logger.info("[signup - " + usuarioResponsavel + "] Projeto cadastrado com sucesso: " + projeto.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				//logger.error("[signup] Projeto ja cadastrado: " + projeto.getNome() + ".");
				return "Projeto com Nome " + projeto.getNome() + " já cadastrado no sistema. Por favor, informe um Nome diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarProjeto(Projeto projeto, String usuarioResponsavel){
		if(projetoDAO.findBySiapeResponsavel(projeto.getSiapeResponsavel())==null){
			//logger.error("[signup] Nenhum projeto com o ID " + projeto.getId() + "foi encontrado no sistema.");
			return "Nenhum projeto com o ID " + projeto.getId() + " encontrado no sistema. Por favor, informe um ID diferente.";
		}
		projetoDAO.updateProjeto(projeto);
		logger.info("[atualizarProjeto - " + usuarioResponsavel + "] Projeto " + projeto.getNome() + " atualizado com sucesso.");
		return "OK";
	}

	public String removerProjeto(BigInteger id, String usuarioResponsavel){
		if(projetoDAO.findById(id) == null){
			//logger.error("[signup] Nenhum projeto com o ID " + id + "foi encontrado no sistema.");
			return "Nenhum projeto com o ID " + id + " encontrado no sistema. Por favor, informe um siape diferente.";
		}
		Projeto projeto = projetoDAO.findById(id);
		projetoDAO.removeProjeto(projeto);
		logger.info("[removerProjeto - " + usuarioResponsavel + "] Projeto " + projeto.getNome() + " removido com sucesso.");
		return "OK";
	}

}
