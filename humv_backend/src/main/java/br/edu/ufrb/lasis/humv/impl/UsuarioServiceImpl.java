package br.edu.ufrb.lasis.humv.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.UsuarioDAO;
import br.edu.ufrb.lasis.humv.entity.Usuario;

@Service
public class UsuarioServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public Usuario login(Usuario usuario){
    	Usuario u = usuarioDAO.findBySiapeOrEmail(usuario.getEmail());
    	if(u == null){
    		u = usuarioDAO.findBySiapeOrEmail(usuario.getSiape().toString());
    		return u;
    	}else{
    		return null;
    	}
    	
    }
    
    public Usuario signup(Usuario usuario){
    	usuarioDAO.saveUser(usuario);
    	return usuario;
    }

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
