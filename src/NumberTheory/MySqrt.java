package NumberTheory;

public class MySqrt {
    static class Solution {
    // public int mySqrt(int x) {
    //     int i=1;
    //     while(i*i <= x){
    //         i++;
    //     }
    //     return i-1;
    // }

    public int mySqrt(int x) {
    int left = 1, right = x;
    int ans = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (mid <= x / mid) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;
}


}
}
