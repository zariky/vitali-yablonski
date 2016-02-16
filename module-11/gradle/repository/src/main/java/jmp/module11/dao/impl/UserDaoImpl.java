package jmp.module11.dao.impl;

import jmp.module11.bean.User;
import jmp.module11.dao.UserDao;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO of {@link User}
 */
public class UserDaoImpl implements UserDao {

    /**
     * The users
     */
    private static final List<User> users = new ArrayList<User>(){{
        add(new User("John"));
        add(new User("Patrick"));
        add(new User("Vasya"));
    }};

    /**
     * Find users
     * @return a users
     */
    @Override
    public List<User> findAll() {
        return users;
    }

}