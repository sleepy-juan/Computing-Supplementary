/*
    BinaryTree.java
*/
package DS;

public class BinaryTree {
    public BinaryTree parent = null;
    public String elem; // element of root
    public BinaryTree left = null;
    public BinaryTree right = null;

    // return whether current tree is external node
    public boolean isExternal() {
        return left == null && right == null;
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
        BinaryTree temp = parent;
        while (temp != null) {
            temp = temp.parent;
            count++;
        }
        return count;
    }

    // height of current subtree
    public int height() {
        int leftH = left == null ? 0 : left.height();
        int rightH = right == null ? 0 : right.height();
        return Math.max(leftH, rightH) + 1;
    }

    // the number of all the nodes in the subtree
    public int size() {
        int leftS = left == null ? 0 : left.size();
        int rightS = right == null ? 0 : right.size();
        return leftS + rightS + 1;
    }

    // set left child
    public void setLeft(String newElem) {
        BinaryTree newTree = new BinaryTree();
        newTree.parent = this;
        left = newTree;
    }

    // set right child
    public void setRight(String newElem) {
        BinaryTree newTree = new BinaryTree();
        newTree.parent = this;
        right = newTree;
    }

    // run the main to check the code
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        root.elem = "ROOT";

        root.setLeft("LEFT");
        root.setRight("RIGHT");

        root.left.setLeft("LEFT-LEFT");
        root.left.setRight("LEFT-RIGHT");
        root.right.setLeft("RIGHT-LEFT");
        root.right.setRight("RIGHT-RIGHT");

        root.right.right.setRight("RIGHT-RIGHT-RIGHT");

        System.out.println(root.right.right.depth());
        System.out.println(root.height());
    }
}