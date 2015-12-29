package jmp.module05.factories;

import jmp.module05.classloaders.JarClassLoader;
import jmp.module05.services.UserService;
import jmp.module05.utils.ConsoleUtils;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * The Factory that creates a instance of implementation {@link UserService} from specific jar
 */
public class UserServiceJarFactory {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(UserServiceJarFactory.class);

    /**
     * The fully-qualified name of implementation {@link UserService}
     */
    private static final String USER_SERVICE_IMPLEMENTATION = "jmp.module05.services.impl.UserServiceImpl";

    /**
     * The ClassLoader that loads from specific jar
     */
    private ClassLoader jarClassLoader;

    /**
      * The Constructor of {@link UserServiceJarFactory} that is PRIVATE because an instance should be created from {@link Builder}
      */
    private UserServiceJarFactory() {
    }

    /**
     * Create a instance of implementation {@link UserService}
     * @return a implementation {@link UserService} or {@link null} if {@link JarClassLoader} cannot load a {@link Class}
     */
    public UserService create(){
        Class newClass = null;
        UserService instance = null;

        try {
            newClass = Class.forName(USER_SERVICE_IMPLEMENTATION, true, jarClassLoader);
            instance = (UserService)newClass.newInstance();
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        }

        return instance;
    }

    /**
     * Create new builder {@link Builder} for {@link UserServiceJarFactory}
     * @return a {@link Builder}
     */
    public static Builder newBuilder() {
        return new UserServiceJarFactory().new Builder();
    }

    /**
     * The Builder of {@link UserServiceJarFactory}
     */
    public class Builder {

        /**
         * The list of jar
         */
        private List<String> jars;

        /**
         * The Constructor of {@link Builder} that is PRIVATE because an instance should be created from {@link UserServiceJarFactory}
         */
        private Builder() {
            jars = new ArrayList<String>();
        }

        /**
         * Append jar to list
         * @param jarName a name of jar
         * @return the {@link Builder}
         */
        public Builder appendJar(String jarName){
            if (jarName != null && ! jarName.isEmpty()) {
                jars.add(jarName);
            }
            return this;
        }

        /**
         * Build a {@link UserServiceJarFactory}
         * @return a instance {@link UserServiceJarFactory}
         */
        public UserServiceJarFactory build() {
            String jar = ConsoleUtils.chooseOption(jars);
            jarClassLoader = new JarClassLoader(jar);
            return UserServiceJarFactory.this;
        }

    }

}