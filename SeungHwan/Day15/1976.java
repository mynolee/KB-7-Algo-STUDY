import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int numJ = Integer.parseInt(st.nextToken());
                if (numJ == 1) {
                    map.get(i).add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] route = new int[M];
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N + 1];

        bfs(route[0], visited);
        

        // 여행 계획에 있는 모든 도시들이 전부 방문 가능한 상태였는지 확인
        boolean answer = true;
        for (int i = 0; i < M; i++) {
            if (!visited[route[i]]) {
                answer = false;
                break;
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }

    private static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
