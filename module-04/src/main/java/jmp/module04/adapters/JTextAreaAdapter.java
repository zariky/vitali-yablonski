package jmp.module04.adapters;

import org.apache.commons.lang3.StringUtils;

import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * The Adapter, a target class is {@link List} and an adaptee class is {@link JTextArea}
 */
public class JTextAreaAdapter implements List<String> {

    /**
     * The message that operation is not supported
     */
    private static final String UNSUPPORTED_OPERATION_ERROR_MESSAGE = "Adapter is not supported this method.";

    /**
     * The delimiter records of {@link JTextArea}
     */
    private static final String DELIMITER = "\n";

    /**
     * The adaptee
     */
    private JTextArea textArea;

    /**
     * The Constructor of adapter {@link JTextAreaAdapter}
     * @param textArea a adaptee
     */
    public JTextAreaAdapter(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public int size() {
        return textArea.getText().split(DELIMITER).length;
    }

    @Override
    public boolean isEmpty() {
        return textArea.getText().isEmpty();
    }

    @Override
    public boolean add(String s) {
        if (isEmpty()) {
            textArea.append(s);
        } else {
            textArea.append(DELIMITER + s);
        }
        return true;
    }

    @Override
    public String get(int index) {
        return textArea.getText().split(DELIMITER)[index];
    }

    @Override
    public String remove(int index) {
        List<String> list = new ArrayList<String>(Arrays.asList(textArea.getText().split(DELIMITER)));
        String value = list.remove(index);
        textArea.setText(StringUtils.join(list, DELIMITER));
        return value;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_ERROR_MESSAGE);
    }

}