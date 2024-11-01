package BD202412括号;

import java.util.Scanner;
import java.util.*;

class Main {

    public static void main(String[] args) {



        
        Scanner input = new Scanner(System.in);
        // code here
        //(())(()()())))
        String str = input.next();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
            if(str.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            }else {
                stack.push(str.charAt(i));
            }
        }
        if(stack.isEmpty()){
            System.out.println("0");
        }else {
            if(stack.peek() == '(') {
                if(str.charAt(str.length() - 1) == '(') {
                    System.out.println(1);
                }else {
                    int count = 0;
                    int sum = 0;
                    for (int i = 0; i < str.length(); i++) {
                        if(str.charAt(i) == '(' && sum > 0) {
                            count++;
                        }
                        if(str.charAt(i) == '(') {
                            sum++;
                        }else {
                            sum--;
                        }
                    }
                    System.out.println(count);
                }
            }else {
                if(str.charAt(0) == ')') {
                    System.out.println(1);
                }else {
                    int count = 0;
                    int sum = 0;
                    for (int i = str.length() - 1; i >= 0; i--) {
                        if(str.charAt(i) == ')' && sum > 0) {
                            count++;
                        }
                        if(str.charAt(i) == ')') {
                            sum++;
                        }else {
                            sum--;
                        }
                    }
                    System.out.println(count);
                }
            }
        }
        input.close();
    }
}