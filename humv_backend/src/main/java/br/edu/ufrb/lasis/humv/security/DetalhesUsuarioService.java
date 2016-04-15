package br.edu.ufrb.lasis.humv.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.edu.ufrb.lasis.humv.dao.UsuarioDAO;
import br.edu.ufrb.lasis.humv.entity.PapelUsuario;
import br.edu.ufrb.lasis.humv.entity.Usuario;

public class DetalhesUsuarioService implements UserDetailsService {
 
	@Autowired
	private UsuarioDAO usuarioDAO;
 
	//@Transactional
	public UserDetails loadUserByUsername(final String siapeEmail) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findBySiapeOrEmail(siapeEmail);
		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getPapelUsuario());
 
		return buildUserForAuthentication(usuario, authorities);
	}
 
	private User buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getSiape().toString(), usuario.getSenha(), 
				usuario.isAtivo(), true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(List<PapelUsuario> papeisUsuario) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (PapelUsuario papelUsuario : papeisUsuario) {
			setAuths.add(new SimpleGrantedAuthority(papelUsuario.getPapel()));
		}
 
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
 
		return result;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
 
}