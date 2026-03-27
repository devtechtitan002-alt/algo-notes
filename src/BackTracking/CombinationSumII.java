import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
public class CombinationSumII {
    static class Solution {
       public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);  // 🔥 important
    backtrack(candidates, target, 0, new ArrayList<>(), res);
    return res;
}

public void backtrack(int[] nums, int target, int start,
                      List<Integer> curr, List<List<Integer>> res) {

    if (target == 0) {
        res.add(new ArrayList<>(curr));
        return;
    }

    for (int i = start; i < nums.length; i++) {

        // 🔥 skip duplicates
        if (i > start && nums[i] == nums[i - 1]) continue;

        if (nums[i] > target) break; // pruning

        curr.add(nums[i]);
        backtrack(nums, target - nums[i], i + 1, curr, res);
        curr.remove(curr.size() - 1);
    }
}
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.combinationSum2(new int[]{2,5,2,1,2}, 5)){
            System.out.println(list);
        }
    }
}
