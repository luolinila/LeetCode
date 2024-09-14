package 预算内的最多机器人数目2398;

import java.util.HashSet;

public class Main {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (right < runningCosts.length) {
            if (getAll(chargeTimes, runningCosts, left, right) <= budget) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }else {
                if (left == right) {
                    right++;
                }
                left++;
            }
        }
        return maxLength;
    }
    long getAll(int[] time, int[] cost, int left, int right) {
        int max = 0;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, time[i]);
            sum += cost[i];
        }
        return max + (long) (right - left + 1) * sum;
    }
}
