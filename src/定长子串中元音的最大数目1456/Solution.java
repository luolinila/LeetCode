package 定长子串中元音的最大数目1456;

public class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        String str = "aeiou";
        for (int i = 0; i < k; i++) {
            if(str.contains(s.charAt(i) + "")) {
                count++;
            }
            right++;
        }
        int temp = count;
        while (right < s.length()) {
            if(str.contains(s.charAt(right) + "")) {
                temp++;
            }
            if(str.contains(s.charAt(left) + "")) {
                temp--;
            }
            count = Math.max(temp, count);
            right++;
            left++;
        }
        return count;
    }
}
