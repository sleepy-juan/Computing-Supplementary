/*
    Tree.java
*/
package DS;

import java.util.ArrayList;

public class Tree {
    Tree parent = null;
    String elem; // element of root
    ArrayList<Tree> children = new ArrayList<>(); // subtrees

    // return whether current tree is external node
    public boolean isExternal() {
        return children.size() == 0;
    }

    // return whether current tree is internal node
    public boolean isInternal() {
        return !isExternal();
    }

    // return whether current tree is root
    public boolean isRoot() {
        return parent == null;
    }

    // return whether the tree is empty
    public boolean empty() {
        return size() == 0;
    }

    // depth of current node (subtree)
    public int depth() {
        int count = 0;
        Tree temp = parent;
        while (temp != null) {
            temp = temp.parent;
            count++;
        }
        return count;
    }

    // height of current subtree
    public int height() {
        int h = 0;
        for (Tree child : children) {
            h = Math.max(child.height(), h);
        }
        return h + 1;
    }

    // the number of all the nodes in the subtree
    public int size() {
        int s = 0;
        for (Tree child : children) {
            s += child.size();
        }
        return s + 1;
    }

    // add child
    public void addChild(String newElem) {
        Tree newTree = new Tree();
        newTree.parent = this;
        newTree.elem = elem;

        children.add(newTree);
    }

    // remove child
    public void removeChild(Tree elem) {
        children.remove(elem);
    }

    // run the main to check the code
    public static void main(String[] args) {
        Tree root = new Tree();
        root.elem = "ROOT";

        root.addChild("A");
        root.addChild("B");
        root.addChild("C");

        Tree childB = root.children.get(1);
        childB.addChild("D");
        childB.addChild("E");

        Tree childE = childB.children.get(1);
        System.out.println(childE.depth());
        System.err.println(root.height());
    }
}