package jmp.module10.dao;

import jmp.module10.beans.Post;
import java.util.List;

/**
 * The DAO of {@link Post}
 */
public interface PostDao {

    /**
     * Save {@link Post} in store
     * @param post a {@link Post} that saves in store
     * @return a post
     */
    public Post save(Post post);

    /**
     * Save {@link Post} in store
     * @param posts a list of {@link Post}
     * @return a posts
     */
    public List<Post> save(List<Post> posts);

}