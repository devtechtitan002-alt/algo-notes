import java.util.List;
import java.util.ArrayList;
public class Subsets {
    static class Solution {
    public List<List<Integer>> backTrack(int[] nums,int start,List<Integer> current,List<List<Integer>> res){

        res.add(new ArrayList<>(current));

        for(int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backTrack(nums,i+1,current,res);
            current.remove(current.size()-1);
        }

        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        return backTrack(nums,0,current,res);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.subsets(new int[]{1,2,3})){
            System.out.println(list);
        }
    }
}
