package jmp.module03.factories.impl;

import jmp.module03.beans.Person;
import jmp.module03.services.PersonService;
import jmp.module03.factories.DAOFactory;
import jmp.module03.factories.PersonServiceFactory;

/**
 * The Factory that creates {@link PersonService} that works with Database source
 */
public class DatabasePersonServiceFactory extends PersonServiceFactory {

    /**
     * Create {@link DatabaseDAOFactory}
     * @return a dao that works with {@link Person}
     */
    @Override
    protected DAOFactory createDAOFactory() {
        return new DatabaseDAOFactory();
    }

}