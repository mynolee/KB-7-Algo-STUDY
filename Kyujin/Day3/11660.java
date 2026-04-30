import java.io.*;
import java.text.FieldPosition;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] l = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                l[i][j] = Integer.parseInt(st.nextToken()) + l[i][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j <= x2; j++) {
                sum += l[j][y2] - l[j][y1-1];
            }
            pw.println(sum);
        }

        // **** 정답 출력 pw.println(answer) ========

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
