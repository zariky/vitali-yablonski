package jmp.module10.dao.jdbc.mappers;

import jmp.module10.beans.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The mapper of user
 */
public class UserMapper implements Mapper<User> {

    private static final String USER_ID = "USER_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_SURNAME = "USER_SURNAME";
    private static final String USER_BIRTHDATE = "USER_BIRTHDATE";

    /**
     * Convert {@link ResultSet} to {@link User}
     * @param rs a {@link ResultSet}
     * @return a {@link User}
     * @throws SQLException
     */
    @Override
    public User create(ResultSet rs) throws SQLException {
        Long id = rs.getLong(USER_ID);
        String name = rs.getString(USER_NAME);
        String surname = rs.getString(USER_SURNAME);
        Timestamp birthdate = rs.getTimestamp(USER_BIRTHDATE);
        return new User(id, name, surname, new Date(birthdate.getTime()));
    }

}
