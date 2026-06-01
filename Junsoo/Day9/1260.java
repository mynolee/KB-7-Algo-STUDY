import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 번호가 작은 정점부터 방문해야 하므로 각 인접 리스트 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v, new boolean[n + 1]);
        sb.append("\n");
        bfs(v, new boolean[n + 1]);
        System.out.println(sb);
    }

    private static void dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        sb.append(cur).append(" ");

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    private static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    sb.append(next).append(" ");
                }
            }
        }
    }
}
