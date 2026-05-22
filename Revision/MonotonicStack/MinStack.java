package Revision.MonotonicStack;
import java.util.Deque;
import java.util.ArrayDeque;

public class MinStack {
    static class MinStacks {

    long minNum = Integer.MAX_VALUE;
    Deque<Long> stack = null;

    public MinStacks() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {

        long num = val;

        if(stack.isEmpty()){

            stack.push(num);
            minNum = num;

        } else {

            if(num < minNum){

                stack.push(2L * num - minNum);
                minNum = num;

            } else {

                stack.push(num);
            }
        }
    }
    
    public void pop() {
        long top = stack.pop();

        if(top < minNum){
            minNum = 2L * minNum - top;
        }
    }
    
    public int top() {
        long top = stack.peek();

        if(top < minNum){
            return (int)minNum;
        }

        return (int)top;
    }
    
    public int getMin() {
        return (int)minNum;
    }
}


    public static void main(String[] args){

        MinStacks mins = new MinStacks();
        mins.push(-2);
        mins.push(0);
        mins.push(-3);
        System.out.println(mins.getMin());
        mins.pop();
        System.out.println(mins.top());
        System.out.println(mins.getMin());
    }

}
