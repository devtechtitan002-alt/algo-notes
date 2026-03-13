import java.util.Arrays;
public class FindFirstandLastPositionofElementinSortedArray {
    static class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2 ;
            if(nums[mid]==target){
                if(result[0]==-1){ result[0] = mid; }
                if(result[1]==-1 && result[0]!=-1 && result[0]>=mid){ result[1] = mid;}
            }
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{},0)));
    }
}
