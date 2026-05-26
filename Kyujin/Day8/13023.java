import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int exist = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (dfs(i, g, v) >= 5) {
                    exist = 1;
                    break;
                }
            }
        }
        pw.println(exist);

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static int dfs(int cur, List<List<Integer>> g, boolean[] v) {
        v[cur] = true;

        int cnt = 1;
        int max1 = 0;
        int max2 = 0;

        for (int nod : g.get(cur)) {
            if (!v[nod]) {
                int res = dfs(nod, g, v);
                if (res > max1) max1 = res;
                else if (res > max2) max2 = res;
            }
        }

        cnt += max1 + max2;

        return cnt;
    }
}

/*
5명이상의 친구 무리가 있는지 알아내는 문제


 */