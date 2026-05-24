import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        dfs(n, m, visited, new ArrayList<>());
        System.out.print(sb);
    }

    private static void dfs(int n, int m, boolean[] visited, List<Integer> cur) {
        if (cur.size() == m) {
            for (int num : cur) {
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cur.add(i);
                visited[i] = true;
                dfs(n, m, visited, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
