package 滑动子数组的美丽值2653;

public class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] sign = new int[105];
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        int index = 0;
        for (int i = 0; i < k; ++i) {
            sign[nums[i] + 50]++;
            right++;
        }
        res[index++] = getXthMin(sign, x);
        while (right < nums.length) {
            sign[nums[right] + 50]++;
            sign[nums[left] + 50]--;
            res[index++] = getXthMin(sign, x);
            left++;
            right++;
        }
        return res;
    }
    public int getXthMin(int[] arr, int x) {
        for (int i = 0; i < arr.length; ++i) {
            x -= arr[i];
            if (x <= 0) {
                if(i - 50 >= 0) {
                    return 0;
                }
                return i;
            }
        }
        return arr.length;
    }
}
