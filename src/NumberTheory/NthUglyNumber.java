package NumberTheory;
import java.util.Set;
import java.util.HashSet;
public class NthUglyNumber {
    static class Solution {
    public boolean isUgly(int num){
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }
    public int nthUglyNumber(int n) {
        int res = -1;
        int num = 1;
        while(n > 0){
            if(isUgly(num)){
                res = num;
                n--;
            }
            num += 1;
        }
        return res;
    }


    // efficient approach
    public int nthUglyNumberOptimized(int n) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        while( set.size() < n ){
            
        }
        return res;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.nthUglyNumber(10));
    }
}
