package jmp.module01.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation for benchmark methods
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Benchmark {

    public String testName() default "";

}