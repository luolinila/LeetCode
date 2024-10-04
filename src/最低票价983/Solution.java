package 最低票价983;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int day : days) {
            arr.add(day);
        }
        int day30 = (int) (costs[2] / costs[0]) + 1;
        int day7 = (int) (costs[1] / costs[0]) + 1;

        int left = 0;
        int count = 0;
        int sumCount = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] - days[left] + 1 > 30) {
                count = i - left + 1;
                if (count >= day30) {
                    sumCount += costs[2];
                    for (int j = left; j < i; j++) {
                        arr.remove((Integer) days[j]);
                    }
                    left = i;
                    i--;
                } else {
                    left++;
                }
            }
        }
        if (days[days.length - 1] - days[left] + 1 <= 30 && days.length - 1 - left + 1 >= day30) {
            sumCount += costs[2];
            for (int j = left; j < days.length; j++) {
                arr.remove((Integer) days[j]);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(sumCount);
        days = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            days[i] = arr.get(i);
        }
        arr = new ArrayList<>();
        left = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] - days[left] + 1 > 7) {
                count = i - left + 1;
                if (count >= day7) {
                    sumCount += costs[1];
                    for (int j = left; j < i; j++) {
                        arr.remove((Integer) days[j]);
                    }
                    left = i;
                    i--;
                } else {
                    left++;
                }
            }
        }
        if (days[days.length - 1] - days[left] + 1 <= 7 && days.length - 1 - left + 1 >= day7) {
            sumCount += costs[1];
            for (int j = left; j < days.length; j++) {
                arr.remove((Integer) days[j]);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(sumCount);
        sumCount += arr.size() * costs[0];
        return sumCount;
    }
}
