package jmp.module06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * The Main class that simulates java.lang.OutOfMemoryError: Metaspace (Load classes continuously
 * and make them stay in memory).
 */
public class PermOutOfMemoryError extends ClassLoader {

    private static final String CLASS_EXTENSION = ".class";

    private static final String CLASS_CHARSET_NAME  = "latin1";

    /**
     * The mock bytes
     */
    private byte[] classData;

    /**
     * The constructor
     */
    public PermOutOfMemoryError() {
        super(PermOutOfMemoryError.class.getClassLoader());
        this.classData = convertClassToBytes(PermOutOfMemoryError.class);
    }

    /**
     * Convert {@link Class} to array of {@link Byte}
     * @param clazz
     * @return a bytes of {@link Class}
    */
    private byte[] convertClassToBytes(Class clazz) {
        String className = clazz.getName();
        String classPath = className.replace('.', '/') + CLASS_EXTENSION;
        byte[] buffer = new byte[1024];
        byte[] result = null;

        try (InputStream inputStream = PermOutOfMemoryError.class.getClassLoader().getResourceAsStream(classPath);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();){
            int read;
            while ((read = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, read);
            }
            result =  outputStream.toByteArray();
        } catch (IOException e) {
            System.err.println(e);
        }

        return result;
    }

    /**
     * Find a class
     * @param className a fully-qualified name of a class
     * @return a {@link Class} that associates with a fully-qualified name
     * @throws ClassNotFoundException if a {@link Class} is not exist in specific jar
     */
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String[] classParts = className.split("\\.");
        String newClassName = classParts[classParts.length - 1];
        byte[] newClassData = null;

        try {
            newClassData = new String(classData, CLASS_CHARSET_NAME).replaceAll(PermOutOfMemoryError.class.getSimpleName(), newClassName).getBytes(CLASS_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
        }

        return defineClass(className, newClassData, 0, newClassData.length);
    }

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader permOutOfMemoryErrorClassLoader = new PermOutOfMemoryError();
        final String PACKAGE_NAME = PermOutOfMemoryError.class.getPackage().getName();
        final String SIMPLE_CLASS_NAME = PermOutOfMemoryError.class.getSimpleName();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String className = (PACKAGE_NAME + "._" + String.format("%0" + (SIMPLE_CLASS_NAME.length() - 1) + "d", i));
            Class.forName(className, true , permOutOfMemoryErrorClassLoader);
        }
    }

}