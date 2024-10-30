package 检查一个字符串是否包含所有长度为K的二进制子串1461;

import java.util.HashMap;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k > s.length()) return false;
        HashMap<Long, Integer> map = new HashMap<>();
        String str = s.substring(0, k);
        long n = Integer.parseInt(str, 2);
        map.put(n, 1);
        int right = k;
        int a = (int) Math.pow(2, k);
        while (right < s.length()) {
            n = n << 1;
            n += (s.charAt(right) - '0');
            n %= a;
            map.put(n, 1);
            right++;
        }
        for(long i = 0; i < Math.pow(2, k); ++i) {
            if(!map.containsKey(i)) {
                return false;
            }
        }
        return true;
    }
}
