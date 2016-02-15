package jmp.module10.dao;

import jmp.module10.beans.User;
import java.util.List;

/**
 * The DAO of {@link User}
 */
public interface UserDao {

    /**
     * Find {@ User} in store
     * @return a users
     */
    public List<User> findAll();

    /**
     * Save {@link User} in store
     * @param user a {@link User} that saves in store
     * @return a user
     */
    public User save(User user);

    /**
     * Save {@link User} in store
     * @param users a list of {@link User}
     * @return a users
     */
    public List<User> save(List<User> users);

}