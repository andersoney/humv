package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * The Class representing the data access for Sector objects.
 *
 * @author Vinicius Moura
 *
 * @version 1.1
 *
 * @since 7 de junho de 2016
 */
public class SetorDAO extends GenericDAO<Setor> implements Serializable {

    private static final long serialVersionUID = 1L;

    private SessionFactory sessionFactory;

    public SetorDAO() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Saves a sector in the database.
     *
     * @param sector the sector to be saved
     */
    public void saveSetor(Setor setor) {
        super.save(setor);
    }

    /**
     * Updates a sector in the database.
     *
     * @param setor the sector to be updated
     */
    public void updateSetor(Setor setor) {
        super.update(setor);
    }

    public Setor searchByNome(String nome) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("nome", nome));
        return (Setor) criteria.uniqueResult();
    }

}
