import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer>[] graph;
    private static int[] groupNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v =  Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }
            // 방문하지 않은 모든 노드는 그룹 번호를 0으로 초기화
            groupNum = new int[v + 1];

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            // 모든 정점이 인접해있지 않을 수 있으므로 모든 정점에 대해 탐색
            // 이분 그래프가 아닌 경우는 바로 판단이 가능하지만
            // 이분 그래프가 맞는지 판단하려면 모든 정점에 대한 for문이 수행되어야 하므로
            // 진위 여부 저장 변수 추가로 필요
            boolean isBipartite = true;
            for (int i = 1; i <= v; i++) {
                // 그룹 번호가 0이면 아직 방문되지 않은 정점
                if(groupNum[i] == 0){
                    if (!isBipartite(i)) {
                        // 이분 그래프가 아닌 경우 바로 다음 테스트케이스로 넘어가기 위해 isBipartite에 false 저장
                        isBipartite = false;
                        break;
                    }
                }
            }

            if (isBipartite) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isBipartite(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        // 그룹의 시작 정점(루트)는 그룹 번호를 1로 잡음
        groupNum[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                // 그룹 번호가 0이면 아직 방문되지 않은 정점
                if (groupNum[next] == 0) {
                    q.offer(next);
                    // 인접한 next 정점의 그룹 번호는 인접한 cur 정점의 그룹 번호의 반대로 저장
                    // 반대로 구분하기 위해 그룹은 -1과 1로 나뉜다고 가정
                    groupNum[next] = groupNum[cur] * -1;
                } else if (groupNum[next] == groupNum[cur]) {
                    // 현재 그룹의 정점과 인접해 있는데 이미 방문되었고 두 정점의 그룹 번호가 같다면 이분 그래프 아님
                    return false;
                } // 방문되었지만 두 정점의 그룹 번호가 다르다면 문제 없음
            }
        }
        return true;
    }
}
