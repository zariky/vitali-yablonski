package jmp.module05.classloaders;

import jmp.module05.utils.JarUtils;
import org.apache.log4j.Logger;

/**
 * The ClassLoader that loads classes from specific jar that is not located in classpath
 */
public class JarClassLoader extends ClassLoader {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(JarClassLoader.class);

    /**
     * The name of jar where classes will be searched
     */
    private String jarName;

    /**
     * The constructor
     * @param jarName a name of jar
     */
    public JarClassLoader(String jarName) {
        this(jarName, JarClassLoader.class.getClassLoader());
    }

    /**
     * The constructor
     * @param jarName a name of jar
     * @param parent a {@link ClassLoader} that works in delegation case
     */
    public JarClassLoader(String jarName, ClassLoader parent) {
        super(parent);
        this.jarName = jarName;
    }

    /**
     * Find a class in specific jar by a fully-qualified name of a class
     * @param className a fully-qualified name of a class
     * @return a {@link Class} that associates with a fully-qualified name
     * @throws ClassNotFoundException if a {@link Class} is not exist in specific jar
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        logger.info("Loading class " + className + " from jar " + jarName);

        Class<?> newClass = null;
        byte[] bytes = JarUtils.getBytes(jarName, className);

        if (bytes != null) {
            newClass = defineClass(className, bytes, 0, bytes.length);
            logger.info("Class " + className + " from jar " + jarName + " was loaded");
        } else {
            throw new ClassNotFoundException(className);
        }

        return newClass;
    }

}