import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b); // a가 먼저, b는 뒤에
            indegree[b]++; // b 앞에 와야하는 사람 한명 추가
        }

        Queue<Integer> q = new ArrayDeque<>();
        // 맨 처음 올 indegree 값 0부터 큐에 넣음
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur =  q.poll();
            // 꺼내면서 출력
            sb.append(cur).append(" ");

            for (int next : graph[cur]) {
                // next 앞에 와야 할 cur은 이미 줄 섰으므로 1 감소
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}
