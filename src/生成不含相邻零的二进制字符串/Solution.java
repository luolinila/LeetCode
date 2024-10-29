package 生成不含相邻零的二进制字符串;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < Math.pow(2, n); i++) {
            int temp = i;
            int sign = 1;
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                int next = temp % 2;
                if(sign == 0 && next == 0) {
                    flag = false;
                    break;
                }
                sign = next;
                temp = temp >> 1;
            }
            if(flag) {
                res.add(String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0'));
            }
        }
        return res;
    }
}
