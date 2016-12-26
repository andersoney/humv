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
    
    @RequestMapping(method = RequestMethod.GET, value = "/{email:.*}")
    public Usuario findById(@PathVariable final String email){
    	System.out.println(email);
    	Usuario u = usuarioServiceImpl.findById(email);
    	System.out.println(u);
    	return u;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Usuario> search(@RequestParam(value="palavrachave") String palavrachave){
    	return usuarioServiceImpl.search(palavrachave);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/obterMedicosAtivos")
    public List<Usuario> obterMedicosAtivos(){
    	return usuarioServiceImpl.obterMedicosAtivos();
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrarUsuario(@RequestBody Usuario usuario, @RequestParam(value="username") String username){
    	return usuarioServiceImpl.cadastrarUsuario(usuario, username);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String atualizarUsuario(@RequestBody Usuario usuario, @RequestParam(value="username") String  username){
    	return usuarioServiceImpl.atualizarUsuario(usuario, username);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{email:.*}")
    public String removerUsuario(@PathVariable final String email, @RequestParam(value="username") String  username){
    	return usuarioServiceImpl.removerUsuario(email, username);
    }
    
	public UsuarioServiceImpl getUsuarioServiceImpl( ) {
		return usuarioServiceImpl;
	}

	public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
		this.usuarioServiceImpl = usuarioServiceImpl;
	}

}
