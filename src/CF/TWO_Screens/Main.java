package CF.TWO_Screens;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] strs = new String[n][2];
        for (int i = 0; i < n; i++) {
            strs[i][0] = sc.next();
            strs[i][1] = sc.next();
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < Math.min(strs[i][0].length(), strs[i][1].length()); j++) {
                if (strs[i][0].charAt(j) != strs[i][1].charAt(j)) {
                    break;
                }
                count++;
            }
            arr[i] += strs[i][0].length() + strs[i][1].length() - count + (count == 0 ? 0 : 1);
        }
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
