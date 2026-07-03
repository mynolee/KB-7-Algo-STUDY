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
        int k = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(from).add(new int[]{to, d});
        }

        List<List<Integer>> kd = new ArrayList<>();
        for (int i = 0; i <= n; i++) kd.add(new ArrayList<>());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (kd.get(curNode).size() >= k) continue;

            kd.get(curNode).add(curDist);

            for (int[] next : g.get(curNode)) {
                int nextNode = next[0];
                int dist = next[1];

                if (kd.get(nextNode).size() < k) {
                    pq.offer(new int[]{nextNode, curDist + dist});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> d = kd.get(i);
            if (d.size() < k) bw.write("-1\n");
            else bw.write(d.get(k - 1) + "\n");
        }
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}