package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.ProprietarioDAO;
import br.edu.ufrb.lasis.humv.entity.Proprietario;

/** Implementação do serviço para cadastro,atualização e remoção de proprietários de animais.
 *  
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1.1
 *  
 *  @since 15 de maio de 2016
 * */

@Service
public class ProprietarioServiceImpl {
	private final static Logger logger = LoggerFactory.getLogger(ProprietarioServiceImpl.class);

		@Autowired
		private ProprietarioDAO proprietarioDAO;

		public List<Proprietario> getAll(){
			try {
				return proprietarioDAO.findAll();
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<Proprietario>();
			}
		}

		public Proprietario findById(String cpf){
			return proprietarioDAO.findByCpf(cpf);
		}

		public String cadastrarProprietario(Proprietario proprietario, String usuarioResponsavel){
			try{
				proprietarioDAO.saveOwner(proprietario);
				logger.info("[signup - " + usuarioResponsavel + "] Proprietário salvo com sucesso: " + proprietario.getNome() + ".");
				return "OK";
			}catch(DataIntegrityViolationException ex){
				if(ex.getMessage().toLowerCase().contains("constraint")){
					logger.error("[signup] CPF j� cadastrado: " + proprietario.getCpf() + ".");
					return "Proprietário com CPF " + proprietario.getCpf() + " j� cadastrado no sistema. Por favor, informe um CPF diferente.";
				}else{
					return "Erro ao conectar-se com o banco de dados.";
				}
			}
		}

		public String atualizarProprietario(Proprietario proprietario, String usuarioResponsavel){
			proprietarioDAO.updateOwner(proprietario);
			logger.info("[atualizarProprietario - " + usuarioResponsavel + "] Proprietario " + proprietario.getCpf() + " atualizado com sucesso.");
			return "OK";
		}
		
		public String removerProprietario(String  cpf, String usuarioResponsavel){
			Proprietario proprietario = proprietarioDAO.findByCpf(cpf);
			proprietarioDAO.removeOwner(proprietario);
			logger.info("[removerProprietario - " + usuarioResponsavel + "] Proprietario " + proprietario.getCpf() + " removido com sucesso.");
	    	return "OK";
	    }

		public ProprietarioDAO getProprietarioDAO() {
			return proprietarioDAO;
		}

		public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
			this.proprietarioDAO = proprietarioDAO;
		}
}
