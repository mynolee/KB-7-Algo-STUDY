import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;
    public static List<Integer> result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        // 거리가 k인 모든 도시를 찾아야 하므로 dfs보다는 bfs가 적합하다
        // 그냥 거리가 아니라 최단거리이므로 a=>b=>a같은 경로는 배제해도 된다
        // 따라서 visited를 true로 만들어줘도 된다

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 1. 입력값을 그래프로 만든다.
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
        }

        // 2. 시작노드에서 bfs를 돌린다.
        result = new ArrayList<>();
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[n + 1];

        v[start] = true;
        q.offer(new int[]{start, 0});
        bfs(g, q, v, k);

        if (result.isEmpty()) result.add(-1);
        Collections.sort(result);
        for (int i : result) bw.write(i + "\n");
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static void bfs(List<List<Integer>> g, Deque<int[]> q,
        boolean[] v, int k) {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nod = cur[0];
            int curDist = cur[1];

            // 3. 거리가 k일때 개수를 세고 멈춘다.
            if (curDist == k) result.add(nod);
            if (curDist == k + 1) return;

            for (int next : g.get(nod)) {
                if (!v[next]) {
                    v[next] = true;
                    q.offer(new int[]{next, curDist + 1});
                }
            }
        }
    }
}

