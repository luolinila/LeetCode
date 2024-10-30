package 交换后字典序最小的字符串3216;

public class Solution {
    public String getSmallestString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                if(Integer.parseInt(s.charAt(i)+"") % 2 != Integer.parseInt(s.charAt(i+1)+"") % 2){
                    continue;
                }
                char[] chars = s.toCharArray();
                chars[i] = s.charAt(i + 1);
                chars[i + 1] = s.charAt(i);
                return String.valueOf(chars);
            }
        }
        return s;
    }
}
