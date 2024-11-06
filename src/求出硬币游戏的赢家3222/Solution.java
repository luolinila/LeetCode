package 求出硬币游戏的赢家3222;

public class Solution {
    public String losingPlayer(int x, int y) {
        boolean flag = false;
        while (x >= 1 && y >= 4) {
            x -= 1;
            y -= 4;
            flag = !flag;
        }
        if (!flag) {
            return "Bob";
        }else {
            return "Alice";
        }
    }
}
