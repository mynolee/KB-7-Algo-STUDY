import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        // 1) DFS 방식
//        dfs(0, rooms, visited);

        // 2) BFS 방식
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rooms.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int cur, List<List<Integer>> rooms, boolean[] visited) {
        visited[cur] = true;
        for (int next : rooms.get(cur)) {
            if (!visited[next]) {
                dfs(next, rooms, visited);
            }
        }
    }
}
