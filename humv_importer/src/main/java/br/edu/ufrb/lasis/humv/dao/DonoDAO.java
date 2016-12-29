package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.utils.HibernateUtils;
import br.edu.ufrb.lasis.humv.utils.NumberUtils;
import java.math.BigInteger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * The Class representing the data access for Animal owner objects.
 *
 * @author Luiz Antônio Pereira
 *
 * @version 2
 *
 * @since 26 de junho de 2016
 */
public class DonoDAO extends GenericDAO<Dono> implements Serializable {

    private static final long serialVersionUID = 1L;

    private SessionFactory sessionFactory;

    public DonoDAO() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Saves an user in the database.
     *
     * @param owner the Animal owner to be saved
     */
    public void saveOwner(Dono proprietario) {
        super.save(proprietario);
    }

    /**
     * Updates an Animal owner in the database.
     *
     * @param owner the Animal owner to be updated
     */
    public void updateOwner(Dono proprietario) {
        super.update(proprietario);
    }

    @SuppressWarnings("unchecked")
    public Dono searchCpfCnpj(String cpfCnpj) {
        Criteria criteria = getCriteria();
        BigInteger conversionResult = NumberUtils.convertStringToBigInteger(cpfCnpj);
        if (conversionResult != null) {
            criteria.add(Restrictions.ilike("cpfCnpj", conversionResult.toString()));
            return (Dono) criteria.uniqueResult();
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public Dono searchNome(String nome) {
        if (!nome.equalsIgnoreCase("Não informado")) {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.ilike("nome", nome));
            return (Dono) criteria.uniqueResult();
        } else {
            return null;
        }
    }

}
