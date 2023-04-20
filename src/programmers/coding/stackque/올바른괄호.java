package programmers.coding.stackque;

import java.util.*;
import java.util.stream.Stream;

/**
 * 올바른괄호 - stack
 */
public class 올바른괄호 {
    public static void main(String[] args) {

    }

    static boolean solution(String s) {

        boolean answer = true;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();


        if(')' == s.charAt(0)) return false;

        for(char c : arr) {

            if(!stack.isEmpty() && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}

