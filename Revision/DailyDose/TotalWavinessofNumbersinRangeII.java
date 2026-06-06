package Revision.DailyDose;

public class TotalWavinessofNumbersinRangeII {
    static class Solution {
    public int getWaviness(long num){
        int waviness = 0;
        String s = "";

        while(num!=0){
            s += num%10;
            num /= 10;
            if(s.length() >= 3){
               if((s.charAt(0) < s.charAt(1) && s.charAt(1) > s.charAt(2) ) || (s.charAt(0) > s.charAt(1) && s.charAt(1) < s.charAt(2))){
                  waviness++;
               }
               s = s.substring(1);
            }
        }
        return waviness;
    }
    public int totalWaviness(long num1, long num2) {
        int waviness = 0;

        if(num1 < 100 && num2 < 100) return 0;

        if(num1 < 100 && num2 >= 100) num1 = 100;

        for(long i=num1;i<=num2;i++){
           waviness += getWaviness(i);
        }

        return waviness;
    }
}
}
