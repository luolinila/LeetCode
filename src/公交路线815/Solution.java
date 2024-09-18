package 公交路线815;

import java.util.HashMap;
import java.util.HashSet;


//作废
public class Solution {
    HashMap<Integer, HashSet<int[]>> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    public int numBusesToDestination(int[][] routes, int source, int target) {
        for (int[] route : routes) {
            for (int i: route) {
                if (!map.containsKey(i)) {
                    map.putIfAbsent(i, new HashSet<>());
                }
                HashSet<int[]> set = map.get(i);
                set.add(route);
                map.put(i, set);
            }
        }
        for (int[] arr: map.get(source)) {
          dfs(source, target, 0, arr);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    void dfs(int source, int target, int count, int[] arr) {
        if (source == target) {
            min = Math.min(min, count);
            return;
        }
        for (int[] i: map.get(source)) {
            System.out.println(i == arr);
            if (i == arr) {
                continue;
            }
            for (int j : i) {
                if (source == j) {
                    continue;
                }
                dfs(j, target, count + 1, i);
            }
        }
    }
}
