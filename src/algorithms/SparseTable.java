package algorithms;

public class SparseTable {
    static int[][] sparseTable;

    public static void build(int n, int[] arr) {
        int log = 32 - Integer.numberOfLeadingZeros(n);
        sparseTable = new int[log][n];
        for (int i = 0; i < n; i++) {
            sparseTable[0][i] = arr[i];
        }
        for (int i = 1; i < log; i++) {
            for (int j = 0; j <= n - (1 << i); j++) {
                sparseTable[i][j] = sparseTable[i - 1][j] & sparseTable[i - 1][j + (1 << (i - 1))];
            }
        }
    }

    public static int get(int l, int r) {
        int logLen = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        return sparseTable[logLen][l] & sparseTable[logLen][r - (1 << logLen) + 1];
    }
}
