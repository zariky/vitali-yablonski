package jmp.module08.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Resource
 */
public class Counter {

    /**
     * The logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    /**
     * The min size
     */
    private static final int MIN_SIZE = 5;

    /**
     * The max size
     */
    private static final int MAX_SIZE = 10;

    /**
     * The size
     */
    private int size;

    /**
     * The lock to control the access to the size
     */
    private ReentrantLock lock;

    /**
     * The condition of increment operation
     */
    private Condition increment;

    /**
     * The condition of decrement operation
     */
    private Condition decrement;

    /**
     * The attribute to control where are pending incrementation in the counter
     */
    private boolean hasIncrementation;

    /**
     * Constructor of the class
     * @param size a initial size of counter
     */
    public Counter(int size) {
        logger.info("Initial size = {}", size);

        this.size = size;
        lock = new ReentrantLock();
        increment = lock.newCondition();
        decrement = lock.newCondition();
        hasIncrementation = true;
    }

    /**
     * Increase of counter
     */
    public void increment() {
        try {
            lock.lock();
            while (size >= MAX_SIZE) {
                decrement.await();
            }
            size++;
            increment.signalAll();

            logger.info("{} increments size = {}", Thread.currentThread().getName(), size);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    /**
     * Decrease of  counter
     */
    public void decrement() {
        try {
            lock.lock();
            while (size <= MIN_SIZE && hasDecrementation()) {
                increment.await();
            }

            if (hasDecrementation()) {
                size--;
                decrement.signalAll();
                logger.info("{} decrements size = {}", Thread.currentThread().getName(), size);
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    /**
     * Check if counter can be decreased
     * @return true if counter can be decreased
     */
    public boolean hasDecrementation() {
        return MIN_SIZE < size || hasIncrementation;
    }

    /**
     * Inform of counter that operation of incrementation was stopped
     */
    public void stopIncrementation() {
        try {
            lock.lock();
            hasIncrementation = false;
            increment.signalAll();
        } finally {
            lock.unlock();
        }
    }

}