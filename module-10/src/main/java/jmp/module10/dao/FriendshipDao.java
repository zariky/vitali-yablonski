package jmp.module10.dao;

import jmp.module10.beans.Friendship;

/**
 * The DAO of {@link Friendship}
 */
public interface FriendshipDao {

    /**
     * Save {@link Friendship} in store
     * @param friendship a {@link Friendship} that saves in store
     */
    public Friendship save(Friendship friendship);

}