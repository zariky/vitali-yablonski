package jmp.module01.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility methods focused on {@link Class}
 */
public final class ClassUtils {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    /**
     * {@link ClassUtils} instances should NOT be constructed because it is utility class
     */
    private ClassUtils() {
    }

    /**
     * Converts an array of {@code Object} in to an array of {@code Class} objects
     *
     * @param array an {@code Object} array
     * @return a {@code Class} array (possibly empty)
     * @throws {@link NullPointerException} if the array is {@code null}
     */
    public static Class<?>[] convertObjectsToClasses(Object[] array) {
        Class<?>[] classes = new Class[array.length];

        for (int i = 0; i < array.length; i++) {
            classes[i] = array[i] == null ? null : array[i].getClass();
        }

        return classes;
    }

    /**
     * Creates a new instance of the class
     *
     * @param cls a {@link Class}
     * @return a new instance of the {@link Class}
     * @throws {@link NullPointerException} if the cls is {@code null}
     */
    public static Object createInstance(Class<?> cls) {
        Object instance = null;

        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            logger.error("Instance of {} was not created.", cls.getName());
        } catch (IllegalAccessException e) {
            logger.error("Access of {} was not acquired.", cls.getName());
        }

        return instance;
    }

}