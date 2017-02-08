package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.ProcedimentoDAO;
import br.edu.ufrb.lasis.humv.dao.SetorDAO;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;

/** 
 *  
 *  @author Vinicius Moura
 *  
 *  @version 1.0
 *  
 *  @since 7 de junho de 2016
 * */


@Service
public class SetorServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(SetorServiceImpl.class);

	@Autowired
	private SetorDAO setorDAO;
	
	@Autowired
	private ProcedimentoDAO procedimentoDAO;

	public List<Setor> getAll(){
		try {
			return setorDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Setor>();
		}
	}

	public Setor findByCodigo(BigInteger codigo){
		return setorDAO.findByCodigo(codigo);
	}
	
	public List<Setor> search(String palavrachave){
		return setorDAO.search(palavrachave);
	}

	public Object cadastrarSetor(Setor setor , String usuarioResponsavel ){
		try{
			Setor s = setorDAO.saveSetor(setor);
			logger.info("[signup - " + usuarioResponsavel + "] Setor cadastrado com sucesso: " + setor.getNome() + ".");
			return s;
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				//logger.error("[signup] Nome do setor já cadastrado: " + setor.getNome() + "."); 
				return "Setor " +  setor.getNome() + " já cadastrado no sistema. Por favor, informe um Nome diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarSetor(Setor setor, String usuarioResponsavel){
		if(setorDAO.findByCodigo(setor.getCodigo()) == null){
			//logger.error("[signup] Nenhum setor com o código " + setor.getCodigo() + "foi encontrado no sistema.");
			return "Nenhum setor com o código " + setor.getCodigo() + "foi encontrado no sistema. Por favor, informe um código diferente.";

		}
		setorDAO.updateSetor(setor);
		logger.info("[atualizarSetor - " + usuarioResponsavel + "] Setor " + setor.getCodigo() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerSetor(BigInteger codigo, String usuarioResponsavel){
		if(setorDAO.findByCodigo(codigo) == null){
			//logger.error("[signup] Nenhum Setor com o código " + codigo + "foi encontrado no sistema.");
			return "Nenhum Setor com o código " + codigo + "foi encontrado no sistema. Por favor, informe um código diferente.";

		}
		Setor setor = setorDAO.findByCodigo(codigo);
		setorDAO.removeSetor(setor);
		List<Procedimento> procedimentos = procedimentoDAO.findByCodigoSetor(codigo);
		for(Procedimento proc : procedimentos){
			proc.setSetor(null);
			procedimentoDAO.updateProcedimento(proc);
		}
		logger.info("[removerSetor - " + usuarioResponsavel + "] Setor " + setor.getCodigo() + " removido com sucesso.");
    	return "OK";
    }

	public SetorDAO getSetorDAO() {
		return setorDAO;
	}

	public void setSetorDAO(SetorDAO setorDAO) {
		this.setorDAO = setorDAO;
	}

	

}
