package jmp.module01.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods focused on VM arguments
 */
public final class VmArgumentsUtils {

    /**
     * {@link VmArgumentsUtils} instances should NOT be constructed because it is utility class
     */
    private VmArgumentsUtils() {
    }

    /**
     * Gets all arguments by key
     *
     * @param key a key to search for
     * @param vmArguments a array of vm arguments
     * @return the {@link List} of arguments (possibly empty)
     */
    public static List<String> findArgumentsByKey(String key, String[] vmArguments) {
        List<String> keyedArguments = new ArrayList<String>();

        for(int i = 0; i < vmArguments.length; i++) {
            if (vmArguments[i].equals(key) && (i + 1) < vmArguments.length && ! vmArguments[i + 1].equals(key)) {
                keyedArguments.add(vmArguments[i + 1]);
            }
        }

        return keyedArguments;
    }

}