package Revision.PriorityQueue;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    static class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];

        // heap for retrieve points based on distance formula
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]*a[0] + a[1]*a[1])-(b[0]*b[0] + b[1]*b[1])));

        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
        }

        int idx=k;
        while(k>0){
            result[idx-k] = pq.poll();
            k--;
        }

        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        for(int[] res : sol.kClosest(points,2)){
            System.out.println(Arrays.toString(res));
        }
    }
}
