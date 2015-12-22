package jmp.module05.services.impl;

import jmp.module05.beans.User;
import jmp.module05.services.UserService;
import org.apache.log4j.Logger;

/**
 * The service that manages a {@link User}
 */
public class UserServiceImpl implements UserService {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    /**
     * Find {@link User} by name
     * @param name a name of {@link User}
     * @return a {@link User} that associates with name
     */
    @Override
    public User find(String name) {
        logger.info("The implementation of UserService from subproject-02");
        return new User("The user('" + name + "') came from the implementation of UserService that locates in subproject-02");
    }

}