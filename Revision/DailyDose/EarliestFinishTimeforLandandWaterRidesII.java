package Revision.DailyDose;
import java.util.Arrays;
public class EarliestFinishTimeforLandandWaterRidesII {
    static class Solution {

    private long solve(int[] start1, int[] dur1,
                       int[] start2, int[] dur2) {

        int m = start2.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = start2[i];
            rides[i][1] = dur2[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        long[] prefixMinDur = new long[m];
        prefixMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        long[] suffixMinFinish = new long[m];
        suffixMinFinish[m - 1] =
                (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                    suffixMinFinish[i + 1],
                    (long) rides[i][0] + rides[i][1]
            );
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            long finish1 = (long) start1[i] + dur1[i];

            int l = 0, r = m;
            while (l < r) {
                int mid = l + (r - l) / 2;

                if (rides[mid][0] <= finish1) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            int idx = l;

            if (idx > 0) {
                ans = Math.min(
                        ans,
                        finish1 + prefixMinDur[idx - 1]
                );
            }

            if (idx < m) {
                ans = Math.min(
                        ans,
                        suffixMinFinish[idx]
                );
            }
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        long a = solve(
                landStartTime, landDuration,
                waterStartTime, waterDuration
        );

        long b = solve(
                waterStartTime, waterDuration,
                landStartTime, landDuration
        );

        return (int) Math.min(a, b);
    }
}
     
}

