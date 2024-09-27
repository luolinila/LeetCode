package BD202420魔法石;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int[] arr = new int[n];
        int count = 0;
        int length = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            if (i != 0 && arr[i] != arr[i - 1]) {
                length = Math.max(length, count);
                count = 1;
            }else {
                count++;
            }
        }
        length = Math.max(length, count);
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = 0; j < n; j++) {
            for (int i = j; i < n; i++) {
                if (map.size() == 2 && !map.containsKey(arr[i])) {
                    for (Integer key : map.keySet()) {
                        max = Math.max(max, map.get(key));
                    }
                    map = new HashMap<>();
                    break;
                }else {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }
            }
            for (Integer key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }
            map = new HashMap<>();
        }
        System.out.println(max - length);
        input.close();
    }
}
