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
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufrb.lasis.humv.entity.Documentacao;


public class DocumentacaoDAO extends GenericDAO<Documentacao> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}



	@Transactional
	public void saveDocumentacao(Documentacao documentacao) {
		super.save(documentacao);
	}

	@Transactional
	public void updateDocumentacao(Documentacao documentacao) {
		super.update(documentacao);
	}

	
	@Transactional
	public void removeDocumentacao(Documentacao documentacao) {
		super.delete(documentacao);
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Documentacao> search(String palavrachave) {
		Criteria criteria = getCriteria();
		criteria.add(
				Restrictions.or(
						Restrictions.ilike("nome", "%" + palavrachave + "%"), 
						Restrictions.ilike("nomeResponsavel", "%" + palavrachave + "%")
						)
				);
		return (List<Documentacao>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Documentacao> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Documentacao>) criteria.list();
	}

	@Transactional
	public Documentacao findById(BigInteger id) {
		return (Documentacao) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}
}
