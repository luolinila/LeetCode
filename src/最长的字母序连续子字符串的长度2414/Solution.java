package 最长的字母序连续子字符串的长度2414;

public class Solution {
    public int longestContinuousSubstring(String s) {
        int left = 0;
        int maxLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1) + 1) {
                maxLength = Math.max(maxLength, i - left + 1);
            }else {
                left = i;
            }
        }
        return maxLength;
    }
}
