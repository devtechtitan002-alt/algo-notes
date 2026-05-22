package Revision.SlidingWindow;

public class MaxConsecutiveOnesIII {
    static class Solution {
    public int longestOnes(int[] nums, int k) {

        // track zero's count
        int zeroes = 0,left=0,maxLen=0;

        for(int right=0;right<nums.length;right++){
            
            // track zeroes
            if(nums[right]==0) zeroes++;

            while(zeroes > k){
                if(nums[left]==0) zeroes--;
                left++;
            }

            maxLen = Math.max(maxLen,(right-left)+1);

        }

        return maxLen;
    }
    }

    public static void main(String[] args){
         Solution sol = new Solution();
         System.out.println(sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}
