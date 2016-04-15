package br.edu.ufrb.lasis.humv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioService {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Usuario login(@RequestBody Usuario usuario){
    	return usuarioServiceImpl.login(usuario);
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Usuario signup(@RequestBody Usuario usuario){
    	return usuarioServiceImpl.signup(usuario);
    }

	public UsuarioServiceImpl getUsuarioServiceImpl() {
		return usuarioServiceImpl;
	}

	public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
		this.usuarioServiceImpl = usuarioServiceImpl;
	}

}
