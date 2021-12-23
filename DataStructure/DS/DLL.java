/*
    DLL.java
    - Doubly Linked List
*/
package DS;

public class DLL {
    class Node {
        String elem;
        Node next, prev;
    }

    Node head = new Node();
    Node tail = new Node();
    // head and tail are empty nodes (not null) when DLL is empty
    int size = 0;

    // return whether DLL is empty
    public boolean empty() {
        return size == 0;
    }

    // add newElem to the front
    // newElem is now head
    public void addFront(String newElem) {
        Node newNode = new Node();
        newNode.elem = newElem;
        newNode.next = head;
        newNode.prev = null;

        head.prev = newNode;
        head = newNode; // order matters; setting the prev of head must come first

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
        size--;
    }

    // add newElem to the back
    // newElem is now tail
    public void addBack(String newElem) {
        Node newNode = new Node();
        newNode.elem = newElem;
        newNode.next = null;
        newNode.prev = tail;

        tail.next = newNode;
        tail = newNode; // order matters; setting the next of tail must come first

        size++;
    }

    // get back WITHOUT removing the element
    public String back() {
        return tail.elem;
    }

    // remove back element
    public void removeBack() {
        if (empty())
            return; // do nothing if empty
        tail = tail.prev;
        size--;
    }
}