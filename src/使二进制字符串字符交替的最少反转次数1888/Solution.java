package 使二进制字符串字符交替的最少反转次数1888;

public class Solution {
    public int minFlips(String s) {
        int len = s.length();
        String a = "";
        String b = "";
        for (int i = 0; i < len; i++) {
            a = a + (i % 2);
            b = b + ((i + 1) % 2);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int counta = 0;
            int countb = 0;
            for (int j = 0; j < len; j++) {
                if(a.charAt(j) != s.charAt((i + j) % len)){
                    counta++;
                }
                if(b.charAt(j) != s.charAt((i + j) % len)){
                    countb++;
                }
            }
            min = Math.min(min, Math.min(counta, countb));
        }
        return min;
    }
}
