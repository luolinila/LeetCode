package 生命游戏289;

public class Main {
    public void gameOfLife(int[][] board) {
        int[][] arr = new int[board.length + 2][board[0].length + 2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    arr[i][j] ++;
                    arr[i][j + 1] ++;
                    arr[i][j + 2] ++;
                    arr[i + 1][j] ++;
                    arr[i + 1][j + 2] ++;
                    arr[i + 2][j] ++;
                    arr[i + 2][j + 1] ++;
                    arr[i + 2][j + 2] ++;
                }
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 2) {
                    continue;
                }
                if (arr[i][j] == 3) {
                    board[i - 1][j - 1] = 1;
                }else {
                    board[i - 1][j - 1] = 0;
                }
            }
        }
    }
}
