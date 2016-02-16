package jmp.module10.dao.jdbc;

import jmp.module10.dao.Store;
import jmp.module10.dao.jdbc.utils.JdbcHelper;

/**
 * The Database
 */
public class Database extends JdbcHelper implements Store {

    private static final String CREATE_DATABASE_QUERY =
        "DROP TABLE IF EXISTS users;" +
        "CREATE TABLE users (" +
        "             id INT AUTO_INCREMENT, " +
        "             name VARCHAR(255) NOT NULL, " +
        "             surname VARCHAR(255) NOT NULL, " +
        "             birthdate TIMESTAMP NOT NULL);" +
        "DROP TABLE IF EXISTS posts;" +
        "CREATE TABLE posts (" +
        "             id INT AUTO_INCREMENT, " +
        "             user INT NOT NULL, " +
        "             text VARCHAR(255) NOT NULL, " +
        "             timestamp TIMESTAMP NOT NULL, " +
        "             FOREIGN KEY (user) REFERENCES users(id));" +
        "DROP TABLE IF EXISTS likes;" +
        "CREATE TABLE likes (" +
        "             id INT AUTO_INCREMENT, " +
        "             post INT NOT NULL, " +
        "             user INT NOT NULL, " +
        "             timestamp TIMESTAMP NOT NULL, " +
        "             FOREIGN KEY (user) REFERENCES users(id), " +
        "             FOREIGN KEY (post) REFERENCES posts(id));" +
        "DROP TABLE IF EXISTS friendships;" +
        "CREATE TABLE friendships (" +
        "             id INT AUTO_INCREMENT, " +
        "             user1 INT NOT NULL, " +
        "             user2 INT NOT NULL, " +
        "             timestamp TIMESTAMP NOT NULL, " +
        "             FOREIGN KEY (user1) REFERENCES users(id), " +
        "             FOREIGN KEY (user2) REFERENCES users(id));";

    /**
     * Create database
     */
    @Override
    public void create() {
        execute(CREATE_DATABASE_QUERY);
    }

}