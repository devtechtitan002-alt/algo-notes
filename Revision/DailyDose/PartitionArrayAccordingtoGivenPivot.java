package Revision.DailyDose;
import java.util.Arrays;

public class PartitionArrayAccordingtoGivenPivot {
    static class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;

        int[] result = new int[nums.length];

        int totalLeft=0,totalRight=0;

        for(int num : nums){
            if(num< pivot) totalLeft++;
            if(num > pivot) totalRight++;
        }
 
        int totalPivot = n - (totalLeft+totalRight);

        int pivotIdx = totalLeft;

        while(totalPivot!=0){
            result[pivotIdx++] = pivot;
            totalPivot--;
        }

        int lStart=0,rStart = n-totalRight;

        for(int num: nums){

            if(num < pivot) result[lStart++] = num;

            if(num > pivot) result[rStart++] = num;
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.pivotArray(new int[]{1,2,3},1)));
    }
}
