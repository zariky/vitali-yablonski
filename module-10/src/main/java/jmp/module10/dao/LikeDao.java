package jmp.module10.dao;

import jmp.module10.beans.Like;

/**
 * The DAO of {@link Like}
 */
public interface LikeDao {

    /**
     * Save {@link Like} in store
     * @param like a {@link Like} that saves in store
     */
    public Like save(Like like);

}