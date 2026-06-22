import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringBuilder sb;

    public static int[] froms;
    public static int[] tos;
    public static int[] limits;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        limits = new int[3];
        limits[0] = Integer.parseInt(st.nextToken());
        limits[1] = Integer.parseInt(st.nextToken());
        limits[2] = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[limits[0] + 1][limits[1] + 1];
        List<Integer> result = new ArrayList<>();
        froms = new int[]{0, 0, 1, 1, 2, 2};
        tos = new int[]{1, 2, 0, 2, 0, 1};

        dfs(v, new int[]{0, 0, limits[2]}, result);

        Collections.sort(result);
        for (int i : result) bw.write(i + " ");
        // 풀이 작성 끝 =======================
        br.close();
        bw.close();
    }

    public static void dfs(boolean[][] v, int[] abc, List<Integer> result) {
        v[abc[0]][abc[1]] = true;

        if (abc[0] == 0) result.add(abc[2]);

        for (int i = 0; i < 6; i++) {
            int[] temp = new int[]{abc[0], abc[1], abc[2]};
            
            int from = froms[i];
            int to = tos[i];
            
            int move = Math.min(temp[from], limits[to] - temp[to]);
            temp[from] -= move;
            temp[to] += move;
            
            if (!v[temp[0]][temp[1]]) dfs(v, temp, result);
        }
    }
}

