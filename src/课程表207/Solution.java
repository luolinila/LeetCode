package 课程表207;

import 接雨水42.左右双向填补法;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] arr = new int[numCourses][numCourses];
        int[] sign = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            arr[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        int count = numCourses;
        while (count > 0) {
            boolean flag = true;
            for (int i = 0; i < numCourses; i++) {
                if (sign[i]== 0 && sum(arr[i]) == 0) {
                    count--;
                    flag = false;
                    sign[i] = 1;
                    for (int j = 0; j < numCourses; j++) {
                        arr[j][i] = 0;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return count <= 0;
    }
    public int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return 1;
            }
            sum += arr[i];
        }
        return sum;
    }
}
