package jmp.module05.services;

import jmp.module05.beans.User;

/**
 * The service that manages a {@link User}
 */
public interface UserService {

    /**
     * Find {@link User} by name
     * @param name a name of {@link User}
     * @return a {@link User} that associates with name
     */
    public User find(String name);

}