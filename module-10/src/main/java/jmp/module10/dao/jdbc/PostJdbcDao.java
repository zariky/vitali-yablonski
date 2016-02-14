package jmp.module10.dao.jdbc;

import jmp.module10.beans.Post;
import jmp.module10.dao.PostDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;

import java.sql.Timestamp;

/**
 * The DAO of {@link Post} that implements a {@link PostDao} to stores a {@link Post} to database
 */
public class PostJdbcDao extends JdbcHelper implements PostDao {

    private static final String INSERT_POST_QUERY = "INSERT INTO posts (user, text, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Post} in database
     * @param post a {@link Post} that saves in database
     */
    @Override
    public Post save(Post post) {
        Long id = save(INSERT_POST_QUERY, new Object[]{post.getUser().getId(), post.getText(), new Timestamp(post.getTimestamp().getTime())});
        post.setId(id);
        return post;
    }

}