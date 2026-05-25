import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        n++;
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int cnt = 0;
        v[0] = true;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                dfs(i, g, v);
                cnt++;
            }
        }

        pw.println(cnt);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void dfs(int cur, List<List<Integer>> g, boolean[] v) {
        v[cur] = true;

        for (int node : g.get(cur)) {
            if (!v[node]) {
                dfs(node, g, v);
            }
        }
    }
}

