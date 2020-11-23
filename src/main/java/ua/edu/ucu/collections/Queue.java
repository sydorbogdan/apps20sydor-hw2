package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList data;

    public Queue() {
        this.data = new ImmutableLinkedList();
    }

    //    Object peek() - Returns the object at the beginning of the Queue without removing it
    public Object peek() {
        return data.getFirst();
    }

    //    Object dequeue() - Removes and returns the object at the beginning of the Queue.
    public Object dequeue() {
        Object peeked = data.getFirst();
        data = data.removeFirst();
        return peeked;
    }

    //    void enqueue(Object e) - Adds an object to the end of the Queue.
    public void enqueue(Object e) {
        data = data.addLast(e);
    }

}
