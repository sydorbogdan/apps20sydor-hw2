package ua.edu.ucu.collections;


public class Node implements Cloneable {
    private Object data;
    private Node next;

    public Node(Object inpData, Node inpNext) {
        this.data = inpData;
        this.next = inpNext;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
