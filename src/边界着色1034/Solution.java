package 边界着色1034;

public class Solution {
    boolean[][] sign;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        sign = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, color, grid[row][col]);
        return grid;
    }
    void dfs(int[][] grid, int row, int col, int color, int startColor) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != startColor || sign[row][col]) {
            return;
        }
        sign[row][col] = true;
        if (row - 1 >= 0 && grid[row - 1][col] == startColor) {
            dfs(grid, row - 1, col, color, startColor);
        }else {
            if (row - 1 < 0 || !sign[row - 1][col]) {
                grid[row][col] = color;
            }
        }
        if (row + 1 < grid.length && grid[row + 1][col] == startColor) {
            dfs(grid, row + 1, col, color, startColor);
        }else {
            if (row + 1 >= grid.length || !sign[row + 1][col]) {
                grid[row][col] = color;
            }
        }
        if (col - 1 >= 0 && grid[row][col - 1] == startColor) {
            dfs(grid, row, col - 1, color, startColor);
        }else {
            if (col - 1 < 0 || !sign[row][col - 1]) {
                grid[row][col] = color;
            }
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == startColor) {
            dfs(grid, row, col + 1, color, startColor);
        }else {
            if (col + 1 >= grid[0].length || !sign[row][col + 1]) {
                grid[row][col] = color;
            }
        }
    }
}
