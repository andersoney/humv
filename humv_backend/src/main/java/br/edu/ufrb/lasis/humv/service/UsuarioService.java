package br.edu.ufrb.lasis.humv.service;

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
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/api/usuario")
@Secured("ROLE_ADMIN")
public class UsuarioService {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
    
    @RequestMapping
    public List<Usuario> getAll(){
    	return usuarioServiceImpl.getAll(); 
    }
    
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Usuario findById(@PathVariable("email") final String email){
    	return usuarioServiceImpl.findById(email);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String signup(@RequestBody Usuario usuario){
    	return usuarioServiceImpl.signup(usuario);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarUsuario(@RequestBody Usuario usuario){
    	return usuarioServiceImpl.atualizarUsuario(usuario);
    }
    
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public String removerUsuario(@RequestParam String  email){
    	return usuarioServiceImpl.removerUsuario(email);
    }
    
	public UsuarioServiceImpl getUsuarioServiceImpl( ) {
		return usuarioServiceImpl;
	}

	public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
		this.usuarioServiceImpl = usuarioServiceImpl;
	}

}
