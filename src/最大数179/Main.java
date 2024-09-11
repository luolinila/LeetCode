package 最大数179;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if((o1 + o2).compareTo(o2 + o1) > 0) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        if (allZero(sb.toString())) {
            return "0";
        }
        return sb.toString();
    }
    boolean allZero(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
