import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int hackingCount[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        hackingCount = new int[N + 1];
        Arrays.fill(hackingCount, 0);

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int max = 0;
        for (int count : hackingCount) {
            if (count > max) {
                max = count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackingCount[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                // 아직 미방문했으면
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        hackingCount[start] = count;
    }
}
