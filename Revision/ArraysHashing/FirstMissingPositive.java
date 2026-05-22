package Revision.ArraysHashing;
import java.util.Set;
import java.util.HashSet;

public class FirstMissingPositive {
    static class Solution{

        // Set approach 
        // TC:O(n) 
        // SC:O(n) - for Set Theoritically O(n^2) worst case
        public int firstMissingPositive(int[] nums){
        
           Set<Integer> set = new HashSet<>();
           int firstPositive = 1;

           for(int num : nums){
              set.add(num);
              while(set.contains(firstPositive)){
                set.remove(firstPositive);
                firstPositive++;
              }
           }

           return firstPositive;

        }

        // Set approach 
        // TC:O(n) 
        // SC:O(1) - what problem expects

        private void swap(int[] nums,int i,int j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] =  temp;
        }

        public int firstMissingPositiveByCyclicSort(int[] nums){
          
            for(int i=0;i<nums.length;i++){
                while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                    swap(nums,nums[i]-1,i);
                }
            }

            for(int i=0;i<nums.length;i++){
                if(nums[i] != i+1) return i+1;
            }

            return nums.length+1;

        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositiveByCyclicSort(new int[]{1,1}));
    }
}
