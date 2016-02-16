package jmp.module10.dao;

import jmp.module10.beans.Like;
import java.util.List;

/**
 * The DAO of {@link Like}
 */
public interface LikeDao {

    /**
     * Save {@link Like} in store
     * @param like a {@link Like} that saves in store
     * @return a like
     */
    public Like save(Like like);

    /**
     * Save {@link Like} in store
     * @param likes a list of {@link Like}
     * @return a likes
     */
    public List<Like> save(List<Like> likes);

}