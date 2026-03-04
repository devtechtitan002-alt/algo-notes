import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class TwoSum2 {
    static class Solution{
       public int[] twoSum(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int currSum=nums[left]+nums[right];
            if(currSum==target){
                return new int[]{left+1,right+1};
            }
            if(currSum>target){
               right--;
            }
            else{
                left++;
            }
        }
        return new int[]{};
       }
    }
    public static void main(String args[]){
        Solution sol = new Solution();

        int[] res1 = sol.twoSum(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(res1));

        int[] res2 = sol.twoSum(new int[]{2,3,4},6);
        System.out.println(Arrays.toString(res2));

        int[] res3 = sol.twoSum(new int[]{-1,0},-1);
        System.out.println(Arrays.toString(res3));

        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(2,3,1));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,3));
        HashSet<List<Integer>> set = new HashSet<>();
        System.out.println(set.add(l1));
        System.out.println(set.add(l2));


    }
}
