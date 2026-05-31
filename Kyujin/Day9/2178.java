import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;
    public static int minDist;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[r][c];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<int[]> q = new ArrayDeque<>();
        minDist = -1;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(row.substring(j, j + 1)) == 1) v[i][j] = true;
                else v[i][j] = false;
            }
        }
        q.offer(new int[]{0, 0, 1});
        v[0][0] = false;
        bfs(q, v, dr, dc);

        pw.println(minDist);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void bfs(Deque<int[]> q, boolean[][] v, int[] dr, int[] dc) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            if (r == v.length - 1 && c == v[0].length - 1) {
                minDist = minDist == -1 ? d : Math.min(minDist, d);
            }

            for (int i = 0; i < 4; i++) {
                int ir = r + dr[i];
                int ic = c + dc[i];

                if (ir >= 0 && ir < v.length && ic >= 0 && ic < v[0].length) {
                    if (v[ir][ic]) {
                        v[ir][ic] = false;
                        q.offer(new int[]{ir, ic, d + 1});
                    }
                }
            }
        }
    }
}

