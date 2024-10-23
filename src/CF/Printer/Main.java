package CF.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] data = new int[n][3];
            for(int j = 0; j < n; j++) {
                data[j][0] = scanner.nextInt();
                data[j][1] = scanner.nextInt();
                data[j][2] = scanner.nextInt();
            }
            long left = 0;
            long right = 1;
            for(int j = 0; j < 18; j++) {
                right *= 10;
            }
            while (left <= right) {
                long mid = (left + right) >> 1;
                if (isOK(mid, data, k)) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
    private static boolean isOK(long mid, int[][] data, int k) {
        long sum = 0;
        for (int i = 0; i < data.length; i++) {
            long q = mid /((long) data[i][0] * data[i][1] + data[i][2]);
            long r = mid % ((long) data[i][0] * data[i][1] + data[i][2]);
            sum += q * data[i][1] + Math.min(r / data[i][0], data[i][1]);
            if(sum >= k) {
                return true;
            }
        }
        return false;
    }
}
