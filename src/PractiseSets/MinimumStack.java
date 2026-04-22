package PractiseSets;
import java.util.Stack;

public class MinimumStack {
    static class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if(!minStack.isEmpty()){
            minStack.push(Math.min(val,minStack.peek()));
        }else{
            minStack.push(val);
        }
    }

    public void pop() {

        if(!stack.isEmpty()){
             stack.pop();
             minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();  // empty check is just defensive as constraints said no valid operations on empty stack
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();   // empty check is just defensive as constraints said no valid operations on empty stack
    }

    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }


}
