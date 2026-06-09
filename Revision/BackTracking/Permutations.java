package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    static class Solution {
    public void dfs(int[] nums,boolean[] visited,List<Integer> temp,List<List<Integer>> result){

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i] == false){
                visited[i] = true;
                temp.add(nums[i]);
                dfs(nums,visited,temp,result);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        dfs(nums,visited,temp,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] num = {1,2,3};
        for(List<Integer> list : sol.permute(num)){
            System.out.println(list);
        }
    }
}
