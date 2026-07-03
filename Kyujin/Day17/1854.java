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

        List<PriorityQueue<Integer>> kd = new ArrayList<>();
        for (int i = 0; i <= n; i++) kd.add(new PriorityQueue<>((o1, o2) -> o2 - o1));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.offer(new int[]{1, 0});
        kd.get(1).offer(0);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (kd.get(curNode).size() == k && kd.get(curNode).peek() < curDist) continue;

            for (int[] next : g.get(curNode)) {
                int nextNode = next[0];
                int dist = next[1];

                PriorityQueue<Integer> nextHeap = kd.get(nextNode);
                if (nextHeap.size() < k) {
                    nextHeap.offer(curDist + dist);
                    pq.offer(new int[]{nextNode, curDist + dist});
                } else if (nextHeap.peek() > curDist + dist) {
                    nextHeap.poll();
                    nextHeap.offer(curDist + dist);
                    pq.offer(new int[]{nextNode, curDist + dist});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            PriorityQueue<Integer> heap = kd.get(i);
            if (heap.size() < k) bw.write("-1\n");
            else bw.write(heap.peek() + "\n");
        }
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}