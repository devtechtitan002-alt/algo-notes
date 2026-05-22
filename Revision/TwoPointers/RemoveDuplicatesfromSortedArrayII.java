package Revision.TwoPointers;
import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
    static class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for(int read=0;read<nums.length;read++){
            if(write<2 || nums[read] != nums[write-2]){  // write itself act as valid region + write-2 ensures that
                nums[write] = nums[read];
                write++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return write;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
