package PractiseSets;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class LIS {
    static class Solution{

        // brute force - 0

        public int isMonotonicIncreasing(List<Integer> list){
            if(list.size()<=0) return list.size();
            int count = 0;
            for(int i=1;i<list.size();i++){
               if(list.get(i-1) < list.get(i)){
                count++;
               }else{
                break;
               }
            }
            return count == list.size()-1 ? count+1 : 0;
        }

        public void helperBruteForce0(int[] nums, int i,List<Integer> curr,List<List<Integer>> res) {
            if (i == nums.length) {
                System.out.println(new ArrayList<>(curr));
                res.add(new ArrayList<>(curr));
                return;
            }

                curr.add(nums[i]);    // PICK
                helperBruteForce0(nums, i + 1, curr, res);
                curr.remove(curr.size()-1);
                helperBruteForce0(nums, i + 1, curr, res); // NOT PICK

            return;
        }

        // brute force - 1

        public void helperBruteForce(int[] nums, int prevIndex, int i,List<Integer> curr,List<List<Integer>> res) {
            if (i == nums.length) {
                System.out.println(new ArrayList<>(curr));
                res.add(new ArrayList<>(curr));
                return;
            }

            // PICK (only if valid)
            if (prevIndex == -1 || nums[prevIndex] < nums[i]) {
                curr.add(nums[i]);
                helperBruteForce(nums, i, i + 1, curr, res);
                curr.remove(curr.size()-1);
            }

            // NOT PICK
            helperBruteForce(nums, prevIndex, i + 1, curr, res);

            return;
        }

        // optimized 

        public int dfs(int[] nums, int prevIndex, int i,int[][] dp) {
            if (i == nums.length) return 0;

            // shift from -1 to 0 ( so map indices from 0 to n)
            if(dp[i][prevIndex+1]!=-1) return dp[i][prevIndex+1];

            int pick = 0;

            // PICK (only if valid)
            if (prevIndex == -1 || nums[prevIndex] < nums[i]) {
                pick = 1 + dfs(nums, i, i + 1,dp);
            }

            // NOT PICK
            int notPick = dfs(nums, prevIndex, i + 1,dp);

            return dp[i][prevIndex+1] = Math.max(pick, notPick);
        }

        // top down approach

        public int lisBottomUp(int[] nums) {
    int n = nums.length;

    int[][] dp = new int[n + 1][n + 1];

    for (int i = n - 1; i >= 0; i--) {

        for (int prevIndex = i - 1; prevIndex >= -1; prevIndex--) {

            int notPick = dp[i + 1][prevIndex + 1];

            int pick = 0;
            if (prevIndex == -1 || nums[prevIndex] < nums[i]) {
                pick = 1 + dp[i + 1][i + 1];
            }

            dp[i][prevIndex + 1] = Math.max(pick, notPick);
        }
    }

    return dp[0][0];
}


        public int lowerBound(List<Integer> nums, int target){
    int l = 0, r = nums.size();
    while(l < r){
        int mid = l + (r - l)/2;
        if(nums.get(mid) < target){
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return l;
}

public int lengthByBinarySearchLIS(int[] nums){
    List<Integer> tails = new ArrayList<>();

    for(int num : nums){
        if(tails.size() == 0 || tails.get(tails.size()-1) < num){
            tails.add(num);
        } else {
            int idx = lowerBound(tails, num);
            tails.set(idx, num);  // 🔥 key fix
        }
    }

    return tails.size();
}



        public int lengthOfLIS(int[] nums){
            //List<List<Integer>> res = new ArrayList<>();
            //List<Integer> curr = new ArrayList<>();

            // very naive --> generate all subsequence then check for each subsequence is strictly increasing
            // helperBruteForce0(nums, 0,curr,res);
            // int maxLen=0;
            // for(List<Integer> list : res){
            //     maxLen = Math.max(maxLen,isMonotonicIncreasing(list));
            // }
            // return maxLen;

            // naive --> while generate all subsequence prune by strictly increasing so all subsequences added is only stricly increasing 
            // helperBruteForce(nums, -1, 0,curr,res);
            // int maxLen=0;
            // for(List<Integer> list : res){
            //     maxLen = Math.max(maxLen,list.size());
            // }
            // return maxLen;

            // optimze
            // int n = nums.length;
            // int[][] dp = new int[n][n+1];
            // for(int[] dps : dp){
            //     Arrays.fill(dps,-1);
            // }
            // return dfs(nums, -1, 0,dp);

            int n = nums.length;
            int[][] dp = new int[n][n+1];
            return topDownLIS(nums,dp);
        }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
