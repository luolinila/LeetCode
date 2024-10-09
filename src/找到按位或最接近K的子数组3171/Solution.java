package 找到按位或最接近K的子数组3171;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int temp = nums[0];
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            temp = temp | nums[right];
            min = Math.min(min, Math.abs(temp - k));
            if (temp <= k) {
                right++;
            }else {
                if (left == right) {
                    right++;
                }
                left++;
                if (left >= nums.length) {
                    break;
                }
                temp = nums[left];
                for (int i = left; i < right; i++) {
                    temp = temp | nums[i];
                }
            }
        }
        return min;
    }
}
