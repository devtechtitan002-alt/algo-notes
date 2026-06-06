package Revision.DailyDose;
import java.util.Arrays;
public class MinimumCostofBuyingCandiesWithDiscount {
     class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0,last=cost.length-1;

        Arrays.sort(cost);

        for(int i=cost.length-1;i>=0;i--){
            if((last-i)==2){
                last=i-1;
                continue;
            }
            minCost += cost[i];
        }
        
        return minCost;
    }
}
}
