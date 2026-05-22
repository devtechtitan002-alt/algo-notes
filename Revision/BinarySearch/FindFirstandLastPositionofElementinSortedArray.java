package Revision.BinarySearch;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    static class Solution {
    public void leftPass(int[] nums,int target,int[] result){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target) {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            if(nums[mid] == target)  result[0] = mid;
        }
        return;
    }
    public void rightPass(int[] nums,int target,int[] result){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] <= target) {
                left = mid+1;
            }
            else{
                right=mid-1;
            }
            if(nums[mid] == target)  result[1] = mid;
        }
        return;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        leftPass(nums,target,result);
        rightPass(nums,target,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{2,7,7,8,9},8)));
    }
}
