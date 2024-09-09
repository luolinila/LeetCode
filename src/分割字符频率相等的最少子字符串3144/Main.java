package 分割字符频率相等的最少子字符串3144;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        HashSet<String> phStrs = new HashSet<>();
        String lastStr = new String();
        String str = new String();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt(i);
            if(isPH(str + s.charAt(i)) || phStrs.contains(str + s.charAt(i))) {
                phStrs.add(str + s.charAt(i));
            }else {
                if (isPH(lastStr + str)) {
                    phStrs.add(lastStr + str);
                    lastStr += str;
                }else {
                    phStrs.add(str);
                    lastStr = str;
                    count ++;
                }
                str = new String();
            }
        }

        System.out.println(count);
    }



    public static boolean isPH(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else   map.put(c, 1);
        }
        int count = map.get(str.charAt(0));
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            if (entry.getValue() != count) return false;
        return true;
    }
}
