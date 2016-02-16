package jmp.module10.dao.jdbc;

import jmp.module10.beans.Friendship;
import jmp.module10.dao.FriendshipDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO of {@link Friendship} that implements a {@link FriendshipDao} to stores a {@link Friendship} to database
 */
public class FriendshipJdbcDao extends JdbcHelper implements FriendshipDao {

    private static final String INSERT_FRIENDSHIP_QUERY = "INSERT INTO friendships (user1, user2, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Friendship} in database
     * @param friendship a {@link Friendship} that saves in database
     * @return a friendship
     */
    @Override
    public Friendship save(final Friendship friendship) {
        List parameters = new ArrayList(){{
            add(friendship.getUser1().getId());
            add(friendship.getUser2().getId());
            add(new Timestamp(friendship.getTimestamp().getTime()));
        }};

        Long id = save(INSERT_FRIENDSHIP_QUERY, parameters);
        friendship.setId(id);
        return friendship;
    }

    /**
     * Save {@link Friendship} in database
     * @param friendships  a list of {@link Friendship}
     * @return a friendships
     */
    @Override
    public List<Friendship> save(List<Friendship> friendships) {
        List<List> batches = new ArrayList<List>();
        for (int index = 0; index < friendships.size(); index++) {
            final Friendship friendship = friendships.get(index);
            List parameters = new ArrayList() {{
                add(friendship.getUser1().getId());
                add(friendship.getUser2().getId());
                add(new Timestamp(friendship.getTimestamp().getTime()));
            }};
            batches.add(parameters);
        }

        List<Long> idEntities = batcheSave(INSERT_FRIENDSHIP_QUERY, batches);
        for (int index = 0; index < idEntities.size(); index++) {
            friendships.get(index).setId(idEntities.get(index));
        }

        return friendships;
    }

}