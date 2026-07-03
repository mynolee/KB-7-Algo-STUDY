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
        int x = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(from).add(new int[]{to, d});
        }

        int[] fromX = new int[n + 1];
        Arrays.fill(fromX, Integer.MAX_VALUE);
        fromX[x] = 0;
        dijkstra(fromX, g, x);

        int maxDist = 0;

        for (int i = 1; i <= n; i++) {
            int[] fromI = new int[n + 1];
            Arrays.fill(fromI, Integer.MAX_VALUE);
            fromI[i] = 0;

            dijkstra(fromI, g, i);

            int go = fromI[x];
            int backHome = fromX[i];
            maxDist = Math.max(maxDist, go + backHome);
        }
        bw.write(String.valueOf(maxDist));
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static void dijkstra(int[] d, List<List<int[]>> g, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (d[curNode] < curDist) continue;

            for (int[] next : g.get(curNode)) {
                int nextNode = next[0];
                int dist = next[1];

                if (d[nextNode] > curDist + dist) {
                    d[nextNode] = curDist + dist;
                    pq.offer(new int[]{nextNode, d[nextNode]});
                }
            }
        }
    }
}