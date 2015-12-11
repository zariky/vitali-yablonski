package jmp.module03.dao;

import jmp.module03.beans.Person;

import java.util.List;

/**
 * The DAO of {@link Person}
 */
public interface PersonDAO {

    /**
     * Save {@link Person} to store
     * @param person a {@link Person} that saves to store
     */
    public void save(Person person);

    /**
     * Find {@link Person} by name
     * @param name a attribute of {@link Person}
     * @return a {@link Person} from store by name or a {@code null} if {@link Person} is not exist
     */
    public Person findByName(String name);

    /**
     * Find all {@link Person} form store
     * @return a {@link List} of {@link Person} (possibly empty)
     */
    public List<Person> findAll();

    /**
     * Free resources
     */
    public void close();

}