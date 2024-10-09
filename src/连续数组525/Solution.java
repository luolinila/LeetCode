package 连续数组525;

public class Solution {
    public int findMaxLength(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        return get(arr, -1, nums.length - 1);
    }
    public int get(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if ((right - left) % 2 == 0 && (right - left) / 2 == nums[right] - (left == -1 ? 0 : nums[left])) {
            return right - left;
        }
        return Math.max(get(nums, left + 1, right), get(nums, left, right - 1));
    }
}
