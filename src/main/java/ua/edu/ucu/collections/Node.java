package ua.edu.ucu.collections;

import lombok.Getter;
import lombok.Setter;

public class Node {
    @Getter @Setter private Object data;
    @Getter @Setter private Node next;

    public Node(Object inpData, Node inpNext){
        this.data = inpData;
        this.next = inpNext;
    }
}
