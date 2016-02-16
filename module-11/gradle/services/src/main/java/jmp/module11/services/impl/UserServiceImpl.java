package jmp.module11.services.impl;

import jmp.module11.bean.User;
import jmp.module11.dao.UserDao;
import jmp.module11.dao.impl.UserDaoImpl;
import jmp.module11.services.UserService;
import java.util.List;

/**
 * The DAO of {@link User}
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    /**
     * Find users
     * @return a users
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}