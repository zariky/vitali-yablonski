package jmp.module10.dao;

import jmp.module10.beans.Friendship;

import java.util.List;

/**
 * The DAO of {@link Friendship}
 */
public interface FriendshipDao {

    /**
     * Save {@link Friendship} in store
     * @param friendship a {@link Friendship} that saves in store
     * @return a friendship
     */
    public Friendship save(Friendship friendship);

    /**
     * Save {@link Friendship} in store
     * @param friendships  a list of {@link Friendship}
     * @return a friendships
     */
    public List<Friendship> save(List<Friendship> friendships);

}