package 购物NC14526;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] sum = new int[310][310];
        int[][] dp = new int[310][310];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 310; i++) {
            Arrays.sort(sum[i], 1,1 + m);
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = i; j <= Math.min(i * m, n); j++) {
                for(int k = Math.max(i - 1, j - m); k <= Math.min((i - 1) * m, j); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + sum[i][j - k] + (j - k) * (j - k));
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
