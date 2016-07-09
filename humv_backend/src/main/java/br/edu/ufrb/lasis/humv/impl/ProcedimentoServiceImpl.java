package br.edu.ufrb.lasis.humv.impl;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.ProcedimentoDAO;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;

@Service
public class ProcedimentoServiceImpl {
	private final static Logger logger = LoggerFactory.getLogger(ProcedimentoServiceImpl.class);
	
	@Autowired
	private ProcedimentoDAO procedimentoDAO;
	
	public List<Procedimento> getAll(){
		try{
			return procedimentoDAO.findAll();
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ArrayList<Procedimento>();
		}
	}
	
	public List<Procedimento> findByNome(String nome){
			return procedimentoDAO.findByName(nome);			
	}
	
	public Procedimento findByCodigo(Integer codigo){
		return procedimentoDAO.findByCode(codigo);
	}
	
	public List<Procedimento> search(String palavrachave){
		return procedimentoDAO.search(palavrachave);
	}
	
	public String cadastrarProcedimento(Procedimento procedimento , String usuarioResponsavel ){
		try{
			procedimentoDAO.saveProcedimento(procedimento);
			logger.info("[cadastrarProcedimento - " + usuarioResponsavel + "] Procedimento cadastrado com sucesso: " + procedimento.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				//logger.error("[signup] Nome do Procedimento j� cadastrado: " + procedimento.getNome() + ".");
				return "Setor " +  procedimento.getNome() + " já cadastrado no sistema. Por favor, informe um nome diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarProcedimento(Procedimento procedimento, String usuarioResponsavel){
		if(procedimentoDAO.findByCode(procedimento.getCodigo())==null){
			//logger.error("[signup] Nenhum Procedimento com o c�digo " + procedimento.getCodigo() + "foi encontrado no sistema.");
			return "Nenhum procedimento com o código " + procedimento.getCodigo() + "foi encontrado no sistema. Por favor, informe um código diferente.";

		}
		procedimentoDAO.updateProcedimento(procedimento);
		logger.info("[atualizarProcedimento - " + usuarioResponsavel + "] Código do Procedimento " + procedimento.getCodigo() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerProcedimento(Integer codigo, String usuarioResponsavel){
		if(procedimentoDAO.findByCode(codigo) == null){
			//logger.error("[signup] Nenhum Procedimento com o C�digo " + codigo + "foi encontrado no sistema.");
			return "Nenhum Procedimento com o código " + codigo + "foi encontrado no sistema. Por favor, informe um código diferente.";
		}
		Procedimento procedimento = procedimentoDAO.findByCode(codigo);
		procedimentoDAO.removeProcedimento(procedimento);
		logger.info("[removerProcedimento - " + usuarioResponsavel + "] procedimento " + procedimento.getCodigo() + " removido com sucesso.");
    	return "OK";
    }

	public ProcedimentoDAO getProcedimentoDAO() {
		return procedimentoDAO;
	}

	public void setProcedimentoDAO(ProcedimentoDAO procedimentoDAO) {
		this.procedimentoDAO=procedimentoDAO;
	}
}
