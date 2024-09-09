package 统计单词个数;

import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        String str = "dadw dawdwda dadawd ad ad adwd";
        String find = "ad";
        String[] strs = str.split(" ");
        int count = 0;
        int index = strs.length - 1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].compareTo(find) == 0) {
                count++;
                index = Math.min(index, index);
            }
        }
        System.out.println(count == 0 ? -1 : (count + " " + index));
    }
}
