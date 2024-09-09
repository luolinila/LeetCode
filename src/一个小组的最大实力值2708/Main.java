package 一个小组的最大实力值2708;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{6,-3,-4,8,4,7,6,4,7,7,-3,-6,9}));
    }
    static public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                count++;
                if (Math.abs(nums[index]) > Math.abs(nums[i]) || nums[index] >= 0) {
                    index = i;
                }
            }
        }
        if (count % 2 != 0) {
            nums[index] = 0;
        }
        if (allZero(nums)) {
            return 0;
        }else {
            long sum = 1;
            for (int i : nums) {
                if (i == 0) {
                    continue;
                }
                sum *= i;
            }
            return sum;
        }
    }
    static public boolean allZero(int[] arr) {
        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
