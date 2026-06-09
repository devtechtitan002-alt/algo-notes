package Revision.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum {
    static class Solution {

    public void dfs(int[] candidates,int target,int idx,List<Integer> temp,List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(idx == candidates.length) return;

        int currNum = candidates[idx];

        if(target < 0 || target < currNum) return;

        temp.add(currNum);
        dfs(candidates,target-currNum,idx,temp,result);
        temp.remove(temp.size()-1);
        dfs(candidates,target,idx+1,temp,result);

    }

    public void backTrack(int[] candidates,int target,int start,List<Integer> temp,List<List<Integer>> result){
         
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<candidates.length;i++){

            // further case not producing results
             if(candidates[i] > target)
                break;

            temp.add(candidates[i]);

            // reuse allowed so not i+1 so use i again
            backTrack(candidates,target-candidates[i],i,temp,result);

            // undo case
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(candidates,target,0,temp,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {2,3,5};
        for(List<Integer> list : sol.combinationSum(nums,8)){
            System.out.println(list);
        }
    }
}
