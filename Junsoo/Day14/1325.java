import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 신뢰 관계 <-> 해킹 가능은 반대
            graph[b].add(a);
        }

        // 컴퓨터를 최대로 해킹할 수 있는 경우가 여러 개일 수 있으므로
        // 최대값도 구하고 배열로도 저장하여 모든 경우를 출력할 수 있게 해야함
        int maxCnt = 0;
        int[] cnt =  new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cnt[i] = bfs(i);
            maxCnt = Math.max(maxCnt, cnt[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == maxCnt) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
