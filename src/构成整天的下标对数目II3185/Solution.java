package 构成整天的下标对数目II3185;

import java.util.HashMap;

public class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for (int hour : hours) {
            int temp = hour % 24 + (hour % 24 == 0 ? 24 : 0);
            if(map.containsKey(temp)) {
                count += map.get(temp);
            }
            map.put(24 - (hour % 24), map.getOrDefault(24 - (hour % 24), 0) + 1);
        }
        return count;
    }
}
