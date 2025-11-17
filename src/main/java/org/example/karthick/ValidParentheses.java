package org.example.karthick;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String str){

        char[] chars = str.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for(char c : chars){
            if('(' == c) stack.push(')');
            else if('[' == c) stack.push(']');
            else if('{' == c) stack.push('}');
            else if( stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();

    }
}
