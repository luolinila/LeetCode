package 可获得的最大点数1423;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int all = 0;
        k = cardPoints.length - k;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            right++;
            all += cardPoints[i];
        }
        min = sum;
        while (right < cardPoints.length) {
            sum += cardPoints[right];
            all += cardPoints[right];
            sum -= cardPoints[left];
            min = Math.min(min, sum);
            left++;
            right++;
        }
        return all - min;
    }
}
