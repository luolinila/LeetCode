package 灯泡开关Ⅱ672;

import java.util.HashSet;

public class Solution {
    boolean[] sign;
    HashSet<String> set = new HashSet<>();
    HashSet<String> haveSet = new HashSet<>();
    public int flipLights(int n, int presses) {
        sign = new boolean[n + 1];
        dfs(sign, presses, -1);
        return set.size();
    }
    void dfs (boolean[] arr, int count, int sign) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            str.append(arr[i] ? '1' : '0');
        }
        String s = str.toString();
        if (haveSet.contains(sign + s)) {
            return;
        }
        haveSet.add(sign + s);
        if (set.size() == Math.pow(2, arr.length - 1)) {
            return;
        }
        if(count <= 0) {
            System.out.println(sign + s);
            set.add(str.toString());
            return;
        }
        for(int i = 0; i < 4; i++) {
            boolean[] flag = arr.clone();
            if (i == 0) {
                for (int j = 1; j < arr.length; j++) {
                    flag[j] = !flag[j];
                }
            }
            if (i == 1) {
                for (int j = 1; j < arr.length; j++) {
                    if (j % 2 == 0) {
                        flag[j] = !flag[j];
                    }
                }
            }
            if (i == 2) {
                for (int j = 1; j < arr.length; j++) {
                    if (j % 2 != 0) {
                        flag[j] = !flag[j];
                    }
                }
            }
            if (i == 3) {
                for (int j = 1; j < arr.length; j += 3) {
                    flag[j] = !flag[j];
                }
            }
            dfs(flag, count - 1, i);
        }
    }
}
