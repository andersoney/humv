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

import br.edu.ufrb.lasis.humv.entity.Material;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

@Repository
public class MaterialDAO extends GenericDAO<Material> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveMaterial(Material material) {
		super.save(material);
	}

	@Transactional
	public void updateMaterial(Material material) {
		super.update(material);
	}

	@Transactional
	public void removeMaterial(Material material) {
		super.delete(material);
	}

	@Transactional
	public Material findByKey(BigInteger id) {
		return (Material) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Material> search(String palavrachave) {
		Criteria criteria = getCriteria();

		BigInteger conversionResult = NumberUtils.convertStringToBigInteger(palavrachave);
		if (conversionResult != null) {
			criteria.add( Restrictions.eq("id", conversionResult)  );
		} else {
			criteria.add(Restrictions.ilike("discriminacao", "%" + palavrachave + "%"));
		}
		
		return (List<Material>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Material> searchByKitMaterial(int modelo) {
		Criteria criteria = getCriteria();
		criteria.add( Restrictions.eq("kit", modelo));	
		return (List<Material>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Material> findByDiscriminacao(String discriminacao){
		Criteria criteria = getCriteria().add(Restrictions.ilike("discriminacao", "%" + discriminacao + "%"));
		criteria.addOrder(Order.asc("discriminacao"));
		return (List<Material>) criteria.list();
	}

}
