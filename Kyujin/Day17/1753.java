import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            g.get(from).add(new int[]{to, dist});
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>(
            Comparator.comparingInt((int[] o) -> o[1])
        );
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > d[curNode]) continue;

            for (int[] next : g.get(curNode)) {
                int nextNode = next[0];
                int dist = next[1];

                if (d[nextNode] > d[curNode] + dist) {
                    d[nextNode] = d[curNode] + dist;
                    q.offer(new int[]{nextNode, d[nextNode]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(d[i] + "\n");
        }
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}