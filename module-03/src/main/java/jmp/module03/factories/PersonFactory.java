package jmp.module03.factories;

import jmp.module03.beans.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * The Factory that creates {@link Person}
 */
public class PersonFactory {

    /**
     * The pool of users
     */
    private static List<String> usersPool = new ArrayList<String>(){
        {
            add("John");
            add("Patrick");
            add("Vasya");
        }
    };

    /**
     * The id of pool
     */
    private static int id = 0;

    /**
     *  {@link PersonFactory} instances should NOT be constructed
     */
    private PersonFactory (){
    }

    /**
     * Create unique {@link Person}
     * @return a {@link Person} or a {@code null} if source unique names is absent
     */
    public static final Person create() {
        String name = usersPool.get(id++);
        return new Person(name);
    }

}