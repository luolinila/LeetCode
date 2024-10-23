package 石子游戏II1140;

import java.util.Arrays;

public class Solution {
    int[][] sign;
    int[] arr;
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        arr = new int[len];
        arr[len - 1] = piles[len - 1];
        sign = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(sign[i], -1);
        }
        for (int i = len - 2; i >= 0; i--) {
            arr[i] = piles[i] + arr[i + 1];
        }
        return dfs(0, 1);
    }
    public int dfs(int n, int m) {
        if(n + m * 2 >= arr.length) {
            return arr[n];
        }
        if(sign[n][m] != -1) {
            return sign[n][m];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= m * 2; i++) {
            min = Math.min(min, dfs(n + i, Math.max(i, m)));
        }
        int temp = arr[n] - min;
        sign[n][m] = temp;
        return temp;
    }
}
