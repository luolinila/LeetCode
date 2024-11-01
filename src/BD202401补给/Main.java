package BD202401补给;

import java.util.Scanner;
import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int b = input.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = input.nextInt();
            arr[i][1] = input.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(b - arr[i][0] - arr[i][1] >= 0) {
                count++;
                b -= (arr[i][0] + arr[i][1]);
            }else {
                if(b >= (int)(arr[i][0] / 2) + arr[i][1]) {
                    count++;
                }
                break;
            }
        }
        System.out.println(count);
        input.close();
    }
}
