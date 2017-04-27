package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;

@Repository
public class SolicitacaoMaterialDAO extends GenericDAO<SolicitacaoMaterial> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveSolicitacaoMaterial(SolicitacaoMaterial solicitacaoMaterial) {
		super.save(solicitacaoMaterial);
	}

	@Transactional
	public void updateSolicitacaoMaterial(SolicitacaoMaterial solicitacaoMaterial) {
		super.update(solicitacaoMaterial);
	}

	@Transactional
	public void removeSolicitacaoMaterial(SolicitacaoMaterial solicitacaoMaterial) {
		super.delete(solicitacaoMaterial);
	}

	@Transactional
	public SolicitacaoMaterial findById(BigInteger id) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (SolicitacaoMaterial) criteria.uniqueResult();
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<SolicitacaoMaterial> findByStatus(String status) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("status", status));
		criteria.addOrder(Order.desc("dataSolicitacao"));
		return (List<SolicitacaoMaterial>) criteria.list();	
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<SolicitacaoMaterial> findByDataSolicitacao(Date date) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("dataSolicitacao", date));
		criteria.addOrder(Order.desc("id"));
		return (List<SolicitacaoMaterial>) criteria.list();	
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<SolicitacaoMaterial> findByDataLiberacao(Date date) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("dataLiberacao", date));
		criteria.addOrder(Order.desc("id"));
		return (List<SolicitacaoMaterial>) criteria.list();	
	}

}
