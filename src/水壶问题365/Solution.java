package 水壶问题365;

import java.util.HashSet;

public class Solution {
    boolean sign = false;
    int button1 = 0;
    int button2 = 0;
    HashSet<String> set = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int target) {
        button1 = x;
        button2 = y;
        dfs(x, y, target);
        return sign;
    }
    void dfs(int x, int y, int target) {
        if (sign || x == target || y == target || x + y == target) {
            sign = true;
            return;
        }
        if (set.contains(x + " " + y)) {
            return;
        }
        System.out.println(x + " " + y);
        set.add(x + " " + y);
        dfs(button1, y, target);
        dfs(x, button2, target);
        if (x + y > button1) {
            dfs(button1, y + x - button1, target);
        }else {
            dfs(x + y, 0, target);
        }
        if (y + x > button2) {
            dfs(x + y - button2, button2, target);
        }else {
            dfs(0, x + y, target);
        }
        dfs(x, 0, target);
        dfs(0, y, target);
    }
}
