import java.io.*;
import java.util.*;

public class Main {
    public static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[n];
        dfs(v, 0, m, new StringBuilder());
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
    public static void dfs(boolean[] v, int cnt, int target, StringBuilder sb) {
        if (cnt == target) {
            pw.println(sb.toString());
            return;
        }

        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sb.append((i + 1) + " ");
                dfs(v, cnt + 1, target, sb);
                v[i] = false;
                sb.delete(cnt * 2, cnt * 2 + 2);
            }
        }
    }
}

