package Revision.MonotonicStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class RemoveKDigits {
    static class Solution {
    public String removeKdigits(String num, int k) {

        // stack initialisation
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<num.length();i++){
            
            int currNum = num.charAt(i) - '0';
            while(!stack.isEmpty() && k>0 && currNum < stack.peek()){
                k--;
                stack.pop();
            }
            stack.push(currNum);
        }

        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        if(sb.toString().equals("")) return "0";

        while(sb.length() > 0 && sb.charAt(0) == '0' ){
            sb = sb.deleteCharAt(0);
        }

        return sb.toString().equals("") ? "0" : sb.toString();

    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.removeKdigits("33526221184202197273",19));
    }
    
}
