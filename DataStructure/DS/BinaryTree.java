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
        newTree.elem = newElem;
        newTree.parent = this;
        left = newTree;
    }

    // set right child
    public void setRight(String newElem) {
        BinaryTree newTree = new BinaryTree();
        newTree.elem = newElem;
        newTree.parent = this;
        right = newTree;
    }

    // traversal
    public void preorder() {
        System.out.println(elem);
        if (left != null)
            left.preorder();
        if (right != null)
            right.preorder();
    }

    public void postorder() {
        if (left != null)
            left.postorder();
        if (right != null)
            right.postorder();
        System.out.println(elem);
    }

    public void inorder() {
        if (left != null)
            left.inorder();
        System.out.println(elem);
        if (right != null)
            right.inorder();
    }

    // run the main to check the code
    public static void main(String[] args) {
        //
        // --------A
        // ----B-------C
        // --D---E---F---G
        //

        BinaryTree root = new BinaryTree();
        root.elem = "A";

        root.setLeft("B");
        root.setRight("C");

        root.left.setLeft("D");
        root.left.setRight("E");
        root.right.setLeft("F");
        root.right.setRight("G");

        root.preorder(); // A, B, D, E, C, F, G,
        System.out.println();

        root.postorder(); // D, E, B, F, G, C, A,
        System.out.println();

        root.inorder(); // D, B, E, A, F, C, G,
        System.out.println();
    }
}