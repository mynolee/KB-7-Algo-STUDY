import java.io.*;
import java.lang.reflect.Array;
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

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(from).add(new int[]{to, d});
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        boolean isUpdated = false;
        for (int round = 1; round <= n - 1; round++) {
            isUpdated = false;

            for (int curNode = 1; curNode <= n; curNode++) {
                if (d[curNode] == Integer.MAX_VALUE) continue;

                for (int[] next : g.get(curNode)) {
                    int nextNode = next[0];
                    int dist = next[1];

                    if (d[nextNode] > d[curNode] + dist) {
                        d[nextNode] = d[curNode] + dist;
                        isUpdated = true;
                    }
                }
            }

            if (!isUpdated) break;
        }

        boolean hasNegativeCycle = false;
        if (isUpdated) {
            for (int curNode = 1; curNode <= n; curNode++) {
                if (d[curNode] == Integer.MAX_VALUE) continue;

                for (int[] next : g.get(curNode)) {
                    int nextNode = next[0];
                    int dist = next[1];

                    if (d[nextNode] > d[curNode] + dist) {
                       hasNegativeCycle = true;
                       break;
                    }
                }

                if (hasNegativeCycle) break;
            }
        }

        if (hasNegativeCycle) bw.write("-1");
        else {
            for (int i = 2; i < d.length; i++) {
                if (d[i] == Integer.MAX_VALUE) bw.write("-1\n");
                else bw.write(d[i] + "\n");
            }
        }
        /* 풀이 작성 끝 */
        br.close();
        bw.close();
    }

}