import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
public class SubsetsII {
    static class Solution {
    public List<List<Integer>> backTrack(int[] nums,int start,List<Integer> current,List<List<Integer>> res){

        res.add(new ArrayList<>(current));

        for(int i=start;i<nums.length;i++){

            //if( i>start && nums[i] == nums[i-1]) continue;

            current.add(nums[i]);
            backTrack(nums,i+1,current,res);
            current.remove(current.size()-1);
        }

        return res;
    }

    public void backTrackNotLoop(int[] nums,int i,List<Integer> current,List<List<Integer>> res,Set<List<Integer>> set){   // not suited appraoch

            if(i>=nums.length){
                if(set.contains(new ArrayList<>(current))) return;
                set.add(new ArrayList<>(current));
                res.add(new ArrayList<>(current));
                return;
            }

            current.add(nums[i]);
            backTrackNotLoop(nums,i+1,current,res,set);
            current.remove(current.size()-1);
            backTrackNotLoop(nums,i+1,current,res,set);

    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        backTrackNotLoop(nums,0,current,res,set);
        return res;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<Integer> list : sol.subsetsWithDup(new int[]{1,2,2})){
            System.out.println(list);
        }
    }
}
