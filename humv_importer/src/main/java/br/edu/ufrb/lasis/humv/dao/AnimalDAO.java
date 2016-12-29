package br.edu.ufrb.lasis.humv.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.utils.HibernateUtils;

/**
 * The Class representing the data access for animal objects.
 *
 * @author Luiz Antônio Pereira
 *
 * @version 1.1
 *
 * @since 16 de maio de 2016
 */
public class AnimalDAO extends GenericDAO<Animal> implements Serializable {

    private static final long serialVersionUID = 1L;

    private SessionFactory sessionFactory;
    
    public AnimalDAO(){
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Saves a animal in the database.
     *
     * @param animal animal to be saved
     */
    public void saveAnimal(Animal animal) {
        super.save(animal);
    }

    /**
     * Updates a animal in the database.
     *
     * @param animal animal to be updated
     */
    public void updateAnimal(Animal animal) {
        super.update(animal);
    }
    
}
