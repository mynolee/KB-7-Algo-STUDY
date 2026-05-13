import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        // 1) BFS
//        Queue<Integer> q = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                q.offer(i);
//                visited[i] = true;
//
//                while (!q.isEmpty()) {
//                    int cur = q.poll();
//                    for (int next = 0; next < n; next++) {
//                        if (computers[cur][next] == 1 && !visited[next]) {
//                            q.offer(next);
//                            visited[next] = true;
//                        }
//                    }
//                }
//                answer++;
//            }
//        }

        // 2) DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int cur, int n, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        for (int next = 0; next < n; next++) {
            if (computers[cur][next] == 1 && !visited[next]) {
                dfs(next, n, computers, visited);
            }
        }
    }
}
