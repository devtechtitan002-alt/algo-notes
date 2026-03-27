import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class SubsetsII {
    static class Solution {
    public List<List<Integer>> backTrack(int[] nums,int start,List<Integer> current,List<List<Integer>> res){

        res.add(new ArrayList<>(current));

        for(int i=start;i<nums.length;i++){

            if( i>start && nums[i] == nums[i-1]) continue;

            current.add(nums[i]);
            backTrack(nums,i+1,current,res);
            current.remove(current.size()-1);
        }

        return res;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        return backTrack(nums,0,current,res);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.subsetsWithDup(new int[]{1,2,2})){
            System.out.println(list);
        }
    }
}
