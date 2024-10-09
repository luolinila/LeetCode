package 考试;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }
        System.out.println(arr[0][0]);
    }
}