package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.edu.ufrb.lasis.humv.entity.Hello;

@Repository
public class HelloDAO extends GenericDAO<Hello> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Hello saveHello(Hello h) {
		return super.save(h);
	} 

	@Transactional
	public void update(Hello h) {
		super.update(h);
	}

	@Transactional
	public void remove(Hello h) {
		super.delete(h);
	}
	
	/*public Cargo findByCargo(String cargo){
		return (Cargo) getCriteria().add(Restrictions.eq("nomeCargo", cargo)).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public List findByParteCargo(String cargo){
		return getCriteria().add(Restrictions.ilike("nomeCargo", "%" + cargo + "%")).list();
	}*/
	
}
