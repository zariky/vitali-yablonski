package jmp.module03.factories;

import jmp.module03.beans.Person;
import jmp.module03.dao.PersonDAO;
import jmp.module03.services.PersonService;
import jmp.module03.services.impl.PersonServiceImpl;

/**
 * The Factory that creates {@link PersonService} for specific source
 */
public abstract class PersonServiceFactory {

    /**
     * Create {@link PersonService} with specific dao
     * @return a service that works with {@link Person}
     */
    public final PersonService create() {
        DAOFactory daoFactory = createDAOFactory();
        PersonDAO personDAO = daoFactory.createPersonDAO();
        PersonService personService = new PersonServiceImpl(personDAO);
        return personService;
    }

    /**
     * Create {@link DAOFactory} with specific source
     * @return a dao that works with {@link Person}
     */
    protected abstract DAOFactory createDAOFactory();

}