package algorithms;

public class Geometry {
    public static double distanceFromPointToLine(int x1, int y1, int a, int b, int c) {
        return Math.abs((a * x1 + b * y1 + c) / Math.sqrt(a * a + b * b));
    }

    public static void linesIntersection(int a1, int b1, int c1, int a2, int b2, int c2) {
        if (c1 < 0) {
            a1 *= -1;
            b1 *= -1;
            c1 *= -1;
        }
        if (c2 < 0) {
            a2 *= -1;
            b2 *= -1;
            c2 *= -1;
        }

        double x, y;
        if (a1 != 0) {
            y = (c2 * a1 - a2 * c1) / (double) (b1 * a2 - a1 * b2);
            x = -(c1 + b1 * y) / a1;
        } else {
            x = (c2 * b1 - c1 * b2) / (double) (a2 * b1);
            y = -(a1 * x + c1) / b1;
        }
    }

    public static double polygonSquare(long[] x, long[] y) {
        int n = x.length;

        for (int i = 1; i < n; i++) {
            x[i] -= x[0];
            y[i] -= y[0];
        }

        long sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += x[i] * y[i + 1] - y[i] * x[i + 1];
        }
        return Math.abs(sum) / 2.0;
    }

    public static double angleBetweenVectors(int x1, int y1, int x2, int y2) {
        int scalar = x1 * x2 + y1 * y2;
        int pseudo = x1 * y2 - y1 * x2;
        return Math.abs(Math.atan2(pseudo, scalar));
    }

    public static double polarAngle(int x, int y) {
        return (Math.atan2(y, x) + 2 * Math.PI) % (2 * Math.PI);
    }
}
