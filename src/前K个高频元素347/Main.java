package 前K个高频元素347;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (int num : map.keySet()) {
            res[index][0] = num;
            res[index][1] = map.get(num);
            index++;
        }
        Arrays.sort(res, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = res[i][0];
        }
        return result;
    }
}
