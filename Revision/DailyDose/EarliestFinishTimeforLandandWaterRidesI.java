package Revision.DailyDose;

public class EarliestFinishTimeforLandandWaterRidesI {
    static class Solution {
    public int getearliestFinish(int[] first, int[] fTime, int[] second, int[] sTime){

        /*
        int minTime = Integer.MAX_VALUE;

        for(int i=0;i<first.length;i++){
            for(int j=0;j<second.length;j++){
               int finishTime = first[i]+fTime[i];
               finishTime = Math.max(finishTime, second[j]);
               minTime = Math.min(minTime, finishTime+sTime[j]);
            }
        }

        return minTime;

        */

        int firstFinishTime = Integer.MAX_VALUE;

        for(int i=0;i<first.length;i++){
            firstFinishTime = Math.min(firstFinishTime , first[i]+fTime[i]);
        }

        int secondFinishTime = Integer.MAX_VALUE;

        for(int i=0;i<second.length;i++){
            secondFinishTime = Math.min(secondFinishTime , Math.max(firstFinishTime,second[i])+sTime[i]);
        }

        return secondFinishTime;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(getearliestFinish(landStartTime, landDuration, waterStartTime,  waterDuration) , getearliestFinish(waterStartTime,  waterDuration , landStartTime, landDuration));
    }

}

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.earliestFinishTime(new int[]{2,8},new int[]{4,1},new int[]{6},new int[]{3}));
    }
}
