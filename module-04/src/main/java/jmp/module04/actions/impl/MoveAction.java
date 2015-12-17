package jmp.module04.actions.impl;

import jmp.module04.actions.Action;

import java.util.List;

/**
 * The Action that performs copying of a first element from {@link List} 'listFrom' to {@link List} 'listTo'
 */
public class MoveAction implements Action {

    /**
     * The index of a first element
     */
    private static final int FIRST_ELEMENT = 0;

    /**
     * The {@link List} that acquires a first element from {@link List} 'listFrom' by action
     */
    private List listTo;

    /**
     * The {@link List} that transmits a first element to {@link List} 'listTo' by action
     */
    private List listFrom;

    /**
     * The Constructor of {@link MoveAction}
     * @param listTo a {@link List} that acquires a first element
     * @param listFrom  a {@link List} that transmits a first element
     */
    public MoveAction(List listTo, List listFrom) {
        this.listTo = listTo;
        this.listFrom = listFrom;
    }

    /**
     * Perform copying of a first element from {@link List} 'listFrom' to {@link List} 'listTo'
     */
    @Override
    public void perform() {
        if ( ! listFrom.isEmpty()) {
            listTo.add(listFrom.get(FIRST_ELEMENT));
            listFrom.remove(FIRST_ELEMENT);
        }
    }

}