package jmp.module03.services.impl;

import jmp.module03.beans.Person;
import jmp.module03.dao.PersonDAO;
import jmp.module03.services.PersonService;

import java.util.List;

/**
 * The Service that implements {@link PersonService} and manages {@link Person}
 */
public class PersonServiceImpl implements PersonService {

    /**
     * The specific dao
     */
    private PersonDAO personDAO;

    /**
     * The constructor
     * @param personDAO a specific dao
     */
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    /**
     * Save {@link Person} to store
     * @param person a {@link Person} that saves to store
     */
    public void save(Person person) {
        personDAO.save(person);
    }

    /**
     * Find {@link Person} by name in store
     * @param name a attribute of {@link Person}
     * @return a {@link Person} from store by name or a {@code null} if {@link Person} is not exist
     */
    public Person findByName(String name) {
        return personDAO.findByName(name);
    }

    /**
     * Find all {@link Person} form store
     * @return a {@link java.util.List} of {@link Person} (possibly empty)
     */
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    /**
     * Free resources
     */
    public void close() {
        personDAO.close();
    }

}