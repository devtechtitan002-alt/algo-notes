package ArraysHashing;
import java.util.HashSet;
import java.util.Set;
public class FirstMissingPositive {
    static class Solution {
    public int firstMissingPositive(int[] nums) {
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
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(sol.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(sol.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
