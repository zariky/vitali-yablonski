package jmp.module12;

import jmp.module12.utils.Utils;

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        Object[] array1 = {"1", 2, "3"};
        Object[] array2 = {"1", 2, null, true};

        println(Utils.join(null));
        println(Utils.join(array1));
        println(Utils.join(array2));

        println(Utils.factorial(0));
        println(Utils.factorial(1));
        println(Utils.factorial(5));

        println(Utils.normalize(null));
        println(Utils.normalize(""));
        println(Utils.normalize(" "));
        println(Utils.normalize(" t "));
        println(Utils.normalize(" test "));
    }

    private static void println(Object value) {
        System.out.println("|" + value + "|");
    }

}