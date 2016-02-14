package jmp.module10.dao.jdbc;

import jmp.module10.beans.User;
import jmp.module10.dao.UserDao;
import jmp.module10.dao.jdbc.mappers.Mapper;
import jmp.module10.dao.jdbc.mappers.UserMapper;
import jmp.module10.dao.jdbc.utils.JdbcHelper;

import java.sql.Timestamp;
import java.util.List;

/**
 * The DAO of {@link User} that implements a {@link UserDao} to stores a {@link User} to database
 */
public class UserJdbcDao extends JdbcHelper implements UserDao {

    private static final String SELECT_USER_QUERY = "SELECT u.id AS USER_ID, u.name AS USER_NAME, u.surname AS USER_SURNAME, u.birthdate AS USER_BIRTHDATE FROM users u;";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (name, surname, birthdate) VALUES (?,?,?);";

    /**
     * The mapper of {@link User}
     */
    private Mapper userMapper = new UserMapper();

    /**
     * Find {@ User} in database
     * @return a users
     */
    @Override
    public List<User> findAll() {
        return find(SELECT_USER_QUERY, userMapper);
    }

    /**
     * Save {@link User} in database
     * @param user a {@link User} that saves in database
     */
    @Override
    public User save(User user) {
        Long id = save(INSERT_USER_QUERY, new Object[]{user.getName(), user.getSurname(), new Timestamp(user.getBirthdate().getTime())});
        user.setId(id);
        return user;
    }

}