package jmp.module10.dao.jdbc;

import jmp.module10.beans.Post;
import jmp.module10.dao.PostDao;
import jmp.module10.dao.jdbc.utils.JdbcHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The DAO of {@link Post} that implements a {@link PostDao} to stores a {@link Post} to database
 */
public class PostJdbcDao extends JdbcHelper implements PostDao {

    private static final String INSERT_POST_QUERY = "INSERT INTO posts (user, text, timestamp) VALUES (?,?,?);";

    /**
     * Save {@link Post} in database
     * @param post a {@link Post} that saves in database
     * @return a post
     */
    @Override
    public Post save(final Post post) {
        List parameters = new ArrayList(){{
            add(post.getUser().getId());
            add(post.getText());
            add(new Timestamp(post.getTimestamp().getTime()));
        }};

        Long id = save(INSERT_POST_QUERY, parameters);
        post.setId(id);
        return post;
    }

    /**
     * Save {@link Post} in database
     * @param posts a list of {@link Post}
     * @return a posts
     */
    @Override
    public List<Post> save(List<Post> posts) {
        List<List> batches = new ArrayList<List>();
        for (int index = 0; index < posts.size(); index++) {
            final Post post = posts.get(index);
            List parameters = new ArrayList() {{
                add(post.getUser().getId());
                add(post.getText());
                add(new Timestamp(post.getTimestamp().getTime()));
            }};
            batches.add(parameters);
        }

        List<Long> idEntities = batcheSave(INSERT_POST_QUERY, batches);
        for (int index = 0; index < idEntities.size(); index++) {
            posts.get(index).setId(idEntities.get(index));
        }

        return posts;
    }

}