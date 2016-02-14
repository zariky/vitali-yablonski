package jmp.module10.dao.jdbc;

import jmp.module10.beans.Friendship;
import jmp.module10.dao.FriendshipDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;

import java.sql.Timestamp;

/**
 * The DAO of {@link Friendship} that implements a {@link FriendshipDao} to stores a {@link Friendship} to database
 */
public class FriendshipJdbcDao extends JdbcHelper implements FriendshipDao {

    private static final String INSERT_FRIENDSHIP_QUERY = "INSERT INTO friendships (user1, user2, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Friendship} in database
     * @param friendship a {@link Friendship} that saves in database
     */
    @Override
    public Friendship save(Friendship friendship) {
        Long id = save(INSERT_FRIENDSHIP_QUERY, new Object[]{friendship.getUser1().getId(), friendship.getUser2().getId(), new Timestamp(friendship.getTimestamp().getTime())});
        friendship.setId(id);
        return friendship;
    }

}