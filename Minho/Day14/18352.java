import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 찾을 거리
        X = Integer.parseInt(st.nextToken()); // 출발 도시

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1; // 방문 안 함
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B); // 단방향 도로
        }

        bfs(X);

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}