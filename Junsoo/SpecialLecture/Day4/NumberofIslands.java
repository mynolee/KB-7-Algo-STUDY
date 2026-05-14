import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    answer++;
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                                continue;
                            }
                            if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                                q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
