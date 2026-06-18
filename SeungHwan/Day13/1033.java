import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        long p;
        long q;

        public Edge(int to, long p, long q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    static ArrayList<Edge>[] graph;
    static long[] ingredients;
    static boolean[] visited;
    static long lcm = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        ingredients = new long[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long p = Integer.parseInt(st.nextToken());
            long q = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, p, q));
            graph[b].add(new Edge(a, q, p));

            // 나중에 나눌 때 정수로 나누어 떨어지게 하기 위해 충분히 크게 만들기
            lcm *= (p * q) / GCD(p, q);
        }

        ingredients[0] = lcm;
        DFS(0);

        long gcd = ingredients[0];
        for (int i = 1; i < N; i++) {
            gcd = GCD(gcd, ingredients[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ingredients[i] / gcd).append(" ");
        }

        System.out.println(sb);
    }

    private static void DFS(int now) {
        visited[now] = true;

        for (Edge edge : graph[now]) {
            if (!visited[edge.to]) {
                ingredients[edge.to] = ingredients[now] * edge.q / edge.p;
                DFS(edge.to);
            }
        }
    }

    // 최대 공약수 구하는 함수
    private static long GCD(long A, long B) {
        if (B == 0) return A;
        return GCD(B, A % B);
    }
}
