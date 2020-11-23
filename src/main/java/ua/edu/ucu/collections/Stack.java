package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.security.PublicKey;

public class Stack {
    public ImmutableLinkedList data;

    public Stack(){
        this.data = new ImmutableLinkedList();
    }

//    Object peek() - Returns the object from the top of the Stack without removing it
    public Object peek(){
        return data.getFirst();
    }

//    Object pop() - Removes and returns the object from the top of the Stack
    public Object pop(){
        Object peeked = data.getFirst();
        data = data.removeFirst();
        return peeked;
    }

//    void push(Object e) - Adds an object to the the top of the Stack
    public void push(Object e) {
        data = data.addFirst(e);
    }
}
