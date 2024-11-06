package 存在重复元素III220;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums.length <= 1) return false;
        for(int len = Math.min(indexDiff + 1, nums.length); len >= 2 ; --len) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < len; i++) {
                right++;
            }
            if(Math.abs(nums[right - 1] - nums[left]) <= valueDiff) {
                return true;
            }
            while (right < nums.length) {
                if(Math.abs(nums[right] - nums[left + 1]) <= valueDiff) {
                    return true;
                }
                right++;
                left++;
            }
        }
        return false;
    }
}
