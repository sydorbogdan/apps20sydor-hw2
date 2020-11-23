package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testQueue() {
        Queue testQueue = new Queue();
        for (int i=1; i<5; i++){
            testQueue.enqueue(i);
        }
        for (int i=1; i<5; i++){
            assertEquals(i, testQueue.peek());
            assertEquals(i, testQueue.dequeue());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() {
        Queue testQueue = new Queue();
        testQueue.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueException() {
        Queue testQueue = new Queue();
        testQueue.dequeue();
    }

}
