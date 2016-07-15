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
import br.edu.ufrb.lasis.humv.entity.Projeto;

@Repository
public class ProjetoDAO extends GenericDAO<Projeto> implements Serializable {

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
	 * @param projeto
	 *            the Project to be saved
	 */
	@Transactional
	public void saveProjeto(Projeto projeto) {
		super.save(projeto);
	}

	/**
	 * Updates an project in the database.
	 *
	 * @param projeto
	 *            the Project to be updated
	 */
	@Transactional
	public void updateProjeto(Projeto projeto) {
		super.update(projeto);
	}

	/**
	 * Removes an project in the database.
	 *
	 * @param projeto
	 *            the Project to be removed
	 */
	@Transactional
	public void removeProjeto(Projeto projeto) {
		super.delete(projeto);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Projeto> findBySiapeResponsavel(BigInteger siape){
		Criteria criteria = getCriteria().add(Restrictions.eq("siapeResponsavel", siape));
		criteria.addOrder(Order.asc("siapeResponsavel"));
		return (List<Projeto>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Projeto> search(String palavrachave) {
		Criteria criteria = getCriteria();
		criteria.add(
				Restrictions.or(
						Restrictions.ilike("nome", "%" + palavrachave + "%"), 
						Restrictions.ilike("nomeResponsavel", "%" + palavrachave + "%")
						)
				);
		return (List<Projeto>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Projeto> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Projeto>) criteria.list();
	}

	@Transactional
	public Projeto findById(BigInteger id) {
		return (Projeto) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}

}
