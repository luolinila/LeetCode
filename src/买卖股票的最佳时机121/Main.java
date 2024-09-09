package 买卖股票的最佳时机121;

public class Main {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] arr = new int[prices.length];
        arr[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            arr[i] = Math.min(arr[i - 1], prices[i]);
            max = Math.max(max, prices[i] - arr[i]);
        }
        return max;
    }
}
