package 有效的数独36;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (list.contains(board[i][j])) {
                    return false;
                }
                list.add(board[i][j]);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            ArrayList<Character> list = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (list.contains(board[j][i])) {
                    return false;
                }
                list.add(board[j][i]);
            }
        }
        ArrayList[] lists = new ArrayList[9];
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Character>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i < 3 && j < 3) {
                    if (lists[0].contains(board[i][j])) {
                        return false;
                    }
                    lists[0].add(board[i][j]);
                }
                if (i < 3 && (j >= 3 && j < 6)) {
                    if (lists[1].contains(board[i][j])) {
                        return false;
                    }
                    lists[1].add(board[i][j]);
                }
                if (i < 3 && j >= 6) {
                    if (lists[2].contains(board[i][j])) {
                        return false;
                    }
                    lists[2].add(board[i][j]);
                }
                if ((i >= 3 && i < 6) && j < 3) {
                    if (lists[3].contains(board[i][j])) {
                        return false;
                    }
                    lists[3].add(board[i][j]);
                }
                if ((i >= 3 && i < 6) && (j >= 3 && j < 6)) {
                    if (lists[4].contains(board[i][j])) {
                        return false;
                    }
                    lists[4].add(board[i][j]);
                }
                if ((i >= 3 && i < 6) && j >= 6) {
                    if (lists[5].contains(board[i][j])) {
                        return false;
                    }
                    lists[5].add(board[i][j]);
                }
                if(i >= 6 && j < 3) {
                    if (lists[6].contains(board[i][j])) {
                        return false;
                    }
                    lists[6].add(board[i][j]);
                }
                if(i >= 6 && (j >= 3 && j < 6)) {
                    if (lists[7].contains(board[i][j])) {
                        return false;
                    }
                    lists[7].add(board[i][j]);
                }
                if(i >= 6 && j >= 6) {
                    if (lists[8].contains(board[i][j])) {
                        return false;
                    }
                    lists[8].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
