package Revision.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    static class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
  
        for(String s : tokens){

            switch(s){
                
                case "+" : 
                    stack.push(String.valueOf(Integer.valueOf(stack.pop())+Integer.valueOf(stack.pop())));
                    break;

                case "-" :
                    int b = Integer.valueOf(stack.pop());
                    int a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a-b));
                    break;

                case "*" : 
                    stack.push(String.valueOf(Integer.valueOf(stack.pop())*Integer.valueOf(stack.pop())));
                    break;

                case "/" :
                    int d = Integer.valueOf(stack.pop());
                    int c = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(c/d));
                    break;

                default :
                    stack.push(s);

            }
        }

        return Integer.valueOf(stack.pop());
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
     }
}
