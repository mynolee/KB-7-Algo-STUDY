import java.util.*;
import java.io.*;

public class Main {

    // 트리 간선 정보 담을 클래스
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력 받기 시작
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 정점 번호
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                // 정점까지의 거리
                int weight = Integer.parseInt(st.nextToken());
                
                tree[from].add(new Edge(to, weight));
            }
        }
        
        // 1번째 DFS : 임의의 노드(1)에서 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        dfs(1, 0);
        
        // 2번째 DFS : 1번째 DFS에서 찾은 가장 먼노드의 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }
    
    private static void dfs (int node, int distance) {
        visited[node] = true;
        
        // 현재까지 거리가 최대 거리보다 클때마다 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }
        
        // 연결된 노드 탐색
        for (Edge edge : tree[node]) {
            if (!visited[edge.to]) {
                dfs(edge.to, distance + edge.weight);
            }
        }
    }
}
