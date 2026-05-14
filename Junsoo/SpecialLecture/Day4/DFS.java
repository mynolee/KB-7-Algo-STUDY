import java.util.*;

class Solution {
    // 4방향 (우, 하, 좌, 상)
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    int n;
    int m;
    boolean[][] visited;

    public void solution(int[][] grid, int startRow, int startCol) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        dfs(grid, startRow, startCol);
    }

    // DFS 탐색
    void dfs(int[][] grid, int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(grid, nr, nc);
                }
            }
        }
    }
}
