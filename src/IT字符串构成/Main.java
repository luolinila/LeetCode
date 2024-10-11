package IT字符串构成;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ransomNote = sc.nextLine();
        String magazine = sc.nextLine();
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        for(Character c : ransomNote.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(Character c : magazine.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Character c : map1.keySet()) {
            if(!map2.containsKey(c) || map1.get(c) > map2.get(c)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
