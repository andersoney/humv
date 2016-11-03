package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;

@Repository
public class AtendimentoSocialDAO extends GenericDAO<AtendimentoSocial> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveAtendimentoSocial(AtendimentoSocial atendimentoSocial) {
		super.save(atendimentoSocial);
	}

	@Transactional
	public void updateAtendimentoSocial(AtendimentoSocial atendimentoSocial) {
		super.update(atendimentoSocial);
	}


	@Transactional
	public void removeAtendimentoSocial(AtendimentoSocial atendimentoSocial) {
		super.delete(atendimentoSocial);
	}


	@Transactional
	public AtendimentoSocial findById(BigInteger id) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (AtendimentoSocial) criteria.uniqueResult();
	}

}
