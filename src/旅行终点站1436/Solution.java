package 旅行终点站1436;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String start = paths.get(0).get(0);
        while (map.containsKey(start)) {
            start = map.get(start);
        }
        return start;
    }
}
