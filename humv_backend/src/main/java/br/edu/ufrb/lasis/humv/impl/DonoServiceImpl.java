package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.DonoDAO;
import br.edu.ufrb.lasis.humv.entity.Dono;

/** Implementação do serviço para cadastro,atualização e remoção de donos de animais.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.1
 *  
 *  @since 15 de maio de 2016
 * */

@Service
public class DonoServiceImpl {
	private final static Logger logger = LoggerFactory.getLogger(DonoServiceImpl.class);

		@Autowired
		private DonoDAO donoDAO;

		public List<Dono> getAll(){
			try {
				return donoDAO.findAll();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Dono>();
			}
		}

		public Dono findById(String id){
			return donoDAO.findByKey(id);
		}

		public String cadastrarDono(Dono dono, String usuarioResponsavel){
			try{
				donoDAO.saveOwner(dono);
				logger.info("[signup - " + usuarioResponsavel + "] Dono salvo com sucesso: " + dono.getNome() + ".");
				return "OK";
			}catch(DataIntegrityViolationException ex){
				if(ex.getMessage().toLowerCase().contains("constraint")){
					logger.error("[signup] CPF ja cadastrado: " + dono.getId() + ".");
					return "Dono com id " + dono.getId() + " ja cadastrado no sistema. Por favor, informe um CPF diferente.";
				}else{
					return "Erro ao conectar-se com o banco de dados.";
				}
			}
		}

		public String atualizarDono(Dono dono, String usuarioResponsavel){
			if(donoDAO.findByKey(dono.getId())==null){
				logger.error("[signup] Nenhum dono com o id " + dono.getId() + "foi encontrado no sistema.");
				return "Nenhum dono com o CPF " + dono.getId() + " encontrado no sistema. Por favor, informe um CPF diferente.";
			}
			donoDAO.updateOwner(dono);
			logger.info("[atualizarDono - " + usuarioResponsavel + "] Dono " + dono.getId() + " atualizado com sucesso.");
			return "OK";
		}
		
		public String removerDono(String  cpf, String usuarioResponsavel){
			if(donoDAO.findByKey(cpf)==null){
				logger.error("[signup] Nenhum dono com o CPF " + cpf + "foi encontrado no sistema.");
				return "Nenhum dono com o CPF " + cpf + " encontrado no sistema. Por favor, informe um CPF diferente.";
			}
			Dono dono = donoDAO.findByKey(cpf);
			donoDAO.removeOwner(dono);
			logger.info("[removerDono - " + usuarioResponsavel + "] Dono " + dono.getId() + " removido com sucesso.");
	    	return "OK";
	    }

		public DonoDAO getProprietarioDAO() {
			return donoDAO;
		}

		public void setDonoDAO(DonoDAO donoDAO) {
			this.donoDAO = donoDAO;
		}
}
