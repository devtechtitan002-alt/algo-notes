package NumberTheory;
import java.util.Set;
import java.util.HashSet;

public class HappyNumber {
    static class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while( n != 1 && !seen.contains(n)){
            seen.add(n);
            int sum = 0;
            while(n != 0){
                int d = n%10;
                sum += d*d;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    /*
    public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();

    while (n != 1 && !seen.contains(n)) {
        seen.add(n);

        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }

        n = sum;
    }

    return n == 1;
}
     */
}
}
