package 最小差值I908;

public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int sum = 0;
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        int ad = (nums[maxIndex] + nums[minIndex]) / 2;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (ad - k <= nums[i] && ad + k >= nums[i]) {
                nums[i] = 0;
            }else {
                nums[i] = nums[i] - ad;
                if(nums[i] < 0) {
                    nums[i] += k;
                }else {
                    nums[i] -= k;
                }
            }
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return max - min;
    }
}
