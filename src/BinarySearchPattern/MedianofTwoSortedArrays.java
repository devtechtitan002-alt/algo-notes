public class MedianofTwoSortedArrays {
    static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
        return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;

    int left = 0;
    int right = m;

    int leftSize = (m+n+1)/2;

    while(left <= right){

        int partitionA = left + (right-left)/2;
        int partitionB = leftSize - partitionA;

        int Aleft  = (partitionA==0) ? Integer.MIN_VALUE : nums1[partitionA-1];
        int Aright = (partitionA==m) ? Integer.MAX_VALUE : nums1[partitionA];

        int Bleft  = (partitionB==0) ? Integer.MIN_VALUE : nums2[partitionB-1];
        int Bright = (partitionB==n) ? Integer.MAX_VALUE : nums2[partitionB];

        if(Aleft <= Bright && Bleft <= Aright){

            if((m+n)%2 == 0){
                return (Math.max(Aleft,Bleft) + Math.min(Aright,Bright)) / 2.0;
            }else{
                return Math.max(Aleft,Bleft);
            }

        }
        else if(Aleft > Bright){
            right = partitionA - 1;
        }
        else{
            left = partitionA + 1;
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
