package 接雨水42;

import java.util.Stack;

public class 单调栈法 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public static int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int modelHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int leftHeight = height[stack.peek()];
                int h = Math.min(leftHeight, height[i]) - modelHeight;
                sum += h * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }
}
