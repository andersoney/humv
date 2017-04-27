package br.edu.ufrb.lasis.humv.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.lasis.humv.impl.SolicitacaoMaterialServiceImpl;
import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;

@RestController
@RequestMapping(value = "/api/solicitacaoMaterial")
@Secured("ROLE_ADMIN")
public class SolicitacaoMaterialService {
	@Autowired
	private SolicitacaoMaterialServiceImpl solicitacaoMaterialServiceImpl;

	@RequestMapping
	public List<SolicitacaoMaterial> getAll() {
		return solicitacaoMaterialServiceImpl.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public SolicitacaoMaterial findById(@PathVariable BigInteger id) {
		return solicitacaoMaterialServiceImpl.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{status}")
	public List<SolicitacaoMaterial> findByStatus(@PathVariable String status) {
		return solicitacaoMaterialServiceImpl.searchByStatus(status);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dataLiberacao")
	public List<SolicitacaoMaterial> findByDataLiberacao(@RequestParam(value="dataLiberacao") Date data) {
		return solicitacaoMaterialServiceImpl.searchByDataLiberacao(data);
	}
	
	@RequestMapping(method = RequestMethod.GET,  value = "/dataSolicitacao")
	public List<SolicitacaoMaterial> findByDataSolicitacao(@RequestParam(value="dataSolicitacao") Date data) {
		return solicitacaoMaterialServiceImpl.searchByDataSolicitacao(data);
	}
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String cadastrarSolicitacaoMaterial(
			@RequestBody SolicitacaoMaterial solicitacaoMaterial,
			@RequestParam(value = "username") String username) {
		return solicitacaoMaterialServiceImpl.cadastrarSolicitacaoMaterial(solicitacaoMaterial,
				username);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String atualizarQuestionarioSocioeconomico(
			@RequestBody SolicitacaoMaterial solicitacaoMaterial,
			@RequestParam(value = "username") String username) {
		return solicitacaoMaterialServiceImpl.atualizarSolicitacaoMaterial(solicitacaoMaterial,
				username);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String removerQuestionarioSocioeconomico(@PathVariable BigInteger id,
			@RequestParam(value = "username") String username) {
		return solicitacaoMaterialServiceImpl.removerSolicitacaoMaterial(id, username);
	}
	
	
}
