import java.io.*;
import java.util.*;

public class Main {
    static int[] max = new int[3];
    static boolean[][] visited;
    static boolean[] answer;

    // 6가지 이동 경로를 자동화하기 위한 인덱스 (from -> to)
    /**
     * 6P2
     * A-> B | A -> C
     * B -> C | B -> A
     * C -> A | C -> B
     */
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max[0] = Integer.parseInt(st.nextToken());
        max[1] = Integer.parseInt(st.nextToken());
        max[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[max[0] + 1][max[1] + 1];
        answer = new boolean[max[2] + 1];

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= max[2]; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }


    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        // 초기 상태는 C만 가득
        q.add(new int[]{0, 0, max[2]});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            // A가 비어있을 때의 C의 양을 정답 처리
            if (a == 0) answer[c] = true;

            // 6가지 경우 탐색
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};

                // 주는 인덱스와 받는 인덱스
                int send = from[i];
                int receive = to[i];

                // 받는 물통의 남은 용량과 주는 물통의 현재 양 중 작은 값만큼 이동
                /** ex)
                 * 주는 물통이 5L 있고, 받는 물통에 남은 용량이 3L 있으면
                 * 줄 수 있는 양은 3L가 최대임.
                 */
                int amount = Math.min(max[receive] - next[receive], next[send]);
                next[receive] += amount;
                next[send] -= amount;

                // 아직 방문해보지 않은 유일한 상태(A와 B의 값 기준)라면 큐에 삽입
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new int[]{next[0], next[1], next[2]});
                }
            }
        }
    }
}
