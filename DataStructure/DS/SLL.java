/*
    SLL.java
    - Singly Linked List
*/
package DS;

public class SLL {
    class Node {
        String elem;
        Node next;
    }

    Node head = new Node();
    // head is an empty node (not null) when SLL is empty
    int size = 0;

    // return whether SLL is empty
    public boolean empty() {
        return size == 0;
    }

    // add newElem to the front
    // newElem is now head
    public void addFront(String newElem) {
        Node newNode = new Node();
        newNode.elem = newElem;
        newNode.next = head;

        head = newNode;

        size++;
    }

    // get front WITHOUT removing the element
    public String front() {
        return head.elem;
    }

    // remove front element
    public void removeFront() {
        if (empty())
            return; // do nothing if empty
        head = head.next;
    }
}