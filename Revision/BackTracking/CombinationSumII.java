package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

    static class Solution {

    public void backTrack(int[] nums,int target,int start,List<Integer> temp,List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<nums.length;i++){

            if(target < nums[i]) break;

            if(i>start && nums[i-1] == nums[i]) continue;

            temp.add(nums[i]);

            // each candidate may take atmost once
            backTrack(nums,target-nums[i],i+1,temp,result);

            // undo
            temp.remove(temp.size()-1);

        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(candidates,target,0,temp,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {2,5,2,1,2};
        for(List<Integer> list : sol.combinationSum2(nums,5)){
            System.out.println(list);
        }
    }
}
