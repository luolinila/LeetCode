package 得到K个黑块的最少涂色次数2379;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W'){
                count++;
            }
            right++;
        }
        min = count;
        while (right < blocks.length()) {
            if(blocks.charAt(right) == 'W'){
                count++;
            }
            if(blocks.charAt(left) == 'W'){
                count--;
            }
            min = Math.min(min, count);
            left++;
            right++;
        }
        return min;
    }
}
