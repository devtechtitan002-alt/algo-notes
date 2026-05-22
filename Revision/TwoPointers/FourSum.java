package Revision.TwoPointers;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FourSum {
    static class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // sort ease for avoid duplicates as problem asked a,b,c,d should be distinct + once a,b fixed then using 2 pointers for c and d easily move only when sorted
        Arrays.sort(nums);

        for(int i=0;i<(nums.length-3);i++){

            if( i>0 && nums[i-1] == nums[i]) continue;

            int one = nums[i];

            for(int j=i+1;j<(nums.length-2);j++){

                if(j>i+1 && nums[j-1] == nums[j]) continue;

                int two = nums[j];

                int left = j+1;
                int right = nums.length-1;

                while(left<right){

                    int three = nums[left];
                    int four = nums[right];

                    long sum = (long)one + two + three + four;

                    if( sum == target){

                        result.add(new ArrayList<>(Arrays.asList(one,two,three,four)));

                        while(left<right && nums[left] == nums[left+1]) left++;

                        while(left<right && nums[right] == nums[right-1]) right--;

                        left++;
                        right--;

                    }
                    else if(sum < target){
                       left++;
                    }else{
                       right--;
                    }

                }
            }
        }

        return result;

    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List list : sol.fourSum(new int[]{1,0,-1,0,-2,2},0)){
           System.out.println(list);
        }
    }
}
