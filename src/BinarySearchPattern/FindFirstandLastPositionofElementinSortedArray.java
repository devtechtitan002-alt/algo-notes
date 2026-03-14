import java.util.Arrays;
public class FindFirstandLastPositionofElementinSortedArray {
    static class Solution {
    /*
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
    */
    public int binarySearchForEndPos(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<=target) left = mid+1;
            else right=mid;
        }
        return nums[left]==target ? left : left>0 ? (nums[left-1]==target ? left-1 : -1) : -1;
    }
    public int binarySearchForStartPos(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target) right = mid;
            else left=mid+1;
        }
        return nums[right]==target ? right : -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==0) return result;
        if(nums.length==1){
            if(nums[0]==target) return new int[]{0,0};
            else return result;
        }
        result[1] = binarySearchForEndPos(nums,target);
        result[0] = binarySearchForStartPos(nums,target);
        return result;
    }
    /*
    public int findFirst(int[] nums, int target){
    int left = 0, right = nums.length-1;
    int ans = -1;

    while(left <= right){
        int mid = left + (right-left)/2;

        if(nums[mid] >= target){
            right = mid-1;
        } else {
            left = mid+1;
        }

        if(nums[mid] == target) ans = mid;
    }

    return ans;
}

public int findLast(int[] nums, int target){
    int left = 0, right = nums.length-1;
    int ans = -1;

    while(left <= right){
        int mid = left + (right-left)/2;

        if(nums[mid] <= target){
            left = mid+1;
        } else {
            right = mid-1;
        }

        if(nums[mid] == target) ans = mid;
    }

    return ans;
}

public int[] searchRange(int[] nums, int target) {
    return new int[]{findFirst(nums,target), findLast(nums,target)};
} */
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{},0)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{8,8},8)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{0},0)));
        System.out.println(Arrays.toString(sol.searchRange(new int[]{2,2},1)));
    }
}
