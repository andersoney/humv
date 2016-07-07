/*
 * 
 */
package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.ufrb.lasis.humv.entity.Usuario;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

/**
 * The Class representing the data access for User objects.
 * 
 * @author tassiovale
 */
@Repository
public class UsuarioDAO extends GenericDAO<Usuario> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Saves an user in the database.
	 *
	 * @param user
	 *            the user to be saved
	 */
	@Transactional
	public void saveUser(Usuario usuario) {
		super.save(usuario);
	}

	/**
	 * Updates an user in the database.
	 *
	 * @param user
	 *            the user to be updated
	 */
	@Transactional
	public void updateUser(Usuario usuario) {
		super.update(usuario);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param user
	 *            the user to be removed
	 */
	@Transactional
	public void removeUser(Usuario usuario) {
		super.delete(usuario);
	}

	/**
	 * Find an specific user by SIAPE or email.
	 * 
	 * @param email
	 *            the intended email
	 * @return the resulting user
	 */
	@Transactional
	public Usuario findBySiapeOrEmail(String siapeEmail) {
		Criteria criteria = getCriteria();

		Integer conversionResult = NumberUtils.convertStringToInteger(siapeEmail);
		if (conversionResult != null) {
			criteria.add(
					Restrictions.or(Restrictions.eq("siape", conversionResult), Restrictions.eq("email", siapeEmail)));
		} else {
			criteria.add(Restrictions.eq("email", siapeEmail));
		}

		return (Usuario) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> search(String palavrachave) {
		Criteria criteria = getCriteria();

		Integer conversionResult = NumberUtils.convertStringToInteger(palavrachave);
		if (conversionResult != null) {
			criteria.add(
					Restrictions.or(
							Restrictions.eq("siape", conversionResult), 
							Restrictions.ilike("email", "%" + palavrachave + "%"),
							Restrictions.ilike("nome", "%" + palavrachave + "%")
					)
			);
		} else {
			criteria.add(
					Restrictions.or(
							Restrictions.ilike("email", "%" + palavrachave + "%"),
							Restrictions.ilike("nome", "%" + palavrachave + "%")
					)
			);
		}
		
		return (List<Usuario>) criteria.list();
	}

	@Transactional
	public Usuario findBySiape(int siape) {
		return (Usuario) getCriteria().add(Restrictions.eq("siape", siape)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> findByEmailList(String email){
		Criteria criteria = getCriteria().add(Restrictions.ilike("email", "%" + email + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Usuario>) criteria.list();
	}
	
	@Transactional
	public Usuario findByEmail(String email) {
		return (Usuario) getCriteria().add(Restrictions.eq("email", email)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Usuario>) criteria.list();
	}

	public Usuario getSessionUser() {
		try{
			return this.findBySiape(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
		}catch(Exception ex){
			return null;
		}
	}

}
