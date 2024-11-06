package 找到字符串中所有字母异位词438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        int left = 0, right = 0;
        for(int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            right++;
        }
        if (compare(pMap, sMap)) {
            ans.add(left);
        }
        while(right < s.length()) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
            right++;
            left++;
            if(compare(pMap, sMap)) {
                ans.add(left);
            }
        }
        return ans;
    }
    public boolean compare(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for(Character c : map1.keySet()) {
            if(!map2.containsKey(c)) {
                return false;
            }
            if(map1.get(c) > map2.get(c)) {
                return false;
            }
        }
        return true;
    }
}
