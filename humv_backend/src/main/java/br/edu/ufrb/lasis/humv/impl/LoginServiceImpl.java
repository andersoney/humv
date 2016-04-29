package br.edu.ufrb.lasis.humv.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.UsuarioDAO;
import br.edu.ufrb.lasis.humv.entity.Usuario;

@Service
public class LoginServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	private static final String ADMIN_USERNAME = "humv";
	private static final String ADMIN_PASSWORD = "lAs1s_UFRB";

	@Autowired
	private UsuarioDAO usuarioDAO;

	public String login(String username, String senha){
		Usuario u = usuarioDAO.findBySiapeOrEmail(username);
		if(u != null){
			if(senha.equals(u.getSenha())){
				return "OK-" + u.getPerfil();
			}else{
				logger.error("[login] Erro durante login do usuário " + u.getSiape() + " - " + u.getNome() + ".");
				return "Senha incorreta, por favor, digite-a novamente.";
			}
		}else
			if(!username.equals(ADMIN_USERNAME)){
				logger.error("[login] Login com usuário inválido: " + username + ".");
				return "Usuário inválido, por favor, digite-o novamente.";
			}else
				if(senha.equals(ADMIN_PASSWORD)){
					Usuario usuario = new Usuario();
					usuario.setEmail(ADMIN_USERNAME);
					usuario.setSenha(ADMIN_PASSWORD);
					return "OK";
				}else{
					logger.error("[login] Erro durante login do usuário ADMIN do sistema.");
					return "Senha incorreta, por favor, digite-a novamente.";
				}

	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
