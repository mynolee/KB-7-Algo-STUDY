import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 각 열에 시추관을 뚫었을 때 얻을 수 있는 석유량
        int[] oilByColumn = new int[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // 석유가 아니거나 이미 방문한 칸이면 건너뜀
                if (land[row][col] == 0 || visited[row][col]) {
                    continue;
                }
                // 하나의 석유 덩어리가 걸쳐 있는 열들 저장
                Set<Integer> columns = new HashSet<>();
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{row, col});
                visited[row][col] = true;
                int oilSize = 0;
                // BFS로 하나의 석유 덩어리 전체 탐색
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    oilSize++;
                    columns.add(cur[1]);

                    for (int i = 0; i < 4; i++) {
                        int nx = cur[0] + dx[i];
                        int ny = cur[1] + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        if (land[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }

                // 이 덩어리가 걸쳐 있는 모든 열에 덩어리 크기 더함
                for (int column : columns) {
                    oilByColumn[column] += oilSize;
                }
            }
        }
        int answer = 0;
        for (int oil : oilByColumn) {
            answer = Math.max(answer, oil);
        }
        return answer;
    }
}
