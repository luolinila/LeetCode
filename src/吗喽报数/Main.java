package 吗喽报数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 1;
        int position = 0;
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
        System.out.println();
        while (list.size() > 1) {
            if (count == m ) {
                list.remove(position);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println();
                count = 1;
            }else {
                position++;
                count++;
            }
            if (position >= list.size()) {
                position = 0;
            }
        }
        System.out.println(list.get(0));
    }
}
