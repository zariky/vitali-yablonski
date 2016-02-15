package jmp.module10;

import jmp.module10.beans.Friendship;
import jmp.module10.beans.Like;
import jmp.module10.beans.Post;
import jmp.module10.beans.User;
import jmp.module10.dao.FriendshipDao;
import jmp.module10.dao.LikeDao;
import jmp.module10.dao.PostDao;
import jmp.module10.dao.Store;
import jmp.module10.dao.UserDao;
import jmp.module10.dao.jdbc.Database;
import jmp.module10.dao.jdbc.FriendshipJdbcDao;
import jmp.module10.dao.jdbc.LikeJdbcDao;
import jmp.module10.dao.jdbc.PostJdbcDao;
import jmp.module10.dao.jdbc.UserJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The main class
 */
public class Main {

    private static final int USERS = 1500;

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        logger.info("Creating database...");
        Store store = new Database();
        store.create();

        UserDao userDao = new UserJdbcDao();
        FriendshipDao friendshipDao = new FriendshipJdbcDao();
        PostDao postDao = new PostJdbcDao();
        LikeDao likeDao = new LikeJdbcDao();

        logger.info("Creating users...");
        List<User> users = generateUsers();
        users = userDao.save(users);

        logger.info("Creating friendships...");
        List<Friendship> friendships = generateFriendships(users);
        friendships = friendshipDao.save(friendships);

        logger.info("Creating posts...");
        List<Post> posts = generatePosts(users);
        posts = postDao.save(posts);

        logger.info("Creating likes...");
        List<Like> likes = generateLikes(posts, users);
        likes = likeDao.save(likes);

        for (User user : userDao.findAll()) {
            System.out.println(user);
        }
    }

    private static List<User> generateUsers() {
        List<User> users = new ArrayList<User>();

        for (int index = 0; index < USERS; index++) {
            users.add(new User("name" + index, "surname" + index, new Date()));
        }

        return users;
    }

    private static List<Post> generatePosts(List<User> users) {
        List<Post> posts = new ArrayList<Post>();

        for (int index = 0; index < users.size(); index++) {
            if ((index % 2) == 0) {
                posts.add(new Post(users.get(index), "post" + index, new Date()));
            }
        }

        return posts;
    }

    private static List<Like> generateLikes(List<Post> posts, List<User> users) {
        List<Like> likes = new ArrayList<Like>();
        Date february2015 = new GregorianCalendar(2015, 2, 7).getTime();
        Date march2015 = new GregorianCalendar(2015, 2, 7).getTime();

        for (int index = 0; index < users.size(); index++) {
            User user = users.get(index);
            if ((index % 2) == 0) {
                for (Post post : posts) {
                    likes.add(new Like(post, user, march2015));
                }
            } else {
                for (Post post : posts) {
                    likes.add(new Like(post, user, february2015));
                }
            }
        }

        return likes;
    }

    private static List<Friendship> generateFriendships(List<User> users) {
        List<Friendship> friendships = new ArrayList<Friendship>();

        for (int firstHalf = 0; firstHalf < USERS / 2; firstHalf++) {
            if ((firstHalf % 2) == 0) {
                for (int secondHalf = USERS / 2 + 1; secondHalf < USERS; secondHalf++) {
                    friendships.add(new Friendship(users.get(firstHalf), users.get(secondHalf), new Date()));
                }
            }
        }

        return friendships;
    }

}