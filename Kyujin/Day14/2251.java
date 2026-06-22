import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static int limitA;
    public static int limitB;
    public static int limitC;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        limitA = Integer.parseInt(st.nextToken());
        limitB = Integer.parseInt(st.nextToken());
        limitC = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[limitA + 1][limitB + 1];
        List<Integer> result = new ArrayList<>();
        dfs(v, 0, 0, limitC, result);

        Collections.sort(result);
        for (int i : result) bw.write(i + " ");
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static void dfs(boolean[][] v, int a, int b, int c, List<Integer> result) {
        v[a][b] = true;

        if (a == 0) result.add(c);

        // a => b
        if (a + b <= limitB) {
            if (!v[0][a + b]) dfs(v, 0, a + b, c, result);
        } else {
            if (!v[a - (limitB - b)][limitB]) dfs(v, a - (limitB - b), limitB, c, result);
        }

        // a => c
        if (a + c <= limitC) {
            if (!v[0][b]) dfs(v, 0, b, a + c, result);
        } else {
            if (!v[a - (limitC - c)][b]) dfs(v, a - (limitC - c), b, limitC, result);
        }

        // b => a
        if (a + b <= limitA) {
            if (!v[a + b][0]) dfs(v, a + b, 0, c, result);
        } else {
            if (!v[limitA][b - (limitA - a)]) dfs(v, limitA, b - (limitA - a), c, result);
        }

        // b => c
        if (b + c <= limitC) {
            if (!v[a][0]) dfs(v, a, 0, b + c, result);
        } else {
            if (!v[a][b - (limitC - c)]) dfs(v, a, b - (limitC - c), limitC, result);
        }

        // c => a
        if (a + c <= limitA) {
            if (!v[a + c][b]) dfs(v, a + c, b, 0, result);
        } else {
            if (!v[limitA][b]) dfs(v, limitA, b, c - (limitA - a), result);
        }

        // c => b
        if (c + b <= limitB) {
            if (!v[a][b + c]) dfs(v, a, b + c, 0, result);
        } else {
            if (!v[a][limitB]) dfs(v, a, limitB, c - (limitB - b), result);
        }
    }
}

