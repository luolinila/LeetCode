package 子串出现次数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String str = "edgnb";

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (s.charAt(i + j) == str.charAt(j)) {
                    if (j == str.length() - 1) {
                        count++;
                    }
                }else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
