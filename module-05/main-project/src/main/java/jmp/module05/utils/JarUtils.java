package jmp.module05.utils;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * The Utility methods that helps to works with a jar that contains a compiled java files
 */
public final class JarUtils {

    /**
     * The logger
     */
    private static final Logger logger = Logger.getLogger(JarUtils.class);

    /**
     * The extension of a compiled java file
     */
    private static final String JAVA_CLASS_EXTENSION = ".class";

    /**
     * The package separator
     */
    private static final char PACKAGE_SEPARATOR = '.';

    /**
     * The file separator
     */
    private static final char FILE_SEPARATOR = '/';

    /**
     * The {@link JarUtils} instances should NOT be constructed because it is utility class
     */
    private JarUtils() {
    }

    /**
     * Get array of bytes of a compiled java file by name from jar
     * @param jarName a name of a jar
     * @param className a fully-qualified name of a class
     * @return a bytes of class or {@link null} if a class is not exist in a jar
     */
    public static byte[] getBytes(String jarName, String className) {
        byte[] bytes = null;

        if (jarName != null && ! jarName.isEmpty() && className != null && ! className.isEmpty()) {
            try (JarFile jarFile = new JarFile(jarName);) {
                Enumeration<JarEntry> jarEntries = jarFile.entries();
                while (jarEntries.hasMoreElements()) {
                    JarEntry jarEntry = jarEntries.nextElement();
                    if (equals(jarEntry.getName(), className)) {
                        bytes = convertJarEntryToBytes(jarEntry, jarFile);
                    }
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }

        return bytes;
    }

    /**
     * Compare a name of a jar entry with a fully-qualified name of a class
     * @param jarEntryName a name of a jar entry
     * @param className a fully-qualified name of a class
     * @return true if jarEntryName and className is equals
     */
    private static boolean equals(String jarEntryName, String className) {
        boolean compare = false;

        if (jarEntryName.endsWith(JAVA_CLASS_EXTENSION)) {
            jarEntryName = jarEntryName.replace(FILE_SEPARATOR, PACKAGE_SEPARATOR).substring(0, jarEntryName.length() - JAVA_CLASS_EXTENSION.length());
            compare = className.equals(jarEntryName);
        }

        return compare;
    }

    /**
     * Convert {@link JarEntry} to array of {@link Byte}
     * @param jarEntry a entry of jar
     * @param jarFile a jar
     * @return a bytes of jarEntry
     * @throws IOException If a bytes cannot be read for any reason, or if the input stream has been closed, or if some other I/O error occurs
     */
    private static byte[] convertJarEntryToBytes(JarEntry jarEntry, JarFile jarFile) throws IOException {
        byte[] bytes = new byte[(int)jarEntry.getSize()];
        try (InputStream inputStream = jarFile.getInputStream(jarEntry);) {
            inputStream.read(bytes, 0, bytes.length);
        }
        return bytes;
    }

}