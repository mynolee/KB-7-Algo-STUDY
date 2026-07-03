import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int target, weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 마을, 학생 수
        int M = Integer.parseInt(st.nextToken());   // 도로 갯수
        int X = Integer.parseInt(st.nextToken());   // 모일 마을(시작 노드)

        // 정방향 그래프(집 -> X로 갈 때)
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        // 역방향 그래프(X -> 집으로 돌아갈 때)
        ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, t));
            reverseGraph.get(b).add(new Node(a, t));
        }

        // 1. 집 -> 파티장(X)으로 가는 최단거리
        // 이거도 출발점을 X로 두고 역방향 그래프를 돌린다.
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;    // 시작점 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은거 찾았으면 스킵
            if (dist[curVertex] < curWeight) continue;

            for (Node next : reverseGraph.get(curVertex)) {
                // 더 짧은 경로 발견 시
                if (dist[next.target] > dist[curVertex] + next.weight) {
                    dist[next.target] = dist[curVertex] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }

        // 2. 파티장(X) -> 집으로 돌아오는 최단거리 (정방향 그래프)
        int[] backDist = new int[N + 1];
        Arrays.fill(backDist, Integer.MAX_VALUE);
        backDist[X] = 0;

        // 다시 돌아갈 때
        pq.add(new Node(X, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은거 찾았으면 스킵
            if (backDist[curVertex] < curWeight) {
                continue;
            }

            for (Node next : graph.get(curVertex)) {
                // 더 짧은 경로 발견 시
                if (backDist[next.target] > backDist[curVertex] + next.weight) {
                    backDist[next.target] = backDist[curVertex] + next.weight;
                    pq.add(new Node(next.target, backDist[next.target]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE && backDist[i] != Integer.MAX_VALUE) {
                max = Math.max(max, dist[i] + backDist[i]);
            }
        }

        System.out.println(max);
    }
}
