package jmp.module03.utils;

/**
 * The class of constants
 */
public final class Constants {

    /**
     * {@link Constants} instances should NOT be constructed because it is class of constants
     */
    private Constants() {
    }

    public static final String PERSON_FIND_ALL_QUERY = "Person.findAll";
    public static final String PERSON_FIND_BY_NAME_QUERY = "Person.findByName";
    public static final String PERSON_NAME_ATTRIBUTE = "name";

    public static final String SOURCE_MODE = "-source";
    public static final String FILE_MODE = "file";
    public static final String DATABASE_MODE = "db";

    public static final String EMPTY = "";

}