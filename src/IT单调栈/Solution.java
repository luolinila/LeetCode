package IT单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num2.length; i++) {
            for (int j = i + 1; j < num2.length; j++) {
                if(num2[i] < num2[j]) {
                    map.put(num2[i], num2[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < num1.length; i++) {
            System.out.print(map.getOrDefault(num1[i], -1) + " ");
        }
    }
}
