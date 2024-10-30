package 爱生气的书店老板1052;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int allSum = 0;
        int sqSum = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < customers.length; i++) {
            allSum += customers[i];
            customers[i] *= grumpy[i];
            sqSum += customers[i];
            if(i < minutes) {
                count += customers[i];
                right++;
            }
        }
        int temp = count;
        while (right < customers.length) {
            temp += customers[right];
            temp -= customers[left];
            count = Math.max(temp, count);
            left++;
            right++;
        }
        return allSum - sqSum + count;
    }
}
