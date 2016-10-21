package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.AtendimentoDAO;
import br.edu.ufrb.lasis.humv.entity.Atendimento;

@Service
public class AtendimentoServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(AtendimentoServiceImpl.class);

	@Autowired
	private AtendimentoDAO atendimentoDAO;

	public List<Atendimento> getAll(){
		try {
			return atendimentoDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Atendimento>();
		}
	}

	public Atendimento findById(BigInteger id){
		return atendimentoDAO.findById(id);
	}

	public List<Atendimento> searchByDateAndMedico(String date, String id, boolean incluiCancelados){
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (ParseException e) {
			logger.error("[searchByDateAndMedico] Erro ao converter data.");
			e.printStackTrace();
		}
		return atendimentoDAO.searchByDateAndMedico(data, id, incluiCancelados);
	}

	public String cadastrarAtendimento(Atendimento atendimento, String usuarioResponsavel){
		try{
			atendimentoDAO.saveAtendimento(atendimento);
			logger.info("[cadastrarAtendimento - " + usuarioResponsavel + "] Atendimento salvo com sucesso: " + atendimento.getId() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[cadastrarAtendimento] Atendimento ja cadastrado: " + atendimento.getId() + ".");
				return "Atendimento ja cadastrado no sistema. Por favor, informe um atendimento diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String cancelarAtendimentos(String idMedico, String dataInicio, String dataFim, String motivo, String usuarioResponsavel){
		try{
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
			atendimentoDAO.cancelarAtendimentos(idMedico, formatter.parse(dataInicio), formatter.parse(dataFim), motivo);
			logger.info("[cancelarAtendimentos - " + usuarioResponsavel + "] Atendimentos entre " + dataInicio + " e " + dataFim + " para o médico " + idMedico + " cancelados com sucesso.");
			return "OK";
		} catch (ParseException e) {
			logger.error("[cancelarAtendimentos] Erro ao converter data.");
			e.printStackTrace();
			return "Erro ao converter data.";
		}
	}

	public String atualizarAtendimento(Atendimento atendimento, String usuarioResponsavel){
		atendimentoDAO.updateAtendimento(atendimento);
		logger.info("[atualizarAtendimento - " + usuarioResponsavel + "] Atendimento " + atendimento.getId() + " atualizado com sucesso.");
		return "OK";
	}

	public String removerAtendimento(BigInteger id, String usuarioResponsavel){
		Atendimento atendimento = atendimentoDAO.findById(id);
		atendimentoDAO.removeAtendimento(atendimento);
		logger.info("[removerAtendimento - " + usuarioResponsavel + "] Atendimento " + atendimento.getId() + " removido com sucesso.");
		return "OK";
	}

	public AtendimentoDAO getAtendimentoDAO() {
		return atendimentoDAO;
	}

	public void setAtendimentoDAO(AtendimentoDAO atendimentoDAO) {
		this.atendimentoDAO = atendimentoDAO;
	}

}
