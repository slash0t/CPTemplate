package algorithms;

public class DSU {
    public static int find(int elem, int[] dsu) {
        if (elem == dsu[elem]) {
            return elem;
        }
        return dsu[elem] = find(dsu[elem], dsu);
    }

    public static int union(int elem1, int elem2, int[] dsu, int[] size) {
        int head1 = find(elem1, dsu);
        int head2 = find(elem2, dsu);

        if (size[head1] < size[head2]) {
            dsu[head1] = head2;

            return head2;
        } else {
            dsu[head2] = head1;

            if (size[head1] == size[head2]) {
                size[head1]++;
            }

            return head1;
        }
    }
}
