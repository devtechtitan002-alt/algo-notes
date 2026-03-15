import java.util.Stack;
public class RemoveKDigits {
    static class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> numsStack = new Stack<>();
        int times = k;
        for(char ch : num.toCharArray()){
            int digit = ch-'0';
            while( !numsStack.isEmpty() && digit < numsStack.peek() && times>0 ){
                numsStack.pop();
                times--;
            }
            numsStack.push(digit);
        }
        // After main loop + removing remaining k:
        while(times-- > 0 && !numsStack.isEmpty()) numsStack.pop();

        // Build from stack → comes out reversed
        StringBuilder sb = new StringBuilder();
        while(!numsStack.isEmpty()){
          sb.append(numsStack.pop());
        }
        sb.reverse(); // ✅ now correct order

        // Strip leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0'){
           sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
     
        /*
        int n = num.length();
    
    if (k >= n) return "0";

    char[] stack = new char[n];
    int top = -1;

    for (char ch : num.toCharArray()) {

        while (top >= 0 && stack[top] > ch && k > 0) {
            top--;
            k--;
        }

        stack[++top] = ch;
    }

    // remove remaining digits from end
    top -= k;

    // skip leading zeros
    int start = 0;
    while (start <= top && stack[start] == '0') {
        start++;
    }

    if (start > top) return "0";

    return new String(stack, start, top - start + 1);
     */
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.removeKdigits("1432219",3));
        System.out.println(sol.removeKdigits("10200",1));
        System.out.println(sol.removeKdigits("10",2));
        System.out.println(sol.removeKdigits("112",1));
        System.out.println(sol.removeKdigits("33526221184202197273",19));
    }
}
