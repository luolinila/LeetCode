package 接雨水42;

public class 逐层填补法 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,2}));
    }
    public static int trap(int[] height) {
        int sum = 0;
        height = chuLing(height);
        while (height.length > 1) {
            for (int i = 0; i < height.length; i++) {
                if(height[i] < 1) {
                    sum ++;
                }else {
                    height[i] --;
                }
            }
            height = chuLing(height);
        }
        return sum;
    }
    public static int[] chuLing(int[] in) {
        int left = 0, right = in.length - 1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] != 0) {
                left = i;
                break;
            }
        }
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] != 0) {
                right = i;
                break;
            }
        }
        int[] out = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            out[i - left] = in[i];
        }
        int count = 0;
        for (int i: out) {
            count += i;
        }
        if (count == 0) {
            return new int[0];
        }
        return out;
    }
}
