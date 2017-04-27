package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.SolicitacaoMaterialDAO;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;

@Service
public class SolicitacaoMaterialServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(SolicitacaoMaterialServiceImpl.class);

	@Autowired
	private SolicitacaoMaterialDAO solicitacaoMaterialDAO;

	public List<SolicitacaoMaterial> getAll() {
		try {
			return solicitacaoMaterialDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<SolicitacaoMaterial>();
		}
	}

	public SolicitacaoMaterial findById(BigInteger id) {
		return solicitacaoMaterialDAO.findById(id);
	}

	
	public String cadastrarSolicitacaoMaterial(SolicitacaoMaterial solicitacaoMaterial,
			String usuarioResponsavel) {
		try {
			solicitacaoMaterialDAO.saveSolicitacaoMaterial(solicitacaoMaterial);
			logger.info("[cadastrarSolicitacaoMaterial - " + usuarioResponsavel
					+ "] Solicitação salva com sucesso: " + solicitacaoMaterial.getId() + ".");
			return "OK";
		} catch (DataIntegrityViolationException ex) {
			logger.error("[cadastrarSolicitacaoMaterial - " + usuarioResponsavel + "] " + ex.getMessage()
					+ " / root cause: " + ex.getRootCause().getMessage());
			if (ex.getMessage().toLowerCase().contains("constraint")) {
				return "Erro no registro da solicitação.";
			} else {
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarSolicitacaoMaterial(SolicitacaoMaterial solicitacaoMaterial,
			String usuarioResponsavel) {
		if (solicitacaoMaterialDAO.findById(solicitacaoMaterial.getId()) == null) {
			return "Solicitação de material não encontrada no sistema. Por favor, informe um id diferente.";
		}
		solicitacaoMaterialDAO.updateSolicitacaoMaterial(solicitacaoMaterial);
		logger.info("[atualizarSolicitacaoMaterial - " + usuarioResponsavel + "] Solicitação de Material "
				+ solicitacaoMaterial.getId() + " atualizada com sucesso.");
		return "OK";
	}

	public String removerSolicitacaoMaterial(BigInteger id, String usuarioResponsavel) {
		if (solicitacaoMaterialDAO.findById(id) == null) {
			return "Nenhuma solicitação com esse identificador encontrado no sistema.";
		}
		SolicitacaoMaterial solicitacaoMaterial = solicitacaoMaterialDAO.findById(id);
		solicitacaoMaterialDAO.removeSolicitacaoMaterial(solicitacaoMaterial);
		logger.info("[removerSolicitacaoMaterial - " + usuarioResponsavel + "] Solicitação de Material "
				+ solicitacaoMaterial.getId() + " removida com sucesso.");
		return "OK";
	}
	
	public List<SolicitacaoMaterial> searchByStatus(String status){
		return solicitacaoMaterialDAO.findByStatus(status);
	}
	
	public List<SolicitacaoMaterial> searchByDataSolicitacao(Date date){
		return solicitacaoMaterialDAO.findByDataSolicitacao(date);
	}
	
	public List<SolicitacaoMaterial> searchByDataLiberacao(Date date){
		return solicitacaoMaterialDAO.findByDataLiberacao(date);
	}

}
