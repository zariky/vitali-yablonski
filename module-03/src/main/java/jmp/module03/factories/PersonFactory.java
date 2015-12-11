package jmp.module03.factories;

import jmp.module03.beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The Factory that creates unique {@link Person}
 */
public class PersonFactory {

    /**
     * The pool of unique names
     */
    private static List<String> namesPool = new ArrayList<String>(){
        {
            add("John");
            add("Patrick");
            add("Vasya");
        }
    };

    /**
     * The counter
     */
    private static int counter = 0;

    /**
     *  {@link PersonFactory} instances should NOT be constructed
     */
    private PersonFactory (){
    }

    /**
     * Create unique {@link Person}
     * @return a unique {@link Person}
     */
    public static final Person create() {
        int id = ++counter;
        int randomNamesPool = ThreadLocalRandom.current().nextInt(0, namesPool.size() - 1);
        String name = namesPool.get(randomNamesPool);
        return new Person(name + " " + id);
    }

}