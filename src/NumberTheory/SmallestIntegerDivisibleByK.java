package NumberTheory;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisibleByK {
    static class Solution {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> seen = new HashSet<>();
int r = 0;

for (int n = 1; n <= k; n++) {
    r = (r * 10 + 1) % k;

    if (r == 0) return n;      // found
    if (seen.contains(r)) break; // cycle → impossible

    seen.add(r);
}

        return -1; // no such n
    }

    /*
    public int smallestRepunitDivByK(int k) {
    if (k % 2 == 0 || k % 5 == 0) return -1;

    int r = 0;

    for (int n = 1; n <= k; n++) {
        r = (r * 10 + 1) % k;
        if (r == 0) return n;
    }

    return -1;
}
     */
}
}
