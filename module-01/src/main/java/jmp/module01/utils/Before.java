package jmp.module01.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation for benchmark methods to be run before an test has been performed
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Before {}