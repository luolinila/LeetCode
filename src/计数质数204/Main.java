package 计数质数204;

public class Main {
    public int countPrimes(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(dp[i] != 0) {
                continue;
            }
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
            count++;
            for (int j = i; j <= n; j += i) {
                dp[j] = i;
            }
        }
        return count;
    }
}
