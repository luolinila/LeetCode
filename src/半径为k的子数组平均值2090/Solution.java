package 半径为k的子数组平均值2090;

import java.util.Arrays;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if(nums.length < 2 * k + 1) return res;
        int left = 0, right = 0;
        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
            right++;
        }
        res[(left + right - 1) / 2] = (int)(sum / (2 * k + 1));
        while (right < nums.length) {
            sum += nums[right];
            sum -= nums[left];
            res[(left + right + 1) / 2] = (int)(sum / (2 * k + 1));
            left++;
            right++;
        }
        return res;
    }
}
