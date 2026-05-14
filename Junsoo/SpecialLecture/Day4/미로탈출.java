import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int row = maps.length;
        // maps[0]은 Strinig이므로 .length가 아닌 .length()
        int col = maps[0].length();
        
        // 시작 지점, 레버 좌표, 출구 좌표
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];
        
        // S->L , L->E 최소 시간 구해서 더하기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char cur = maps[i].charAt(j);
                if (cur == 'S') {
                    S[0] = i;
                    S[1] = j;
                } else if (cur == 'L') {
                    L[0] = i;
                    L[1] = j;
                } else if(cur == 'E') {
                    E[0] = i;
                    E[1] = j;
                }
            }
        }
        int StoL = bfs(maps, S, L);
        int LtoE = bfs(maps, L, E);
        if (StoL == -1 || LtoE == -1) {
             return -1;
        }
        return StoL + LtoE;
    }
    
    private int bfs(String[] maps, int[] src, int[] dest) {
        int row = maps.length;
        // maps[0]은 Strinig이므로 .length가 아닌 .length()
        int col = maps[0].length();
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        int[][] dist = new int[row][col];
        int[] dx = {-1 ,1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.offer(new int[]{src[0], src[1]});
        visited[src[0]][src[1]] = true;
        dist[src[0]][src[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dest[0] && cur[1] == dest[1]) {
                return dist[dest[0]][dest[1]];
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                // 'X'인 경우만 이동 못하는 것이므로 == 'O'로 하면 안되고 != 'X'로 해야 함
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }
}
