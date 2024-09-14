package 被围绕的区域130;

public class Main {
    boolean[][] sign;
    public void solve(char[][] board) {
        sign = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !sign[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs (char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || sign[i][j]) return;
        sign[i][j] = true;
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
