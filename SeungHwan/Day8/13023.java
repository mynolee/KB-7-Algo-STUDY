import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] friends;
    static ArrayList<Integer>[] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        friends = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                friends[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = friends[i][0];
            int y = friends[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;

            backtrack(visited, i, 1);

            visited[i] = false;

            if (answer == 1) break;
        }

        System.out.println(answer);
    }

    private static void backtrack(boolean[] visited, int current, int len) {
        if (len == 5) {
            answer = 1;
            return;
        }

        for (int next : graph[current]) {

            if (!visited[next]) {
                // 1
                visited[next] = true;

                // 2
                backtrack(visited, next, len + 1);

                //3
                visited[next] = false;
            }
        }
    }
}
