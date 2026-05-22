package Revision.TwoPointers;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {
    static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // sort input array so easily remove duplicates + binary two pointer strongly we can move
        Arrays.sort(nums);

        // approach : fix one num + two pointer search on remaining two indices 
        for(int i=0;i<(nums.length-2);i++){
             
            // skip duplicates
            if(i>0 && nums[i-1]==nums[i]) continue; // same value on further fixation may produce duplicates

            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                 
                 int sum = nums[i] + nums[left] + nums[right];

                 if(sum == 0){
                     result.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));

                     while(left<right && nums[left] == nums[left+1]) left++;

                     while(left<right && nums[right] == nums[right-1]) right--;

                     left++;
                     right--;
                 }
                 else if(sum < 0){
                    left++;
                 }else{
                    right--;
                 }
            }
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List list : sol.threeSum(new int[]{-1,0,1,2,-1,-4})){
           System.out.println(list);
        }
    }
}
