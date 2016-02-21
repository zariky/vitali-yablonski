package jmp.module11.services;

import jmp.module11.bean.User;
import java.util.List;

/**
 * The Service of {@link User}
 */
public interface UserService {

    /**
     * Find users
     * @return a users
     */
    public List<User> findAll();

}