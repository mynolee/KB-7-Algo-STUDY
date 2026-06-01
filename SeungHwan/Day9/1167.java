import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int maxDiameter = 0; // 전역으로 지름의 최댓값을 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Edge(to, weight));
            }
        }

        visited = new boolean[V + 1];
        
        // 아무 노드(1번)에서나 DFS를 딱 한 번만 시작합니다.
        dfs(1);

        System.out.println(maxDiameter);
    }

    // 이 함수는 현재 노드에서 아래(자식 방향)로 뻗어나갈 수 있는 '가장 긴 단일 경로의 길이'를 반환합니다.
    public static int dfs(int node) {
        visited[node] = true;

        int max1 = 0; // 가장 긴 자식 경로
        int max2 = 0; // 두 번째로 긴 자식 경로

        for (Edge edge : tree[node]) {
            if (!visited[edge.to]) {
                // 자식 노드가 아래로 쭉 뻗어가서 얻은 최대 길이에 현재 간선 가중치를 더함
                int childPath = dfs(edge.to) + edge.weight;

                // 탑 2 갱신 로직
                if (childPath > max1) {
                    max2 = max1;
                    max1 = childPath;
                } else if (childPath > max2) {
                    max2 = childPath;
                }
            }
        }

        // 현재 노드를 중심으로 왼쪽 자식 최장선 + 오른쪽 자식 최장선을 더해 지름을 갱신
        maxDiameter = Math.max(maxDiameter, max1 + max2);

        // 부모 노드에게는 자신이 갈 수 있는 가장 긴 한 갈래의 길만 반환해줌
        return max1;
    }
}