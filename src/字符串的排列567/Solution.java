package 字符串的排列567;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> s2Map = new HashMap<>();
        int left = 0, right = 0;
      //  String s = "";
        for (int i = 0; i < s1.length(); ++i) {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            right++;
           // s = s + s2.charAt(i);
        }
        if(compare(s1Map, s2Map)) return true;
        while (right < s2.length()) {
//            s = s + s2.charAt(right);
//            s = s.substring(1);
//            System.out.println(s);
            s2Map.put(s2.charAt(right), s2Map.getOrDefault(s2.charAt(right), 0) + 1);
            s2Map.put(s2.charAt(left), s2Map.getOrDefault(s2.charAt(left), 0) - 1);
            if(compare(s1Map, s2Map)) return true;
            left++;
            right++;
        }
        return false;
    }
    public boolean compare(HashMap<Character, Integer> s1, HashMap<Character, Integer> s2) {
        for (char c : s1.keySet()) {
            if (!s2.containsKey(c)) {
                return false;
            }
            if(s1.get(c) > s2.get(c)) {
                return false;
            }
        }
        return true;
    }
}
