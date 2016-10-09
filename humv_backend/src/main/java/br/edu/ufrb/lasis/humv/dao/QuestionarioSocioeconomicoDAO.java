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

import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

@Repository
public class QuestionarioSocioeconomicoDAO extends GenericDAO<QuestionarioSocioeconomico> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveQuestionario(QuestionarioSocioeconomico questionario) {
		super.save(questionario);
	}

	@Transactional
	public void updateQuestionario(QuestionarioSocioeconomico questionario) {
		super.update(questionario);
	}

	
	@Transactional
	public void removeQuestionario(QuestionarioSocioeconomico questionario) {
		super.delete(questionario);
	}

	@Transactional
	public QuestionarioSocioeconomico findByKey(Integer id) {
		return (QuestionarioSocioeconomico) getCriteria().add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<QuestionarioSocioeconomico> search(String palavrachave) {
		Criteria criteria = getCriteria();

		BigInteger conversionResult = NumberUtils.convertStringToInteger(palavrachave);
		if (conversionResult != null) {
			criteria.add(Restrictions.eq("id", conversionResult));
		} else {
			criteria.add(
					Restrictions.or(
							Restrictions.ilike("nomeDono", "%" + palavrachave + "%")
					)
			);
		}
		
		return (List<QuestionarioSocioeconomico>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestionarioSocioeconomico> findByDono(Integer idDono){
		Criteria criteria = getCriteria().add(Restrictions.ilike("id", "%" + idDono + "%"));
		criteria.addOrder(Order.asc("data"));
		return (List<QuestionarioSocioeconomico>) criteria.list();
	}
}