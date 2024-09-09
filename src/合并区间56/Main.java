package 合并区间56;

import java.util.ArrayList;

public class Main {
    public int[][] merge(int[][] intervals) {
        int[] sign = new int[10001];
        boolean[] flag = new boolean[10001];
        for (int i = 0; i < intervals.length; i++) {
            flag[intervals[i][0]] = true;
            sign[intervals[i][0]] ++;
            sign[intervals[i][1]] --;
        }
        ArrayList<Integer[]> res = new ArrayList<>();
        for (int i = 0; i < sign.length; i++) {
            if (sign[i] > 0 || flag[i]) {
                int temp = 0;
                for (int j = i; j < sign.length; j++) {
                    temp += sign[j];
                    if (temp == 0) {
                        res.add(new Integer[]{i, j});
                        i = j;
                        break;
                    }
                }
            }
        }
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArr[i][0] = res.get(i)[0];
            resArr[i][1] = res.get(i)[1];
        }
        return resArr;
    }
}
