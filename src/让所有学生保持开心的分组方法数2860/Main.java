package 让所有学生保持开心的分组方法数2860;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int countWays(List<Integer> nums) {
        nums.sort(Integer::compare);
        for (Integer num : nums) {
            System.out.println(num);
        }
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if ((i + 1) > nums.get(i) && isOK(nums, i)) {
                count++;
            }
        }
        if (notZero(nums)) {
            count++;
        }
        return count;
    }
    public boolean notZero(List<Integer> nums) {
        for (Integer num : nums) {
            if (num == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isOK (List<Integer> nums, int index) {
        for (int i = index + 1; i < nums.size(); i++) {
            if ((index + 1) >= nums.get(i)) {
                return false;
            }
        }
        return true;
    }
}
