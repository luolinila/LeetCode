package 和至少为K的最短子数组862;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        // + + 大: left++ 小: right++
        // + - 大: left++ 小: right++
        // - + 大: left++ 小: left++
        // - - 大: left++ 小: left++
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            if (sum < k) {
                if (nums[left] > 0) {
                    right ++;
                }else {
                    left++;
                }
            }else {
                min = Math.min(min, right - left + 1);
                System.out.println(left + " " + right + " " + sum);
                if (left == right) {
                    right++;
                }else {
                    sum -= nums[right];
                }
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
