package jmp.module10.dao.jdbc;

import jmp.module10.beans.Like;
import jmp.module10.dao.LikeDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;

import java.sql.Timestamp;

/**
 * The DAO of {@link Like} that implements a {@link LikeDao} to stores a {@link Like} to database
 */
public class LikeJdbcDao extends JdbcHelper implements LikeDao {

    private static final String INSERT_LIKE_QUERY = "INSERT INTO likes (post, user, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Like} in database
     * @param like a {@link Like} that saves in database
     */
    @Override
    public Like save(Like like) {
        Long id = save(INSERT_LIKE_QUERY, new Object[]{like.getPost().getId(), like.getUser().getId(), new Timestamp(like.getTimestamp().getTime())});
        like.setId(id);
        return like;
    }

}