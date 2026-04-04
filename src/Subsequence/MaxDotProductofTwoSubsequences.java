package Subsequence;

public class MaxDotProductofTwoSubsequences {
    static class Solution {
    public int maxDot(int[] n1,int i1,int[] n2,int i2){
        if( i1 < 0 || i2 < 0 ) return Integer.MIN_VALUE;

        int skip1 = maxDot(n1,i1-1,n2,i2);
        int skip2 = maxDot(n1,i1,n2,i2-1);

        int currDot = n1[i1] * n2[i2];
        int pick = Math.max(currDot,maxDot(n1,i1-1,n2,i2-1) == Integer.MIN_VALUE ? maxDot(n1,i1-1,n2,i2-1) : currDot+maxDot(n1,i1-1,n2,i2-1) );

        return Math.max(pick,Math.max(skip1,skip2));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        return maxDot(nums1,nums1.length-1,nums2,nums2.length-1);
    }

    /*
    import java.util.*;

public class Solution {

    public int maxDot(int[] n1, int i1, int[] n2, int i2, int[][] dp){
        if(i1 < 0 || i2 < 0) return Integer.MIN_VALUE;

        if(dp[i1][i2] != Integer.MIN_VALUE) return dp[i1][i2];

        int skip1 = maxDot(n1, i1-1, n2, i2, dp);
        int skip2 = maxDot(n1, i1, n2, i2-1, dp);

        int currDot = n1[i1] * n2[i2];

        int prev = maxDot(n1, i1-1, n2, i2-1, dp);

        int pick;
        if(prev == Integer.MIN_VALUE){
            pick = currDot; // start fresh
        } else {
            pick = Math.max(currDot, currDot + prev); // extend or start new
        }

        return dp[i1][i2] = Math.max(pick, Math.max(skip1, skip2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return maxDot(nums1, n-1, nums2, m-1, dp);
    }
}
     */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxDotProduct(new int[]{2,1,-2,5},new int[]{3,0,-6}));
    }
}
