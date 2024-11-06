package 辽宁省ccpc2024省赛.A;

import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String sign = ",.!?";
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int n = sc.nextInt();
        String[] learn = new String[n];
        for (int i = 0; i < n; i++) {
            learn[i] = sc.next();
        }
        for (int i = 0; i < arr.length; i++) {
            if(sign.contains(arr[i].charAt(arr[i].length() - 1) + "")){
                arr[i] = arr[i].substring(0, arr[i].length() - 1);
            }
            arr[i] = arr[i].toUpperCase();
            set.add(arr[i]);
        }
        for (int i = 0; i < n; ++i) {
            learn[i] = learn[i].toUpperCase();
            set.remove(learn[i]);
        }
        System.out.println(set.size());
    }
}
