import java.io.*;
import java.util.*;

public class Main {
    /**
     * Node 클래스에 Comparable 인터페이스 구현
     * PriorityQueue가 비용(dist)이 가장 작은 노드부터 꺼내올 수 있도록
     * 오름차순 정렬 기준(compareTo)을 정의
     */
    static class Node implements Comparable<Node> {
        int toGo;
        int dist;

        public Node(int toGo, int dist) {
            this.toGo = toGo;
            this.dist = dist;
        }

        // 우선순위 큐에서 정렬 기준을 '비용(dist)이 작은 순'으로 설정
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(departure).add(new Node(arrival, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        // 다익스트라 알고리즘 구현
        int[] dist = new int[N + 1];    // start에서 각 도시까지 가는 최소 비용
        Arrays.fill(dist, Integer.MAX_VALUE);   // 모든 거리를 무한대로 초기화
        dist[start] = 0;

        // 비용이 낮은 노드를 먼저 꺼내기 위해 PriorityQueue 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.toGo;
            int curDist = cur.dist; // 현재까지의 최단거리

            // 현재 꺼낸 노드의 비용이 이미 기록된 최소 비용보다 크다면 탐색할 필요 없음
            if (curDist > dist[curVertex]) continue;

            // 목적지에 도달했다면 이미 최소 비용이 보장되므로 종료 가능
            if (curVertex == end) break;

            // 다음 도시로 이동 준비
            for (Node nextCity : list.get(curVertex)) {
                // 새로운 경로를 통해 다음 도시로 가는 비용 계산
                int nextDist = curDist + nextCity.dist;

                // 기존에 기록된 최단 거리보다 더 저렴하다면 갱신 후 큐에 삽입
                if (nextDist < dist[nextCity.toGo]) {
                    dist[nextCity.toGo] = nextDist;
                    pq.add(new Node(nextCity.toGo, nextDist));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
