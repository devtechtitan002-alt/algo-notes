import java.util.List;
import java.util.ArrayList;
public class Permutations {
    static class Solution {
        public void permute(int[] nums, List<Integer> curr,
                    boolean[] used, List<List<Integer>> res) {

    if(curr.size() == nums.length){
        res.add(new ArrayList<>(curr));
        return;
    }

    for(int i = 0; i < nums.length; i++){
        if(used[i]) continue;

        // CHOOSE
        used[i] = true;
        curr.add(nums[i]);

        // EXPLORE
        permute(nums, curr, used, res);

        // UNDO (BACKTRACK)
        curr.remove(curr.size()-1);
        used[i] = false;
    }
}
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(nums,curr,used,res);
        return  res;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.permute(new int[]{1,2,3}));
    }
}
