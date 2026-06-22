import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;    // 0: 미방문, 1: 빨강, -1: 파랑

    /**
     * 1. 아직 방문하지 않은 노드를 탐색할 때, 시작 노드를 1(빨간색)로 칠하고 큐(Queue)에 넣습니다.
     * 2. 큐에서 노드를 꺼내어 이웃 노드들을 확인합니다.
     * 3. 이웃 노드가 방문하지 않은 노드(0)라면, 현재 노드와 반대되는 색(-현재 노드의 색)으로 칠하고 큐에 넣습니다.
     * 예시: 내가 1이면 이웃은 -1로, 내가 -1이면 이웃은 1로 칠함.
     * 4. 이웃 노드가 이미 방문한 노드인데, 하필 나와 똑같은 색으로 칠해져 있다면?
     * 이분 그래프가 아닌 것.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < K; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   // 정점 갯수
            int E = Integer.parseInt(st.nextToken());   // 간선 갯수

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph.get(A).add(B);
                graph.get(B).add(A);
            }

            colors = new int[V + 1];
            boolean isBipartite = true;

            // 연결 리스트가 끊어져 있는 경우를 위해 모든 정점을 확인
            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {   // 아직 방문하지 않은 정점 발견시
                    if (!bfs(i)) {  // BFS를 돌렸는데 이분 그래프가 아니라면
                        isBipartite = false;
                        break;
                    }
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        colors[start] = 1;  // 시작 정점을 1로 칠함

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                // case 1: 인접한 정점이 아직 미방문한 정점인 경우
                if (colors[next] == 0) {
                    colors[next] = colors[cur] * -1; // 현재 노드와 반대 색상으로 칠하기
                    queue.add(next);
                } // case 2: 이미 방문한 정점인데, 나와 색이 같은 경우(충돌 발생!)
                else if (colors[next] == colors[cur]) {
                    return false;
                }
            }
        }

        return true;
    }
}
