package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;

@Repository
public class AtendimentoSocialDAO extends GenericDAO<AtendimentoSocial> implements Serializable {

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

    @SuppressWarnings("unchecked")
    @Transactional
    public List<AtendimentoSocial> search(String palavrachave) {
        Criteria criteria = getCriteria();
        BigInteger conversionResult = NumberUtils.convertStringToBigInteger(palavrachave);
        if (conversionResult != null) {
        	criteria.add(
                    Restrictions.or(
                            Restrictions.eq("animal.rghumv", conversionResult),
                            Restrictions.eq("dono.id", conversionResult)
                    )
            );
        } else{
        	if( palavrachave.indexOf('+')>= 0){
        		palavrachave = palavrachave.replaceAll("+", " ");
            }
        	criteria = getCriteria().createAlias("dono", "d").add(Restrictions.eq("d.nome", palavrachave));
        	List <AtendimentoSocial> results = criteria.list();
        	if(results.size() != 0){
        		return results;
        	}
        	else {
        	    criteria = getCriteria().createAlias("dono", "d").add(
                        Restrictions.or(
                                Restrictions.ilike("d.nome", "%" + palavrachave + "%"),
                                Restrictions.ilike("d.cpfCnpj", "%" + palavrachave + "%")
                        )
                );
        	}
        	
        }

        return (List<AtendimentoSocial>) criteria.list();
    }

}
