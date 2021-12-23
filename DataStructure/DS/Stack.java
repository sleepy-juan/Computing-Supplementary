/*
    Stack.java
    - First-In-Last-Out (FILO) Structure
*/
package DS;

public class Stack {
    DLL list = new DLL();

    // return whether stack is empty
    public boolean empty() {
        return list.empty();
    }

    // push to the stack
    public void push(String newElem) {
        list.addBack(newElem);
    }

    // pop from the stack
    // pop REMOVES the element
    public String pop() {
        String temp = list.back();
        list.removeBack();
        return temp;
    }

    // get last element of the stack
    // top DOES NOT remove the element
    public String top() {
        return list.back();
    }
}
