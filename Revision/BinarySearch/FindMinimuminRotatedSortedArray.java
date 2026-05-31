package Revision.BinarySearch;

public class FindMinimuminRotatedSortedArray {
    static class Solution {
    public int findMin(int[] nums) {   
        int left=0,right=nums.length-1,min=0;
         while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }
        return nums[left];
         
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{3,4,5,1,2}));
        System.out.println(sol.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(sol.findMin(new int[]{11,13,15,17}));
        System.out.println(sol.findMin(new int[]{3,1,2}));

    }
}
