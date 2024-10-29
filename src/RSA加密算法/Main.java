package RSA加密算法;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "123456";
        List<Integer> arr = findFirstNPrimes(str.length());
        BigInteger big = BigInteger.ONE;
        for (int i = 0; i < str.length(); i++) {
            BigInteger temp = new BigInteger(arr.get(i) + "").pow(Integer.parseInt(String.valueOf(str.charAt(i))));
            big = big.multiply(temp);
        }
        System.out.println(big);
    }
    public static List<Integer> findFirstNPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                primes.add(num);
                count++;
            }
            num++;
        }
        return primes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
