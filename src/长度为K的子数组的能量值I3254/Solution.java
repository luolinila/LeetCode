package 长度为K的子数组的能量值I3254;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, -1);
        int left = 0;
        int right = 0;
        ArrayList<Integer> nowArr = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            nowArr.add(nums[i]);
            right++;
        }
        if(isOK(nowArr)) {
            res[0] = nums[right - 1];
        }
        while(right < nums.length) {
            nowArr.add(nums[right]);
            nowArr.remove(0);
            left++;
            if(isOK(nowArr)) {
                res[left] = nums[right];
            }
            right++;
        }
        return res;
    }
    public boolean isOK(ArrayList<Integer> nums) {
        for(int i = 0; i  < nums.size() - 1; i++) {
            if(nums.get(i) != nums.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }
}
