package jmp.module01.beans;

import java.lang.reflect.Method;

/**
 * Bean that contains all information about a test
 */
public class Evaluation {

    /**
     * The name of test
     */
    private String name;

    /**
     * The time that will be spent on one iteration
     */
    private Long time;

    /**
     * The {@link Method} that contains test
     */
    private Method test;

    public Evaluation() {
    }

    public Evaluation(String name, Long time, Method test) {
        this.name = name;
        this.time = time;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Method getTest() {
        return test;
    }

    public void setTest(Method test) {
        this.test = test;
    }

}