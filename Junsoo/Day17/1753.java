import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int vertex;
        int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v =  Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value)
        );
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Edge(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            // cur이 갱신 전 정보라면 무시
            if (cur.value > dist[cur.vertex]) {
                continue;
            }

            for (Edge next : graph[cur.vertex]) {
                if (dist[next.vertex] > dist[cur.vertex] + next.value) {
                    dist[next.vertex] = dist[cur.vertex] + next.value;
                    pq.offer(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
