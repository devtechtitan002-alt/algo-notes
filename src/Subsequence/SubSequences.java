package Subsequence;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {
    static class Solution {
    public void backTrack(int[] nums,int start,List<Integer> current,List<List<Integer>> res){

        if(start >= nums.length ){
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[start]);
        backTrack(nums,start+1,current,res);
        current.remove(current.size()-1);
        backTrack(nums,start+1,current,res);
        
    }
    public List<List<Integer>> subsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(nums,0,current,res);
        return res;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.subsequences(new int[]{3,2,3})){
            System.out.println(list);
        }
    }
}
