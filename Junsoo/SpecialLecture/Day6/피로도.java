import java.util.*;

class Solution {
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        // 현재 경로에서 탐험한 던전 수와 기존 최댓값을 비교해 갱신
        answer = Math.max(answer, count);
        // 모든 던전 하나씩 확인
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                // 현재 던전 탐험 처리
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                // 다른 탐험 순서도 확인하기 위해 방문 상태 되돌림
                visited[i] = false;
            }
        }
    }
}
