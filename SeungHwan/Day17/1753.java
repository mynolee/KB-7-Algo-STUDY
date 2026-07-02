import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        // 우선순위 큐에서 거리가 짧은 순으로 정렬하기 위함
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        List<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        // 최단 거리 배열 초기화
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        // 다익스트라 알고리즘 실행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은 경로 찾았으면 패스
            if (dist[curVertex] < curWeight) continue;

            // 인접 노드들 확인
            for (Node next : graph[curVertex]) {
                // 더 짧은 지름길을 발견했을 때만!
                if (dist[next.target] > dist[curVertex] + next.weight) {
                    dist[next.target] = dist[curVertex] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
