package 大小为K且平均值大于等于阈值的子数组数目1343;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        double avg = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < k; i++) {
            avg += arr[i] * 1.0 / k;
            right++;
        }
        if(avg >= threshold){
            count++;
        }
        while (right < arr.length) {
            avg += arr[right] * 1.0 / k;
            avg -= arr[left] * 1.0 / k;
            if(avg >= threshold){
                count++;
            }
            left++;
            right++;
        }
        return count;
    }
}
