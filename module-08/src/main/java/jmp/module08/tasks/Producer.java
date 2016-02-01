package jmp.module08.tasks;

import jmp.module08.resources.Counter;

/**
 * The Producer that increments a resource {@link Counter}
 */
public class Producer implements Runnable {

    /**
     * The counter that limits count of iteration over a resource {@link Counter}
     */
    private static final int MAX_PRODUCE_VALUE = 30;

    /**
     * The resource
     */
    private Counter counter;

    /**
     * Constructor of the class
     * @param counter
     */
	public Producer (Counter counter){
        this.counter = counter;
	}

    /**
     * Core method of the producer
     */
    @Override
    public void run() {
        for (int i = 0; i < MAX_PRODUCE_VALUE; i++){
            counter.increment();
        }

        counter.stopIncrementation();
    }

}