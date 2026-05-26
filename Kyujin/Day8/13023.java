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
            v[i] = true;
            if (dfs(i, g, v, 1)) {
                exist = 1;
                break;
            }
            v[i] = false;
        }
        pw.println(exist);

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static boolean dfs(int cur, List<List<Integer>> g, boolean[] v, int cnt) {
        if (cnt >= 5) return true;

        for (int nod : g.get(cur)) {
            if (!v[nod]) {
                v[nod] = true;
                if (dfs(nod, g, v, cnt + 1)) return true;
                v[nod] = false;
            }
        }

        return false;
    }
}

/*
5명이상의 친구 무리가 있는지 알아내는 문제


 */