import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class Main {
    private static boolean isExist = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(graph, visited, i, 1);
                visited[i] = false;
            }

            if (isExist) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    // 5명이 연결되어 있는지(간선 4개가 이어져 있는지) 판단
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int cur, int count) {
        if (count == 5) {
            isExist = true;
            return;
        }

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(graph, visited, next, count + 1);
                visited[next] = false;
            }
        }
    }
}
