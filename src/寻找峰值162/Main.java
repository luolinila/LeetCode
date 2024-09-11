package 寻找峰值162;

public class Main {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] > nums[i - 1])&&(i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }
}
