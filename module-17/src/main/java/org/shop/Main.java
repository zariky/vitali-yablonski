package org.shop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Object o = context.getBean("UserService");
        Object o1 = context.getBean("UserServiceAlias");
        System.out.println(o);
        System.out.println(o1);
    }

}