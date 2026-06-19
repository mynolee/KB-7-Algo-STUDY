import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<List<int[]>> g = new ArrayList<>();
        int[] result = new int[n];
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w1 = Integer.parseInt(st.nextToken());
            int w2 = Integer.parseInt(st.nextToken());
            int gcd = gcd(Math.max(w1, w2), Math.min(w1, w2));

            g.get(a).add(new int[]{b, w1/gcd, w2/gcd});
            g.get(b).add(new int[]{a, w2/gcd, w1/gcd});
        }

        v[0] = true;
        result[0] = 1;
        dfs(g, 0, v, result);

        for (int i : result) bw.write(String.valueOf(i) + " ");
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void dfs(List<List<int[]>> g, int cur, boolean[] v, int[] result) {
        for (int[] arr : g.get(cur)) {
            int nod = arr[0];
            int w1 = arr[1];
            int w2 = arr[2];
            if (!v[nod]) {
                v[nod] = true;

                int gcd = gcd(Math.max(result[cur], w1), Math.min(result[cur], w1));
                for (int i = 0; i < result.length; i++) {
                    if (i != nod) result[i] *= w1 / gcd;
                }
                result[nod] = result[cur] / w1 * w2;
                dfs(g, nod, v, result);
            }
        }
    }
}
