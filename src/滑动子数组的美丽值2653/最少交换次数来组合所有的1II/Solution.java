package 滑动子数组的美丽值2653.最少交换次数来组合所有的1II;

import java.util.ArrayList;

public class Solution {
    public int minSwaps(int[] nums) {
        int count1 = 0;
        int[] fsum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count1++;
            }
            if(i == 0) {
                fsum[i] = (nums[i] + 1) % 2;
            }else {
                fsum[i] = (nums[i] + 1) % 2 + fsum[i - 1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                int end = (i + count1 - 1) % nums.length;
                if(i < end) {
                    int temp = fsum[end] - (i == 0 ? 0 : fsum[i - 1]);
                    min = Math.min(min, temp);
                }else {
                    int temp = fsum[end] + fsum[nums.length - 1] - (i == 0 ? 0 : fsum[i - 1]);
                    min = Math.min(min, temp);
                }
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
