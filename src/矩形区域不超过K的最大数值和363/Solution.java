package 矩形区域不超过K的最大数值和363;

import java.util.Arrays;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] arr = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 0;
        }
        Arrays.fill(arr[0], 0);
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                arr[i][j] = matrix[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                for (int g = 0; g < i; g++) {
                    for (int l = 0; l < j; l++) {
                        int temp = arr[i][j] - arr[i][l] - arr[g][j] + arr[g][l];
                        if (temp <= k) {
                            max = Math.max(max, temp);
                        }
                    }
                }
            }
        }
        return max;
    }
}
