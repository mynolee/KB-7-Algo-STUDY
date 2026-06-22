import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] color; // 0: 방문 안 함, 1: 빨강, -1: 파랑

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean result = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        result = false;
                        break;
                    }
                }
            }

            sb.append(result ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (color[next] == 0) {
                    color[next] = -color[now];
                    queue.offer(next);
                } else if (color[next] == color[now]) {
                    return false;
                }
            }
        }

        return true;
    }
}