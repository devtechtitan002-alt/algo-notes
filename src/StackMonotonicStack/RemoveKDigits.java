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
        char[] stack = new char[num.length()];
int top = -1;

for(char ch : num.toCharArray()){
    while(top >= 0 && ch < stack[top] && times > 0){
        top--;
        times--;
    }
    stack[++top] = ch;
}

// remove remaining k from end
top = top - times;

// build result
StringBuilder sb = new StringBuilder();
for(int i = 0; i <= top; i++){
    sb.append(stack[i]);
}

// strip leading zeros
while(sb.length() > 1 && sb.charAt(0) == '0'){
    sb.deleteCharAt(0);
}

return sb.isEmpty() ? "0" : sb.toString();
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
