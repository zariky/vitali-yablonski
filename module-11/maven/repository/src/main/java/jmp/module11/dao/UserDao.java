package jmp.module11.dao;

import jmp.module11.bean.User;
import java.util.List;

/**
 * The DAO of {@link User}
 */
public interface UserDao {

    /**
     * Find users
     * @return a users
     */
    public List<User> findAll();

}