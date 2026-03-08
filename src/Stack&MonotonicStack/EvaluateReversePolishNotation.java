import java.util.Set;
import java.util.Stack;
public class EvaluateReversePolishNotation {
    static class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = Set.of("+","-","*","/");
        for(String s : tokens){
            if( ops.contains(s) ){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result=0;
                if( s.equals("+") ) { result = num1+num2; }
                else if( s.equals("-") ) { result = num1-num2; }
                else if( s.equals("*") ) { result = num1*num2; }
                else if( s.equals("/") ) { result = num1/num2; }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
        /*
        Stack<Integer> stack = new Stack<>();

for(String s : tokens){

    switch(s){

        case "+":
            stack.push(stack.pop() + stack.pop());
            break;

        case "-":
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a - b);
            break;

        case "*":
            stack.push(stack.pop() * stack.pop());
            break;

        case "/":
            int d = stack.pop();
            int c = stack.pop();
            stack.push(c / d);
            break;

        default:
            stack.push(Integer.parseInt(s));
    }
}

return stack.pop();
 */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(sol.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(sol.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
}
