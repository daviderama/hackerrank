// Stacks: Balanced Brackets
// https://www.hackerrank.com/challenges/ctci-balanced-brackets

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char c, top;
        for (int s = 0; s < expression.length(); s++ ){
            c = expression.charAt(s);
            if( stack.isEmpty() ){
                stack.push(c);
            } else {
                top = stack.peek();
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{'){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( isBalanced(expression) ? "YES" : "NO" );
        }
    }
}
