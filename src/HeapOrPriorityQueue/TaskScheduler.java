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

    /*
    import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int f : freq){
            if(f > 0) maxHeap.offer(f);
        }

        int time = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while(cycle > 0 && !maxHeap.isEmpty()){
                int curr = maxHeap.poll();
                if(curr - 1 > 0){
                    temp.add(curr - 1);
                }
                time++;
                cycle--;
            }

            for(int t : temp){
                maxHeap.offer(t);
            }

            if(maxHeap.isEmpty()) break;

            time += cycle; // idle time
        }

        return time;
    }
}
     */
}
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}
