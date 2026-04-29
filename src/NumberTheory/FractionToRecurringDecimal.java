package NumberTheory;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    static class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        if( numerator < 0 || denominator < 0) sb.append("-");

        // initial integer part
        sb.append(numerator/denominator);

        // decimal handling
        sb.append(".");

        Map<Integer,Integer> map = new HashMap<>();

        int rem = numerator% denominator;

        while(rem != 0){
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                sb.replace(3,idx,"(");
                sb.append(")");
                break;
            }

            map.put(rem,0);

            numerator *= 10;
            sb.append(numerator/denominator);
            rem = numerator%denominator;
                  
        }

        return sb.toString();
    }

    // AI Code

    /*
    public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";

    StringBuilder res = new StringBuilder();

    // handle sign
    if ((numerator < 0) ^ (denominator < 0)) {
        res.append("-");
    }

    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);

    // integer part
    res.append(num / den);
    long rem = num % den;

    if (rem == 0) return res.toString();

    res.append(".");

    Map<Long, Integer> map = new HashMap<>();

    while (rem != 0) {
        if (map.containsKey(rem)) {
            int idx = map.get(rem);
            res.insert(idx, "(");
            res.append(")");
            break;
        }

        map.put(rem, res.length());

        rem *= 10;
        res.append(rem / den);
        rem %= den;
    }

    return res.toString();
}
     */
}
}
