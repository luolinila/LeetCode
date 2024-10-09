package 除自身以外数组的乘积238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] front = new int[nums.length + 1];
        int[] rear = new int[nums.length + 1];
        front[0] = 1;
        rear[rear.length - 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            front[i] = nums[i - 1] * front[i - 1];
            rear[rear.length - 1 - i] = nums[rear.length - 1 - i] * rear[rear.length - i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = front[i] * rear[i + 1];
        }
        return ans;
    }
}
