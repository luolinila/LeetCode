package 统计特殊整数2376;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int countSpecialNumbers(int n) {
        String nStr = String.valueOf(n);
        int res = 0;
        int prod = 9;
        for (int i = 0; i < nStr.length() - 1; i++) {
            res += prod;
            prod *= 9 - i;
        }
        res += dp(0, false, nStr);
        return res;
    }

    public int dp(int mask, boolean prefixSmaller, String nStr) {
        if (Integer.bitCount(mask) == nStr.length()) {
            return 1;
        }
        int key = mask * 2 + (prefixSmaller ? 1 : 0);
        if (!memo.containsKey(key)) {
            int res = 0;
            int lowerBound = mask == 0 ? 1 : 0;
            int upperBound = prefixSmaller ? 9 : nStr.charAt(Integer.bitCount(mask)) - '0';
            for (int i = lowerBound; i <= upperBound; i++) {
                if (((mask >> i) & 1) == 0) {
                    res += dp(mask | (1 << i), prefixSmaller || i < upperBound, nStr);
                }
            }
            memo.put(key, res);
        }
        return memo.get(key);
    }
}
