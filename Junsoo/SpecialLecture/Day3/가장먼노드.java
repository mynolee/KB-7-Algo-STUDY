import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 노드 번호 1부터 n이므로 n+1까지 필요
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 거리를 구해야 하므로 거리 저장 배열을 통해 방문 여부까지 판단, 노드 번호: 1부터 n
        // 자기 자신은 거리 0 인데 방문 전 상태를 구분하기 위해 -1로 초기화
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                // 방문하지 않은 노드를 검사할 때는 dist가 -1 이어야 함
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(d, maxDist);
        }
        for (int d : dist) {
            if (d == maxDist) {
                answer++;
            }
        }
        return answer;
    }
}
