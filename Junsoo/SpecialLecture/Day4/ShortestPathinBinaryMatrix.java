import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // 출발점이나 도착점이 1인 경우 가능한 경우가 없으므로 -1 리턴
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        // 대각선 경로까지 모두 고려
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        // 최단 경로는 이동 횟수가 아니라 방문 칸 수 이므로 출발점부터 1로 초기화
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return dist[n - 1][n - 1];
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }
}
