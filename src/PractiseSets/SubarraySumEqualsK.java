package PractiseSets;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class SubarraySumEqualsK {
    static class Solution {
    public int subarraySum(int[] nums, int k) {
    int currSum = 0, count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int num : nums) {
        currSum += num;

        int target = currSum - k;
        if (map.containsKey(target)) {
            count += map.get(target);
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    }

    return count;
}

public int longestSubarraySumEquals(int[] nums, int k) {
    int currSum = 0, maxLen = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<>(Arrays.asList(-1)));

    for (int i=0;i<nums.length; i++) {
        currSum += nums[i];

        int target = currSum - k;
        if (map.containsKey(target)) {
            maxLen = Math.max(maxLen , (i - (map.get(target).get(0)+1) )+1 );
        }

        map.computeIfAbsent(currSum, x -> new ArrayList<>()).add(i);
    }

    return maxLen;
}

    }

     public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestSubarraySumEquals(new int[]{3, 4, 7, 2, -3, 1, 4, 2},7));
    }
}

