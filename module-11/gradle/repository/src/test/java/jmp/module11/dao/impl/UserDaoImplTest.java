package jmp.module11.dao.impl;

import jmp.module11.bean.User;
import jmp.module11.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * The Test of {@link UserDaoImpl}
 */
public class UserDaoImplTest {

    private static final int USERS = 3;

    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        assertEquals(USERS, users.size());
    }

}