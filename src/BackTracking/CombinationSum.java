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
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.combinationSum(new int[]{2,3,5},8)){
            System.out.println(list);
        }
    }
}
