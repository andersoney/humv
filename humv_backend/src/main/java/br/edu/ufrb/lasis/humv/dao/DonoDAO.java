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
import br.edu.ufrb.lasis.humv.entity.Dono;

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
public class DonoDAO extends GenericDAO<Dono> implements Serializable{

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
	public void saveOwner(Dono proprietario) {
		super.save(proprietario);
	}

	/**
	 * Updates an Animal owner in the database.
	 *
	 * @param owner
	 *            the Animal owner to be updated
	 */
	@Transactional
	public void updateOwner(Dono proprietario) {
		super.update(proprietario);
	}

	/**
	 * Removes an user in the database.
	 *
	 * @param owner
	 *            the Animal owner to be removed
	 */
	@Transactional
	public void removeOwner(Dono proprietario) {
		super.delete(proprietario);
	}

	/**
	 * Find an specific owner by CPF.
	 * 
	 * @param cpf
	 *            the owner id 
	 * @return the resulting owner
	 */
	@Transactional
	public Dono findByKey(String id) {
		return (Dono) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Dono> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		//?? Perguntar a Tassio se realmente deve ser "nome" ou não seria nome
		//R: "nome", pois se refere ao nome da coluna da tabela no banco de dados, e n�o � vari�vel String nome
		return (List<Dono>) criteria.list();
	}
}
