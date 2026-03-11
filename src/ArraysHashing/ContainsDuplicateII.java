package ArraysHashing;
import java.util.HashMap;
public class ContainsDuplicateII {
    static class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          if(indexMap.containsKey(nums[i]) && Math.abs(indexMap.get(nums[i])-i) <= k ) return true;
          indexMap.put(nums[i],i);
        }
        return false;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.containsNearbyDuplicate(new int[]{},3));
    }
}
