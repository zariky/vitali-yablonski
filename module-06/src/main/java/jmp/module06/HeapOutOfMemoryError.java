package jmp.module06;

/**
 * The Main class that simulates java.lang.OutOfMemoryError: Java heap space (Сreate big objects continuously
 * and make them stay in memory. Do not use arrays or collections).
 */
public class HeapOutOfMemoryError {

    /*
     * The bean that contains information about a folder
     */
    private static class Folder {

        private String name;
        private int size;
        private Folder parent;

        public Folder(String name, int size, Folder parent) {
            this.name = name;
            this.size = size;
            this.parent = parent;
        }

    }

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        final String FOLDER = "Folder";
        Folder root = new Folder(FOLDER, Integer.MAX_VALUE, null);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            root = new Folder(FOLDER + i, i, root);
        }
    }

}