package 接雨水42;

public class 左右双向填补法 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2}));
    }
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0 ) {
                continue;
            }
            int temp = 0;
            int[] tempArray = height.clone();
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] < height[i]) {
                    temp += (height[i] - height[j]);
                    tempArray[j] = tempArray[i];
                }else {
                    sum += temp;
                    height = tempArray.clone();
                    i = j - 1;
                    break;
                }
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] == 0 ) {
                continue;
            }
            int temp = 0;
            int[] tempArray = height.clone();
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] < height[i]) {
                    temp += (height[i] - height[j]);
                    tempArray[j] = tempArray[i];
                }else {
                    sum += temp;
                    height = tempArray.clone();
                    i = j + 1;
                    break;
                }
            }
        }
        return sum;
    }
}
