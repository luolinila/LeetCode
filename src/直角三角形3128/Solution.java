package 直角三角形3128;

public class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int[] xIndex = new int[grid.length];
        int[] yIndex = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xIndex[i]++;
                    yIndex[j]++;
                }
            }
        }
        long count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += (long) (xIndex[i] - 1) * (yIndex[j] - 1);
                }
            }
        }
        return count;
    }
}
