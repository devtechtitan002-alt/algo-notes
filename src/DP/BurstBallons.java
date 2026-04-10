package DP;

public class BurstBallons {
    static class Solution {
    public class BurstBalloonsRecursive {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n+1] = 1;
        for (int i = 0; i < n; i++) arr[i+1] = nums[i];

        Integer[][] memo = new Integer[n+2][n+2];
        return helper(arr, 1, n, memo);
    }

    private int helper(int[] arr, int left, int right, Integer[][] memo) {
        if (left > right) return 0; // no balloons to burst
        if (memo[left][right] != null) return memo[left][right];

        int maxCoins = 0;
        for (int k = left; k <= right; k++) {
            int coins = arr[left-1] * arr[k] * arr[right+1]; // coins from bursting k last
            coins += helper(arr, left, k-1, memo);           // left subinterval
            coins += helper(arr, k+1, right, memo);          // right subinterval
            maxCoins = Math.max(maxCoins, coins);
        }

        memo[left][right] = maxCoins;
        return maxCoins;
    }

    public static void main(String[] args) {
        BurstBalloonsRecursive sol = new BurstBalloonsRecursive();
        int[] nums = {3,1,5,8};
        System.out.println(sol.maxCoins(nums)); // Output: 167
    }
}
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxCoins(new int[]{3,1,5,8}));
    }
}
