package jmp.module10;

import jmp.module10.beans.Friendship;
import jmp.module10.beans.Like;
import jmp.module10.beans.Post;
import jmp.module10.beans.User;
import jmp.module10.dao.*;
import jmp.module10.dao.Store;
import jmp.module10.dao.jdbc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * The main class
 */
public class Main {

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        Store store = new Database();
        store.create();

        UserDao userDao = new UserJdbcDao();
        PostDao postDao = new PostJdbcDao();
        LikeDao likeDao = new LikeJdbcDao();
        FriendshipDao friendshipDao = new FriendshipJdbcDao();

        User u1 = userDao.save(new User("1", "2", new Date()));
        Post p = postDao.save(new Post(u1, "2", new Date()));
        Like l = likeDao.save(new Like(p, u1 , new Date()));
        User u2 = userDao.save(new User("3", "4", new Date()));
        Friendship f = friendshipDao.save(new Friendship(u1, u2, new Date()));

        logger.info(u1.toString());
        logger.info(p.toString());
        logger.info(l.toString());
        logger.info(u2.toString());
        logger.info(f.toString());
        logger.info(userDao.findAll().toString());
    }

}