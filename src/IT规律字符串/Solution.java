package IT规律字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] p = sc.nextLine().split(" ");
        HashMap<Character, List<Integer>> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        for (List<Integer> list : map.values()) {
            if(!isOK(p, list)) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
    static boolean isOK(String[] strs, List<Integer> list) {
        String s = strs[list.get(0)];
        for (Integer i : list) {
            //System.out.println(i + " " + strs[i] + " ");
            if(strs[i].compareTo(s) != 0) {
                return false;
            }
        }
        return true;
    }
}
