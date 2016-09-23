package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufrb.lasis.humv.entity.Atendimento;

/**
 * The Class representing the data access for User objects.
 * 
 * @author tassiovale
 */
@Repository
public class AtendimentoDAO extends GenericDAO<Atendimento> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveAtendimento(Atendimento atendimento) {
		super.save(atendimento);
	}

	@Transactional
	public void updateAtendimento(Atendimento atendimento) {
		super.update(atendimento);
	}


	@Transactional
	public void removeAtendimento(Atendimento atendimento) {
		super.delete(atendimento);
	}


	@Transactional
	public Atendimento findById(BigInteger id) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("id", id));

		return (Atendimento) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Atendimento> searchByDateAndMedico(Date date, String id, boolean incluiCancelados) {
		Criteria criteria = getCriteria();
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date); 
		calendar.add(Calendar.DATE, 1);
		Date dataDepois = calendar.getTime();
				
		ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("medico.email"),"medico.email");
        criteria.setProjection(projectionList); 
		
        Conjunction conjunction = Restrictions.and(
				Restrictions.eq("medico.email", id), 
				Restrictions.ge("horarioMarcado", date),
				Restrictions.lt("horarioMarcado", dataDepois)
				
		);
        
        if(!incluiCancelados){
        	conjunction.add(Restrictions.ne("status", Atendimento.STATUS_CANCELADO));
        }
        
		criteria.add(conjunction);
		
		criteria.addOrder(Order.asc("horarioMarcado"));
		
		return (List<Atendimento>) criteria.list();
	}
	
}
