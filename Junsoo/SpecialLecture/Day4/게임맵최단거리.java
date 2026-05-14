import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        int[][] dist = new int[row][col];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == row - 1 && cur[1] == col - 1) {
                return dist[row - 1][col - 1];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }
}
