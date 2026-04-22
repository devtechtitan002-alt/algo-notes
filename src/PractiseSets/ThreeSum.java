package PractiseSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static class Solution{
        public List<List<Integer>> threeSum(int[] nums){
            if(nums.length < 3) return null;
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i=0;i<=nums.length-3;i++){

                  // prune duplicates
                  if(i>0 && nums[i-1] == nums[i]) continue;

                  int j=i+1,k=nums.length-1;
                  while(j<k){
                      int sum = nums[i] + nums[j] + nums[k];
                      if(sum==0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));

                        while(j<k && nums[j]==nums[j+1]) j++;
                        while(j<k && nums[k]==nums[k-1]) k--;

                        j++;
                        k--;
                      }else if(sum < 0){
                        j++;
                      }else{
                        k--;
                      }
                  }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.threeSum(new int[]{-4,-1,-1,0,1,2}));
    }
}
