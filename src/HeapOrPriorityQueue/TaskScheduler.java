import java.util.HashMap;
import java.util.PriorityQueue;
public class TaskScheduler {
    static class Solution {
    public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    
    // Count frequency
    for (char t : tasks) {
        freq[t - 'A']++;
    }
    
    // Find max frequency
    int maxFreq = 0;
    for (int f : freq) {
        maxFreq = Math.max(maxFreq, f);
    }
    
    // Count how many tasks have max frequency
    int countMax = 0;
    for (int f : freq) {
        if (f == maxFreq) countMax++;
    }
    
    // Apply formula
    int partCount = maxFreq - 1;
    int partLength = n + 1;
    
    int minTime = partCount * partLength + countMax;
    
    // Final answer
    return Math.max(tasks.length, minTime);
}
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}
