package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testStack() {
        Stack testStack = new Stack();
        for (int i = 1; i < 5; i++) {
            testStack.push(i);
        }
        for (int i = 4; i > 0; i--) {
            assertEquals(i, testStack.peek());
            assertEquals(i, testStack.pop());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() {
        Stack testStack = new Stack();
        testStack.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopException() {
        Stack testStack = new Stack();
        testStack.pop();
    }


}
