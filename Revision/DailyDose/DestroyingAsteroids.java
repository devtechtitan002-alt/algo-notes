package Revision.DailyDose;
import java.util.Arrays;

public class DestroyingAsteroids {
    static class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        Long massNew = (long)mass;
        for(int weighs : asteroids){
            if(mass < weighs){
                return false;
            }
            massNew += weighs;
        }

        return true;
    }

    // system design simulation practice free wbesites
}
}