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

import br.edu.ufrb.lasis.humv.entity.DocumentoComprovante;

@Repository
public class DocumentacaoDAO extends GenericDAO<DocumentoComprovante> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}



	@Transactional
	public void saveDocumentacao(DocumentoComprovante documentacao) {
		super.save(documentacao);
	}

	@Transactional
	public void updateDocumentacao(DocumentoComprovante documentacao) {
		super.update(documentacao);
	}

	
	@Transactional
	public void removeDocumentacao(DocumentoComprovante documentacao) {
		super.delete(documentacao);
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoComprovante> findByNome(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%" + nome + "%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<DocumentoComprovante>) criteria.list();
	}

	@Transactional
	public DocumentoComprovante findById(BigInteger id) {
		return (DocumentoComprovante) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}
}
