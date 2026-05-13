import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 4},
                {1, 3},
                {2, 4},
                {3, 4}
        };
        List<List<Integer>> graph = new ArrayList<>(n);
        // -----------------------------------------------
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // -----------------------------------------------
        System.out.println(graph);
        // [[1, 2, 4], [0, 3], [0, 4], [1, 4], [0, 2, 3]]

//        bfs
//        // 시작노드 예약
//        boolean[] visited = new boolean[n];
//        Queue<Integer> q = new ArrayDeque<>();
//        int startNode = 0;
//        q.offer(startNode);
//        visited[startNode] = true;
//
//        while (!q.isEmpty()) {
//            // 방문
//            int cur = q.poll();
//            System.out.println(cur);
//            // 다음노드 예약
//            for (int next : graph.get(cur)) {
//                if (!visited[next]) {
//                    q.offer(next);
//                    visited[next] = true;
//                }
//            }
//        }

        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);
    }

    static void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        // 방문
        visited[cur] = true;
        // 다음노드 dfs 실행
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
