package Revision.MonotonicStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParentheses {
    static class Solution {
    public boolean isValid(String s) {

        // stack for storing 
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(!stack.isEmpty() && ( ch == ')' || ch == ']' || ch == '}' )){
                if(ch == ')' && stack.peek() != '(') return false;
                if(ch == ']' && stack.peek() != '[') return false;
                if(ch == '}' && stack.peek() != '{') return false;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isValid("]"));
    }
}
