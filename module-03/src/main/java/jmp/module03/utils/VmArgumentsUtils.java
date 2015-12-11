package jmp.module03.utils;

/**
 * The Utility methods focused on VM arguments
 */
public final class VmArgumentsUtils {

    /**
     * {@link VmArgumentsUtils} instances should NOT be constructed because it is utility class
     */
    private VmArgumentsUtils() {
    }

    /**
     * Gets argument by key
     *
     * @param key a key to search for
     * @param vmArguments a array of vm arguments
     * @return a argument that associated with key (possibly empty)
     */
    public static String findArgumentByKey(String key, String[] vmArguments) {
        String argument = Constants.EMPTY;

        for(int i = 0; i < vmArguments.length; i++) {
            if (vmArguments[i].equals(key) && (i + 1) < vmArguments.length) {
                argument = vmArguments[i + 1];
            }
        }

        return argument;
    }

}