package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ProcedimentoDAO extends GenericDAO<Procedimento> implements Serializable {

    private static final long serialVersionUID = 1L;

    private SessionFactory sessionFactory;
    
    public ProcedimentoDAO(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * Aqui é salvo o procedimento na database.
     *
     * @param procedimento Variavel do procedimento.
     */
    public void saveProcedimento(Procedimento procedimento) {
        super.save(procedimento);
    }

    public void updateProcedimento(Procedimento procedimento) {
        super.update(procedimento);
    }
    
    public Procedimento searchByNome(String nome) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("nome", nome));
        return (Procedimento) criteria.uniqueResult();
    }

}
