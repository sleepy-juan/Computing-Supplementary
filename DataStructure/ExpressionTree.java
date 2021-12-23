/*
    ExpressionTree.java
*/

import DS.BinaryTree;

public class ExpressionTree {
    // get closing bracket's index
    // given an expression and index of opening bracket
    public static int closingIndex(String exp, int openIndex) {
        int count = 1; // bracket counter; open: +1, close: -1
        int index = openIndex + 1;
        for (; index < exp.length(); index++) {
            char ch = exp.charAt(index);
            if (ch == '(')
                count++;
            else if (ch == ')')
                count--;

            // if count is 0, it is closing index
            if (count == 0)
                break;
        }
        return index;
    }

    // construct a tree with String expression
    // only with + - * / ( ) and a number
    // assumption:
    // 1. only two operand if no bracket. e.g. 1+2+3 will be given as (1+2)+3
    // 2. number is one-digit positive integer
    public static BinaryTree construct(String exp) {
        BinaryTree root = new BinaryTree();

        /* left operand */
        int opIndex = 1; // index of operator
        if (Character.isDigit(/*** (1) ***/)) {
            root.setLeft(Character.toString(/*** (1) ***/));
        } else {
            int index = closingIndex(exp, /*** (2) ***/);
            BinaryTree left = construct(exp.substring(1, index - 1));
            left.parent = root;
            root.left = left;

            opIndex = /*** (3) ***/; // update operator index
        }

        /* operator */
        root.elem = Character.toString(exp.charAt(opIndex));

        /* right operand */
        if (Character.isDigit(/*** (4) ***/)) {
            root.setRight(Character.toString(/*** (4) ***/));
        } else {
            BinaryTree right = construct(exp.substring(opIndex + 1, /*** (5) ***/));
            right.parent = root;
            right.right = right;
        }

        return root;
    }
}
