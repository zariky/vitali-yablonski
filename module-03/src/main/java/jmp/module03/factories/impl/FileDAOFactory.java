package jmp.module03.factories.impl;

import jmp.module03.dao.PersonDAO;
import jmp.module03.dao.impl.FilePersonDAO;
import jmp.module03.factories.DAOFactory;

/**
 * The Factory that creates Dao Components for File source
 */
public class FileDAOFactory implements DAOFactory {

    /**
     * Create {@link FilePersonDAO} component
     * @return a {@FilePersonDAO} dao component
     */
    @Override
    public PersonDAO createPersonDAO() {
        return new FilePersonDAO();
    }

}