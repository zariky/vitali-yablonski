package jmp.module01.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jmp.module01.services.ClassControlService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that manages a {@link Class} in class path
 */
public class ClassPathClassControlService implements ClassControlService {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathClassControlService.class);

    /**
     * Finds {@link Class} by class names
     *
     * @param classNames a {@link List} of class name
     * @return a {@link List} of {@link Class} (possibly empty)
     * @throws {@link NullPointerException} if the classNames is {@code null}
     */
    public List<Class> findByClassNames(List<String> classNames) {
        List<Class> classes = new ArrayList<Class>();

        for(String className : classNames){
            try {
                Class cls = Class.forName(className);
                classes.add(cls);
            } catch (ClassNotFoundException e) {
                logger.error("Class {} was not found.", className);
            }
        }

        return classes;
    }

}