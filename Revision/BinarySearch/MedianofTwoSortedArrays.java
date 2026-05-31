package Revision.BinarySearch;

public class MedianofTwoSortedArrays {
     static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0;

// getting length
int m = nums1.length, n = nums2.length;

// binary search on smaller array
if (n < m) {
    int[] temp = nums1;
    nums1 = nums2;
    nums2 = temp;

    m = nums1.length;
    n = nums2.length;
}

boolean isEven = (m + n) % 2 == 0;
int halfLen = (m + n + 1) / 2;

int l = 0, r = m;

while (true) {

    int pa = l + (r - l) / 2;
    int pb = halfLen - pa;

    int maxLeftA = pa == 0 ? Integer.MIN_VALUE : nums1[pa - 1];
    int maxLeftB = pb == 0 ? Integer.MIN_VALUE : nums2[pb - 1];

    int minRightA = pa == m ? Integer.MAX_VALUE : nums1[pa];
    int minRightB = pb == n ? Integer.MAX_VALUE : nums2[pb];

    // valid partition
    if (maxLeftA <= minRightB && maxLeftB <= minRightA) {

        if (!isEven) {
            median = Math.max(maxLeftA, maxLeftB);
        } else {
            median =
                ((double) Math.max(maxLeftA, maxLeftB)
                + Math.min(minRightA, minRightB)) / 2;
        }

        return median;
    }

    // move partition A right
    else if (maxLeftB > minRightA) {
        l = pa + 1;
    }

    // move partition A left
    else {
        r = pa - 1;
    }
    }

    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
