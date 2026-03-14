public class RemoveDuplicatesfromSortedArrayII {
    static class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[left]!=nums[right]){
                if((right-left)>2){
                   while((right-left)>2){
                   left++;
                   }
                   nums[left]=nums[right];
                }
            }
        }
        return left+1;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
