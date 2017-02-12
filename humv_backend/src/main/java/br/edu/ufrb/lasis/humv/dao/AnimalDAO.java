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
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

/**
 * The Class representing the data access for animal objects.
 * 
 * @author Luiz Antônio Pereira
 * 
 * @version 1.1
 * 
 * @since 16 de maio de 2016
 */
@Repository
public class AnimalDAO  extends GenericDAO<Animal> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Saves a animal in the database.
	 *
	 * @param animal animal to be saved
	 */
	@Transactional
	public void saveAnimal(Animal animal) {
		super.save(animal);
	}

	/**
	 * Updates a animal in the database.
	 * 
	 * @param animal animal to be updated
	 */
	@Transactional
	public void updateAnimal(Animal animal) {
		super.update(animal);
	}

	/**
	 * Removes a animal in the database.
	 *
	 * @param animal the animal to be removed
	 */
	@Transactional
	public void removeAnimal(Animal animal) {
		super.delete(animal);
	}
	
	@Transactional
	public Animal findByRghumv(BigInteger rghumv) {
		return (Animal) getCriteria().add(Restrictions.eq("rghumv", rghumv)).uniqueResult();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Animal> findByDono(BigInteger idDono) {
		Criteria criteria = getCriteria().createAlias("dono", "d").add(Restrictions.eq("d.id", idDono));
		criteria.addOrder(Order.desc("nome"));
		return (List<Animal>) criteria.list();	
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Animal> search(String palavrachave) {
		Criteria criteria = getCriteria();

		BigInteger conversionResult = NumberUtils.convertStringToBigInteger(palavrachave);
		if (conversionResult != null) {
			criteria.add(
					Restrictions.or(
							Restrictions.eq("rghumv", conversionResult), 
							Restrictions.ilike("nome", "%" + palavrachave + "%")
					)
			);
		} else {
			criteria.add(
					Restrictions.or(
							Restrictions.ilike("nome", "%" + palavrachave + "%")
					)
			);
		}
		
		return (List<Animal>) criteria.list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Animal> findByNome(String nome) {
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Animal>) criteria.list();	
	}
}
