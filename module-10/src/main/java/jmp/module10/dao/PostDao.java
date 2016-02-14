package jmp.module10.dao;

import jmp.module10.beans.Post;

/**
 * The DAO of {@link Post}
 */
public interface PostDao {

    /**
     * Save {@link Post} in store
     * @param post a {@link Post} that saves in store
     */
    public Post save(Post post);

}