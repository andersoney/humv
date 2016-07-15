package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

@Repository
public class ProcedimentoDAO extends GenericDAO<Procedimento> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Transactional
	/**
	 * Aqui é salvo o procedimento na database.
	 * @param procedimento
	 * 				Variavel do procedimento.
	 */
	public void saveProcedimento(Procedimento procedimento){
		super.save(procedimento);
	}

	@Transactional
	public void updateProcedimento(Procedimento procedimento){
		super.update(procedimento);
	}

	@Transactional
	public void removeProcedimento(Procedimento procedimento){
		super.delete(procedimento);
	}

	@SuppressWarnings("unchecked")
	public List<Procedimento> findByName(String nome){
		Criteria criteria = getCriteria().add(Restrictions.ilike("nome", "%"+nome+"%"));
		criteria.addOrder(Order.asc("nome"));
		return (List<Procedimento>) criteria.list();
	}
	
	@Transactional
	public Procedimento findByCode(BigInteger codigo){
		return (Procedimento) getCriteria().add(Restrictions.eq("codigo", codigo)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Procedimento> search(String palavrachave) {
		Criteria criteria = getCriteria();

		Integer conversionResult = NumberUtils.convertStringToInteger(palavrachave);
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
		
		return (List<Procedimento>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Procedimento> findByCodigoSetor(BigInteger codigo){
		return (List<Procedimento>) getCriteria().add(Restrictions.eq("codSetor", codigo)).list();
	}
	
	
}
