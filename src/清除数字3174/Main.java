package 清除数字3174;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public String clearDigits(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stack.push(c);
            }
            if (c >= '0' && c <= '9' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder output = new StringBuilder();
        for (Character c : stack) {
            output.insert(0, c);
        }
        return output.toString();
    }
}
