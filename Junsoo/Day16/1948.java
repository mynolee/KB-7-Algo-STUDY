import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int next;
        int cost;

        Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m =  Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[n + 1];
        List<Edge>[] reversedGraph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            reversedGraph[v].add(new Edge(u, w));
            indegree[v]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 시작 도시에서 i번 도시까지 가는데 걸리는 최대 시간 저장
        int[] time = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);

        // 시작 도시에서 각 도시까지의 최장 시간을 위상정렬로 계산
        while (!q.isEmpty()) {
            int cur =  q.poll();

            for (Edge edge : graph[cur]) {
                time[edge.next] = Math.max(time[edge.next], time[cur] + edge.cost);
                indegree[edge.next]--;

                if (indegree[edge.next] == 0) {
                    q.offer(edge.next);
                }
            }
        }

        // 끝 도시에서 거꾸로 이동하며 최장 도로에 포함된 도로 수 계산
        boolean[] visited = new boolean[n + 1];
        q.offer(target);
        visited[target] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge edge : reversedGraph[cur]) {
                // edge.next -> cur 도로가 최장 경로에 포함되는 경우
                // 한 도시에서 이어진 도로 중 최장 경로에 포함된 도로가 여러개일 수 있음
                // 모두 황금칠 해줘야 하므로 visited 여부와 상관 없이 최장 경로 값에 해당하는 도로이기만 하면 count
                if (time[cur] == time[edge.next] + edge.cost) {
                    count++;

                    if (!visited[edge.next]) {
                        q.offer(edge.next);
                        visited[edge.next] = true;
                    }
                }
            }
        }

        // 끝 도시의 최장 경로 시간
        System.out.println(time[target]);
        // 최장 경로에 해당하는 도로 개수
        System.out.println(count);
    }
}
