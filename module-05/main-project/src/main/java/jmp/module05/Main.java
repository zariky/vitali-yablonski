package jmp.module05;

import jmp.module05.factories.UserServiceFactory;
import jmp.module05.services.UserService;
import org.apache.log4j.Logger;

/**
 * The Main class
 */
public class Main {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(Main.class);

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        final String SUBPROJECT_01_JAR = "subproject-01-1.0.0-SNAPSHOT.jar";
        final String SUBPROJECT_02_JAR = "subproject-02-1.0.0-SNAPSHOT.jar";

        UserServiceFactory factory = UserServiceFactory.newBuilder()
                                                       .appendJar(SUBPROJECT_01_JAR)
                                                       .appendJar(SUBPROJECT_02_JAR)
                                                       .build();

        UserService userService = factory.create();

        logger.info(userService.find("John"));
        logger.info(userService.find("Patrick"));
    }

}