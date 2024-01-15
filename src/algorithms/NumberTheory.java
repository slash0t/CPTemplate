package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberTheory {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public static int N = 200000;

    static int[] divArray = new int[N + 1];
    public static void reshFactorize() {
        for (int i = 2; i <= N; i++) {
            if (divArray[i] == 0) {
                for (int j = i; j <= N; j += i)
                    divArray[j] = i;
            }
        }
    }

    public static List<Integer> factorize(int n) {
        List<Integer> numbers = new ArrayList<>();
        while (n > 1) {
            numbers.add(divArray[n]);
            n = n / divArray[n];
        }
        return numbers;
    }

    public static Map<Integer, Integer> factorizePow(int n) {
        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        while (n > 1) {
            numbers.put(divArray[n], numbers.getOrDefault(divArray[n], 0) + 1);
            n = n / divArray[n];
        }
        return numbers;
    }

    public static long M = 1000000007;

    public static long fastPow(long num, long pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow % 2 == 0) {
            long temp = fastPow(num, pow / 2);
            return temp * temp % M;
        }
        return num * fastPow(num, pow - 1) % M;
    }
}
