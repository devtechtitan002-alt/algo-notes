import java.util.PriorityQueue;
import java.util.Arrays;
public class KClosestPointstoOrigin {
    static class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));
        for(int[] ordinates : points){
            pq.add(ordinates);
            if(pq.size()>k){
               pq.poll();
            }
        }
        int[][] res = new int[k][];
        for(int i=0;i<k;i++){
            res[i] = pq.poll();
        }
        return  res;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] xyCor = {
            {3,3},
            {5,-1},
            {-2,4}
        };
        for(int[] res : sol.kClosest(xyCor,2)){
            System.out.println(Arrays.toString(res));
        }
    }
}
