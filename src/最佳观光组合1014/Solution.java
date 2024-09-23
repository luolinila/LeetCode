package 最佳观光组合1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int temp = values[0] + 0;
        int max = 0;
        for (int i = 1; i < values.length; i++) {
            max = Math.max(max, values[i] + temp - i);
            temp = Math.max(temp, values[i] + i);
        }
        return max;

    }
}
