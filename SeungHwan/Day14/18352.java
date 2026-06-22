import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 도시의 갯수
        int M = Integer.parseInt(st.nextToken());   // 도로의 갯수
        int K = Integer.parseInt(st.nextToken());   // 거리 정보
        int X = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        graph = new ArrayList<>();
        // 1부터 N까지 이므로 N + 1 크기로 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 단방향 이므로 한번만 추가
            graph.get(A).add(B);
        }

        distance = new int[N + 1];
        // 초기값 -1로
        Arrays.fill(distance, -1);

        bfs(X);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.length() > 0 ? sb : "-1");
    }


    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        distance[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 도시에서 갈 수 있는 모든 다음 도시들
            for (int next : graph.get(cur)) {
                // 아직 방문 안했으면 -1
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
