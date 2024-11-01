package 不包含相邻元素的子序列的最大和3165;

public class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < queries.length; i++) {
            nums[queries[i][0]] = queries[i][1];
            int[][] arr = new int[nums.length][2];
            int max = Integer.MIN_VALUE;
            arr[0][0] = 0;
            arr[0][1] = nums[0];
            max = Math.max(max, arr[0][0]);
            max = Math.max(max, arr[0][1]);
            for (int j = 1; j < nums.length; j++) {
                arr[j][0] = Math.max(arr[j - 1][0], arr[j - 1][1]);
                arr[j][1] = arr[j - 1][0] + nums[j];
                max = Math.max(max, arr[j][0]);
                max = Math.max(max, arr[j][1]);
            }
            sum += max;
            sum %= 1000000007;
        }
        return sum;
    }
}
