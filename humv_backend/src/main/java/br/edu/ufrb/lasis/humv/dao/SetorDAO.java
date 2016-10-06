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
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

/**
 * The Class representing the data access for Sector objects.
 * 
 * @author Vinicius Moura
 * 
 * @version 1.1
 * 
 * @since 7 de junho de 2016
 */
@Repository
public class SetorDAO  extends GenericDAO<Setor> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Saves a sector in the database.
	 *
	 * @param sector
	 *            the sector to be saved
	 */
	@Transactional
	public void saveSetor(Setor setor) {
		super.save(setor);
	}

	/**
	 * Updates a sector in the database.
	 *
	 * @param setor
	 *            the sector to be updated
	 */
	@Transactional
	public void updateSetor(Setor setor) {
		super.update(setor);
	}

	/**
	 * Removes a sector in the database.
	 *
	 * @param sector
	 *            the sector to be removed
	 */
	@Transactional
	public void removeSetor(Setor setor) {
		super.delete(setor);
	}
	
	
	@Transactional
	public Setor findByCodigo(BigInteger codigo) {
		return (Setor) getCriteria().add(Restrictions.eq("codigo", codigo)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Setor> search(String palavrachave) {
		Criteria criteria = getCriteria();

		BigInteger conversionResult = NumberUtils.convertStringToInteger(palavrachave);
		if (conversionResult != null) {
			criteria.add(
					Restrictions.or(
							Restrictions.eq("codigo", conversionResult), 
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
		
		return (List<Setor>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Setor> findByNome(String nome) {
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Setor>) criteria.list();	
	}	
}
