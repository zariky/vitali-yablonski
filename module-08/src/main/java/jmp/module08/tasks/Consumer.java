package jmp.module08.tasks;

import jmp.module08.resources.Counter;

/**
 * The Consumer that decrements a resource {@link Counter}
 */
public class Consumer implements Runnable {

    /**
     * The resource
     */
    private Counter counter;

    /**
     * Constructor of the class
     * @param counter
     */
    public Consumer(Counter counter) {
        this.counter = counter;
    }

    /**
     * Core method of the consumer
     */
    @Override
    public void run() {
        while (counter.hasDecrementation()) {
            counter.decrement();
        }
    }

}