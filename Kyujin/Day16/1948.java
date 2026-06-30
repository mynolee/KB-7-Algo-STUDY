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
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();
        List<List<int[]>> rg = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i <= n; i++) rg.add(new ArrayList<>());

        int[] edgeIn = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(a).add(new int[]{b, d});
            rg.get(b).add(new int[]{a, d});
            edgeIn[b]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        int[] t = new int[n + 1];

        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < g.get(cur).size(); i++) {
                int next = g.get(cur).get(i)[0];
                int time = g.get(cur).get(i)[1];

                edgeIn[next]--;
                t[next] = Math.max(t[next], t[cur] + time);

                if (edgeIn[next] == 0) q.offer(next);
            }
        }

        int goldRoad = 0;
        boolean[] v = new boolean[n + 1];

        v[start] = true;
        q.offer(end);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < rg.get(cur).size(); i++) {
                int next = rg.get(cur).get(i)[0];
                int time = rg.get(cur).get(i)[1];

                if (t[cur] - time == t[next]) {
                    goldRoad++;
                    if (!v[next]) {
                        v[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        bw.write(t[end] + "\n" + goldRoad);
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }
}