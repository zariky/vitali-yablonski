package jmp.module10.dao.jdbc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The data source
 */
public class DataSource {

    private static final String DB_CONNECTION = "jdbc:h2:temporary/database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);

    /**
     * Connect to database
     * @return a connection of database
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return connection;
    }

}