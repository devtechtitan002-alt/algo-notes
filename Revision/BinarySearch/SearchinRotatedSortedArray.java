package Revision.BinarySearch;

public class SearchinRotatedSortedArray {
    static class Solution {
    public int getPivot(int[] nums){
        int l=0,r=nums.length-1;
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m] > nums[r]) l = m+1;
            else r = m;
        }
        return l; // even r also right here
    }
    public int binarySearch(int[] nums,int target,int l,int r){
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] == target) return m;
            else if(nums[m] < target) l = m+1;
            else r = m-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int pivot = getPivot(nums);  // this give the pivot where right side from this is sorted in ascending if left side is exists its left is sorted in descending
        return target <= nums[right] ? binarySearch(nums,target,pivot,right) : binarySearch(nums,target,left,pivot-1);
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2},3));
    }
}
