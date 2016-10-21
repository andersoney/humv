package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.ufrb.lasis.humv.entity.Parente;

@Repository
public class ParenteDAO extends GenericDAO<Parente> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}



	/**
	 * Saves an project in the database.
	 *
	 * @param Parente
	 *            the Project to be saved
	 */
	@Transactional
	public void saveParente(Parente Parente) {
		super.save(Parente);
	}

	/**
	 * Updates an project in the database.
	 *
	 * @param Parente
	 *            the Project to be updated
	 */
	@Transactional
	public void updateParente(Parente Parente) {
		super.update(Parente);
	}

	/**
	 * Removes an project in the database.
	 *
	 * @param Parente
	 *            the Project to be removed
	 */
	@Transactional
	public void removeParente(Parente Parente) {
		super.delete(Parente);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Parente> search(String palavrachave) {
		Criteria criteria = getCriteria();
		criteria.add(
				Restrictions.or(
						Restrictions.ilike("nome", "%" + palavrachave + "%"), 
						Restrictions.ilike("nomeResponsavel", "%" + palavrachave + "%")
						)
				);
		return (List<Parente>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Parente> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Parente>) criteria.list();
	}

	@Transactional
	public Parente findById(BigInteger id) {
		return (Parente) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}


}
