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
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        int[] edgeIn = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            edgeIn[b]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) if (edgeIn[i] == 0) q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur + " ");
            for (int next : g.get(cur)) {
                edgeIn[next]--;
                if (edgeIn[next] == 0) q.offer(next);
            }
        }

        bw.write(sb.toString());
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }


}

