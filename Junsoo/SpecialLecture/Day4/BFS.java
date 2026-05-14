import java.util.*;

class Solution {
    // 8방향 (상, 하, 좌, 우 + 대각선)
    int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    
    int n;
    int m;
    boolean[][] visited;

    public void solution(int[][] grid, int startRow, int startCol) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        bfs(grid, startRow, startCol);
    }

    // BFS 탐색
    void bfs(int[][] grid, int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(grid[nr][nc] == 1){
                        if (!visited[nr][nc]) {
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
