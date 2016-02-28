package jmp.module12.utils;

public final class Utils {

    private static final String EMPTY = "";
    private static final String SEPARATOR = ",";

    private Utils() {}

    /**
     * Joins a elements of array into a single string
     * @param array the elements that joins together
     * @return a string
     */
    public static String join(Object[] array) {
        StringBuilder sequence = new StringBuilder();

        if (array != null) {
            for (int index = 0; index < array.length; index++) {
                if (index > 0) {
                    sequence.append(SEPARATOR);
                }
                if (array[index] != null) {
                    sequence.append(array[index]);
                }
            }
        }

        return sequence.toString();
    }

    /**
     * Computes factorial of number
     * @param number
     * @return a factorial of number
     */
    public static long factorial(long number) {
        long factorial = 0;

        if (number < 0) {
            throw new IllegalArgumentException("Number should be non-negative.");
        } else if (number <= 1) {
            factorial = 1;
        } else {
            factorial = number * factorial(number - 1);
        }

        return factorial;
    }

    /**
     * Normalizes word
     * @param word
     * @return a string
     */
    public static String normalize(String word) {
        String normalize = EMPTY;

        if (word != null && word.trim().length() > 0) {
            word = word.trim();
            normalize = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        }

        return normalize;
    }

}