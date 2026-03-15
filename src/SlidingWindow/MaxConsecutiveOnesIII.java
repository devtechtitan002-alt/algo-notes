public class MaxConsecutiveOnesIII {
    static class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int count=0,windowLength=0,maxLength=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) count++;
            windowLength = (right-left)+1;
            if(count<=k){
                maxLength = Math.max(windowLength,maxLength);
            }else{
                if(nums[left]==0) count--;
                left++;
            }
        }
        return maxLength;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        System.out.println(sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
        System.out.println(Integer.parseInt("0200"));
    }                                                     
}
