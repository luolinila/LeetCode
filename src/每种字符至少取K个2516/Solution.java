package 每种字符至少取K个2516;

public class Solution {
    public int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        int[] now = new int[3];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[chars[i] - 'a']++;
        }
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] - now[chars[i] - 'a'] - 1 >= k) {
                now[chars[i] - 'a']++;
                maxLength = Math.max(maxLength, i - left + 1);
            }else {
                if (left != i) {
                    now[chars[left] - 'a']--;
                    i--;
                }
                left++;
            }
        }
        for (Character c : new Character[]{'a', 'b', 'c'}) {
            if (arr[c - 'a'] - now[c - 'a'] < k) {
                return -1;
            }
        }
        return s.length() - maxLength;
    }
}
