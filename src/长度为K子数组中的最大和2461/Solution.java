package 长度为K子数组中的最大和2461;

import java.util.HashMap;

public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            right++;
        }
        if(map.size() >= k) {
            max = sum;
        }
        while (right < nums.length) {
            sum += nums[right];
            sum -= nums[left];
            map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
            if(map.get(nums[left]) <= 0) {
                map.remove(nums[left]);
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if(map.size() >= k) {
                max = Math.max(max, sum);
            }
            left++;
            right++;
        }
        return max;
    }
}
