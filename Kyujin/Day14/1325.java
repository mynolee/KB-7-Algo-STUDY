import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        // a가 b를 신뢰: b=>a로 갈 수 있는 엣지가 된다. 단방향 그래프가 될 수 있다.
        // 모든 노드에서 dfs를 시행한다고 하면 최악의 경우 시간초과가 날 것만 같다.
        // 시간제한이 5초기 때문에 시간초과가 나지 않는다.

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] hack = new int[n + 1];

        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(b).add(a);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (hack[i] == -1) continue;

            boolean[] v = new boolean[n + 1];
            hack[i] = dfs(g, v, i);
            max = Math.max(hack[i], max);
        }

        for (int i = 1; i <= n; i++) {
            if (hack[i] == max) bw.write(i + " ");
        }
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static int dfs(List<List<Integer>> g, boolean[] v, int cur) {
        v[cur] = true;

        int cnt = 0;

        for (int next : g.get(cur)) {
            if (!v[next]) {
                cnt += dfs(g, v, next);
            }
        }

        return cnt + 1;
    }
}

