package Revision.MonotonicStack;
import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
   
     static class Solution{
        public int carFleet(int target, int[] position, int[] speed) {
         
            // storing remaining positions to cover along with respective speeds
            double[][] posVsSpeed = new double[position.length][2];

            for(int i=0;i<position.length;i++){
                int remaining_distance = target - position[i];
                posVsSpeed[i][0] = remaining_distance;
                posVsSpeed[i][1] = (double)remaining_distance/speed[i];
            }

            // sort by remaining distance
            Arrays.sort(posVsSpeed,(a,b)->Double.compare(a[0],b[0]));

           // Stack<Double> stack = new Stack<>();

            int fleets=0;
            double minTime=0;

            for(int i=posVsSpeed.length-1;i>=0;i--){

                double currentTime = posVsSpeed[i][1];

                if(minTime != 0 && currentTime <= minTime){
                    continue;
                }else{
                    fleets++;
                    minTime = currentTime;
                }

                
            }

            return fleets;
        }    
     }

     public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.carFleet(10,new int[]{0,4,2},new int[]{2,1,3}));
     }


}
