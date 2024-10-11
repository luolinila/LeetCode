package 优质数对的总数II3164;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i] % k == 0) {
                int temp = nums1[i] / k;
                map1.put(temp, (map1.getOrDefault(temp, 0) + 1));
            }
        }
        if(map1.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        long count = 0;
        int max = Collections.max(map1.keySet());
        for (Integer key2 : map2.keySet()) {
            int temp = map2.get(key2);
            for (int i = key2; i <= max; i += key2) {
                if (map1.containsKey(i)) {
                    count += (long) map1.get(i) * temp;
                }
            }
        }
        return count;
    }
}
