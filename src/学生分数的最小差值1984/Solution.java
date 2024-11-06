package 学生分数的最小差值1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        for(int i = 0; i < k; i++){
            right++;
        }
        int min = nums[right - 1] - nums[left];
        while(right < nums.length){
            min = Math.min(min, nums[right] - nums[left + 1]);
            left++;
            right++;
        }
        return min;
    }
}
