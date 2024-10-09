package 长度最小的子数组209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int temp = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            temp += nums[right];
            if (temp < target) {
                right++;
            }else {
                System.out.println(left + " " + right + " " + temp);
                min = Math.min(min, right - left + 1);
                temp -= nums[left] + nums[right];
                if (left == right) {
                    right++;
                }
                left++;
                if (left >= nums.length) {
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
