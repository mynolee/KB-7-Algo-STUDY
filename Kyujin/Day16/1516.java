import java.io.*;
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

        int n = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        int[] edgeIn = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            g.get(i).add(t);
            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                g.get(next).add(i);
                edgeIn[i]++;
                next = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        int[] t = new int[n + 1];
        for (int i = 1; i <= n; i++) if (edgeIn[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();

            t[cur] += g.get(cur).get(0);
            for (int i = 1; i < g.get(cur).size(); i++) {
                int next = g.get(cur).get(i);
                edgeIn[next]--;
                t[next] = Math.max(t[next], t[cur]);
                if (edgeIn[next] == 0) q.offer(next);
            }
        }

        for (int i = 1; i <= n; i++) bw.write(t[i] + "\n");
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}