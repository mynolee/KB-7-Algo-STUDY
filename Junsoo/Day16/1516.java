import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // i번 건물 짓는데 걸리는 시간
            time[i]= Integer.parseInt(st.nextToken());

            while (true) {
                // i번 건물보다 먼저 지어져야 하는 건물
                int prev = Integer.parseInt(st.nextToken());

                if (prev == -1) {
                    break;
                }

                graph[prev].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] answer =  new int[n + 1];

        // 바로 지을 수 있는 건물부터 시작
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                // i번 건물 짓는데 걸리는 시간(선행 건물이 없으므로 해당 건물 시간만큼만 필요)
                answer[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int cur =  q.poll();

            for (int next : graph[cur]) {
                // next번 건물은 모든 선행 건물이 완성된 후에 지을 수 있음
                // 따라서 선행 건물들의 완성 시간 중 최댓값을 저장
                answer[next] = Math.max(answer[next], answer[cur]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    // 모든 선행 건물이 완성되었으므로 next번 건물 짓는 시간 추가
                    answer[next] += time[next];
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
