package jmp.module03.factories;

import jmp.module03.dao.PersonDAO;

/**
 * The Factory that creates Dao Components for specific source
 */
public interface DAOFactory {

    /**
     * Create {@link PersonDAO} component
     * @return a {@PersonDAO} dao component
     */
    public PersonDAO createPersonDAO();

}