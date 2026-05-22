package Revision.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class TaskScheduler {
    static class Solution {
    public int leastInterval(char[] tasks, int n) {

        // map for freq tracking then put map's values into heap 
        Map<Character,int[]> map = new HashMap<>();
        for(char ch : tasks){
            map.computeIfAbsent(ch,k->new int[]{0,0})[0]++;
        }

        // Min-Heap for Max-Freq Tasks to Least Freq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        pq.addAll(map.values());


        // Queue Cool Down Task Holder
        Queue<int[]> q = new ArrayDeque<>();

        int time=0;

        while(!pq.isEmpty() || !q.isEmpty()){
           int[] task = !pq.isEmpty() ? pq.peek() : null;

           // if any task array satisfy below condtion it going to execute
           if(task!=null && task[1]<=time){
               int[] task_q = pq.poll();
               task_q[0] -= 1; // As current task execution starts at time 
               task_q[1] = time+n;
               if(task_q[0] > 0) q.add(task_q);
           }

           // once cooldown time completed its pushed back into pq
           if(!q.isEmpty() && time >= q.peek()[1]){
              pq.add(q.poll());
           }

           time++;

        }

        return time;

        /*
        // map for frequency tracking
Map<Character, int[]> map = new HashMap<>();

for(char ch : tasks){
    map.computeIfAbsent(ch, k -> new int[]{0, 0})[0]++;
}

// Max-Heap -> highest remaining frequency first
PriorityQueue<int[]> pq =
        new PriorityQueue<>((a,b) -> b[0] - a[0]);

pq.addAll(map.values());

// cooldown queue
Queue<int[]> q = new ArrayDeque<>();

int time = 0;

while(!pq.isEmpty() || !q.isEmpty()){

    // move cooled tasks back to heap
    while(!q.isEmpty() && q.peek()[1] <= time){
        pq.add(q.poll());
    }

    // execute highest freq available task
    if(!pq.isEmpty()){

        int[] task = pq.poll();

        task[0]--;

        // still remaining executions
        if(task[0] > 0){

            // next available time
            task[1] = time + n + 1;

            q.add(task);
        }
    }

    time++;
}

return time;
 */
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}
