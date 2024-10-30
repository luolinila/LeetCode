package 拼车1094;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[trips.length];
        for (int i = 0; i < trips.length; i++) {
            arr[trips[i][1]] += trips[i][0];
            arr[trips[i][2]] -= trips[i][0];
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}
