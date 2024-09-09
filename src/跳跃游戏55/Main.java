package 跳跃游戏55;

public class Main {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
    }
    static Boolean[] dp;
    static int[] arr;
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        dp = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = false;
        }
        arr = nums;
        gx(nums.length - 1);
        dfs(nums.length - 1);
        return dp[0];
    }
    static void dfs(int n) {
        if(dp[0]) {
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            if(dp[i]) {
                gx(i);
                dfs(i);
            }
        }
    }
    static void gx(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n - i) {
                dp[i] = true;
            }else {
                dp[i] = false;
            }
        }
    }
}
