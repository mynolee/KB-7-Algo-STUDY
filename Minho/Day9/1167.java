import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;

    static int maxDistance;
    static int farNode;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());

            while (true) {

                int to = Integer.parseInt(st.nextToken());

                if (to == -1) {
                    break;
                }

                int cost = Integer.parseInt(st.nextToken());

                graph[from].add(new Node(to, cost));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDistance = 0;

        dfs(farNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int now, int distance) {

        visited[now] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farNode = now;
        }

        for (Node next : graph[now]) {

            if (!visited[next.to]) {

                dfs(
                    next.to,
                    distance + next.cost
                );
            }
        }
    }
}