package 几乎唯一子数组的最大和2841;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        long sum = 0;
        long max = 0;
        for(int i = 0 ; i < k; i++){
            int n = nums.get(i);
            map.put(n, map.getOrDefault(n, 0) + 1);
            sum += n;
            right++;
        }
        if(map.size() >= m) {
            max = sum;
        }
        while(right < nums.size()){
            int n1 = nums.get(right);
            int n2 = nums.get(left);
            sum += n1;
            sum -= n2;
            map.put(n2, map.getOrDefault(n2, 0) - 1);
            if(map.get(n2) == 0){
                map.remove(n2);
            }
            map.put(n1, map.getOrDefault(n1, 0) + 1);
            left++;
            right++;
            if(map.size() >= m){
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
