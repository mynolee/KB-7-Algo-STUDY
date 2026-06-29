import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] inDegree = new int[N + 1];
        int[] time = new int[N + 1];
        int[] result = new int[N + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                // num 건물이 지어져야 i번 건물을 지을 수 있으므로
                list.get(num).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];    // 자기 자신 짓는 시간 추가
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list.get(cur)) {
                // 동시에 지을 수 있다는 점을 주의
                // 동시에 지을 수 있으므로, 선행 건물들 중 '가장 늦게 끝나는 시간 + 현재 건물 시간'으로 갱신
                // 선행 건물 중 가장 오래 걸리는 놈이 다 지어질때까지 기다려야 하니까
                result[next] = Math.max(result[next], result[cur] + time[next]);

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}
