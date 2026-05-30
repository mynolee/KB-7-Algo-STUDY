import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if (found) {
                break;
            }
        }

        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int now, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }

        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }

            if (found) {
                return;
            }
        }
    }
}