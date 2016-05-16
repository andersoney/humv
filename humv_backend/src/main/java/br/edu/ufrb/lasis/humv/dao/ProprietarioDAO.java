package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.ufrb.lasis.humv.entity.Proprietario;

/**
 * The Class representing the data access for Animal owner objects.
 * 
 * @author Luiz Antônio Pereira
 * 
 * @version 1
 * 
 * @since 16 de maio de 2016
 */
@Repository
public class ProprietarioDAO extends GenericDAO<Proprietario> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Saves an user in the database.
	 *
	 * @param owner
	 *            the Animal owner to be saved
	 */
	@Transactional
	public void saveOwner(Proprietario proprietario) {
		super.save(proprietario);
	}

	/**
	 * Updates an Animal owner in the database.
	 *
	 * @param owner
	 *            the Animal owner to be updated
	 */
	@Transactional
	public void updateOwner(Proprietario proprietario) {
		super.update(proprietario);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param owner
	 *            the Animal owner to be removed
	 */
	@Transactional
	public void removeOwner(Proprietario proprietario) {
		super.delete(proprietario);
	}

	/**
	 * Find an specific owner by CPF.
	 * 
	 * @param cpf
	 *            the owner id 
	 * @return the resulting owner
	 */
	
	public Proprietario findByCpf(String cpf) {
		return (Proprietario) getCriteria().add(Restrictions.eq("cpf", cpf)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Proprietario> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Proprietario>) criteria.list();
	}
}
