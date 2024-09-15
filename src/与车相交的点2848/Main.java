package 与车相交的点2848;

import java.util.List;

public class Main {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] arr = new int[101];
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++ ) {
                arr[i] ++;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) count++;
        }
        return count;
    }
}
