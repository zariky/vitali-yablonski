package jmp.module03.dao.impl;

import static jmp.module03.utils.Constants.*;
import jmp.module03.beans.Person;
import jmp.module03.dao.PersonDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * The DAO of {@link Person} that implements a {@link PersonDAO} to stores a {@link Person} to database
 */
public class DatabasePersonDAO implements PersonDAO {

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DatabasePersonDAO.class);

    /**
     * The name of factory {@link EntityManagerFactory}
     */
    private static final String NAME_ENTITY_MANAGER_FACTORY = "module03";

    /**
     * The factory {@link EntityManagerFactory}
     */
    private EntityManagerFactory emFactory;

    /**
     * The entity manager {@link EntityManager} that associated with factory {@link EntityManagerFactory}
     */
    private EntityManager em;

    /**
     * Constructor of the {@link DatabasePersonDAO} that initializes {@link EntityManagerFactory} and {@link EntityManager}
     */
    public DatabasePersonDAO() {
        emFactory = Persistence.createEntityManagerFactory(NAME_ENTITY_MANAGER_FACTORY);
        em = emFactory.createEntityManager();
    }

    /**
     * Save {@link Person} to database
     * @param person a {@link Person} that saves to database
     */
    @Override
    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    /**
     * Find {@link Person} by name
     * @param name a attribute of {@link Person}
     * @return a {@link Person} from database by name or a {@code null} if {@link Person} is not exist
     */
    @Override
    public Person findByName(String name) {
        List<Person> persons = em.createNamedQuery(PERSON_FIND_BY_NAME_QUERY, Person.class).setParameter(PERSON_NAME_ATTRIBUTE, name).getResultList();
        return (persons.isEmpty()) ? null : persons.get(0);
    }

    /**
     * Find all {@link Person} form database
     * @return a {@link List} of {@link Person} (possibly empty)
     */
    @Override
    public List<Person> findAll() {
        return em.createNamedQuery(PERSON_FIND_ALL_QUERY, Person.class).getResultList();
    }

    /**
     * Free resources of {@link DatabasePersonDAO}
     */
    @Override
    public void close() {
        em.close();
        emFactory.close();
    }

}