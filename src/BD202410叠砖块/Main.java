package BD202410叠砖块;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < k; i++) {
            int a = input.nextInt();
            a--;
            int b = input.nextInt();
            arr[a] += 1;
            if (b != arr.length) {
                arr[b] -= 1;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = arr[0];
            }else {
                res[i] = res[i - 1] + arr[i];
            }
        }
        Arrays.sort(res);
        System.out.print(res[n / 2]);
        input.close();
    }
}
