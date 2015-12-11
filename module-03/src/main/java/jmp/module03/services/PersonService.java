package jmp.module03.services;

import jmp.module03.beans.Person;

import java.util.List;

/**
 * The Interface of service that manages {@link Person}
 */
public interface PersonService {

    /**
     * Save {@link Person} to store
     * @param person a {@link Person} that saves to store
     */
    public void save(Person person);

    /**
     * Find {@link Person} by name in store
     * @param name a attribute of {@link Person}
     * @return a {@link Person} from store by name or a {@code null} if {@link Person} is not exist
     */
    public Person findByName(String name);

    /**
     * Find all {@link Person} form store
     * @return a {@link java.util.List} of {@link Person} (possibly empty)
     */
    public List<Person> findAll();

    /**
     * Free resources
     */
    public void close();

}