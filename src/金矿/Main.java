package 金矿;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    boolean[][] visited = new boolean[m][n];
                    maxGold = Math.max(dfs(grid, i, j, visited), maxGold);
                }
            }
        }
        System.out.println(maxGold);
    }
    private static int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y]) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        visited[x][y] = true;
        int max = 0;
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            int temp = dfs(grid, newX, newY, visited);
            max = Math.max(temp, max);
        }
        visited[x][y] = false;
        return max + grid[x][y];
    }
}
