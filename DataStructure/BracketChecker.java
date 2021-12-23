/*
    BracketChecker.java
*/

import DS.Stack;

public class BracketChecker {
    public static char counterpart(char bracket) {
        if (bracket == ')')
            return '(';
        if (bracket == '}')
            return '{';
        if (bracket == ']')
            return '[';
        return 0;
    }

    // validate: String -> boolean
    // Validate code only with brackets (), {}, and []
    public static boolean validate(String code) {
        Stack stack = new Stack();
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(Character.toString(ch));
                continue;
            }

            if (stack.empty())
                return false;
            if (counterpart(ch) != stack.top().charAt(0))
                return false;
            stack.pop();
        }

        if (!stack.empty())
            return false;
        return true;
    }
}