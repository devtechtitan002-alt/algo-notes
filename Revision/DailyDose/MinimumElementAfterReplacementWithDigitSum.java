package Revision.DailyDose;

public class MinimumElementAfterReplacementWithDigitSum {
    class Solution {
    public int getDigitSum(int num){
        int res=0;
        while(num!=0){
            res += num%10;
            num /= 10;
        }
        return res;
    }
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int num : nums){
            int digitsSum = getDigitSum(num);
            ans = Math.min(ans,digitsSum);
        }
        return ans;
    }
}
}
