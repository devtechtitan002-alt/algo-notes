import java.util.Stack;

public class ValidParentheses {
    static class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
                if( ch=='(' || ch=='{' || ch=='[' ){
                    stack.push(ch);
                }else{
                    if(stack.isEmpty()) return false;
                    char openBracket = stack.pop();
                    if( ch == ')' && openBracket!='(' ) return false;
                    if( ch == ']' && openBracket!='[') return false;
                    if( ch == '}' && openBracket!='{' ) return false;
                }
        }
        return stack.isEmpty();
        /*
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
        s = s.replace("()", "");
        s = s.replace("[]", "");
        s = s.replace("{}", "");
        }
  
        // If everything was valid, string becomes empty
        return s.isEmpty();
        */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isValid("()[]{}"));
        System.out.println(sol.isValid("([])"));
        System.out.println(sol.isValid("([)]"));
    }
} 
}
