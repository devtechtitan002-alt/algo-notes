package Revision.SortingAlgos;
import java.util.Arrays;

public class InsertionSorting {
    static class Solution{
        public void insertionSort(int[] nums){
           for(int right=1;right<nums.length;right++){
            
              int key = nums[right];
              int left = right-1;

              // make sure left part sorted
              while(left>=0 && nums[left] > key){
                  nums[left+1] = nums[left];
                  left--;
              }
 
              nums[left+1] = key;

           }
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{2,8,1,3,9,4};
        sol.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
