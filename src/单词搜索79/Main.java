package 单词搜索79;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    Deque<String> stack = new LinkedList<>();
    public boolean exist(char[][] board, String word) {
        for (Character c : word.toCharArray()) {
            stack.push(String.valueOf(c));
        }
        return false;
    }
}
