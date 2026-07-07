import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int city;
        int cost;
        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m =  Integer.parseInt(br.readLine());
        List<Node>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );
        int[] dist =  new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.city]) {
                continue;
            }
            for (Node next : graph[cur.city]) {
                if (dist[next.city] > dist[cur.city] + next.cost) {
                    dist[next.city] = dist[cur.city] + next.cost;
                    pq.offer(new Node(next.city, dist[next.city]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
