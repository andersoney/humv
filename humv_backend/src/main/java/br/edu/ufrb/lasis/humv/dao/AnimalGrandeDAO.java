package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.entity.Proprietario;

/**
 * The Class representing the data access for Large animal objects.
 * 
 * @author Luiz Antônio Pereira
 * 
 * @version 1.1
 * 
 * @since 16 de maio de 2016
 */

public class AnimalGrandeDAO  extends GenericDAO<AnimalGrande> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Saves a large animal in the database.
	 *
	 * @param animal
	 *            the large animal to be saved
	 */
	@Transactional
	public void saveLargeAnimal(AnimalGrande animal) {
		super.save(animal);
	}

	/**
	 * Updates a large animal in the database.
	 *
	 * @param animal
	 *            the large animal to be updated
	 */
	@Transactional
	public void updateLargeAnimal(AnimalGrande animal) {
		super.update(animal);
	}

	/**
	 * Removes a large animal in the database.
	 *
	 * @param animal
	 *            the large animal to be removed
	 */
	@Transactional
	public void removeLargeAnimal(AnimalGrande animal) {
		super.delete(animal);
	}
	
	public AnimalGrande findByRghumv(String rghumv) {
		return (AnimalGrande) getCriteria().add(Restrictions.eq("rghumv", rghumv)).uniqueResult();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<AnimalGrande> findByProprietario(Proprietario proprietario) {
		String cpf = proprietario.getNome();
		Criteria criteria = getCriteria().add(Restrictions.ilike("proprietario", "%" + cpf + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<AnimalGrande>) criteria.list();	
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<AnimalGrande> findByNome(String nome) {
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<AnimalGrande>) criteria.list();	
	}
}
