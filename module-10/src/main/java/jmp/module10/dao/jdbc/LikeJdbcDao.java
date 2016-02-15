package jmp.module10.dao.jdbc;

import jmp.module10.beans.Like;
import jmp.module10.dao.LikeDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO of {@link Like} that implements a {@link LikeDao} to stores a {@link Like} to database
 */
public class LikeJdbcDao extends JdbcHelper implements LikeDao {

    private static final String INSERT_LIKE_QUERY = "INSERT INTO likes (post, user, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Like} in database
     * @param like a {@link Like} that saves in database
     * @return a like
     */
    @Override
    public Like save(final Like like) {
        List parameters = new ArrayList(){{
            add(like.getPost().getId());
            add(like.getUser().getId());
            add(new Timestamp(like.getTimestamp().getTime()));
        }};

        Long id = save(INSERT_LIKE_QUERY, parameters);
        like.setId(id);
        return like;
    }

    /**
     * Save {@link Like} in database
     * @param likes a list of {@link Like}
     * @return a likes
     */
    @Override
    public List<Like> save(List<Like> likes) {
        List<List> batches = new ArrayList<List>();
        for (int index = 0; index < likes.size(); index++) {
            final Like like = likes.get(index);
            List parameters = new ArrayList() {{
                add(like.getPost().getId());
                add(like.getUser().getId());
                add(new Timestamp(like.getTimestamp().getTime()));
            }};
            batches.add(parameters);
        }

        List<Long> idEntities = batcheSave(INSERT_LIKE_QUERY, batches);
        for (int index = 0; index < idEntities.size(); index++) {
            likes.get(index).setId(idEntities.get(index));
        }

        return likes;
    }

}