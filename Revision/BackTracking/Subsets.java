package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;

public class Subsets {
    static class Solution {

    public void generateSubsets(int[] nums,int idx,List<Integer> temp,List<List<Integer>> result){
        
        if(idx == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);

        generateSubsets(nums,idx+1,temp,result);

        temp.remove(temp.size()-1);

        generateSubsets(nums,idx+1,temp,result);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generateSubsets(nums,0,temp,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        for(List<Integer> list : sol.subsets(nums)){
            System.out.println(list);
        }
    }
}
