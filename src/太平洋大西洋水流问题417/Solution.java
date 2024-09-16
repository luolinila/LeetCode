package 太平洋大西洋水流问题417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean[][] tpy;
    boolean[][] dxy;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        tpy = new boolean[heights.length][heights[0].length];
        dxy = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, 1);
        }
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, heights[0].length - 1, 0);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, heights.length - 1, i, 0);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (tpy[i][j] && dxy[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    void dfs(int[][] height, int i, int j, int sign) {
        if (i < 0 || j < 0 || i >= tpy.length || j >= tpy[i].length) {
            return;
        }
        if (sign == 0) {
            if (tpy[i][j]) {
                return;
            }
            tpy[i][j] = true;
        }else {
            if (dxy[i][j]) {
                return;
            }
            dxy[i][j] = true;
        }
        if(i - 1 >= 0 && height[i - 1][j] >= height[i][j]) {
            dfs(height, i - 1, j, sign);
        }
        if(j - 1 >= 0 && height[i][j - 1] >= height[i][j]) {
            dfs(height, i, j - 1, sign);
        }
        if(i + 1 < tpy.length && height[i + 1][j] >= height[i][j]) {
            dfs(height, i + 1, j, sign);
        }
        if(j + 1 < tpy[0].length && height[i][j + 1] >= height[i][j]) {
            dfs(height, i, j + 1, sign);
        }
    }
}
