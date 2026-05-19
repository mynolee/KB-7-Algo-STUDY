import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 각 전선을 하나씩 끊어보기
        for (int cut = 0; cut < wires.length; cut++) {
            List<List<Integer>> graph = new ArrayList<>();
            // 1 ~ n번 송전탑이므로 n + 1 개 필요
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            // cut 번째 전선 제외하고 그래프 구성
            for (int i = 0; i < wires.length; i++) {
                if (i == cut) {
                    continue;
                }
                graph.get(wires[i][0]).add(wires[i][1]);
                graph.get(wires[i][1]).add(wires[i][0]);
            }

            boolean[] visited = new boolean[n + 1];
            // 1번 송전탑이 속한 전력망 송전탑 개수
            int count = dfs(graph, visited, 1);
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        return answer;
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        // 현재 송전탑 포함해서 개수 세기
        int count = 1;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(graph, visited, next);
            }
        }
        return count;
    }
}
