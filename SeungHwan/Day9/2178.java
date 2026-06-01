import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};    // 상 하 좌 우
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(board[n][m]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny] = board[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
