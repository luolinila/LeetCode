package 子数组最大平均数I643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        double max = 0;
        double avg = 0;
        for (int i = 0; i < k; i++) {
            avg += nums[i] * 1.0 / k;
            right++;
        }
        max = avg;
        while (right < nums.length) {
            avg += nums[right] * 1.0 / k;
            avg -= nums[left] * 1.0 / k;
            right++;
            left++;
            max = Math.max(max, avg);
        }
        return max;
    }
}
