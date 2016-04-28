package br.edu.ufrb.lasis.humv.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.ufrb.lasis.humv.dao.UsuarioDAO;
import br.edu.ufrb.lasis.humv.entity.Usuario;

@Service
public class UsuarioServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	public List<Usuario> getAll(){
		try {
			return usuarioDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();
		}
	}

	public Usuario findById(String email){
		return usuarioDAO.findByEmail(email);
	}

	public String signup(Usuario usuario){
		try{
			usuarioDAO.saveUser(usuario);
			logger.info("[signup] Usuário salvo com sucesso: " + usuario.getNome() + ".");
			return "OK";
		}catch(DataIntegrityViolationException ex){
			if(ex.getMessage().toLowerCase().contains("constraint")){
				logger.error("[signup] E-mail já cadastrado: " + usuario.getEmail() + ".");
				return "Usuário com e-mail " + usuario.getEmail() + " já cadastrado no sistema. Por favor, informe um e-mail diferente.";
			}else{
				return "Erro ao conectar-se com o banco de dados.";
			}
		}
	}

	public String atualizarUsuario(Usuario usuario){
		usuarioDAO.updateUser(usuario);
		logger.info("[atualizarUsuario] Usuário " + usuario.getEmail() + " atualizado com sucesso.");
		return "OK";
	}
	
	public String removerUsuario(@RequestParam String  email){
		Usuario usuario = usuarioDAO.findByEmail(email);
		usuarioDAO.removeUser(usuario);
		logger.info("[removerUsuario] Usuário " + usuario.getEmail() + " removido com sucesso.");
    	return "OK";
    }

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
