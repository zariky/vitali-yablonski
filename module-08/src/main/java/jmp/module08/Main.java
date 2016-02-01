package jmp.module08;

import jmp.module08.resources.Counter;
import jmp.module08.tasks.Consumer;
import jmp.module08.tasks.Producer;

/**
 * The Main class of Concurrency Module
 */
public class Main {

    /**
     * The Main method
     * @param args a array of programm arguments
     */
    public static void main(String[] args) {
        final int INITIAL_COUNTER_VALUE = 10;

        Counter counter = new Counter(INITIAL_COUNTER_VALUE);

        Runnable producer = new Producer(counter);
        Thread threadProducer = new Thread(producer, "Producer");

        Runnable consumer = new Consumer(counter);
        Thread threadConsumer = new Thread(consumer, "Consumer");

        threadProducer.start();
        threadConsumer.start();
    }

}