package 无重复字符的最长子串3;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }else {
                set.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
