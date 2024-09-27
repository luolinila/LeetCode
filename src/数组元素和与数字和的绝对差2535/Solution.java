package 数组元素和与数字和的绝对差2535;

public class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (char c : String.valueOf(nums[i]).toCharArray()) {
                num += c - '0';
            }
        }
        return sum - num;
    }
}
