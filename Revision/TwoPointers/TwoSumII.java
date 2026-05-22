package Revision.TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    static class Solution{
        public int[] twoSum(int[] numbers, int target) {

            // As by problem statement ensures given input is non-decreasing order : so we can implement binary search two pointer method here

            int left=0,right=numbers.length-1;

            while(left<right){
                
                int sum = numbers[left] + numbers[right];

                if(sum == target){
                    return new int[]{left+1,right+1};
                }else if(target > sum){
                    left++;
                }else{
                    right--;
                }
            }

            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{-1,0},-1)));
    }
}
