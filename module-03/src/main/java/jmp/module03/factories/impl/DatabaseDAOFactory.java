package jmp.module03.factories.impl;

import jmp.module03.dao.PersonDAO;
import jmp.module03.dao.impl.DatabasePersonDAO;
import jmp.module03.factories.DAOFactory;

/**
 * The Factory that creates Dao Components for Database source
 */
public class DatabaseDAOFactory implements DAOFactory {

    /**
     * Create {@link DatabasePersonDAO} component
     * @return a {@link DatabasePersonDAO} dao component
     */
    @Override
    public PersonDAO createPersonDAO() {
        return new DatabasePersonDAO();
    }

}