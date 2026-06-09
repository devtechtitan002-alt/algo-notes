package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    static class Solution {

    public void backtrack(int start,int[] nums,List<Integer> temp,List<List<Integer>> result) {

        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1};
        for(List<Integer> list : sol.subsetsWithDup(nums)){
            System.out.println(list);
        }
    }
}
