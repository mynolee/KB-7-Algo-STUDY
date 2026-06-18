import java.util.*;
import java.io.*;

public class Main {
    private static class Edge {
        int to; // 연결 재료 번호
        int p; // 현재 재료 비율
        int q; // 다음 재료 비율

        public Edge(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    private static List<Edge>[] graph;
    private static boolean[] visited;
    private static long[] value;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n]; // 비율 저장 그래프
        visited = new boolean[n];
        value = new long[n]; // 각 재료 양

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        long lcm = 1; // 비율들 최소공배수

        // n-1개 줄 주의, 재료 개수는 0번 부터 n-1번까지 n개
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, p, q));
            graph[b].add(new Edge(a, q, p));
            lcm *= (p * q / gcd(p, q)); // p, q의 최소공배수 누적해서 전체 최소공배수 구함
        }

        // 0번 재료 값을 최소공배수 lcm으로 잡고 dfs 시작
        // 이후 전체 최대공약수로 다시 나눠줌
        value[0] = lcm;
        dfs(0);
        long gcd = value[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, value[i]);
        }

        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(value[i] / gcd).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (Edge edge : graph[cur]) {
            if (!visited[edge.to]) {
                // cur : edge.to = edge.p : edge.q
                value[edge.to] = value[cur] * edge.q / edge.p;
                dfs(edge.to);
            }
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
