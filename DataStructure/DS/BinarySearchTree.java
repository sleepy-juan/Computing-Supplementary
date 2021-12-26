package DS;

public class BinarySearchTree {
    BinaryTree tree = null;

    public BinaryTree search(String k) {
        BinaryTree current = tree;
        while (current != null) {
            if (current.elem.equals(k))
                return current;
            else if (current.elem.compareTo(k) < 0)
                current = current.right;
            else
                current = current.left;
        }
        return null;
    }

    public void insert(String k) {
        if (search(k) != null)
            return;

        if (tree == null) {
            tree = new BinaryTree();
            tree.elem = k;
            return;
        }

        BinaryTree parent = null;
        BinaryTree current = tree;
        while (current != null) {
            parent = current;
            if (current.elem.compareTo(k) < 0)
                current = current.right;
            else
                current = current.left;
        }

        if (parent.elem.compareTo(k) < 0)
            parent.setRight(k);
        else
            parent.setLeft(k);
    }

    public void delete(String k) {
        BinaryTree found = search(k);
        if (found == null)
            return;

        if (found.left == null && found.right == null) {
            if (found.parent.left == found)
                found.parent.left = null;
            else
                found.parent.right = null;
        } else if (found.left == null) {
            if (found.parent.left == found)
                found.parent.left = found.right;
            else
                found.parent.right = found.right;
        } else if (found.right == null) {
            if (found.parent.left == found)
                found.parent.left = found.left;
            else
                found.parent.right = found.left;
        } else {
            BinaryTree temp = found.left;
            while (temp.right != null) {
                temp = temp.right;
            }

            String stemp = found.elem;
            found.elem = temp.elem;
            temp.elem = stemp;

            if (temp.left == null) {
                if (temp.parent.left == temp)
                    temp.parent.left = null;
                else
                    temp.parent.right = null;
            } else {
                if (temp.parent.left == temp)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right = temp.left;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("INSERT TEST");

        tree.insert("E");
        tree.insert("A");
        tree.insert("G");
        tree.insert("C");
        tree.insert("D");
        tree.insert("F");
        tree.insert("B");

        tree.tree.preorder(); // E, A, C, B, D, G, F
        System.out.println();
        tree.tree.inorder(); // A, B, C, D, E, F, G
        System.out.println();
        tree.tree.postorder(); // B, D, C, A, F, G, E
        System.out.println();

        System.out.println("DELETE TEST");

        tree.delete("E");
        tree.delete("A");

        tree.tree.preorder(); // D, C, B, G, F
        System.out.println();
        tree.tree.inorder(); // B, C, D, F, G
        System.out.println();
        tree.tree.postorder(); // B, C, F, G, D
        System.out.println();

        System.out.println("SEARCH TEST");

        System.out.println(tree.search("E")); // null
        System.out.println(tree.search("F").parent.elem); // G
    }
}
