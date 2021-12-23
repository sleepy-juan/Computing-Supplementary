/*
    Queue.java
    - First-In-First-Out (FIFO) Structure
*/
package DS;

public class Queue {
    DLL list = new DLL();

    // return whether Q is empty
    public boolean empty() {
        return list.empty();
    }

    // enqueue to the Q
    public void enqueue(String newElem) {
        list.addBack(newElem);
    }

    // dequeue from the Q
    // dequeue REMOVES the element
    public String dequeue() {
        String temp = list.front();
        list.removeFront();
        return temp;
    }

    // get last element of the Q
    // top DOES NOT remove the element
    public String top() {
        return list.front();
    }
}
