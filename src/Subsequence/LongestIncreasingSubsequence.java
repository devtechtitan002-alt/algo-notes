package Subsequence;
import java.util.Arrays;
public class LongestIncreasingSubsequence {
    static class Solution {
        public int longestIS(int[] nums, int idx, int prevIdx, int[][] dp) {
    if (idx == nums.length) return 0;

    // shift prevIdx by +1 to handle -1
    if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];

    // skip
    int notTake = longestIS(nums, idx + 1, prevIdx, dp);

    int take = 0;

    // pick (only if valid)
    if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
        take = 1 + longestIS(nums, idx + 1, idx, dp);
    }

    return dp[idx][prevIdx + 1] = Math.max(take, notTake);
}

public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n + 1]; // prevIdx from -1 to n-1

    for (int[] row : dp) {
        Arrays.fill(row, -1);
    }

    return longestIS(nums, 0, -1, dp);
}
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
