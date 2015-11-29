package jmp.module01.services;

import java.util.List;

/**
 * Interface of service that manages a {@link Class}
 */
public interface ClassControlService {

    /**
     * Finds {@link Class} by class names
     *
     * @param classNames a {@link List} of class name
     * @return a {@link List} of {@link Class}
     */
    public List<Class> findByClassNames(List<String> classNames);

}