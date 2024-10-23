package 最小元素和最大元素的最小平均值3194;

import java.util.Arrays;

public class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        double min = Integer.MAX_VALUE;
        while (left < right) {
            min = Math.min(min, (double) (nums[left] + nums[right]) / 2);
            left++;
            right--;
        }
        return min;
    }
}
