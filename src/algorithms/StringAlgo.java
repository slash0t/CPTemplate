package algorithms;

public class StringAlgo {
    public static int[] zFunc(String s) {
        int n = s.length();
        int[] z = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            z[i] = Math.max(0, Math.min(right - i, z[i - left]));

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] > right) {
                left = i;
                right = z[i] + i;
            }
        }
        return z;
    }

    public static int[] preFunc(String s) {
        int n = s.length();
        int[] p = new int[n];

        for (int i = 1; i < n; i++) {
            int j = p[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = p[j - 1];
            }
            p[i] = j + (s.charAt(i) == s.charAt(j) ? 1 : 0);
        }

        return p;
    }
}
