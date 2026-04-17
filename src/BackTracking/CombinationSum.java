import java.util.List;
import java.util.ArrayList;
public class CombinationSum {
    static class Solution {
    int globalSum = 0;
    public void combinationsSum(int[] nums,int target,int index,List<Integer> curr,List<List<Integer>> res){
        if( globalSum > target ){
            globalSum -= nums[index];
            curr.remove(curr.size()-1);
            return;
        }
        if( globalSum == target ) res.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            globalSum += nums[i];
            curr.add(nums[i]);
            combinationsSum(nums,target,i,curr,res);
        }
        globalSum -= nums[index];
        if(curr.size()>0) curr.remove(curr.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationsSum(candidates,target,0,curr,res);
       return res;    
    }

    /*
    public void backtrack(int[] nums, int target, int start,
                      List<Integer> curr, List<List<Integer>> res){

    if(target == 0){
        res.add(new ArrayList<>(curr));
        return;
    }

    if(target < 0) return;

    for(int i = start; i < nums.length; i++){

        curr.add(nums[i]);

        // reuse allowed → i (not i+1)
        backtrack(nums, target - nums[i], i, curr, res);

        curr.remove(curr.size()-1); // undo
    }
}
     */

     /*
     public void dfs(int[] nums, int i, int target,
                List<Integer> curr, List<List<Integer>> res){

    if(target == 0){
        res.add(new ArrayList<>(curr));
        return;
    }

    if(i >= nums.length || target < 0) return;

    // include
    curr.add(nums[i]);
    dfs(nums, i, target - nums[i], curr, res);

    // exclude
    curr.remove(curr.size()-1);
    dfs(nums, i+1, target, curr, res);
}
     */
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.combinationSum(new int[]{2,3,5},8)){
            System.out.println(list);
        }
    }
}
