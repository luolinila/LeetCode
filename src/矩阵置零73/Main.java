package 矩阵置零73;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> xSet = new HashSet<>();
        HashSet<Integer> ySet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }
        for (Integer x : xSet) {
            Arrays.fill(matrix[x], 0);
        }
        for (Integer y : ySet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
