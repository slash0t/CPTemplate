package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graphs {
    public static void Dijkstra(int n, ArrayList<LinkedList<Edge>> edgeList) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[n * 2];
        Arrays.fill(vis, false);
        long[] dis = new long[n * 2];
        Arrays.fill(dis, -1L);
        int[] pre = new int[n * 2];
        Arrays.fill(pre, -1);

        pq.add(new Edge(0, 0));
        dis[0] = 0;
        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            int u = top.to;
            long value = top.value;
            if (vis[u]) {
                continue;
            }
            vis[u] = true;

            for (Edge edge : edgeList.get(u)) {
                int to = edge.to;
                long eValue = edge.value;
                if (dis[to] == -1 || value + eValue < dis[to]) {
                    dis[to] = value + eValue;
                    pre[to] = u;
                    pq.add(new Edge(to, dis[to]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        long value;

        public Edge(int to, long value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(value, o.value);
        }
    }
}
