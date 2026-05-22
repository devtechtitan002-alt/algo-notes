package Revision.ArraysHashing;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicateII {

    static class Solution{

        // Map Approach
        // TC : o(n) 
        // SC : o(n) (avergae ) worst case : o(n^2) hash collisions
        public boolean containsNearbyDuplicate(int[] nums,int k){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
               int curr = nums[i];
               if(map.containsKey(curr) && ( Math.abs(i-map.get(curr)) <= k )) return true;
               map.put(curr,i);
            }
            return false;
        }

        // Sliding Window
        // TC : o(n) 
        // SC : o(n) (avergae ) worst case : o(n^2) hash collisions
        public boolean containsNearbyDuplicateBySlidingWindow(int[] nums,int k){

            Set<Integer> set = new HashSet<>();
            int left = 0;

            for(int right=0;right<nums.length;right++){
                
                if(set.contains(nums[right])) return true;

                set.add(nums[right]);

                if(set.size() > k){
                    set.remove(nums[left]);
                    left++;
                }

            }

            return false;

        }

    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
