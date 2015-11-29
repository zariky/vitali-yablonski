package jmp.module01.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility reflection methods focused on {@link Method}
 */
public final class MethodUtils {

    private static final Logger logger = LoggerFactory.getLogger(MethodUtils.class);

    /**
     * {@link MethodUtils} instances should NOT be constructed because it is utility class
     */
    private MethodUtils() {
    }

    /**
     * Gets all methods of the given class that are annotated with the given annotation
     *
     * @param cls a {@link Class} to query
     * @param annotationCls an {@link Annotation} that should be present on a method to be matched
     * @return a {@link List} of {@link Method} (possibly empty)
     * @throws {@link NullPointerException} if the cls or annotationCls are {@code null}
     */
    public static List<Method> getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
        Method[] methods = cls.getMethods();
        List<Method> annotatedMethods = new ArrayList<Method>();

        for (Method method : methods) {
            if (method.getAnnotation(annotationCls) != null) {
                annotatedMethods.add(method);
            }
        }

        return annotatedMethods;
    }

    /**
     * Execute a method with parameters
     *
     * @param instance invoke method on this object
     * @param method a {@link Method} that should be executed on instance with parameters
     * @param parameters an array of {@link Object} that will be passed into method
     * @return a {@link Object} returned by the execute method
     * @throws {@link NullPointerException} if the instance, method or parameters are {@code null}
     */
    public static Object executeMethod(Object instance, Method method, Object[] parameters) {
        Object result = null;
        Class<?>[] parameterTypes = ClassUtils.convertObjectsToClasses(parameters);

        if (isExistMethod(instance, method.getName(), parameterTypes)) {
            method.setAccessible(true);
            try {
                result = method.invoke(instance, parameters);
            } catch (IllegalAccessException e) {
                logger.error("Access to method {} of {} was not acquired.", method.getName(), instance.getClass());
            } catch (InvocationTargetException e) {
                logger.error("Method {} of {} was not executed.",  method.getName(), instance.getClass());
            }
        }

        return result;
    }

    /**
     * Check if name of method exist in instance
     *
     * @param instance search of method in this object
     * @param methodName a name of method that should be found
     * @param parameterTypes match these types of parameters on {@link Method}
     * @return a {@link Boolean} like true if method exist
     * @throws {@link NullPointerException} if the instance, methodName or parameterTypes are {@code null}
     */
    private static boolean isExistMethod(Object instance, String methodName, Class<?>[] parameterTypes) {
        Method method = null;

        try {
            method = instance.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            logger.error("Method {} was not found in {}.", methodName, instance.getClass());
        }

        return method != null;
    }

}