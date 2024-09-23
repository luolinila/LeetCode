package 找到小镇的法官997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][1]][0]++;
            arr[trust[i][0]][1]++;
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
        for (int i = 1; i < n + 1; i++) {
            if (arr[i][0] == n - 1 && arr[i][1] == 0) {
                if (index != -1) {
                    return -1;
                }
                index = i;
            }
        }
        return index;
    }
}
