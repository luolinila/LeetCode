package 串联所有单词的子串30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashSet<String> remember =  new HashSet<>();
        int len = words.length * words[0].length();
        if(s.length() < len) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> mapArr = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            mapArr.put(words[i], mapArr.getOrDefault(words[i], 0) + 1);
        }
        int left = 0;
        int right = 0;
        String string = "";
        for(int i = 0; i < len; i++) {
            right++;
            string += s.charAt(i);
        }
        if(compareSet(string, mapArr, words[0].length())) {
            res.add(left);
            remember.add(string);
        }
        while(right < s.length()) {
            string += s.charAt(right);
            string = string.substring(1);
            right++;
            left++;
            if(remember.contains(string)) {
                res.add(left);
                continue;
            }
            if(compareSet(string, mapArr, words[0].length())) {
                res.add(left);
                remember.add(string);
            }
        }
        return res;
    }
    public boolean compareSet(String s, HashMap<String, Integer> set, int baseSize) {
        ArrayList<String> map1 = new ArrayList<>();
        while (!s.isEmpty()) {
            String temp = s.substring(0, baseSize);
            map1.add(temp);
            s = s.substring(baseSize);
        }
        HashMap<String, Integer> map2 = new HashMap<>(set);
        for(String map : map1) {
            if(map2.containsKey(map)) {
                map2.put(map, map2.getOrDefault(map, 0) - 1);
                if(map2.get(map) <= 0) {
                    map2.remove(map);
                }
            }else {
                return false;
            }
        }
        if(map2.isEmpty()) {
            return true;
        }
        return false;
    }
}
