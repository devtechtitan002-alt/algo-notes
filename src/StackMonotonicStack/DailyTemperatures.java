import java.util.Arrays;
import java.util.Stack;
public class DailyTemperatures {
    static class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int yesterday = stack.pop();
                result[yesterday] = i - yesterday;
            }  
            stack.push(i);
        }
        return result;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{30,60,90})));
    }

}
