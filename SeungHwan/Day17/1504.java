import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int target;
        int weight;

        public Node(int target, int width) {
            this.target = target;
            this.weight = width;
        }

        @Override
        public int compareTo(Node o) {
            // compare(this.weight, o.weight)는 (this 기준으로) 두 수 빼서 음수면 오름차순, 양수면 내림차순 
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = new int[N + 1];
        Arrays.fill(distFrom1, Integer.MAX_VALUE);
        distFrom1[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은거 찾았으면 스킵
            if (curWeight > distFrom1[curVertex]) continue;

            for (Node next : graph.get(curVertex)) {
                // 더 짧은 경로 발견시
                if (distFrom1[next.target] > distFrom1[curVertex] + next.weight) {
                    distFrom1[next.target] = distFrom1[curVertex] + next.weight;
                    pq.add(new Node(next.target, distFrom1[next.target]));
                }
            }
        }

        int[] distFromV1 = new int[N + 1];
        Arrays.fill(distFromV1, Integer.MAX_VALUE);
        distFromV1[v1] = 0;

        pq.add(new Node(v1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은거 찾았으면 스킵
            if (curWeight > distFromV1[curVertex]) continue;

            for (Node next : graph.get(curVertex)) {
                // 더 짧은 경로 발견시
                if (distFromV1[next.target] > distFromV1[curVertex] + next.weight) {
                    distFromV1[next.target] = distFromV1[curVertex] + next.weight;
                    pq.add(new Node(next.target, distFromV1[next.target]));
                }
            }
        }

        int[] distFromV2 = new int[N + 1];
        Arrays.fill(distFromV2, Integer.MAX_VALUE);
        distFromV2[v2] = 0;

        pq.add(new Node(v2, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.target;
            int curWeight = cur.weight;

            // 이미 더 짧은거 찾았으면 스킵
            if (curWeight > distFromV2[curVertex]) continue;

            for (Node next : graph.get(curVertex)) {
                // 더 짧은 경로 발견시
                if (distFromV2[next.target] > distFromV2[curVertex] + next.weight) {
                    distFromV2[next.target] = distFromV2[curVertex] + next.weight;
                    pq.add(new Node(next.target, distFromV2[next.target]));
                }
            }
        }
        if (distFrom1[v1] == Integer.MAX_VALUE ||
                distFromV1[v2] == Integer.MAX_VALUE ||
                distFromV2[N] == Integer.MAX_VALUE ||
                distFrom1[v2] == Integer.MAX_VALUE ||
                distFromV2[v1] == Integer.MAX_VALUE ||
                distFromV1[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int answer = Math.min(distFrom1[v1] + distFromV1[v2] + distFromV2[N], distFrom1[v2] + distFromV2[v1] + distFromV1[N]);
        System.out.println(answer);
    }
}
