import java.util.*;

class Solution {
    private int answer = 0;

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        // 양1, 늑대0 으로 시작
        dfs(info, edges, visited, 1, 0);
        return answer;
    }

    private void dfs(int[] info, int[][] edges, boolean[] visited, int sheep, int wolf) {
        if (wolf >= sheep) {
            return;
        }
        answer = Math.max(answer, sheep);
        // 모든 간선 확인하면서 다음 갈 수 있는 노드 찾기
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                if (info[child] == 0) {
                    // 자식 노드가 양
                    dfs(info, edges, visited, sheep + 1, wolf);
                } else {
                    // 자식 노드가 늑대
                    dfs(info, edges, visited, sheep, wolf + 1);
                }
                visited[child] = false;
            }
        }
    }
}
