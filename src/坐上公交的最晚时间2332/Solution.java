package 坐上公交的最晚时间2332;

import java.util.Arrays;

public class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int num = 0;
        int count = 0;
        for (Integer bus : buses) {
            count = capacity;
            while (count > 0 && num < passengers.length && passengers[num] <= bus) {
                num++;
                count--;
            }
        }
        num--;
        int temp = count > 0 ? buses[buses.length - 1] : passengers[num];
        while (num >= 0 && temp == passengers[num]) {
            temp--;
            num--;
        }
        return temp;
    }
}
