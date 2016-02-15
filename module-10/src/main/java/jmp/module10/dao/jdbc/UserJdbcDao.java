package jmp.module10.dao.jdbc;

import jmp.module10.beans.User;
import jmp.module10.dao.UserDao;
import jmp.module10.dao.jdbc.mappers.Mapper;
import jmp.module10.dao.jdbc.mappers.UserMapper;
import jmp.module10.dao.jdbc.utils.JdbcHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO of {@link User} that implements a {@link UserDao} to stores a {@link User} to database
 */
public class UserJdbcDao extends JdbcHelper implements UserDao {

    private static final String SELECT_USER_BY_FRIENDSHIPS_AND_LIKES_QUERY =
            "SELECT u.id AS USER_ID, u.name AS USER_NAME, u.surname AS USER_SURNAME, u.birthdate AS USER_BIRTHDATE " +
            "FROM users u " +
            "INNER JOIN friendships f ON u.id = f.user1 " +
            "INNER JOIN likes l ON u.id = l.user " +
            "WHERE MONTH(l.timestamp) = 3 AND YEAR(l.timestamp) = 2015" +
            "GROUP BY u.id " +
            "HAVING SUM(u.id) > 100 AND SUM(l.id) > 100 " +
            "ORDER BY u.id ASC";
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
    public List<User> find() {
        return find(SELECT_USER_BY_FRIENDSHIPS_AND_LIKES_QUERY, userMapper);
    }

    /**
     * Save {@link User} in database
     * @param user a {@link User} that saves in database
     * @return a user
     */
    @Override
    public User save(final User user) {
        List parameters = new ArrayList(){{
            add(user.getName());
            add(user.getSurname());
            add(new Timestamp(user.getBirthdate().getTime()));
        }};

        Long id = save(INSERT_USER_QUERY, parameters);
        user.setId(id);
        return user;
    }

    /**
     * Save {@link User} in database
     * @param users a list of {@link User}
     * @return a users
     */
    @Override
    public List<User> save(List<User> users) {
        List<List> batches = new ArrayList<List>();
        for (int index = 0; index < users.size(); index++) {
            final User user = users.get(index);
            List parameters = new ArrayList() {{
                add(user.getName());
                add(user.getSurname());
                add(new Timestamp(user.getBirthdate().getTime()));
            }};
            batches.add(parameters);
        }

        List<Long> idEntities = batcheSave(INSERT_USER_QUERY, batches);
        for (int index = 0; index < idEntities.size(); index++) {
            users.get(index).setId(idEntities.get(index));
        }

        return users;
    }

}