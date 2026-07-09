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
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();
        int[] money = new int[n];

        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g.get(from).add(new int[]{to, d});
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[n];
        Arrays.fill(d, Integer.MIN_VALUE);
        d[start] = money[start];

        boolean isUpdated = false;
        for (int round = 1; round <= n - 1; round++) {
            isUpdated = false;

            for (int curNode = 0; curNode < n; curNode++) {
                if (d[curNode] == Integer.MIN_VALUE) continue;

                for (int[] next : g.get(curNode)) {
                    int nextNode = next[0];
                    int cost = money[nextNode] - next[1];


                    if (d[nextNode] < d[curNode] + cost) {
                        d[nextNode] = d[curNode] + cost;
                        isUpdated = true;
                    }
                }
            }

            if (!isUpdated) break;
        }

        boolean hasNegativeCycle = false;
        if (isUpdated) {
            for (int curNode = 0; curNode < n; curNode++) {
                if (d[curNode] == Integer.MIN_VALUE) continue;

                for (int[] next : g.get(curNode)) {
                    int nextNode = next[0];
                    int dist = money[nextNode] - next[1];

                    if (d[nextNode] < d[curNode] + dist) {
                       hasNegativeCycle = true;
                       break;
                    }
                }

                if (hasNegativeCycle) break;
            }
        }

        if (d[end] == Integer.MIN_VALUE) bw.write("gg");
        else if (hasNegativeCycle) bw.write("Gee");
        else bw.write(String.valueOf(d[end]));
        /* 풀이 작성 끝 */
        br.close();
        bw.close();
    }

}