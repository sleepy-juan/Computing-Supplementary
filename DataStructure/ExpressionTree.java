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
        System.out.println(exp);
        BinaryTree root = new BinaryTree();

        /* left operand */
        int opIndex = 1; // index of operator
        if (Character.isDigit(/*** (1) ***/)) {
            root.setLeft(/*** (2) ***/);
        } else {
            int index = closingIndex(exp, /*** (3) ***/);
            BinaryTree left = construct(/*** (4) ***/);
            left.parent = root;
            root.left = left;

            opIndex = index + 1;
        }

        /* operator */
        root.elem = Character.toString(exp.charAt(opIndex));

        /* right operand */
        if (Character.isDigit(/*** (5) ***/)) {
            root.setRight(exp.substring(opIndex + 1, opIndex + 2));
        } else {
            BinaryTree right = construct(exp.substring(/*** (6) ***/, exp.length() - 1));
            right.parent = root;
            root.right = right;
        }

        return root;
    }
}