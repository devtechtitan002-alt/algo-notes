package ArraysHashing;
import java.util.HashSet;
import java.util.Arrays;
public class LongestConsecutiveSequence {
    static class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        int max = 0;

        for(int num : set){

            if(!set.contains(num - 1)){

                int curr = num;
                int count = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
}
