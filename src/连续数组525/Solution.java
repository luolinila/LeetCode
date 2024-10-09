package 连续数组525;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int temp = 0;
        map.put(0, 0);
        System.out.print("0 ");
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 1) {
                temp++;
            }else {
                temp--;
            }
            System.out.print(temp + " ");
            if (map.containsKey(temp)) {
                max = Math.max(max, i - map.get(temp));
            }else {
                map.put(temp, i);
            }
        }
        return max;
    }
}
