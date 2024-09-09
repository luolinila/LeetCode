package 外观数列38;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(countAndSay(i));
        }
    }
    static public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = countAndSay(n - 1);
        ArrayList<Integer[]> resList = new ArrayList<>();
        for (int i = 0; i < res.length(); i++) {
            Integer temp = Integer.parseInt(String.valueOf(res.charAt(i)));
            if (resList.isEmpty() || resList.get(resList.size() - 1)[0].compareTo(temp) != 0) {
                resList.add(new Integer[]{temp, 1});
            }else {
                resList.get(resList.size() - 1)[1] ++;
            }
        }
        String result = "";
        for (Integer[] integers : resList) {
            result += integers[1];
            result += integers[0];
        }
        return result;
    }
}
