package 子串的最大出现次数1297;

import java.util.HashMap;

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> allStr = new HashMap<>();
        for (int i = minSize; i <= maxSize; i++) {
            int left = 0;
            int right = 0;
            String str = "";
            HashMap<Character, Integer> kindMap = new HashMap<>();
            for(int j = 0; j < i; j++) {
                str = str + s.charAt(j);
                kindMap.put(s.charAt(j), kindMap.getOrDefault(s.charAt(j), 0) + 1);
                right++;
            }
            if(kindMap.size() <= maxLetters) {
                allStr.put(str, allStr.getOrDefault(str, 0) + 1);
            }
            while (right < s.length()) {
                str = str + s.charAt(right);
                str = str.substring(1);
                kindMap.put(s.charAt(right), kindMap.getOrDefault(s.charAt(right), 0) + 1);
                kindMap.put(s.charAt(left), kindMap.getOrDefault(s.charAt(left), 0) - 1);
                if(kindMap.get(s.charAt(left)) == 0) {
                    kindMap.remove(s.charAt(left));
                }
                left++;
                right++;
                if(kindMap.size() <= maxLetters) {
                    allStr.put(str, allStr.getOrDefault(str, 0) + 1);
                }
            }
        }
        int max = 0;
        for (String key : allStr.keySet()) {
            max = Math.max(max, allStr.get(key));
        }
        return max;
    }
}
