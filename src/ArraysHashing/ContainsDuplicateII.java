import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class ContainsDuplicateII {
    static class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          if(indexMap.containsKey(nums[i]) && Math.abs(indexMap.get(nums[i])-i) <= k ) return true;
          indexMap.put(nums[i],i);
        }
        return false;
        */
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<k;i++){
            if(i>=nums.length) return false;
            int num=nums[i];
            if(set.contains(num)) return true;
            set.add(num);
        }
        for(int i=k;i<nums.length;i++){
            int num = nums[i];
            if(set.contains(num)) return true;
            set.add(num);
            set.remove(nums[i-k]);
        }
        return false;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
