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
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.entity.Dono;

/**
 * The Class representing the data access for Small animal objects.
 * 
 * @author Luiz Antônio Pereira
 * 
 * @version 1.1
 * 
 * @since 16 de maio de 2016
 */
@Repository
public class AnimalPequenoDAO  extends GenericDAO<AnimalPequeno> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Saves a small animal in the database.
	 *
	 * @param animal
	 *            the small animal to be saved
	 */
	@Transactional
	public void saveLargeAnimal(AnimalPequeno animal) {
		super.save(animal);
	}

	/**
	 * Updates a small animal in the database.
	 *
	 * @param animal
	 *            the small animal to be updated
	 */
	@Transactional
	public void updateLargeAnimal(AnimalPequeno animal) {
		super.update(animal);
	}

	/**
	 * Removes a small animal in the database.
	 *
	 * @param animal
	 *            the small animal to be removed
	 */
	@Transactional
	public void removeLargeAnimal(AnimalPequeno animal) {
		super.delete(animal);
	}
	
	@Transactional
	public AnimalPequeno findByRghumv(String rghumv) {
		return (AnimalPequeno) getCriteria().add(Restrictions.eq("rghumv", rghumv)).uniqueResult();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<AnimalPequeno> findByProprietario(Dono proprietario) {
		String cpf = proprietario.getNome();
		Criteria criteria = getCriteria().add(Restrictions.ilike("proprietario", "%" + cpf + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<AnimalPequeno>) criteria.list();	
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<AnimalPequeno> findByNome(String nome) {
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<AnimalPequeno>) criteria.list();	
	}
}
