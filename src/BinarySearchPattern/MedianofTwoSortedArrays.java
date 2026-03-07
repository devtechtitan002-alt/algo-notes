public class MedianofTwoSortedArrays {
    static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){ return findMedianSortedArrays(nums2,nums1); }
        int left=0,right=nums1.length;
        int medianCondition = (nums1.length+nums2.length+1)/2;
        double median=0;
        while(left<=right){

           // for nums1 
           int partitionA = left+((right-left)/2);

           //for nums2
           int partitionB = medianCondition-partitionA;

           if(partitionB<nums2.length && nums1[partitionA-1] > nums2[partitionB]){   // 1,8 | 10
                right=partitionA-1;                 // 2,3 | 4,5
           }
           else if(partitionA<nums1.length && nums2[partitionB-1] > nums1[partitionA]){    // 1 | 3
                left=partitionA+1;                            // 2,4 | 5
           }

        }
        return -1;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
}
