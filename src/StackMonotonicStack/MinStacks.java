import java.util.Stack;
public class MinStacks {
    static class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> minNumStack;

    public MinStack() {
        minStack = new Stack();
        minNumStack = new Stack();
    }
    
    public void push(int val) {
        if( minStack.isEmpty() && minNumStack.isEmpty()){
            minStack.push(val);
            minNumStack.push(val);
        }else{
            if(minStack.size() >= 1){
                minNumStack.push(Math.min(val,minNumStack.peek()));
            }
            minStack.push(val);
        }  
    }
    
    public void pop() {
        minStack.pop();
        minNumStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minNumStack.peek();
    }
    /*
    class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
        }else{
            long diff = val - min;
            stack.push(diff);

            if(diff < 0){
                min = val;
            }
        }
    }

    public void pop() {

        long diff = stack.pop();

        if(diff < 0){
            min = min - diff;
        }
    }

    public int top() {

        long diff = stack.peek();

        if(diff >= 0){
            return (int)(min + diff);
        }else{
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
     */
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
