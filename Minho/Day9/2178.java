import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (canMove(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, now.distance + 1));
                }
            }
        }

        return -1;
    }

    static boolean canMove(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return maze[x][y] == 1;
    }
}