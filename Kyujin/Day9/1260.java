import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        n++;
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(g.get(i));
        }

        dfs(start, g, new boolean[n]);

        pw.println();

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[n];
        v[start] = true;
        pw.print(start + " ");
        q.offer(start);
        bfs(q, g, v);

        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void dfs(int cur, List<List<Integer>> g, boolean[] v) {
        v[cur] = true;
        pw.print(cur + " ");

        for (int nod : g.get(cur)) {
            if (!v[nod]) {
                dfs(nod, g, v);
            }
        }
    }

    public static void bfs(Deque<Integer> q, List<List<Integer>> g, boolean[] v) {
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nod : g.get(cur)) {
                if (!v[nod]) {
                    v[nod] = true;
                    pw.print(nod + " ");
                    q.offer(nod);
                }
            }
        }
    }
}

