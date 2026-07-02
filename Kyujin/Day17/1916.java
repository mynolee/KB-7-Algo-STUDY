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

        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(from).add(new int[]{to, d});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] d = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > d[curNode]) continue;

            for (int[] next : g.get(curNode)) {
                int nextNode = next[0];
                int dist = next[1];

                if (d[curNode] + dist < d[nextNode]) {
                    d[nextNode] = d[curNode] + dist;
                    pq.offer(new int[]{nextNode, d[nextNode]});
                }
            }
        }

        bw.write(String.valueOf(d[end]));
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}