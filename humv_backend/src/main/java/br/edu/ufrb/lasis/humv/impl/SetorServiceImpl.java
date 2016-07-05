package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.SetorDAO;
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

	public List<Setor> getAll(){
		try {
			return setorDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Setor>();
		}
	}

	public Setor findByCodigo(String codigo){
		return setorDAO.findByCodigo(codigo);
	}

	public String cadastrarSetor(Setor setor , String usuarioResponsavel ){
		try{
			setorDAO.saveSetor(setor);
			logger.info("[signup - " + usuarioResponsavel + "] Setorcadastrado com sucesso: " + setor.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[signup] Nome do Setor j� cadastrado: " + setor.getNome() + ".");
				return "Setor " +  setor.getNome() + " J� cadastrado no sistema. Por favor, informe um Nome diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarSetor(Setor setor, String usuarioResponsavel){
		if(setorDAO.findByCodigo(setor.getCodigo())==null){
			logger.error("[signup] Nenhum Setor com o c�digo " + setor.getCodigo() + "foi encontrado no sistema.");
			return "Nenhum Setor com o c�digo " + setor.getCodigo() + "foi encontrado no sistema. Por favor, informe um C�digo diferente.";

		}
		setorDAO.updateSetor(setor);
		logger.info("[atualizarSetor - " + usuarioResponsavel + "] Setor " + setor.getCodigo() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerSetor(String codigo, String usuarioResponsavel){
		if(setorDAO.findByCodigo(codigo) ==null){
			logger.error("[signup] Nenhum Setor com o C�digo " + codigo + "foi encontrado no sistema.");
			return "Nenhum Setor com o C�digo " + codigo + "foi encontrado no sistema. Por favor, informe um C�digo diferente.";

		}
		Setor setor = setorDAO.findByCodigo(codigo);
		setorDAO.removeSetor(setor);
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
