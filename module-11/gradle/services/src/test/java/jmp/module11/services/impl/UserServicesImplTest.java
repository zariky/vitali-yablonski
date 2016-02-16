package jmp.module11.services.impl;

import jmp.module11.bean.User;
import jmp.module11.dao.UserDao;
import jmp.module11.services.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * The Test of {@link UserServiceImpl}
 */
public class UserServicesImplTest {

    private static final List<User> USERS = new ArrayList<User>(){{
        add(new User("John"));
        add(new User("Patrick"));
        add(new User("Vasya"));
    }};

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        assertArrayEquals(USERS.toArray(), users.toArray());
    }

}