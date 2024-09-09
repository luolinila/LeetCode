package 颜色分类75;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
    static public void sortColors(int[] nums) {
        int[] temp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < temp[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
