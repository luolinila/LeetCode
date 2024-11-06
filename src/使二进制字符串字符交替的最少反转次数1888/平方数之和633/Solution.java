package 使二进制字符串字符交替的最少反转次数1888.平方数之和633;

import java.util.HashSet;

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i * i <= c / 2; i++) {
            int n = (int)Math.sqrt(c - i * i);
            if(i * i + n * n == c) {
                return true;
            }
        }
        return false;
    }
}
