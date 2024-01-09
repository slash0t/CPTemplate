package algorithms;

public class BIT {
    public static int n;
    public static long[] t;

    public static void init(int nn) {
        n = nn;
        t = new long[n];
    }

    public static long sum(int r) {
        long result = 0;
        for (; r >= 0; r = (r & (r+1)) - 1)
            result += t[r];
        return result;
    }

    public static void inc(int i, long delta) {
        for (; i < n; i = (i | (i+1))) {
            t[i] += delta;
        }
    }

    public static long sum(int l, int r) {
        return sum(r) - sum(l-1);
    }

    public static void init(long[] a) {
        init(a.length);
        for (int i = 0; i < a.length; i++) {
            inc(i, a[i]);
        }
    }
}
