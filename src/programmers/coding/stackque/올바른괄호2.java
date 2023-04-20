package programmers.coding.stackque;

import java.util.Stack;

/**
 * 올바른괄호 - stack
 */
public class 올바른괄호2 {
    public static void main(String[] args) {
        solution("(()(");
    }

    static boolean solution(String s) {

        boolean answer = true;

        int cnt = 0;

        for(char c : s.toCharArray()) {

            if(c == '(') cnt++;
            else if(c == ')') cnt--;

            if(cnt < 0)
                return false;
        }
        return cnt == 0 ? true : false;
    }
}

