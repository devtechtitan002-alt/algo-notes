import java.util.Arrays;
import java.util.Stack;
import java.util.HashMap;
import java.util.Collections;
public class CarFleet {
    static class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

double[][] cars = new double[n][2];

for(int i=0;i<n;i++){
    cars[i][0] = position[i];
    cars[i][1] = (double)(target-position[i]) / speed[i];
}

Arrays.sort(cars,(a,b)->Double.compare(a[0],b[0]));

Stack<Double> stack = new Stack<>();

for(int i=n-1;i>=0;i--){
    double time = cars[i][1];

    if(!stack.isEmpty() && time <= stack.peek()){
        continue;
    }

    stack.push(time);
}

return stack.size();
/*
 int n = position.length;

int[][] cars = new int[n][2];

for(int i=0;i<n;i++){
    cars[i] = new int[]{position[i], speed[i]};
}

Arrays.sort(cars,(a,b)->b[0]-a[0]);

double lastTime = -1;
int fleets = 0;

for(int[] car : cars){
    double time = (double)(target-car[0])/car[1];

    if(time > lastTime){
        fleets++;
        lastTime = time;
    }
}

return fleets;
 */
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3}));
    }
}
