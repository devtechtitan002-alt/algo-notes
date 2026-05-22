package Revision.ArraysHashing;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class ContainsDuplicate{

    static class Solution{

        // sort approach 
        // TC : o(nlogn) + o(n) == o(nlogn) 
        // SC : depends .sort() max o(n)
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i=1;i<nums.length;i++){
                if(nums[i-1] == nums[i]) return true;
            }
            return false;
        }

        // set approach
        // TC : o(n)
        // SC : o(n)
        public boolean containsDuplicateSetAppraoch(int[] nums){
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
               if(set.contains(nums[i])) return true;
               set.add(nums[i]);
            }
            return false;
        }
        
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println("Hello I am back");
    }

}