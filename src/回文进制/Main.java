package 回文进制;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String m = scanner.next();
        String huiWen = huiWen(m);
        int step = 0;
        while (step <= 30 && huiWen.compareTo(m) != 0) {
            m = Integer.toString(Integer.parseInt(m, n) + Integer.parseInt(huiWen, n), n);
            huiWen = huiWen(m);
            step++;
        }
        System.out.println(step > 31 ? -1 : step);
    }
    static public String huiWen(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}
