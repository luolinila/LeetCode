package 乘积小于K的子数组713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 1;
        int count = 0;
        while (right < nums.length) {
            sum *= nums[right];
            if (sum < k) {
                count += (right - left + 1);
                right++;
            }else {
                sum /= nums[left];
                if (left == right) {
                    right++;
                }else {
                    sum /= nums[right];
                }
                left++;
                if (left == nums.length) {
                    break;
                }
            }
        }
        return count;
    }
}
