package IT单调栈;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        int[] out = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            int max = -1;
            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]) {
                    for (int k = j + 1; k < num2.length; k++) {
                        if (num2[k] > num1[i]) {
                            max = k;
                        }
                    }
                    break;
                }
            }
            out[i] = max;
        }
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }
}
