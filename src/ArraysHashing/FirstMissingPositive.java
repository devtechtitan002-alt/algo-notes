import java.util.HashSet;
import java.util.Set;
public class FirstMissingPositive {
    static class Solution {
    public void swap(int[] nums,int currIndex){
       int temp=nums[nums[currIndex]-1];
       nums[nums[currIndex]-1]=nums[currIndex];
       nums[currIndex]=temp;
    }
    public int firstMissingPositive(int[] nums) {
        /*
        int positive=1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            while(set.contains(positive)) {
                set.remove(positive);
                positive++;
            }
        }
        return positive;
         */
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0 && nums[i]<nums.length && nums[i] != nums[nums[i]-1]){
                swap(nums,i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(sol.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(sol.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(sol.firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999}));
        System.out.println(sol.firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    }
}
