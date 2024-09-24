package 字符串中最多数目的子序列2207;

public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long aCount = 0;
        long bCount = 0;
        long count = 0;
        for(int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(1)) {
                bCount++;
                count += aCount;
            }
            if (text.charAt(i) == pattern.charAt(0)) {
                aCount++;
            }
        }
        return (long) count + Math.max(aCount, bCount);
    }
}
