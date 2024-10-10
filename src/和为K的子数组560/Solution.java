package 和为K的子数组560;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(k == arr[j] - (i == 0 ? 0 : arr[i - 1])) {
                    count++;
                }
            }
        }
        return count;
    }
}
