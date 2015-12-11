package jmp.module03.factories;

import jmp.module03.beans.Person;
import jmp.module03.dao.PersonDAO;
import jmp.module03.factories.impl.DatabasePersonServiceFactory;
import jmp.module03.factories.impl.FilePersonServiceFactory;
import jmp.module03.services.PersonService;
import jmp.module03.services.impl.PersonServiceImpl;

import static jmp.module03.utils.Constants.DATABASE_MODE;
import static jmp.module03.utils.Constants.FILE_MODE;

/**
 * The Factory that creates {@link PersonService} for specific source
 */
public abstract class PersonServiceFactory {

    /**
     * Create {@link PersonService} with specific dao
     * @param source a mode of factory
     * @return a service or a {@code null} if source is not supported that works with {@link Person}
     */
    public static final PersonService create(String source) {
        PersonServiceFactory personServiceFactory = null;
        PersonService personService = null;

        if (FILE_MODE.equals(source)) {
            personServiceFactory = new FilePersonServiceFactory();
        } else if (DATABASE_MODE.equals(source)) {
            personServiceFactory = new DatabasePersonServiceFactory();
        }

        if (personServiceFactory != null) {
            DAOFactory daoFactory = personServiceFactory.createDAOFactory();
            PersonDAO personDAO = daoFactory.createPersonDAO();
            personService = new PersonServiceImpl(personDAO);
        }

        return personService;
    }

    /**
     * Create {@link DAOFactory} with specific source
     * @return a dao that works with {@link Person}
     */
    protected abstract DAOFactory createDAOFactory();

}