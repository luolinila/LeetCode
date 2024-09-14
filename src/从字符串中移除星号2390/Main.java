package 从字符串中移除星号2390;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
