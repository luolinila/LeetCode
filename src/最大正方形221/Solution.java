package 最大正方形221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] arr = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int min = matrix[i - 1][j - 1];
                min = Math.min(min, matrix[i - 1][j]);
                min = Math.min(min, arr[i][j - 1]);
                arr[i][j] = min + matrix[i - 1][j - 1];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max * max;
    }
}
