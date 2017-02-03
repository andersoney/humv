package br.edu.ufrb.lasis.humv.service;

import java.math.BigInteger;
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

import br.edu.ufrb.lasis.humv.entity.Material;
import br.edu.ufrb.lasis.humv.impl.MaterialServiceImpl;

@RestController
@RequestMapping(value = "/api/material")
@Secured("ROLE_ADMIN")
public class MaterialService {

	@Autowired
	private MaterialServiceImpl materialServiceImpl;

	@RequestMapping
	public List<Material> getAll() {
		return materialServiceImpl.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codigo}")
	public Material findById(@PathVariable BigInteger codigo) {
		return materialServiceImpl.findById(codigo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public List<Material> search(@RequestParam(value = "palavrachave") String palavrachave) {
		return materialServiceImpl.search(palavrachave);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String cadastrarMaterial(@RequestBody Material material, @RequestParam(value = "username") String username) {
		return materialServiceImpl.cadastrarMaterial(material, username);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/retornaCadastrado", consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public Material cadastrarMaterialRetornandoCadatrado(@RequestBody Material material,
			@RequestParam(value = "username") String username) {
		materialServiceImpl.cadastrarMaterial(material, username);
		return material;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String atualizarMaterial(@RequestBody Material material, @RequestParam(value = "username") String username) {
		return materialServiceImpl.atualizarMaterial(material, username);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{codigo}")
	public String removerMaterial(@PathVariable BigInteger codigo, @RequestParam(value = "username") String username) {
		return materialServiceImpl.removerMaterial(codigo, username);
	}

}
