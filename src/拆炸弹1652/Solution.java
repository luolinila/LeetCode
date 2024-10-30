package 拆炸弹1652;

import java.util.Arrays;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        res = code.clone();
        int sum = 0;
        int left = 0;
        int right = 0;
        if(k > 0) {
            for(int i = 0; i < k; i++) {
                sum += code[i];
                right++;
            }
            res[res.length - 1] = sum;
            for(int i = 0; i < res.length; i++) {
                sum += code[right];
                sum -= code[left];
                res[i] = sum;
                left++;
                left %= code.length;
                right++;
                right %= code.length;
            }
        }else if(k < 0) {
            k = Math.abs(k);
            for(int i = 0; i < k; i++) {
                sum += code[i];
                right++;
            }
            res[k] = sum;
            for(int i = k + 1; i < res.length; i++) {
                sum += code[right];
                sum -= code[left];
                res[i] = sum;
                left++;
                left %= code.length;
                right++;
                right %= code.length;
            }
            for(int i = 0; i < k; i++) {
                sum += code[right];
                sum -= code[left];
                res[i] = sum;
                left++;
                left %= code.length;
                right++;
                right %= code.length;
            }
        }else {
            Arrays.fill(res, 0);
        }
        return res;
    }
}
