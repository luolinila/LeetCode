package 省份数量547;

import java.util.HashSet;

public class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            count++;
            dfs(isConnected, i);
        }
        return count;
    }
    void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected[0].length; j++) {
            if(isConnected[i][j] == 1 && !set.contains(j)) {
                set.add(j);
                dfs(isConnected, j);
            }
        }
    }
}
