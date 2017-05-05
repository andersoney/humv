package br.edu.ufrb.lasis.humv.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ufrb.lasis.humv.dao.MaterialDAO;
import br.edu.ufrb.lasis.humv.entity.Material;

@Service
public class MaterialServiceImpl {
	private final static Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

	@Autowired
	private MaterialDAO materialDAO;

	public List<Material> getAll() {
		try {
			return materialDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Material>();
		}
	}

	public Material findById(BigInteger id) {
		return materialDAO.findByKey(id);
	}

	public List<Material> search(String palavrachave) {
		return materialDAO.search(palavrachave);
	}
	
	public List<Material> searchByKitMaterial(int modelo) {
		return materialDAO.searchByKitMaterial(modelo);
	}

	public String cadastrarMaterial(Material material, String usuarioResponsavel) {
		try {
			materialDAO.saveMaterial(material);
			logger.info("[cadastrarMaterial - " + usuarioResponsavel + "] Material salvo com sucesso: "
					+ material.getDiscriminacao() + ".");
			return "OK";
		} catch (DataIntegrityViolationException ex) {
			if (ex.getMessage().toLowerCase().contains("constraint")) {
				return "Material com Id " + material.getId() + " já cadastrado no sistema.";
			} else {
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarMaterial(Material material, String usuarioResponsavel) {
		if (materialDAO.findByKey(material.getId()) == null) {
			return "Nenhum material com o Id " + material.getId() + " encontrado no sistema.";
		}
		materialDAO.updateMaterial(material);
		logger.info("[atualizarMaterial - " + usuarioResponsavel + "] Material " + material.getId()
				+ " atualizado com sucesso.");
		return "OK";
	}

	public String removerMaterial(BigInteger id, String usuarioResponsavel) {
		if (materialDAO.findByKey(id) == null) {
			return "Nenhum material com o Id " + id + " encontrado no sistema.";
		}
		Material material = materialDAO.findByKey(id);
		materialDAO.removeMaterial(material);
		logger.info("[removerMaterial - " + usuarioResponsavel + "] Material " + material.getId()
				+ " removido com sucesso.");
		return "OK";
	}

}
