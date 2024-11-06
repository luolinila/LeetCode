package 找到一个数字的K美丽值2269;

public class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        String str = "";
        int right = 0;
        for (int i = 0; i < k; i++) {
            str += s.charAt(i);
            right++;
        }
        int count = 0;
        int n = Integer.parseInt(str);
        if(num % n == 0) {
            count++;
        }
        while (right < s.length()) {
            str += s.charAt(right);
            str = str.substring(1);
            right++;
            n = Integer.parseInt(str);
            if(n == 0) {
                continue;
            }
            if(num % n == 0) {
                count++;
            }
        }
        return count;
    }
}
